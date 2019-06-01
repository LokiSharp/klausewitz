package clausewitz.parser


import clausewitz.antlr.ClausewitzBaseVisitor
import clausewitz.antlr.ClausewitzParser
import clausewitz.antlr.ClausewitzParser.AssignmentContext
import clausewitz.antlr.ClausewitzVisitor
import com.google.common.base.CaseFormat
import org.atteo.evo.inflector.English
import java.time.format.DateTimeFormatter
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.KType
import kotlin.reflect.full.primaryConstructor

fun String.toSnakeCase(from: CaseFormat = CaseFormat.LOWER_CAMEL) = from.to(CaseFormat.LOWER_UNDERSCORE, this)
fun String.toCamelCase(from: CaseFormat = CaseFormat.LOWER_UNDERSCORE) =
    camelCaseCache.computeIfAbsent(this) { str -> from.to(CaseFormat.LOWER_CAMEL, str) }

fun String.pluralise() = pluralCache.computeIfAbsent(this, English::plural)

private val pluralCache: ConcurrentMap<String, String> = ConcurrentHashMap()
private val camelCaseCache: ConcurrentMap<String, String> = ConcurrentHashMap()
/**
 * Resolves the appropriate [ClausewitzVisitor] to parse an object of [type].
 */
private fun resolveVisitor(name: String?, type: KType): ClausewitzVisitor<*> {
    // Map<String, Integer> => Map
    val classifierClass = type.classifier as KClass<*>

    return when (classifierClass) {
        // literals
        String::class -> StringVisitor
        Long::class -> IntegerVisitor // TODO: support Int with overflow if too big?
        Double::class -> RealVisitor
        Boolean::class -> BooleanVisitor

        // collections
        List::class -> ListVisitor(name, type.typeArgument(0))
        Map::class -> MapVisitor(
            name,
            type.typeArgument(0),
            type.typeArgument(1)
        )

        else ->
            when {
                // Data class (visit object and fill its arguments)
                classifierClass.isData -> ObjectVisitor(classifierClass)

                // Exhausted options
                else -> throw IllegalArgumentException("Unexpected type for $name ($type): $classifierClass")
            }
    }
}

class ObjectVisitor<T : Any>(private val clazz: KClass<T>) : ClausewitzBaseVisitor<T>() {
    private val constructor = clazz.primaryConstructor ?: throw IllegalStateException("No constructor for $clazz")

    override fun visitConfig(ctx: ClausewitzParser.ConfigContext) = visitAssignments(ctx.assignment())
    override fun visitMap(ctx: ClausewitzParser.MapContext) = visitAssignments(ctx.assignment())

    /**
     * Iterates through the parameters available on this object, finding assignments to resolve them.
     */
    private fun visitAssignments(assignments: List<AssignmentContext>): T {
        val params = constructor.parameters

        val parameterValues: Map<KParameter, List<ClausewitzParser.ValueContext>> = params
            .map { p -> p to assignments.findMatching(p.name).map { it.value() } }
            .toMap()

        val multiValues = parameterValues.filterValues { it.size > 1 }
        val singleValues = parameterValues.filterValues { it.size <= 1 }.mapValues { (_, ctxs) -> ctxs.getOrNull(0) }

        val singleResolvedValues: Map<KParameter, Any?> = singleValues
            .map { (parameter, value) ->
                parameter to value?.accept(
                    resolveVisitor(
                        parameter.name,
                        parameter.type
                    )
                )
            }
            .toMap()
            .filterValues { it != null }

        val multiResolvedValues: Map<KParameter, List<Any>> = multiValues
            .map { (parameter, values) ->
                parameter to values.map {
                    it.accept(
                        resolveVisitor(
                            parameter.name,
                            parameter.typeArgument(0)
                        )
                    )
                }
            }
            .toMap()

        val resolvedValues = singleResolvedValues + multiResolvedValues
        return try {
            constructor.callBy(resolvedValues)
        } catch (e: IllegalArgumentException) {
            val debug = resolvedValues.map { (k, v) -> k.name to v }
            throw RuntimeException("Error creating $clazz with $debug", e)
        }
    }

    private fun List<AssignmentContext>.findMatching(parameterName: String?): List<AssignmentContext> {
        return this.filter { assignment ->
            val field = assignment.field().text.stripped

            // FIXME: does this evaluate them all first, or in order?
            when (parameterName) {
                field -> true
                field.pluralise() -> true
                field.toCamelCase() -> true
                field.toCamelCase().pluralise() -> true
                else -> false
            }
        }
    }
}

private class ListVisitor(private val name: String?, type: KType) : ClausewitzBaseVisitor<List<Any>>() {
    private val visitor = resolveVisitor(name, type) // Find visitor for array generic type

    override fun visitArray(ctx: ClausewitzParser.ArrayContext): List<Any> = ctx.value().map { it.accept(visitor) }

    override fun visitMap(ctx: ClausewitzParser.MapContext): List<Any> {
        val distinctKeys = ctx.assignment().map { it.field().text }.distinct()
        if (distinctKeys.size > 1) throw IllegalArgumentException("$name multimap has multiple keys: $distinctKeys")
        return ctx.assignment().map { it.value() }.map { it.accept(visitor) }
    }
}

private class MapVisitor(name: String?, keyType: KType, valueType: KType) : ClausewitzBaseVisitor<Any>() {
    private val keyVisitor = resolveVisitor(name, keyType) // Visitor for key generic type
    private val valueVisitor = resolveVisitor(name, valueType) // Visitor for value generic type

    override fun visitMap(ctx: ClausewitzParser.MapContext): Map<Any, Any> {
        return ctx.assignment()
            .map { it.field().accept(keyVisitor) to it.value().accept(valueVisitor) }
            .toMap()
    }
}

private object StringVisitor : ClausewitzBaseVisitor<String>() {
    override fun visitString(ctx: ClausewitzParser.StringContext): String = ctx.text.stripped
    override fun visitSymbol(ctx: ClausewitzParser.SymbolContext): String = ctx.text.stripped
}

private object IntegerVisitor : ClausewitzBaseVisitor<Long>() {
    override fun visitInteger(ctx: ClausewitzParser.IntegerContext): Long = ctx.text.toLong()
    override fun visitSymbol(ctx: ClausewitzParser.SymbolContext): Long = ctx.text.toLong()
    override fun visitPercent(ctx: ClausewitzParser.PercentContext): Long = ctx.text.removeSuffix("%").toLong()
}

private object RealVisitor : ClausewitzBaseVisitor<Double>() {
    override fun visitInteger(ctx: ClausewitzParser.IntegerContext): Double = ctx.text.toDouble()
    override fun visitReal(ctx: ClausewitzParser.RealContext): Double = ctx.text.toDouble()
    override fun visitSymbol(ctx: ClausewitzParser.SymbolContext): Double = ctx.text.toDouble()
}

private object BooleanVisitor : ClausewitzBaseVisitor<Boolean>() {
    override fun visitSymbol(ctx: ClausewitzParser.SymbolContext): Boolean = when (ctx.text) {
        TRUE -> true
        FALSE -> false
        else -> throw IllegalArgumentException("Expected boolean but got ${ctx.text}")
    }
}

private fun KParameter.typeArgument(idx: Int) = type.typeArgument(idx)
private fun KType.typeArgument(idx: Int) =
    this.arguments[idx].type ?: throw IllegalStateException("No type argument $idx on $this")

private val stellarisDateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
val String.stripped get() = removeSurrounding("\"")

const val TRUE = "yes"
const val FALSE = "no"
val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
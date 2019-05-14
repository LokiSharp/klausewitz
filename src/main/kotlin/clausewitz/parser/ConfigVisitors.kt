package clausewitz.parser

import clausewitz.antlr.ClausewitzBaseVisitor
import clausewitz.antlr.ClausewitzLexer
import clausewitz.antlr.ClausewitzParser
import com.google.common.collect.Multimap
import com.google.common.collect.MultimapBuilder
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Visitors which parse to untyped Multimaps
// WIP: misses a bunch of cases, use TypedVisitors if possible.

fun parseConfig(input: CharStream) =
    ClausewitzParser(CommonTokenStream(ClausewitzLexer(input))).config().toConfigBlock()

fun ClausewitzParser.ConfigContext.toConfigBlock() = ConfigVisitor.visit(this)

internal object ConfigVisitor : ClausewitzBaseVisitor<ConfigBlock>() {
    override fun visitConfig(ctx: ClausewitzParser.ConfigContext) = ctx.assignment().toBlock()
}

internal object AssignmentVisitor : ClausewitzBaseVisitor<ConfigAssignment>() {
    override fun visitAssignment(ctx: ClausewitzParser.AssignmentContext): ConfigAssignment {
        val field = ctx.field().text.stripped
        val value = ctx.value().accept(ValueVisitor)
        return field to value
    }
}

object ValueVisitor : ClausewitzBaseVisitor<Any>() {
    override fun visitSymbol(ctx: ClausewitzParser.SymbolContext): Any = when (ctx.text) {
        TRUE -> true
        FALSE -> false
        else -> ctx.text
    }

    override fun visitString(ctx: ClausewitzParser.StringContext): String = ctx.text.stripped
    override fun visitInteger(ctx: ClausewitzParser.IntegerContext): Long = ctx.text.toLong()
    override fun visitReal(ctx: ClausewitzParser.RealContext): Double = ctx.text.toDouble()
    override fun visitDate(ctx: ClausewitzParser.DateContext): LocalDate = LocalDate.parse(
        ctx.text,
        dateFormatter
    )

    override fun visitPercent(ctx: ClausewitzParser.PercentContext): Int = ctx.text.removeSuffix("%").toInt()
    override fun visitArray(ctx: ClausewitzParser.ArrayContext) = ctx.value().map { it.accept(ValueVisitor) }
    override fun visitMap(ctx: ClausewitzParser.MapContext) = ctx.assignment().toBlock()
}

private fun List<ClausewitzParser.AssignmentContext>.toBlock(): ConfigBlock = this
    .map { it.accept(AssignmentVisitor) }
    .toMultimap()

fun <K, V> Collection<Pair<K, V>>.toMultimap(): Multimap<K, V> {
    return this.fold(
        MultimapBuilder
            .hashKeys()
            .arrayListValues()
            .build<K, V>()
    ) { acc, (k, v) -> acc.apply { put(k, v) } }
}

val String.stripped get() = removeSurrounding("\"")

const val TRUE = "yes"
const val FALSE = "no"

val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

typealias ConfigBlock = Multimap<String, Any>
typealias ConfigAssignment = Pair<String, Any>
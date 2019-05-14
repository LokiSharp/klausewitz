package clausewitz.parser

import clausewitz.antlr.ClausewitzLexer
import clausewitz.antlr.ClausewitzParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

inline fun <reified T : Any> parseClausewitzFile(file: String): T {
    val input = CharStreams.fromFileName(file)
    val config = ClausewitzParser(CommonTokenStream(ClausewitzLexer(input))).config()
    val result = config.accept(ObjectVisitor(T::class))
    return result
}
package org.slk.clausewitz.parser

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.slk.clausewitz.antlr.ClausewitzLexer
import org.slk.clausewitz.antlr.ClausewitzParser

inline fun <reified T : Any> parseClausewitzFile(file: String): T {
    val input = CharStreams.fromFileName(file)
    val config = ClausewitzParser(CommonTokenStream(ClausewitzLexer(input))).config()
    val result = config.accept(ObjectVisitor(T::class))
    return result
}
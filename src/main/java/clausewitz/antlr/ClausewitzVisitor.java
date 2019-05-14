// Generated from C:/Users/LokiSharp/IdeaProjects/clausewitz/src/antlr\Clausewitz.g4 by ANTLR 4.7.2
package clausewitz.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ClausewitzParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface ClausewitzVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link ClausewitzParser#config}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConfig(ClausewitzParser.ConfigContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#assignment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignment(ClausewitzParser.AssignmentContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#field}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitField(ClausewitzParser.FieldContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#value}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitValue(ClausewitzParser.ValueContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#symbol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSymbol(ClausewitzParser.SymbolContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#string}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString(ClausewitzParser.StringContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#integer}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInteger(ClausewitzParser.IntegerContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#real}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReal(ClausewitzParser.RealContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#date}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDate(ClausewitzParser.DateContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#percent}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPercent(ClausewitzParser.PercentContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#map}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMap(ClausewitzParser.MapContext ctx);

    /**
     * Visit a parse tree produced by {@link ClausewitzParser#array}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArray(ClausewitzParser.ArrayContext ctx);
}
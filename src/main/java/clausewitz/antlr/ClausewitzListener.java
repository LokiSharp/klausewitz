// Generated from C:/Users/LokiSharp/IdeaProjects/clausewitz/src/antlr\Clausewitz.g4 by ANTLR 4.7.2
package clausewitz.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ClausewitzParser}.
 */
public interface ClausewitzListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link ClausewitzParser#config}.
     *
     * @param ctx the parse tree
     */
    void enterConfig(ClausewitzParser.ConfigContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#config}.
     *
     * @param ctx the parse tree
     */
    void exitConfig(ClausewitzParser.ConfigContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#assignment}.
     *
     * @param ctx the parse tree
     */
    void enterAssignment(ClausewitzParser.AssignmentContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#assignment}.
     *
     * @param ctx the parse tree
     */
    void exitAssignment(ClausewitzParser.AssignmentContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#field}.
     *
     * @param ctx the parse tree
     */
    void enterField(ClausewitzParser.FieldContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#field}.
     *
     * @param ctx the parse tree
     */
    void exitField(ClausewitzParser.FieldContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#value}.
     *
     * @param ctx the parse tree
     */
    void enterValue(ClausewitzParser.ValueContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#value}.
     *
     * @param ctx the parse tree
     */
    void exitValue(ClausewitzParser.ValueContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#symbol}.
     *
     * @param ctx the parse tree
     */
    void enterSymbol(ClausewitzParser.SymbolContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#symbol}.
     *
     * @param ctx the parse tree
     */
    void exitSymbol(ClausewitzParser.SymbolContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#string}.
     *
     * @param ctx the parse tree
     */
    void enterString(ClausewitzParser.StringContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#string}.
     *
     * @param ctx the parse tree
     */
    void exitString(ClausewitzParser.StringContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#integer}.
     *
     * @param ctx the parse tree
     */
    void enterInteger(ClausewitzParser.IntegerContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#integer}.
     *
     * @param ctx the parse tree
     */
    void exitInteger(ClausewitzParser.IntegerContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#real}.
     *
     * @param ctx the parse tree
     */
    void enterReal(ClausewitzParser.RealContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#real}.
     *
     * @param ctx the parse tree
     */
    void exitReal(ClausewitzParser.RealContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#date}.
     *
     * @param ctx the parse tree
     */
    void enterDate(ClausewitzParser.DateContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#date}.
     *
     * @param ctx the parse tree
     */
    void exitDate(ClausewitzParser.DateContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#percent}.
     *
     * @param ctx the parse tree
     */
    void enterPercent(ClausewitzParser.PercentContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#percent}.
     *
     * @param ctx the parse tree
     */
    void exitPercent(ClausewitzParser.PercentContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#map}.
     *
     * @param ctx the parse tree
     */
    void enterMap(ClausewitzParser.MapContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#map}.
     *
     * @param ctx the parse tree
     */
    void exitMap(ClausewitzParser.MapContext ctx);

    /**
     * Enter a parse tree produced by {@link ClausewitzParser#array}.
     *
     * @param ctx the parse tree
     */
    void enterArray(ClausewitzParser.ArrayContext ctx);

    /**
     * Exit a parse tree produced by {@link ClausewitzParser#array}.
     *
     * @param ctx the parse tree
     */
    void exitArray(ClausewitzParser.ArrayContext ctx);
}
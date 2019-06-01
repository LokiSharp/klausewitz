// Generated from C:/Users/LokiSharp/IdeaProjects/clausewitz/src/antlr\Clausewitz.g4 by ANTLR 4.7.2
package org.slk.clausewitz.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClausewitzParser extends Parser {
    public static final int
            OPERATOR = 1, BLOCK_START = 2, BLOCK_END = 3, INT = 4, PCT = 5, REAL = 6, DATE = 7,
            STRING = 8, SYMBOL = 9, WHITESPACE = 10, LINE_COMMENT = 11;
    public static final int
            RULE_config = 0, RULE_assignment = 1, RULE_field = 2, RULE_value = 3,
            RULE_symbol = 4, RULE_string = 5, RULE_integer = 6, RULE_real = 7, RULE_date = 8,
            RULE_percent = 9, RULE_map = 10, RULE_array = 11;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rP\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4" +
                    "\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\3\3\3\3\3\4\3\4" +
                    "\5\4\'\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\61\n\5\3\6\3\6\3\7\3\7" +
                    "\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\7\fA\n\f\f\f\16\fD\13\f\3\f" +
                    "\3\f\3\r\3\r\6\rJ\n\r\r\r\16\rK\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22" +
                    "\24\26\30\2\3\4\2\6\6\n\13\2N\2\35\3\2\2\2\4 \3\2\2\2\6&\3\2\2\2\b\60" +
                    "\3\2\2\2\n\62\3\2\2\2\f\64\3\2\2\2\16\66\3\2\2\2\208\3\2\2\2\22:\3\2\2" +
                    "\2\24<\3\2\2\2\26>\3\2\2\2\30G\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34" +
                    "\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35\3\2\2\2 !\5" +
                    "\6\4\2!\"\7\3\2\2\"#\5\b\5\2#\5\3\2\2\2$\'\5\f\7\2%\'\5\n\6\2&$\3\2\2" +
                    "\2&%\3\2\2\2\'\7\3\2\2\2(\61\5\16\b\2)\61\5\24\13\2*\61\5\20\t\2+\61\5" +
                    "\22\n\2,\61\5\f\7\2-\61\5\n\6\2.\61\5\26\f\2/\61\5\30\r\2\60(\3\2\2\2" +
                    "\60)\3\2\2\2\60*\3\2\2\2\60+\3\2\2\2\60,\3\2\2\2\60-\3\2\2\2\60.\3\2\2" +
                    "\2\60/\3\2\2\2\61\t\3\2\2\2\62\63\t\2\2\2\63\13\3\2\2\2\64\65\7\n\2\2" +
                    "\65\r\3\2\2\2\66\67\7\6\2\2\67\17\3\2\2\289\7\b\2\29\21\3\2\2\2:;\7\t" +
                    "\2\2;\23\3\2\2\2<=\7\7\2\2=\25\3\2\2\2>B\7\4\2\2?A\5\4\3\2@?\3\2\2\2A" +
                    "D\3\2\2\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7\5\2\2F\27\3\2\2" +
                    "\2GI\7\4\2\2HJ\5\b\5\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2" +
                    "\2MN\7\5\2\2N\31\3\2\2\2\7\35&\60BK";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public ClausewitzParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "config", "assignment", "field", "value", "symbol", "string", "integer",
                "real", "date", "percent", "map", "array"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, "'{'", "'}'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "OPERATOR", "BLOCK_START", "BLOCK_END", "INT", "PCT", "REAL", "DATE",
                "STRING", "SYMBOL", "WHITESPACE", "LINE_COMMENT"
        };
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Clausewitz.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ConfigContext config() throws RecognitionException {
        ConfigContext _localctx = new ConfigContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_config);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(27);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STRING) | (1L << SYMBOL))) != 0)) {
                    {
                        {
                            setState(24);
                            assignment();
                        }
                    }
                    setState(29);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AssignmentContext assignment() throws RecognitionException {
        AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_assignment);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(30);
                field();
                setState(31);
                match(OPERATOR);
                setState(32);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FieldContext field() throws RecognitionException {
        FieldContext _localctx = new FieldContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_field);
        try {
            setState(36);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(34);
                    string();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(35);
                    symbol();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ValueContext value() throws RecognitionException {
        ValueContext _localctx = new ValueContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_value);
        try {
            setState(46);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(38);
                    integer();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(39);
                    percent();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(40);
                    real();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(41);
                    date();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(42);
                    string();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(43);
                    symbol();
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(44);
                    map();
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(45);
                    array();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SymbolContext symbol() throws RecognitionException {
        SymbolContext _localctx = new SymbolContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_symbol);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(48);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STRING) | (1L << SYMBOL))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_string);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(50);
                match(STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IntegerContext integer() throws RecognitionException {
        IntegerContext _localctx = new IntegerContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_integer);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(52);
                match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RealContext real() throws RecognitionException {
        RealContext _localctx = new RealContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_real);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                match(REAL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DateContext date() throws RecognitionException {
        DateContext _localctx = new DateContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_date);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(56);
                match(DATE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PercentContext percent() throws RecognitionException {
        PercentContext _localctx = new PercentContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_percent);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(58);
                match(PCT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MapContext map() throws RecognitionException {
        MapContext _localctx = new MapContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_map);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(60);
                match(BLOCK_START);
                setState(64);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STRING) | (1L << SYMBOL))) != 0)) {
                    {
                        {
                            setState(61);
                            assignment();
                        }
                    }
                    setState(66);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(67);
                match(BLOCK_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArrayContext array() throws RecognitionException {
        ArrayContext _localctx = new ArrayContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_array);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(69);
                match(BLOCK_START);
                setState(71);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(70);
                            value();
                        }
                    }
                    setState(73);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLOCK_START) | (1L << INT) | (1L << PCT) | (1L << REAL) | (1L << DATE) | (1L << STRING) | (1L << SYMBOL))) != 0));
                setState(75);
                match(BLOCK_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConfigContext extends ParserRuleContext {
        public ConfigContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<AssignmentContext> assignment() {
            return getRuleContexts(AssignmentContext.class);
        }

        public AssignmentContext assignment(int i) {
            return getRuleContext(AssignmentContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_config;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitConfig(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AssignmentContext extends ParserRuleContext {
        public AssignmentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public FieldContext field() {
            return getRuleContext(FieldContext.class, 0);
        }

        public TerminalNode OPERATOR() {
            return getToken(ClausewitzParser.OPERATOR, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignment;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitAssignment(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class FieldContext extends ParserRuleContext {
        public FieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public SymbolContext symbol() {
            return getRuleContext(SymbolContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_field;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitField(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ValueContext extends ParserRuleContext {
        public ValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IntegerContext integer() {
            return getRuleContext(IntegerContext.class, 0);
        }

        public PercentContext percent() {
            return getRuleContext(PercentContext.class, 0);
        }

        public RealContext real() {
            return getRuleContext(RealContext.class, 0);
        }

        public DateContext date() {
            return getRuleContext(DateContext.class, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public SymbolContext symbol() {
            return getRuleContext(SymbolContext.class, 0);
        }

        public MapContext map() {
            return getRuleContext(MapContext.class, 0);
        }

        public ArrayContext array() {
            return getRuleContext(ArrayContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitValue(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SymbolContext extends ParserRuleContext {
        public SymbolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STRING() {
            return getToken(ClausewitzParser.STRING, 0);
        }

        public TerminalNode INT() {
            return getToken(ClausewitzParser.INT, 0);
        }

        public TerminalNode SYMBOL() {
            return getToken(ClausewitzParser.SYMBOL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_symbol;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitSymbol(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class StringContext extends ParserRuleContext {
        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STRING() {
            return getToken(ClausewitzParser.STRING, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitString(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IntegerContext extends ParserRuleContext {
        public IntegerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INT() {
            return getToken(ClausewitzParser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_integer;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitInteger(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class RealContext extends ParserRuleContext {
        public RealContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode REAL() {
            return getToken(ClausewitzParser.REAL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_real;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor) return ((ClausewitzVisitor<? extends T>) visitor).visitReal(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DateContext extends ParserRuleContext {
        public DateContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DATE() {
            return getToken(ClausewitzParser.DATE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_date;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor) return ((ClausewitzVisitor<? extends T>) visitor).visitDate(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class PercentContext extends ParserRuleContext {
        public PercentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PCT() {
            return getToken(ClausewitzParser.PCT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_percent;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitPercent(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MapContext extends ParserRuleContext {
        public MapContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BLOCK_START() {
            return getToken(ClausewitzParser.BLOCK_START, 0);
        }

        public TerminalNode BLOCK_END() {
            return getToken(ClausewitzParser.BLOCK_END, 0);
        }

        public List<AssignmentContext> assignment() {
            return getRuleContexts(AssignmentContext.class);
        }

        public AssignmentContext assignment(int i) {
            return getRuleContext(AssignmentContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_map;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor) return ((ClausewitzVisitor<? extends T>) visitor).visitMap(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ArrayContext extends ParserRuleContext {
        public ArrayContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BLOCK_START() {
            return getToken(ClausewitzParser.BLOCK_START, 0);
        }

        public TerminalNode BLOCK_END() {
            return getToken(ClausewitzParser.BLOCK_END, 0);
        }

        public List<ValueContext> value() {
            return getRuleContexts(ValueContext.class);
        }

        public ValueContext value(int i) {
            return getRuleContext(ValueContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_array;
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClausewitzVisitor)
                return ((ClausewitzVisitor<? extends T>) visitor).visitArray(this);
            else return visitor.visitChildren(this);
        }
    }
}
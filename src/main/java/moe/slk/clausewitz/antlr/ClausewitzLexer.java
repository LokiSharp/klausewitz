// Generated from C:/Users/LokiSharp/IdeaProjects/clausewitz/src/antlr\Clausewitz.g4 by ANTLR 4.7.2
package moe.slk.clausewitz.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClausewitzLexer extends Lexer {
    public static final int
            OPERATOR = 1, BLOCK_START = 2, BLOCK_END = 3, INT = 4, PCT = 5, REAL = 6, DATE = 7,
            STRING = 8, SYMBOL = 9, WHITESPACE = 10, LINE_COMMENT = 11;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u0082\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2&\n" +
                    "\2\3\3\3\3\3\4\3\4\3\5\5\5-\n\5\3\5\6\5\60\n\5\r\5\16\5\61\3\6\5\6\65" +
                    "\n\6\3\6\6\68\n\6\r\6\16\69\3\6\3\6\3\7\5\7?\n\7\3\7\6\7B\n\7\r\7\16\7" +
                    "C\3\7\3\7\6\7H\n\7\r\7\16\7I\3\b\6\bM\n\b\r\b\16\bN\3\b\3\b\6\bS\n\b\r" +
                    "\b\16\bT\3\b\3\b\6\bY\n\b\r\b\16\bZ\3\t\3\t\3\t\3\t\7\ta\n\t\f\t\16\t" +
                    "d\13\t\3\t\3\t\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\3\13\6\13p\n\13\r\13\16" +
                    "\13q\3\13\3\13\3\f\3\f\7\fx\n\f\f\f\16\f{\13\f\3\f\3\f\3\r\3\r\3\16\3" +
                    "\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33" +
                    "\2\3\2\t\4\2>>@@\3\2\62;\4\2$$^^\5\2\62;C\\c|\b\2\'\'/\60\62<B\\aac|\5" +
                    "\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0092\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3" +
                    "\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2" +
                    "\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2" +
                    "\2\2\t,\3\2\2\2\13\64\3\2\2\2\r>\3\2\2\2\17L\3\2\2\2\21\\\3\2\2\2\23g" +
                    "\3\2\2\2\25o\3\2\2\2\27u\3\2\2\2\31~\3\2\2\2\33\u0080\3\2\2\2\35&\7?\2" +
                    "\2\36\37\7>\2\2\37&\7@\2\2 &\t\2\2\2!\"\7>\2\2\"&\7?\2\2#$\7@\2\2$&\7" +
                    "?\2\2%\35\3\2\2\2%\36\3\2\2\2% \3\2\2\2%!\3\2\2\2%#\3\2\2\2&\4\3\2\2\2" +
                    "\'(\7}\2\2(\6\3\2\2\2)*\7\177\2\2*\b\3\2\2\2+-\5\33\16\2,+\3\2\2\2,-\3" +
                    "\2\2\2-/\3\2\2\2.\60\t\3\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62" +
                    "\3\2\2\2\62\n\3\2\2\2\63\65\5\33\16\2\64\63\3\2\2\2\64\65\3\2\2\2\65\67" +
                    "\3\2\2\2\668\t\3\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3" +
                    "\2\2\2;<\7\'\2\2<\f\3\2\2\2=?\5\33\16\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2" +
                    "@B\t\3\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EG\7\60\2" +
                    "\2FH\t\3\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\16\3\2\2\2KM\t\3" +
                    "\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2\2PR\7\60\2\2QS\t" +
                    "\3\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VX\7\60\2\2WY" +
                    "\t\3\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\20\3\2\2\2\\b\5\31\r" +
                    "\2]a\n\4\2\2^_\7^\2\2_a\t\4\2\2`]\3\2\2\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2" +
                    "\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\5\31\r\2f\22\3\2\2\2gk\t\5\2\2hj\t" +
                    "\6\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\24\3\2\2\2mk\3\2\2\2n" +
                    "p\t\7\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\b\13\2\2" +
                    "t\26\3\2\2\2uy\7%\2\2vx\n\b\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2" +
                    "\2z|\3\2\2\2{y\3\2\2\2|}\b\f\3\2}\30\3\2\2\2~\177\7$\2\2\177\32\3\2\2" +
                    "\2\u0080\u0081\7/\2\2\u0081\34\3\2\2\2\23\2%,\61\649>CINTZ`bkqy\4\b\2" +
                    "\2\2\3\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

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

    public ClausewitzLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "OPERATOR", "BLOCK_START", "BLOCK_END", "INT", "PCT", "REAL", "DATE",
                "STRING", "SYMBOL", "WHITESPACE", "LINE_COMMENT", "STRING_DELIM", "NEGATION"
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}
// Generated from ArrayInit.g4 by ANTLR 4.13.1
package com.github.viniciusfcf.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ArrayInitLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INT=7, WS=8, ASTERISK=9, 
		SLASH=10, PLUS=11, MINUS=12, ID=13, NAME=14, NUMBER=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "INT", "WS", "LETTER", 
			"DIGIT", "ASTERISK", "SLASH", "PLUS", "MINUS", "ID", "NAME", "NUMBER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", "'('", "')'", "'^'", null, null, "'*'", "'/'", 
			"'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "INT", "WS", "ASTERISK", "SLASH", 
			"PLUS", "MINUS", "ID", "NAME", "NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ArrayInitLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ArrayInit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000f\\\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u00061\b"+
		"\u0006\u000b\u0006\f\u00062\u0001\u0007\u0004\u00076\b\u0007\u000b\u0007"+
		"\f\u00077\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000fL\b\u000f\u000b"+
		"\u000f\f\u000fM\u0001\u0010\u0004\u0010Q\b\u0010\u000b\u0010\f\u0010R"+
		"\u0001\u0010\u0001\u0010\u0004\u0010W\b\u0010\u000b\u0010\f\u0010X\u0003"+
		"\u0010[\b\u0010\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\u0000\u0013\u0000"+
		"\u0015\t\u0017\n\u0019\u000b\u001b\f\u001d\r\u001f\u000e!\u000f\u0001"+
		"\u0000\u0003\u0001\u000009\u0003\u0000\t\n\r\r  \u0002\u0000AZaz_\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000"+
		"\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007)\u0001\u0000\u0000\u0000"+
		"\t+\u0001\u0000\u0000\u0000\u000b-\u0001\u0000\u0000\u0000\r0\u0001\u0000"+
		"\u0000\u0000\u000f5\u0001\u0000\u0000\u0000\u0011;\u0001\u0000\u0000\u0000"+
		"\u0013=\u0001\u0000\u0000\u0000\u0015?\u0001\u0000\u0000\u0000\u0017A"+
		"\u0001\u0000\u0000\u0000\u0019C\u0001\u0000\u0000\u0000\u001bE\u0001\u0000"+
		"\u0000\u0000\u001dG\u0001\u0000\u0000\u0000\u001fK\u0001\u0000\u0000\u0000"+
		"!P\u0001\u0000\u0000\u0000#$\u0005{\u0000\u0000$\u0002\u0001\u0000\u0000"+
		"\u0000%&\u0005,\u0000\u0000&\u0004\u0001\u0000\u0000\u0000\'(\u0005}\u0000"+
		"\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005(\u0000\u0000*\b\u0001\u0000"+
		"\u0000\u0000+,\u0005)\u0000\u0000,\n\u0001\u0000\u0000\u0000-.\u0005^"+
		"\u0000\u0000.\f\u0001\u0000\u0000\u0000/1\u0007\u0000\u0000\u00000/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u00003\u000e\u0001\u0000\u0000\u000046\u0007\u0001"+
		"\u0000\u000054\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9:\u0006\u0007\u0000\u0000:\u0010\u0001\u0000\u0000\u0000;<\u0007\u0002"+
		"\u0000\u0000<\u0012\u0001\u0000\u0000\u0000=>\u0007\u0000\u0000\u0000"+
		">\u0014\u0001\u0000\u0000\u0000?@\u0005*\u0000\u0000@\u0016\u0001\u0000"+
		"\u0000\u0000AB\u0005/\u0000\u0000B\u0018\u0001\u0000\u0000\u0000CD\u0005"+
		"+\u0000\u0000D\u001a\u0001\u0000\u0000\u0000EF\u0005-\u0000\u0000F\u001c"+
		"\u0001\u0000\u0000\u0000GH\u0003\u0011\b\u0000HI\u0003\u0013\t\u0000I"+
		"\u001e\u0001\u0000\u0000\u0000JL\u0003\u0011\b\u0000KJ\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000"+
		"\u0000\u0000N \u0001\u0000\u0000\u0000OQ\u0003\u0013\t\u0000PO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000SZ\u0001\u0000\u0000\u0000TV\u0005.\u0000\u0000UW\u0003"+
		"\u0013\t\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000"+
		"ZT\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\"\u0001\u0000\u0000"+
		"\u0000\u0007\u000027MRXZ\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
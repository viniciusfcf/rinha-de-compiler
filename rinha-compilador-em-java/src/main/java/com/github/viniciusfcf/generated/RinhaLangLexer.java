// Generated from RinhaLang.g4 by ANTLR 4.13.1
package com.github.viniciusfcf.generated;

	import com.github.viniciusfcf.datastructures.*;
	import com.github.viniciusfcf.exceptions.IsiSemanticException;
	import com.github.viniciusfcf.ast.*;
	import com.github.viniciusfcf.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RinhaLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, AP=7, FP=8, SC=9, OP=10, 
		ATTR=11, VIR=12, ACH=13, FCH=14, OPREL=15, ID=16, NUMBER=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "AP", "FP", "SC", "OP", 
			"ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'numero'", "'texto'", "'leia'", "'print'", "'if'", "'else'", "'('", 
			"')'", "';'", null, "'='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "AP", "FP", "SC", "OP", "ATTR", 
			"VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS"
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


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}


	public RinhaLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RinhaLang.g4"; }

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
		"\u0004\u0000\u0012~\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"e\b\u000e\u0001\u000f\u0001\u000f\u0005\u000fi\b\u000f\n\u000f\f\u000f"+
		"l\t\u000f\u0001\u0010\u0004\u0010o\b\u0010\u000b\u0010\f\u0010p\u0001"+
		"\u0010\u0001\u0010\u0004\u0010u\b\u0010\u000b\u0010\f\u0010v\u0003\u0010"+
		"y\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000"+
		"\u0012\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012\u0001\u0000\u0005\u0003\u0000*"+
		"+--//\u0001\u0000az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r"+
		"\r  \u0086\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%"+
		"\u0001\u0000\u0000\u0000\u0003,\u0001\u0000\u0000\u0000\u00052\u0001\u0000"+
		"\u0000\u0000\u00077\u0001\u0000\u0000\u0000\t=\u0001\u0000\u0000\u0000"+
		"\u000b@\u0001\u0000\u0000\u0000\rE\u0001\u0000\u0000\u0000\u000fG\u0001"+
		"\u0000\u0000\u0000\u0011I\u0001\u0000\u0000\u0000\u0013K\u0001\u0000\u0000"+
		"\u0000\u0015M\u0001\u0000\u0000\u0000\u0017O\u0001\u0000\u0000\u0000\u0019"+
		"Q\u0001\u0000\u0000\u0000\u001bS\u0001\u0000\u0000\u0000\u001dd\u0001"+
		"\u0000\u0000\u0000\u001ff\u0001\u0000\u0000\u0000!n\u0001\u0000\u0000"+
		"\u0000#z\u0001\u0000\u0000\u0000%&\u0005n\u0000\u0000&\'\u0005u\u0000"+
		"\u0000\'(\u0005m\u0000\u0000()\u0005e\u0000\u0000)*\u0005r\u0000\u0000"+
		"*+\u0005o\u0000\u0000+\u0002\u0001\u0000\u0000\u0000,-\u0005t\u0000\u0000"+
		"-.\u0005e\u0000\u0000./\u0005x\u0000\u0000/0\u0005t\u0000\u000001\u0005"+
		"o\u0000\u00001\u0004\u0001\u0000\u0000\u000023\u0005l\u0000\u000034\u0005"+
		"e\u0000\u000045\u0005i\u0000\u000056\u0005a\u0000\u00006\u0006\u0001\u0000"+
		"\u0000\u000078\u0005p\u0000\u000089\u0005r\u0000\u00009:\u0005i\u0000"+
		"\u0000:;\u0005n\u0000\u0000;<\u0005t\u0000\u0000<\b\u0001\u0000\u0000"+
		"\u0000=>\u0005i\u0000\u0000>?\u0005f\u0000\u0000?\n\u0001\u0000\u0000"+
		"\u0000@A\u0005e\u0000\u0000AB\u0005l\u0000\u0000BC\u0005s\u0000\u0000"+
		"CD\u0005e\u0000\u0000D\f\u0001\u0000\u0000\u0000EF\u0005(\u0000\u0000"+
		"F\u000e\u0001\u0000\u0000\u0000GH\u0005)\u0000\u0000H\u0010\u0001\u0000"+
		"\u0000\u0000IJ\u0005;\u0000\u0000J\u0012\u0001\u0000\u0000\u0000KL\u0007"+
		"\u0000\u0000\u0000L\u0014\u0001\u0000\u0000\u0000MN\u0005=\u0000\u0000"+
		"N\u0016\u0001\u0000\u0000\u0000OP\u0005,\u0000\u0000P\u0018\u0001\u0000"+
		"\u0000\u0000QR\u0005{\u0000\u0000R\u001a\u0001\u0000\u0000\u0000ST\u0005"+
		"}\u0000\u0000T\u001c\u0001\u0000\u0000\u0000UV\u0005G\u0000\u0000Ve\u0005"+
		"t\u0000\u0000WX\u0005L\u0000\u0000Xe\u0005t\u0000\u0000YZ\u0005G\u0000"+
		"\u0000Z[\u0005t\u0000\u0000[e\u0005e\u0000\u0000\\]\u0005L\u0000\u0000"+
		"]^\u0005t\u0000\u0000^e\u0005e\u0000\u0000_`\u0005E\u0000\u0000`e\u0005"+
		"q\u0000\u0000ab\u0005N\u0000\u0000bc\u0005e\u0000\u0000ce\u0005q\u0000"+
		"\u0000dU\u0001\u0000\u0000\u0000dW\u0001\u0000\u0000\u0000dY\u0001\u0000"+
		"\u0000\u0000d\\\u0001\u0000\u0000\u0000d_\u0001\u0000\u0000\u0000da\u0001"+
		"\u0000\u0000\u0000e\u001e\u0001\u0000\u0000\u0000fj\u0007\u0001\u0000"+
		"\u0000gi\u0007\u0002\u0000\u0000hg\u0001\u0000\u0000\u0000il\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k \u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mo\u0007\u0003\u0000\u0000"+
		"nm\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000qx\u0001\u0000\u0000\u0000rt\u0005.\u0000"+
		"\u0000su\u0007\u0003\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001"+
		"\u0000\u0000\u0000xr\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y\"\u0001\u0000\u0000\u0000z{\u0007\u0004\u0000\u0000{|\u0001\u0000\u0000"+
		"\u0000|}\u0006\u0011\u0000\u0000}$\u0001\u0000\u0000\u0000\u0007\u0000"+
		"dhjpvx\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
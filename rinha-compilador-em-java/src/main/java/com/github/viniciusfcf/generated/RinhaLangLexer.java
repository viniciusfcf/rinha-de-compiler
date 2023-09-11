// Generated from RinhaLang.g4 by ANTLR 4.13.1
package com.github.viniciusfcf.generated;

	import com.github.viniciusfcf.datastructures.IsiSymbol;
	import com.github.viniciusfcf.datastructures.IsiVariable;
	import com.github.viniciusfcf.datastructures.IsiSymbolTable;
	import com.github.viniciusfcf.exceptions.IsiSemanticException;
	import com.github.viniciusfcf.ast.IsiProgram;
	import com.github.viniciusfcf.ast.AbstractCommand;
	import com.github.viniciusfcf.ast.CommandLeitura;
	import com.github.viniciusfcf.ast.CommandEscrita;
	import com.github.viniciusfcf.ast.CommandAtribuicao;
	import com.github.viniciusfcf.ast.CommandDecisao;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, AP=9, 
		FP=10, SC=11, OP=12, ATTR=13, VIR=14, ACH=15, FCH=16, OPREL=17, ID=18, 
		NUMBER=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "AP", 
			"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'senao'", "'('", "')'", "';'", null, "'='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "AP", "FP", "SC", 
			"OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS"
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
		"\u0004\u0000\u0014\u0091\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010x\b\u0010\u0001\u0011\u0001\u0011\u0005\u0011|\b\u0011"+
		"\n\u0011\f\u0011\u007f\t\u0011\u0001\u0012\u0004\u0012\u0082\b\u0012\u000b"+
		"\u0012\f\u0012\u0083\u0001\u0012\u0001\u0012\u0004\u0012\u0088\b\u0012"+
		"\u000b\u0012\f\u0012\u0089\u0003\u0012\u008c\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014\u0001\u0000\u0006\u0003\u0000*+--//\u0002\u0000"+
		"<<>>\u0001\u0000az\u0003\u000009AZaz\u0001\u000009\u0003\u0000\t\n\r\r"+
		"  \u0098\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000"+
		"\u0000\u0000\u00032\u0001\u0000\u0000\u0000\u0005;\u0001\u0000\u0000\u0000"+
		"\u0007B\u0001\u0000\u0000\u0000\tH\u0001\u0000\u0000\u0000\u000bM\u0001"+
		"\u0000\u0000\u0000\rU\u0001\u0000\u0000\u0000\u000fX\u0001\u0000\u0000"+
		"\u0000\u0011^\u0001\u0000\u0000\u0000\u0013`\u0001\u0000\u0000\u0000\u0015"+
		"b\u0001\u0000\u0000\u0000\u0017d\u0001\u0000\u0000\u0000\u0019f\u0001"+
		"\u0000\u0000\u0000\u001bh\u0001\u0000\u0000\u0000\u001dj\u0001\u0000\u0000"+
		"\u0000\u001fl\u0001\u0000\u0000\u0000!w\u0001\u0000\u0000\u0000#y\u0001"+
		"\u0000\u0000\u0000%\u0081\u0001\u0000\u0000\u0000\'\u008d\u0001\u0000"+
		"\u0000\u0000)*\u0005p\u0000\u0000*+\u0005r\u0000\u0000+,\u0005o\u0000"+
		"\u0000,-\u0005g\u0000\u0000-.\u0005r\u0000\u0000./\u0005a\u0000\u0000"+
		"/0\u0005m\u0000\u000001\u0005a\u0000\u00001\u0002\u0001\u0000\u0000\u0000"+
		"23\u0005f\u0000\u000034\u0005i\u0000\u000045\u0005m\u0000\u000056\u0005"+
		"p\u0000\u000067\u0005r\u0000\u000078\u0005o\u0000\u000089\u0005g\u0000"+
		"\u00009:\u0005;\u0000\u0000:\u0004\u0001\u0000\u0000\u0000;<\u0005n\u0000"+
		"\u0000<=\u0005u\u0000\u0000=>\u0005m\u0000\u0000>?\u0005e\u0000\u0000"+
		"?@\u0005r\u0000\u0000@A\u0005o\u0000\u0000A\u0006\u0001\u0000\u0000\u0000"+
		"BC\u0005t\u0000\u0000CD\u0005e\u0000\u0000DE\u0005x\u0000\u0000EF\u0005"+
		"t\u0000\u0000FG\u0005o\u0000\u0000G\b\u0001\u0000\u0000\u0000HI\u0005"+
		"l\u0000\u0000IJ\u0005e\u0000\u0000JK\u0005i\u0000\u0000KL\u0005a\u0000"+
		"\u0000L\n\u0001\u0000\u0000\u0000MN\u0005e\u0000\u0000NO\u0005s\u0000"+
		"\u0000OP\u0005c\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005e\u0000\u0000"+
		"RS\u0005v\u0000\u0000ST\u0005a\u0000\u0000T\f\u0001\u0000\u0000\u0000"+
		"UV\u0005s\u0000\u0000VW\u0005e\u0000\u0000W\u000e\u0001\u0000\u0000\u0000"+
		"XY\u0005s\u0000\u0000YZ\u0005e\u0000\u0000Z[\u0005n\u0000\u0000[\\\u0005"+
		"a\u0000\u0000\\]\u0005o\u0000\u0000]\u0010\u0001\u0000\u0000\u0000^_\u0005"+
		"(\u0000\u0000_\u0012\u0001\u0000\u0000\u0000`a\u0005)\u0000\u0000a\u0014"+
		"\u0001\u0000\u0000\u0000bc\u0005;\u0000\u0000c\u0016\u0001\u0000\u0000"+
		"\u0000de\u0007\u0000\u0000\u0000e\u0018\u0001\u0000\u0000\u0000fg\u0005"+
		"=\u0000\u0000g\u001a\u0001\u0000\u0000\u0000hi\u0005,\u0000\u0000i\u001c"+
		"\u0001\u0000\u0000\u0000jk\u0005{\u0000\u0000k\u001e\u0001\u0000\u0000"+
		"\u0000lm\u0005}\u0000\u0000m \u0001\u0000\u0000\u0000nx\u0007\u0001\u0000"+
		"\u0000op\u0005>\u0000\u0000px\u0005=\u0000\u0000qr\u0005<\u0000\u0000"+
		"rx\u0005=\u0000\u0000st\u0005=\u0000\u0000tx\u0005=\u0000\u0000uv\u0005"+
		"!\u0000\u0000vx\u0005=\u0000\u0000wn\u0001\u0000\u0000\u0000wo\u0001\u0000"+
		"\u0000\u0000wq\u0001\u0000\u0000\u0000ws\u0001\u0000\u0000\u0000wu\u0001"+
		"\u0000\u0000\u0000x\"\u0001\u0000\u0000\u0000y}\u0007\u0002\u0000\u0000"+
		"z|\u0007\u0003\u0000\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~$\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0082\u0007\u0004"+
		"\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u008b\u0001\u0000\u0000\u0000\u0085\u0087\u0005.\u0000"+
		"\u0000\u0086\u0088\u0007\u0004\u0000\u0000\u0087\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000"+
		"\u0000\u008b\u0085\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c&\u0001\u0000\u0000\u0000\u008d\u008e\u0007\u0005\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0006\u0013\u0000\u0000"+
		"\u0090(\u0001\u0000\u0000\u0000\u0007\u0000w{}\u0083\u0089\u008b\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
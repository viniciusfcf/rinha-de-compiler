// Generated from ArrayInit.g4 by ANTLR 4.13.1
package com.github.viniciusfcf.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ArrayInitParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, INT=7, WS=8, ASTERISK=9, 
		SLASH=10, PLUS=11, MINUS=12, ID=13, NAME=14, NUMBER=15;
	public static final int
		RULE_init = 0, RULE_value = 1, RULE_expression = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "value", "expression"
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

	@Override
	public String getGrammarFileName() { return "ArrayInit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArrayInitParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(T__0);
			setState(7);
			value();
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(8);
				match(T__1);
				setState(9);
				value();
				}
				}
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(15);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public TerminalNode INT() { return getToken(ArrayInitParser.INT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_value);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				init();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericAtomExpContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(ArrayInitParser.NUMBER, 0); }
		public NumericAtomExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterNumericAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitNumericAtomExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowerExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowerExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterPowerExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitPowerExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(ArrayInitParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(ArrayInitParser.SLASH, 0); }
		public MulDivExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterMulDivExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitMulDivExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterParenthesisExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitParenthesisExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdAtomExpContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(ArrayInitParser.ID, 0); }
		public IdAtomExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterIdAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitIdAtomExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ArrayInitParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ArrayInitParser.MINUS, 0); }
		public AddSubExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterAddSubExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitAddSubExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionExpContext extends ExpressionContext {
		public TerminalNode NAME() { return getToken(ArrayInitParser.NAME, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).enterFunctionExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayInitListener ) ((ArrayInitListener)listener).exitFunctionExp(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				_localctx = new ParenthesisExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(22);
				match(T__3);
				setState(23);
				expression(0);
				setState(24);
				match(T__4);
				}
				break;
			case NAME:
				{
				_localctx = new FunctionExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(NAME);
				setState(27);
				match(T__3);
				setState(28);
				expression(0);
				setState(29);
				match(T__4);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumericAtomExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(NUMBER);
				}
				break;
			case ID:
				{
				_localctx = new IdAtomExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(44);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(35);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(36);
						_la = _input.LA(1);
						if ( !(_la==ASTERISK || _la==SLASH) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(37);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(38);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(39);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(40);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new PowerExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(41);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(42);
						match(T__5);
						setState(43);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000f2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u000b\b\u0000\n\u0000\f\u0000\u000e\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0014\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\"\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002-\b\u0002\n\u0002\f\u0002"+
		"0\t\u0002\u0001\u0002\u0000\u0001\u0004\u0003\u0000\u0002\u0004\u0000"+
		"\u0002\u0001\u0000\t\n\u0001\u0000\u000b\f6\u0000\u0006\u0001\u0000\u0000"+
		"\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0004!\u0001\u0000\u0000\u0000"+
		"\u0006\u0007\u0005\u0001\u0000\u0000\u0007\f\u0003\u0002\u0001\u0000\b"+
		"\t\u0005\u0002\u0000\u0000\t\u000b\u0003\u0002\u0001\u0000\n\b\u0001\u0000"+
		"\u0000\u0000\u000b\u000e\u0001\u0000\u0000\u0000\f\n\u0001\u0000\u0000"+
		"\u0000\f\r\u0001\u0000\u0000\u0000\r\u000f\u0001\u0000\u0000\u0000\u000e"+
		"\f\u0001\u0000\u0000\u0000\u000f\u0010\u0005\u0003\u0000\u0000\u0010\u0001"+
		"\u0001\u0000\u0000\u0000\u0011\u0014\u0003\u0000\u0000\u0000\u0012\u0014"+
		"\u0005\u0007\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0012"+
		"\u0001\u0000\u0000\u0000\u0014\u0003\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0006\u0002\uffff\uffff\u0000\u0016\u0017\u0005\u0004\u0000\u0000\u0017"+
		"\u0018\u0003\u0004\u0002\u0000\u0018\u0019\u0005\u0005\u0000\u0000\u0019"+
		"\"\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u000e\u0000\u0000\u001b\u001c"+
		"\u0005\u0004\u0000\u0000\u001c\u001d\u0003\u0004\u0002\u0000\u001d\u001e"+
		"\u0005\u0005\u0000\u0000\u001e\"\u0001\u0000\u0000\u0000\u001f\"\u0005"+
		"\u000f\u0000\u0000 \"\u0005\r\u0000\u0000!\u0015\u0001\u0000\u0000\u0000"+
		"!\u001a\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000! \u0001"+
		"\u0000\u0000\u0000\".\u0001\u0000\u0000\u0000#$\n\u0006\u0000\u0000$%"+
		"\u0007\u0000\u0000\u0000%-\u0003\u0004\u0002\u0007&\'\n\u0005\u0000\u0000"+
		"\'(\u0007\u0001\u0000\u0000(-\u0003\u0004\u0002\u0006)*\n\u0004\u0000"+
		"\u0000*+\u0005\u0006\u0000\u0000+-\u0003\u0004\u0002\u0004,#\u0001\u0000"+
		"\u0000\u0000,&\u0001\u0000\u0000\u0000,)\u0001\u0000\u0000\u0000-0\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/\u0005\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000\u0005\f\u0013"+
		"!,.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from ArrayInit.g4 by ANTLR 4.13.1
package com.github.viniciusfcf.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArrayInitParser}.
 */
public interface ArrayInitListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArrayInitParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(ArrayInitParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayInitParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(ArrayInitParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayInitParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ArrayInitParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayInitParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ArrayInitParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericAtomExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumericAtomExp(ArrayInitParser.NumericAtomExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericAtomExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumericAtomExp(ArrayInitParser.NumericAtomExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExp(ArrayInitParser.PowerExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powerExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExp(ArrayInitParser.PowerExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExp(ArrayInitParser.MulDivExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExp(ArrayInitParser.MulDivExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExp(ArrayInitParser.ParenthesisExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExp(ArrayInitParser.ParenthesisExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtomExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdAtomExp(ArrayInitParser.IdAtomExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtomExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdAtomExp(ArrayInitParser.IdAtomExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExp(ArrayInitParser.AddSubExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExp(ArrayInitParser.AddSubExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExp(ArrayInitParser.FunctionExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExp}
	 * labeled alternative in {@link ArrayInitParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExp(ArrayInitParser.FunctionExpContext ctx);
}
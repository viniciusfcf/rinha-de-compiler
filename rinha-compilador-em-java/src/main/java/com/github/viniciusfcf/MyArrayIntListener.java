package com.github.viniciusfcf;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.github.viniciusfcf.generated.ArrayInitListener;
import com.github.viniciusfcf.generated.ArrayInitParser.AddSubExpContext;
import com.github.viniciusfcf.generated.ArrayInitParser.FunctionExpContext;
import com.github.viniciusfcf.generated.ArrayInitParser.IdAtomExpContext;
import com.github.viniciusfcf.generated.ArrayInitParser.InitContext;
import com.github.viniciusfcf.generated.ArrayInitParser.MulDivExpContext;
import com.github.viniciusfcf.generated.ArrayInitParser.NumericAtomExpContext;
import com.github.viniciusfcf.generated.ArrayInitParser.ParenthesisExpContext;
import com.github.viniciusfcf.generated.ArrayInitParser.PowerExpContext;
import com.github.viniciusfcf.generated.ArrayInitParser.ValueContext;

public class MyArrayIntListener implements ArrayInitListener{

	@Override
	public void visitTerminal(TerminalNode node) {
		System.out.println("MyArrayIntListener.visitTerminal()");
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		System.out.println("MyArrayIntListener.visitErrorNode()");
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		System.out.println("MyArrayIntListener.enterEveryRule()");
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		System.out.println("MyArrayIntListener.exitEveryRule()");
	}

	@Override
	public void enterInit(InitContext ctx) {
		System.out.println("MyArrayIntListener.enterInit()");
	}

	@Override
	public void exitInit(InitContext ctx) {
		System.out.println("MyArrayIntListener.exitInit()");
	}

	@Override
	public void enterValue(ValueContext ctx) {
		System.out.println("MyArrayIntListener.enterValue()");
	}

	@Override
	public void exitValue(ValueContext ctx) {
		System.out.println("MyArrayIntListener.exitValue()");
	}

	@Override
	public void enterNumericAtomExp(NumericAtomExpContext ctx) {
		System.out.println("MyArrayIntListener.enterNumericAtomExp()");
	}

	@Override
	public void exitNumericAtomExp(NumericAtomExpContext ctx) {
		System.out.println("MyArrayIntListener.exitNumericAtomExp()");
	}

	@Override
	public void enterPowerExp(PowerExpContext ctx) {
		System.out.println("MyArrayIntListener.enterPowerExp()");
	}

	@Override
	public void exitPowerExp(PowerExpContext ctx) {
		System.out.println("MyArrayIntListener.exitPowerExp()");
	}

	@Override
	public void enterMulDivExp(MulDivExpContext ctx) {
		System.out.println("MyArrayIntListener.enterMulDivExp()");
	}

	@Override
	public void exitMulDivExp(MulDivExpContext ctx) {
		System.out.println("MyArrayIntListener.exitMulDivExp()");
	}

	@Override
	public void enterParenthesisExp(ParenthesisExpContext ctx) {
		System.out.println("MyArrayIntListener.enterParenthesisExp()");
	}

	@Override
	public void exitParenthesisExp(ParenthesisExpContext ctx) {
		System.out.println("MyArrayIntListener.exitParenthesisExp()");
	}

	@Override
	public void enterIdAtomExp(IdAtomExpContext ctx) {
		System.out.println("MyArrayIntListener.enterIdAtomExp()");
	}

	@Override
	public void exitIdAtomExp(IdAtomExpContext ctx) {
		System.out.println("MyArrayIntListener.exitIdAtomExp()");
	}

	@Override
	public void enterAddSubExp(AddSubExpContext ctx) {
		System.out.println("MyArrayIntListener.enterAddSubExp()");
	}

	@Override
	public void exitAddSubExp(AddSubExpContext ctx) {
		System.out.println("MyArrayIntListener.exitAddSubExp()" );
		
	}

	@Override
	public void enterFunctionExp(FunctionExpContext ctx) {
		System.out.println("MyArrayIntListener.enterFunctionExp()");
	}

	@Override
	public void exitFunctionExp(FunctionExpContext ctx) {
		System.out.println("MyArrayIntListener.exitFunctionExp()");
	}

}

package com.github.viniciusfcf.ast;

public class CommandExpr extends AbstractCommand {

	private AbstractCommand cmd1;
	private String op;
	private AbstractCommand cmd2;

	public CommandExpr(AbstractCommand cmd1, String op, AbstractCommand cmd2) {
		this.cmd1 = cmd1;
		this.op = op;
		this.cmd2 = cmd2;
	}

	@Override
	public String generateJavaCode() {
		return "return " + cmd1.generateJavaCode().replace(";","").replaceFirst("return", "") + op + cmd2.generateJavaCode().replaceFirst("return", "");
	}

	@Override
	public String toString() {
		return "CommandExpr [cmd1=" + cmd1 + ", op=" + op + ", cmd2=" + cmd2 + "]";
	}

}

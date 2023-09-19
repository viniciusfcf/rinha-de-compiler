package com.github.viniciusfcf.ast;

public class CommandExpr extends AbstractCommand {

	private String cmd1;
	private String op;
	private String cmd2;

	public CommandExpr(String cmd1, String op, String cmd2) {
		this.cmd1 = cmd1;
		this.op = op;
		this.cmd2 = cmd2;
	}
	
	public CommandExpr(String cmd1) {
		this.cmd1 = cmd1;
	}

	@Override
	public String generateJavaCode() {
		if(cmd2 == null) {
			return "return " + cmd1+";";
		}
		return "return " + cmd1 + op + cmd2;
	}

	@Override
	public String toString() {
		return "CommandExpr [cmd1=" + cmd1 + ", op=" + op + ", cmd2=" + cmd2 + "]";
	}

}

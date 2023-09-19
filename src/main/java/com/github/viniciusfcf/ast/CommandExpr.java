package com.github.viniciusfcf.ast;

public class CommandExpr extends AbstractCommand {

	private final String cmd1;
	private final String op;
	private final String cmd2;
	private final boolean metodoInterno;


	public CommandExpr(String cmd1, String op, String cmd2, boolean metodoInterno) {
		this.cmd1 = cmd1;
		this.op = op;
		this.cmd2 = cmd2;
		this.metodoInterno = metodoInterno;
	}
	
	public CommandExpr(String cmd1, boolean metodoInterno) {
		this(cmd1, null, null, metodoInterno);
	}

	@Override
	public String generateJavaCode() {
		String retorno = null;
		if(cmd2 == null) {
			retorno = cmd1+";";
		}else {
			retorno = cmd1 + op + cmd2;
				
		}
		
		if(metodoInterno) {
			return "return " + retorno;
		}
		return retorno;
	}

	@Override
	public String toString() {
		return "CommandExpr [cmd1=" + cmd1 + ", op=" + op + ", cmd2=" + cmd2 + "]";
	}

}

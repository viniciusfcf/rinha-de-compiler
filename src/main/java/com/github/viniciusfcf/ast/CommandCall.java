package com.github.viniciusfcf.ast;

import java.util.List;

public class CommandCall extends AbstractCommand {

	private final String funcao;
	private final List<String> parameters;
	private final boolean metodoInterno;
	private String params;

	public CommandCall(String funcao, List<String> parameters, boolean metodoInterno) {
		this.funcao = funcao;
		this.parameters = parameters;
		this.metodoInterno = metodoInterno;
		StringBuilder params = new StringBuilder();
		if(parameters != null) {
			
			for (String p : parameters) {
				params.append(","+p);
			}
			this.params = params.deleteCharAt(0).toString();
			
		}
	}

	@Override
	public String generateJavaCode() {
		if(parameters == null || parameters.size() == 0) {
			if(isMetodoInterno()) {
				return "return "+ funcao+";";
			}
			return funcao+"();";
		}
		if(isMetodoInterno()) {
			return "return putInCache(\""+funcao+ "\", new Object[]{"+params +"}, "+funcao+"(" + params+ "));";
		}
		return funcao+"(" + params+ ");";
	}

	public boolean isMetodoInterno() {
		return metodoInterno;
	}

	@Override
	public String toString() {
		return "CommandCall [funcao=" + funcao + ", parameters=" + parameters + ", metodoInterno=" + metodoInterno
				+ "]";
	}

 
}

package com.github.viniciusfcf.ast;

import java.util.List;

public class CommandCall extends AbstractCommand {

	private final String funcao;
	private final List<String> parameters;
	private final boolean metodoInterno;

	public CommandCall(String funcao, List<String> parameters, boolean metodoInterno) {
		this.funcao = funcao;
		this.parameters = parameters;
		this.metodoInterno = metodoInterno;
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
			return "return "+ funcao+"(" + params()+ ");";
		}
		return funcao+"(" + params()+ ");";
	}

	private String params() {
		StringBuilder params = new StringBuilder();
		for (String p : parameters) {
			params.append(","+p);
		}
		return params.deleteCharAt(0).toString();
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

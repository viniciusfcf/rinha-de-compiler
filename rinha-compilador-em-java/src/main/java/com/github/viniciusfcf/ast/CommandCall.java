package com.github.viniciusfcf.ast;

import java.util.List;

public class CommandCall extends AbstractCommand {

	private String funcao;
	private List<String> parameters;

	public CommandCall(String funcao, List<String> parameters) {
		this.funcao = funcao;
		this.parameters = parameters;
	}

	@Override
	public String generateJavaCode() {
		if(parameters == null || parameters.size() == 0) {
			return funcao+"();";
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

	@Override
	public String toString() {
		return "CommandCall [id=" + funcao + ", parameters "+parameters+"]";
	}

}

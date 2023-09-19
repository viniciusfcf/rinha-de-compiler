package com.github.viniciusfcf.datastructures;

import java.util.List;

import com.github.viniciusfcf.ast.AbstractCommand;

public class IsiMethod {
	
	private final String name;
	
	private final List<String> parameters;
	
	private final List<AbstractCommand> commands;

	public IsiMethod(String name, List<String> parameters, List<AbstractCommand> commands) {
		this.name = name;
		this.parameters = parameters;
		this.commands = commands;
		
	}

	public List<String> getParameters() {
		return parameters;
	}

	public List<AbstractCommand> getCommands() {
		return commands;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "IsiMethod [name=" + name + ", parameters=" + parameters + ", commands=" + commands + "]";
	}

}

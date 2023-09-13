package com.github.viniciusfcf.datastructures;

import java.util.ArrayList;
import java.util.List;

import com.github.viniciusfcf.ast.AbstractCommand;

public class IsiMethod {
	
	private final String name;
	
	private List<String> parameters = new ArrayList<>();
	
	private List<AbstractCommand> commands = new ArrayList<>();
	
	public IsiMethod(String name, List<String> parameters, List<AbstractCommand> commands) {
		this.name = name;
		this.parameters = parameters;
		this.commands = commands;
		
	}

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

	public List<AbstractCommand> getCommands() {
		return commands;
	}

	public void setCommands(List<AbstractCommand> commands) {
		this.commands = commands;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "IsiMethod [name=" + name + ", parameters=" + parameters + ", commands=" + commands + "]";
	}

}

package com.github.viniciusfcf.ast;

public class CommandEscrita extends AbstractCommand {

	private Object id;
	
	public CommandEscrita(Object id) {
		this.id = "\""+id.toString()+"\"";
	}
	
	public CommandEscrita(String id) {
		this.id = id;
	}
	
	public CommandEscrita(Boolean id) {
		this.id = id?"true":"false";
	}
	
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return "System.out.println("+id+");";
	}
	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}
	

}

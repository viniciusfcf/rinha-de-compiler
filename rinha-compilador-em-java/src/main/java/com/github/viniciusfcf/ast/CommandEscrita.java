package com.github.viniciusfcf.ast;

public class CommandEscrita extends AbstractCommand {

	private String id;

	public CommandEscrita(Object id) {
		setId(id);

	}

	private void setId(Object id) {
		if (id instanceof String) {
			this.id = "\"" + id.toString() + "\"";
		} else if (id instanceof Number) {
			this.id = id.toString();
		} else if (id instanceof Boolean) {
			this.id = ((Boolean) id) ? "true" : "false";
		} else {
			this.id = "\"" + id.toString() + "\"";
		}
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return "System.out.println(" + id + ");";
	}

	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}

}

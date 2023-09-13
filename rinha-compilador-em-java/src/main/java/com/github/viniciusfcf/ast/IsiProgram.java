package com.github.viniciusfcf.ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.github.viniciusfcf.datastructures.IsiMethod;
import com.github.viniciusfcf.datastructures.IsiSymbol;
import com.github.viniciusfcf.datastructures.IsiSymbolTable;

public class IsiProgram {
	private IsiSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;
	private ArrayList<IsiMethod> metodos;

	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public class MainClass{ \n");
		str.append("  public static void main(String args[]){\n ");
		str.append("  new MainClass().run();\n } \n");
		
		str.append(metodos());
		
		str.append(" private void run() {");
		
		str.append("      Scanner _key = new Scanner(System.in);\n");
		for (IsiSymbol symbol: varTable.getAll()) {
			str.append(symbol.generateJavaCode()+"\n");
		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
		}
		str.append("  }");
		str.append("}");
		
		try {
			FileWriter fr = new FileWriter(new File("/home/vinicius/desenvolvimento/rinha-de-compiler/rinha-compilador-em-java/src/main/java/MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	private String metodos() {
		StringBuilder sb = new StringBuilder();
		for (IsiMethod m : metodos) {
			sb.append("private void ")
					.append(m.getName())
					.append("(")
					;
					StringBuilder params = new StringBuilder();
					for (String p : m.getParameters()) {
						params.append(",Integer "+p);
					}
					sb.append(params.deleteCharAt(0));
					sb.append(") {\n");
					for (AbstractCommand command : m.getCommands()) {
						sb.append(command.generateJavaCode()+"\n");
					}
					
					sb.append("}\n");
		}
		return sb.toString();
	}

	public IsiSymbolTable getVarTable() {
		return varTable;
	}

	public void setVarTable(IsiSymbolTable varTable) {
		this.varTable = varTable;
	}

	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public ArrayList<IsiMethod> getMetodos() {
		return metodos;
	}

	public void setMetodos(ArrayList<IsiMethod> metodos) {
		this.metodos = metodos;
	}

}

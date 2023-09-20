package com.github.viniciusfcf.ast;

import java.util.ArrayList;

import com.github.viniciusfcf.datastructures.IsiMethod;

public class IsiProgram {
	private ArrayList<AbstractCommand> comandos = new ArrayList<AbstractCommand>();
	private String programName;
	private ArrayList<IsiMethod> metodos = new ArrayList<IsiMethod>();

	public String generateTarget() {
		StringBuilder str = new StringBuilder();
//		str.append("import com.github.viniciusfcf.Tupla;\n");
		str.append("public class MainClass{ \n");
		str.append("  public static void main(String args[]){\n ");
		str.append("  run();\n } \n");
		
		str.append(metodos());
		
		str.append(" public static void run() {");
		
//		for (IsiSymbol symbol: varTable.getAll()) {
//			str.append(symbol.generateJavaCode()+"\n");
//		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
		}
		str.append("  }");
		str.append(metodosDefault());
		str.append("}");
		
		String codigoGerado = str.toString();
//		try (FileWriter fr = new FileWriter(new File("/home/vinicius/desenvolvimento/rinha-de-compiler/src/main/java/MainClass.java"));
//				){
//			fr.write(codigoGerado);
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
		
		return codigoGerado;

	}

	private Object metodosDefault() {
		StringBuilder sb = new StringBuilder();
		sb.append("""
				
				public static Object first(Object o) {
					if(o instanceof Tupla) {
						Tupla t = (Tupla) o;
						return t.first;
					}
					throw new RuntimeException("first: Não é uma Tupla Sr.");
				}
				
				public static Object second(Object o) {
					if(o instanceof Tupla) {
						Tupla t = (Tupla) o;
						return t.second;
					}
					throw new RuntimeException("second: Não é uma Tupla Sr.");
				}
				
				
				""");
		return sb.toString();
	}


	private String metodos() {
		StringBuilder sb = new StringBuilder();
		for (IsiMethod m : metodos) {
			sb.append("private static int ")
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

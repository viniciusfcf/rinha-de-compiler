package com.github.viniciusfcf.ast;

import java.util.ArrayList;

import com.github.viniciusfcf.datastructures.IsiMethod;

public class IsiProgram {
	private ArrayList<AbstractCommand> comandos = new ArrayList<AbstractCommand>();
	private String programName;
	private ArrayList<IsiMethod> metodos = new ArrayList<IsiMethod>();

	public String generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("""
				import java.util.HashMap;
				import java.util.Map;

				""");
		str.append("public class MainClass{ \n");
		
		str.append("static Map<MyMapKey, Integer> cache = new HashMap<>(100_000); \n");
		
		str.append(cacheMethods());
		
		
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

	private String cacheMethods() {
		return """
				public static Integer getFromCache(String methodName, Object[] parameters) {
					return cache.get(new MyMapKey(methodName, parameters));
				}
				
				public static Integer putInCache(String methodName, Object[] parameters, Integer value) {
					cache.put(new MyMapKey(methodName, parameters), value);
					return value;
				}
				""";
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
				public static String print(Object obj) {
					String str = obj.toString();
					System.out.println(str);
					return str;
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
					StringBuilder paramsComTipo = new StringBuilder();
					StringBuilder paramsSemTipo = new StringBuilder();
					
					for (String p : m.getParameters()) {
						paramsComTipo.append(",Integer ").append(p);
						paramsSemTipo.append(",").append(p);
					}
					StringBuilder parameters = paramsComTipo.deleteCharAt(0);
					sb.append(parameters);
					sb.append(") {\n");
					
					sb.append(cacheVerification(m.getName(), paramsSemTipo.deleteCharAt(0).toString()));
					
					for (AbstractCommand command : m.getCommands()) {
						sb.append(command.generateJavaCode()+"\n");
					}
					
					
					
					
					sb.append("}\n");
		}
		return sb.toString();
	}

	private String cacheVerification(String name, String parameters) {
		StringBuilder sb = new StringBuilder();
				sb.append("var cached = getFromCache(\""+name+"\", new Object[] {").append(parameters).append("});")
				.append("""
						if(cached != null) {
							return cached;
						}
						
						""");
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

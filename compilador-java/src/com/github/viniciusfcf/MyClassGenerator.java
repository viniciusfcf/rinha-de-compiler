package com.github.viniciusfcf;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class MyClassGenerator {

	static final String className = "javademo";
	
	static Path temp = Paths.get(System.getProperty("java.io.tmpdir"), className);
	
	
	public static void main(String[] args) throws Exception {
		
		String code = "public class " + className + " {" +
				"public static void run() {\n" +
				"       System.out.println(\"Hello Vinicius\"); \n" +
				"    }" +
				"}";
		
		compile(code);
		
		//----------------
		
		Class javaDemoClass = load();
		run(javaDemoClass, "run"); 
	}

	private static void run(Class javaDemoClass, String methodName)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = javaDemoClass.getMethod(methodName);
		method.invoke(null);
	}

	private static Class load() throws MalformedURLException, ClassNotFoundException {
		ClassLoader classLoader = MyClassGenerator.class.getClassLoader();
		URLClassLoader urlClassLoader = new URLClassLoader(
				new URL[] { temp.toUri().toURL() },
				classLoader);
		Class javaDemoClass = urlClassLoader.loadClass(className);
		return javaDemoClass;
	}
	
	public static void compile(String code) throws Exception {
		
		Files.createDirectories(temp);
		
		Path javaSourceFile = Paths.get(temp.normalize().toAbsolutePath().toString(), className + ".java");
		System.out.println("The java source file is loacted at "+javaSourceFile);
		
		Files.write(javaSourceFile, code.getBytes());
		
		File[] files1 = {javaSourceFile.toFile()};
		
		// Get the compiler
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> compilationUnits =
				fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1));
		// A feedback object (diagnostic) to get errors
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		// Compilation unit can be created and called only once
		JavaCompiler.CompilationTask task = compiler.getTask(
				null,
				fileManager,
				diagnostics,
				null,
				null,
				compilationUnits
		);
		// The compile task is called
		task.call();
		// Printing of any compile problems
		for (Diagnostic diagnostic : diagnostics.getDiagnostics())
			System.out.format("Error on line %d in %s%n",
					diagnostic.getLineNumber(),
					diagnostic.getSource());

		// Close the compile resources
		fileManager.close();
	}
}

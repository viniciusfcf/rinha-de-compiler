package com.github.viniciusfcf;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.github.viniciusfcf.generated.RinhaLangLexer;
import com.github.viniciusfcf.generated.RinhaLangParser;

@SuppressWarnings("unused")
public class MyClassGenerator {

	static final String className = "MainClass";
	
	public static void main(String[] args) throws Exception {
		
		if(args.length == 0) {
			args = new String[] {"input.rinha"};
		}
//		System.out.println(Arrays.toString(args));
		
		RinhaLangLexer lexer = new RinhaLangLexer(CharStreams.fromFileName(args[0]));
		
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        RinhaLangParser parser = new RinhaLangParser(tokens);

        ParseTree tree = parser.prog(); // begin parsing at init rule
//        parser.exibeMetodos();
//        parser.exibeComandos();
		
		String code = parser.generateCode();
        
		var directory = Files.createTempDirectory("");
		compile(directory, code);
		
		Class<?> javaDemoClass = load(directory);
		run(javaDemoClass, "run"); 
	}	

	private static void run(Class<?> javaDemoClass, String methodName)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = javaDemoClass.getMethod(methodName);
		method.invoke(null);
	}

	private static Class<?> load(Path file) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try(URLClassLoader urlClassLoader = new URLClassLoader(
				new URL[] { file.toUri().toURL() },
				classLoader);) {
			Class<?> javaDemoClass = urlClassLoader.loadClass(className);
			return javaDemoClass;
		}
		
	}
	
	public static void compile(Path file, String code) throws Exception {
		
		Files.createDirectories(file);
		
		Path javaSourceFile = Paths.get(file.normalize().toAbsolutePath().toString(), className + ".java");
		Files.write(javaSourceFile, code.getBytes());
		
		File[] files1 = {javaSourceFile.toFile()};
		
		// Get the compiler
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);) {
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
			for (Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
				System.err.format("Error on line %d in %s%n %s",
						diagnostic.getLineNumber(),
						diagnostic.getSource(),
						diagnostic.getMessage(Locale.US));
			}
		}
	}
}

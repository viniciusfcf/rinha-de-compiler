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

	static final String className = "javademo";
	
//	Tupla t;
	
	static Path temp = Paths.get(System.getProperty("java.io.tmpdir"), className);
	
	
	public static void main(String[] args) throws Exception {
		
		String arrayContent = 	"{1,2,3,5}";
		RinhaLangLexer lexer = new RinhaLangLexer(CharStreams.fromFileName("input.isi"));
		
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        RinhaLangParser parser = new RinhaLangParser(tokens);

        ParseTree tree = parser.prog(); // begin parsing at init rule
        parser.exibeComandos();
		
		parser.generateCode();
        
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        

		System.out.println("-------------------------");
        
        
        
//        String expressionContent = 	"5 * ( 1+3)";
//		ArrayInitLexer expressionLexer = new ArrayInitLexer(CharStreams.fromString(expressionContent));
//		
//        // create a buffer of tokens pulled from the lexer
//        CommonTokenStream expressionTokens = new CommonTokenStream(expressionLexer);
//
//        // create a parser that feeds off the tokens buffer
//        ArrayInitParser expressionParser = new ArrayInitParser(expressionTokens);
//        expressionParser.addParseListener(new MyArrayIntListener());
//
//        ParseTree expressionTree = expressionParser.expression(); // begin parsing at expression rule
//        System.out.println(expressionTree.toStringTree(expressionParser)); // print LISP-style tree
        
        
        
        
        
        
		System.out.println("-------------------------");
        
		System.out.println("-------------------------");
		String code = "import com.github.viniciusfcf.Tupla;"+
				"import static com.github.viniciusfcf.MyUtils.*;"+
				"public class " + className + " {" +
				"public static void run() {\n" +
				"       print(\"Hello Vinicius\"); \n" +
				"       print(first(new Tupla(1,2))); \n" +
				"       print(second(new Tupla(1,2))); \n" +
//				"       print(second(1)); \n" +
				"    }" +
				"}";
		
		compile(code);
		
		//----------------
		
		Class<?> javaDemoClass = load();
		run(javaDemoClass, "run"); 
	}	

	private static void run(Class<?> javaDemoClass, String methodName)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = javaDemoClass.getMethod(methodName);
		method.invoke(null);
	}

	private static Class<?> load() throws ClassNotFoundException, IOException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try(URLClassLoader urlClassLoader = new URLClassLoader(
				new URL[] { temp.toUri().toURL() },
				classLoader);) {
			Class<?> javaDemoClass = urlClassLoader.loadClass(className);
			return javaDemoClass;
		}
		
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
		for (Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
			System.out.format("Error on line %d in %s%n %s",
					diagnostic.getLineNumber(),
					diagnostic.getSource(),
					diagnostic.getMessage(Locale.US));
		}
		// Close the compile resources
		fileManager.close();
	}
}

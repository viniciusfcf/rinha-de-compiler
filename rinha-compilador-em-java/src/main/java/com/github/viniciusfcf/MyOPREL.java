package com.github.viniciusfcf;

public enum MyOPREL {
//	Add	Soma	3 + 5 = 8, "a" + 2 = "a2", 2 + "a" = "2a", "a" + "b" = "ab"
//			Sub	Subtração	0 - 1 = -1
//			Mul	Multiplicação	2 * 2 = 4
//			Div	Divisão	3 / 2 = 1
//			Rem	Resto da divisão	4 % 2 = 0
//			Eq	Igualdade	"a" == "a", 2 == 1 + 1, true == true
//			Neq	Diferente	"a" != "b", 3 != 1 + 1, true != false
//			Lt	Menor	1 < 2
//			Gt	Maior	2 > 3
//			Lte	Menor ou igual	1 <= 2
//			Gte	Maior ou igual	1 >= 2
//			And	Conjunção	true && false
//			Or	Disjunção	false || true
	
	Add("+"),
	Sub("-"),
	Mul("*"),
	Div("/"),
	Rem("%"),
	Eq("=="),
	Neq("!="),
	Lt("<"),
	Gt(">"),
	Lte("<="),
	Gte(">="),
	And("&&"),
	Or("||"),
	
	;
	
	private final String javaRepresentation;
	
	private MyOPREL(String javaRepresentation) {
		this.javaRepresentation = javaRepresentation;
	}
	
	public String getJavaRepresentation() {
		return javaRepresentation;
	}
	
	public static Object teste(int um, int dois) {
		var tres = um;
		return tres+dois;
	}
	
	public static void main(String[] args) {
		System.out.println(MyOPREL.valueOf("Gt").getJavaRepresentation());
	}
	
	
}

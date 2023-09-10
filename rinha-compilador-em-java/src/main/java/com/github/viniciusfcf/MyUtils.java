package com.github.viniciusfcf;

public class MyUtils {

	public static void print(Object o) {
		System.out.println(o);
	}
	
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
	
	
}

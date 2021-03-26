package com.github.lbcoutinho.javase11practice._10nestedclassesandlambdas;

public class NestedStaticClass {

	private String name;
	private static final String CODE = "code";

	public void outerMethod() {
	}

	public static void outerStaticMethod() {
	}

	public static class NestedClass {

		// Static inner class can access static members of the outer class
		public void method() {
//			System.out.println(name);
//			outerMethod();
			System.out.println(CODE);
			outerStaticMethod();
		}
	}

	public static void main(String[] args) {
		// You can create instances of the nested static class without an instance of the outer class
		new NestedStaticClass.NestedClass();
	}
}

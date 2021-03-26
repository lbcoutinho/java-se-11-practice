package com.github.lbcoutinho.javase11practice._10nestedclassesandlambdas;

public class NestedLocalClass {

	private String name = "name";
	private static final String CODE = "code";

	public void method1(String arg1, final String arg2, String arg3) {
		String var1 = "1";
		final String var2 = "2";
		String var3 = "3";
		var1 = "updated var1";
		arg1 = "updated arg1";

		// Classes defined inside a method context are defined as "Local Inner Classes"
		class LocalClass {

			public void print() {
				// It can access class members
				System.out.println(name);
				System.out.println(CODE);
				// It can access method arguments (final or effectively final)
//				System.out.println(arg1);
				System.out.println(arg2);
				System.out.println(arg3);
				// It can access method variables and constants (final or effectively final)
//				System.out.println(var1);
				System.out.println(var2);
				System.out.println(var3);
			}
		}

		new LocalClass().print();
	}

	public void method2() {
		// LocalClass is available only in the context of method1.
//		new LocalClass().print();
	}

	public static void main(String[] args) {
		new NestedLocalClass().method1("arg1", "arg2", "arg3");
	}
}

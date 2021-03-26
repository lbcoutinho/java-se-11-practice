package com.github.lbcoutinho.javase11practice._10nestedclassesandlambdas;

import java.util.Arrays;

public abstract class NestedAnnonymousClass {

	public void method(String... args) {
		System.out.println(Arrays.toString(args));
	}

	public abstract String absMethod();

	public static void main(String[] args) {
		// When creating the class instance it's possible to override ANY method inline
		var a = new NestedAnnonymousClass() {
			@Override
			public void method(String... args) {
				System.out.println("overrided");
			}

			@Override
			public String absMethod() {
				return "returned abs";
			}
		};

		a.method("a","b");
		System.out.println("a.absMethod() = " + a.absMethod());
	}
}

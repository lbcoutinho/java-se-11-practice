package com.github.lbcoutinho.javase11practice._10nestedclassesandlambdas;

public class NestedMemberClass {

	private String name;
	private static final String CODE = "code";

	public void outerMethod() {
	}

	public static void outerStaticMethod() {
	}

	class MemberClass {

		// Member inner class can any members of the outer class
		public void method() {
			System.out.println(name);
			outerMethod();
			System.out.println(CODE);
			outerStaticMethod();
		}
	}

	public static void main(String[] args) {
//		new NestedMemberClass.MemberClass();
		// You need to create an instance of the outer class to be able to create instances of the member class
		var a = new NestedMemberClass();
		var member = a.new MemberClass();
	}
}

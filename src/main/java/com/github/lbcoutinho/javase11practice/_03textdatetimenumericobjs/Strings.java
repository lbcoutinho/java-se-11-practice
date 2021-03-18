package com.github.lbcoutinho.javase11practice._03textdatetimenumericobjs;

public class Strings {

	public static void main(String[] args) {
		/*
		JVM can optimize memory allocated to store String objects by maintaining
		a single copy of each String literal in the String Pool memory area,
		regardless of how many variables reference this copy.

		This process is called interning

		When a String is created using the constructor a new memory space is allocated,
		even when there is already the same String in the String pool.
		 */
		String s1 = "text";
		System.out.println("s1.intern() = " + s1.intern());

		String s2 = "";
		s2 = 1+1+"u";
		System.out.println("s2 = " + s2);
		s2 = "u"+1+1;
		System.out.println("s2 = " + s2);
		s2 = "u"+(1+1);
		System.out.println("s2 = " + s2);

		/*
		Substring method has begin index in inclusive, but end index is not.
		Example below will print letter from index 0 to 4.
		 */
		String s3 = "HelloWorld";
		System.out.println(s3 + " => s3.substring(0, 5) = " + s3.substring(0, 5));

		// StringBuilder that is initialized with empty construtor has initial capacity of 16 by can increase automatically
		StringBuilder sb1 = new StringBuilder();
		System.out.println("sb1.capacity(); = " + sb1.capacity());
		// When it's initialized with a text, the capacity = 16 + text.size
		StringBuilder sb2 = new StringBuilder("1234567890");
		System.out.println("sb2.capacity(); = " + sb2.capacity());
		sb2.append("12345678901234567");
		System.out.println("sb2.capacity(); = " + sb2.capacity());
	}
}

package com.github.lbcoutinho.javase11practice._02primitivetypesandflow;

public class Main {

	public static void main(String[] args) {
		/*
		Primitive type variables can be assigned with Binary, Octal, Decimal or Hex values.
		Below are 4 different representations of the number 42.
		 */
		int a = 0b101010; // Binary
		System.out.println("a = " + a);
		short b = 052; // Octal
		System.out.println("b = " + b);
		byte c = 42; // Decimal
		System.out.println("c = " + c);
		long d = 0x2A; // Hex
		System.out.println("d = " + d);
		float f = 1.99E2F;
		System.out.println("f = " + f);

		/*
		Operators precedence
		 */
		var ten = 10;
		System.out.println("ten = " + ten);
		var val1 = ++ten;
		System.out.println("val1 = " + val1);
		System.out.println("ten = " + ten);
		var val2 = ten++;
		System.out.println("val2 = " + val2);
		System.out.println("ten = " + ten);

		/*
		Arithmetics operations and type casting
		 */
		byte b1 = 127, b2 = 5;
		byte b3 = (byte) (b1 +b2);
		System.out.println("b3 = " + b3); // value = -124 because the operation overflow the byte type size and the cast is enforcing the type
		var b4 = b1 +b2;
		System.out.println("b4 = " + b4); // value = 132 (correct), the compiler automatically convert the type byte to int to avoid overflow
		/*git
		The resulting type of arithmetic operations on types smaller than int is an int;
		other otherwise, the result is of a type of a largest participant
		 */
		int i1 = b1/b2;
		System.out.println("i1 = " + i1); // value = 25
		float f1 = b1/b2; // Since operation results in int, value 25.0F
		System.out.println("f1 = " + f1);
		float f2 = b1/ (float) b2; // Operation result assumes the type of the largest participant = float, value = 25.4F
		System.out.println("f2 = " + f2);

		/*
		Conditional operator
		 */
		int o1 = 3, o2 = 1;
		// Exclusive OR: to obtain result = true, one condition has to be true and the other false. In this example.
		boolean o3 = o1 > o2 ^ o2 == 1; // value = false
		System.out.println("o3 = " + o3);
		boolean o4 = o1 > o2 ^ o2 != 1; // value = true
		System.out.println("o4 = " + o4);


	}
}

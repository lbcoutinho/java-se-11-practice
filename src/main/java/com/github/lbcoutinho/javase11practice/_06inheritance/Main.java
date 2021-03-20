package com.github.lbcoutinho.javase11practice._06inheritance;

public class Main {

	public static void main(String[] args) {
		new Food();
		new Food();
		/*
		Output:
			Product static init
			Food static init
			Product instance init
			Product constructor
			Food instance init
			Food constructor
			Product instance init
			Product constructor
			Food instance init
			Food constructor
		---
		Static init happens only once, when the classes are loaded to memory.
		Instance init a and constructor are executed on every instance creation,
			starting from the parent to the child classes.
		 */

		Food a = new Food();
		Product  b = new Product();
		Product c = new Food();

		System.out.println(a.whoAmI());
		System.out.println(b.whoAmI());
		System.out.println(c.whoAmI());
		/*
		Output:
			I'm a Food instance
			I'm a Product instance
			I'm a Food instance
		 */

	}
}

package com.github.lbcoutinho.javase11practice._06inheritance;

public class Food extends Product {
	static {
		System.out.println("Food static init");
	}

	{
		System.out.println("Food instance init");
	}

	public Food() {
		System.out.println("Food constructor");
	}

	public String whoAmI() {
		return "I'm a Food instance";
	}
}

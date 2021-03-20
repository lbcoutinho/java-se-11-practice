package com.github.lbcoutinho.javase11practice._06inheritance;

public class Product {
	static {
		System.out.println("Product static init");
	}

	{
		System.out.println("Product instance init");
	}

	public Product() {
		System.out.println("Product constructor");
	}

	public String whoAmI() {
		return "I'm a Product instance";
	}
}

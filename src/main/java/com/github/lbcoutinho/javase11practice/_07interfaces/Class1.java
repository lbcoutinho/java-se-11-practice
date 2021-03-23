package com.github.lbcoutinho.javase11practice._07interfaces;

public class Class1 implements Interface1, Interface2{
	/*
	* When 2 or more interfaces have confliting methods, the implementing class is obligated to override the method
	 */
	@Override
	public void printName() {
		Interface1.super.printName();
	}

	public static void main(String[] args) {
		Class1 c = new Class1();
		c.printName();
	}
}

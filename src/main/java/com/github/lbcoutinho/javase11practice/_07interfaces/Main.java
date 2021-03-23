package com.github.lbcoutinho.javase11practice._07interfaces;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		/*
		* Clonable interface masks a classes as "clonable".
		* This interface type is checked by the Object#clone method before performing
		* the object clone on the heap.
		* If a class that doesn't implements Clonable try to use clone method, it will throw CloneNotSupportedException
		 */

		var c1 = new ClassNotClonable("no clone");
		System.out.println("c1 = " + c1);
		var c2 = new ClassClonable("clonable");
		System.out.println("c2 = " + c2);

		try {
			var c11 = c1.clone();
			System.out.println("c11 = " + c11);
		} catch (CloneNotSupportedException e) {
			System.out.println("Error trying to clone c1");
		}
		var c22 = (ClassClonable) c2.clone();
		System.out.println("c22 = " + c22);
		c22.setTitle("clonable 2");
		System.out.println("c2 = " + c2);
		System.out.println("c22 = " + c22);
	}
}

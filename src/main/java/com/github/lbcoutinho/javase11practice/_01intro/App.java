package com.github.lbcoutinho.javase11practice._01intro;

public class App {

	/*
	Compile the this class using: javac -d ./classes src/main/java/com/github/lbcoutinho/javase11practice/compiler/App.java
	This will generate a .class file at ./class directory

	Execute the code using: java -cp ./classes com.github.lbcoutinho.javase11practice.compiler.App lbcoutinho

	Expected output: Hello lbcoutinho
	 */
	public static void main(String[] args) {
		System.out.println("Hello " + (args.length > 0 ? args[0] : ""));
	}
}

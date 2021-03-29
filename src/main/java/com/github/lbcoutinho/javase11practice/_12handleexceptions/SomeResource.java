package com.github.lbcoutinho.javase11practice._12handleexceptions;

import java.io.FileNotFoundException;

public class SomeResource implements AutoCloseable {

	public void operation(String filename) throws FileNotFoundException {
//		throw new FileNotFoundException("file " + filename + " not found.");
		System.out.println("SomeResource.operation");
	}

	@Override
	public void close() {
		throw new RuntimeException("runtime exception");
	}
}

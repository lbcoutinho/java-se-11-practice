package com.github.lbcoutinho.javase11practice._13javaioapi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputStreams {

	// Streams deal with binary data, working with byte arrays
	public static void main(String[] args) {
		try (FileInputStream in = new FileInputStream("java-logo.jpg");
			 FileOutputStream out = new FileOutputStream("copy-java-logo.jpg")) {
			var buffer = new byte[1024];
			var length = 0;
			var readCount = 1;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
				System.out.printf("reads = %d, length = %d%n", readCount++, length);
			}
			System.out.printf("reads = %d, length = %d%n", readCount++, length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.github.lbcoutinho.javase11practice._13javaioapi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileReaderWriter {

	// Reader and Writer deal with text data, working with char arrays
	public static void main(String[] args) {
		try (FileReader in = new FileReader("text-file.txt", UTF_8);
			 FileWriter out = new FileWriter("copy-text-file.txt", UTF_8)) {
			var buffer = new char[1024];
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

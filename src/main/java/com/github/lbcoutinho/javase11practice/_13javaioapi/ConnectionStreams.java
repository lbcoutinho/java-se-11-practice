package com.github.lbcoutinho.javase11practice._13javaioapi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ConnectionStreams {

	public static void main(String[] args) {
		try (BufferedReader in =
					 // BufferedReader provide readLine method
					 new BufferedReader(
							 // InputStreamReader converts bytes to chars
							 new InputStreamReader(
									 // FileInputStream reads byte from file
									 new FileInputStream("text-file.txt"), UTF_8));
			 PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("copy-text-file-2.txt")))) {
			String line = null;
			var lineCount = 1;
			while ((line = in.readLine()) != null) {
				out.println(line);
				System.out.printf("read line = %d%n", lineCount++);
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

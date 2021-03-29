package com.github.lbcoutinho.javase11practice._12handleexceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class.getName());
	public static final String CLASS_NAME = Main.class.getSimpleName();

	public static void main(String[] args) {
//		demoLogs();
//		tryWithResources();
		demoTryCatch();
//		demoAsserts(null);
	}

	private static void demoLogs() {
		var methodName = "demoMethod";
		log.entering(CLASS_NAME, methodName);

		log.logp(Level.INFO, CLASS_NAME, methodName, "Test logp");
		var e = new IOException("IO expcetion created manually");
		log.throwing(CLASS_NAME, methodName, e);

		log.exiting(CLASS_NAME, methodName);
	}

	private static void tryWithResources() {
		var methodName = "tryWithResources";
		try(SomeResource sr = new SomeResource()) {
			sr.operation("my-file");
		} catch (FileNotFoundException e) {
			System.out.println("catch FileNotFoundException: " + e.getMessage());
			log.throwing(CLASS_NAME, methodName, e);
			// Exception thrown when closing a resource from try-with-resource, are should as suppressed
			Throwable[] supressed = e.getSuppressed();
			System.out.println("supressed.length = " + supressed.length);
			System.out.println(Arrays.toString(supressed));
		} catch (RuntimeException e) {
			// If no exception occurs during resource usage but occurs during resource closing,
			// then it can be caught in a specific catch block as the main exception (not as suppressed)
			System.out.println("catch RuntimeException: " + e.getMessage());
			Throwable[] supressed = e.getSuppressed();
			System.out.println("supressed.length = " + supressed.length);
			System.out.println(Arrays.toString(supressed));
		}
	}

	private static void demoTryCatch() {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			System.out.println("catch NullPointerException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("catch Exception: " + e.getMessage());
		}
	}

	private static void demoAsserts(String arg) {
		var args = Objects.requireNonNull(arg);
		System.out.println("args = " + args);
	}
}

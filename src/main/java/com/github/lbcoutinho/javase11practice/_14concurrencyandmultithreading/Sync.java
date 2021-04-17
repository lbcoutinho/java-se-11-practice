package com.github.lbcoutinho.javase11practice._14concurrencyandmultithreading;

import java.time.LocalTime;

public class Sync {

    public static class Logger {
        private String name;

        public Logger(String name) {
            this.name = name;
        }

        public synchronized void logMe(String threadName) {
            System.out.printf("%s: Thread %s is logging at %s...\n", name, threadName, LocalTime.now());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s: Thread %s is out logging at %s\n", name, threadName, LocalTime.now());
        }
    }

    public static void main(String[] args) {
        // Synchronized method blocks thread execution if the monitor instance is shared between the thread (example 1)
        // Example 1
        var logger = new Logger("L1");
        Runnable r1 = () -> logger.logMe(Thread.currentThread().getName());
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();

        // Example 2
        Runnable r2 = () -> new Logger("L2").logMe(Thread.currentThread().getName());
        new Thread(r2).start();
        new Thread(r2).start();
        new Thread(r2).start();
        try {
            new Object().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

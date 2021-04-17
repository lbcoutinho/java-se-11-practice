package com.github.lbcoutinho.javase11practice._14concurrencyandmultithreading;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exec {

    private static int count = 1;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Runnable r = () -> {
            System.out.printf("Thread %s is running execution %d at %s\n", Thread.currentThread().getName(), count++, LocalTime.now());
//            try {
//                Thread.sleep(1500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        };
        for (int i = 0; i < 10; i++) {
            es.execute(r);
        }
        es.shutdown();
    }
}

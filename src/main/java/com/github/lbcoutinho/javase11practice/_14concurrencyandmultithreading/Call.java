package com.github.lbcoutinho.javase11practice._14concurrencyandmultithreading;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Call {

    private static int count = 1;

    public static void main(String[] args) {
        Callable<String> c = ()->{
            Thread.sleep(2000);
            return "Call " + count++;
        };
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<String> promise = es.submit(c);
        System.out.printf("Promise received at %s: %s\n", LocalTime.now(), promise);
        try {
            // Get invocation blocks execution until promise is resolved
            String result = promise.get();
            System.out.printf("Promise resolved at %s: %s\n", LocalTime.now(), result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }
}

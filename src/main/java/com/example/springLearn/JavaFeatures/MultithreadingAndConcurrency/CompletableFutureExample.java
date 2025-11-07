package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("main thread starts");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("future thread : exploring completable future");
            return "OK";
        });

        //below methods blocks the execution and main thread will be executed after future thread
        //future.get();
        //future.join();

        log.info("main thread ends");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

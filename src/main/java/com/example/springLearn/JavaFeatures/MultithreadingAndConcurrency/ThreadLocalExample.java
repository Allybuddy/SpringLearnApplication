package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalExample {

    public static void main(String[] args){

        String userId = "B08455";

        ThreadLocal<String > threadLocal = new ThreadLocal<>();

        Thread t1 = new Thread( () -> {
            threadLocal.set(userId);
            log.info("thread local for user " + threadLocal.get());
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            threadLocal.set("Allvin");
            log.info(threadLocal.get() + " is a good boy.");
        });
        t2.start();

        //InheritableThreadLocal
        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread t3 = new Thread(() -> {
            inheritableThreadLocal.set("Nexon");
            log.info(inheritableThreadLocal.get() + " is a car");

            Thread t4 = new Thread(() -> {
                log.info(inheritableThreadLocal.get() + " is my wonder car");
            });
            t4.start();
        });
        t3.start();
    }
}

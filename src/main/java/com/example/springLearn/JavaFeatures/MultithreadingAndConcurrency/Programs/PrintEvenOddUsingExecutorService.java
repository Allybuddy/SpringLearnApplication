package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintEvenOddUsingExecutorService {

    static class EvenOddClass{

        int i = 0;
        public synchronized void printEven(){
            try {
                while (i < 10){
                    while(i%2 != 0) {
                        wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    i++;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized void printOdd(){
            try {
                while (i < 10){
                    while (i%2 == 0) {
                        wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    i++;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //method 1
        EvenOddClass obj = new EvenOddClass();

        Thread t1 = new Thread(obj::printEven);
        Thread t2 = new Thread(obj::printOdd);
        t1.start();
        t2.start();

        Thread.sleep(10);

        //method 2
        AtomicInteger i = new AtomicInteger(0);
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.submit(() -> {
            while(i.get() < 10){
                if(i.get() %2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " " + i.get());
                    i.getAndIncrement();
                }
            }

        });

        ex.submit(() -> {
            while (i.get() < 10){
                if(i.get() %2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " " + i.get());
                    i.getAndIncrement();
                }
            }
        });

        ex.shutdown();




    }
}

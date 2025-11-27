package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Print1To100Using10Threads {

    public static void main(String[] args) {

        Print ob = new Print();
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(ob::printNos);
            t.setName("Worker-" + i);
            t.start();
        }
    }

    private static class Print{

        static int counter = 1;

        public synchronized void printNos(){

            while (counter <= 100){
                var threadName = Thread.currentThread().getName();
                log.info("{} : {}", threadName, counter);
                counter++;

                notifyAll();
                try {
                    if (counter <= 100){
                        wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

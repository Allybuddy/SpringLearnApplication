package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintEvenOddUsing2Threads {

    public static void main(String[] args) {
        PrintNos ob = new PrintNos();
        Thread t1 = new Thread(ob::printEven);
        Thread t2 = new Thread(ob::printOdd);
        t1.start();
        t2.start();
    }

    private static class PrintNos{
         int number = 1;
         static final int MAX_NO = 10;

         public synchronized void printEven() {
             while (number<=MAX_NO){
                 while (number%2 != 0) {
                     try{
                         wait();
                     }
                     catch (InterruptedException e){

                     }
                 }
                 log.info("{} : {}", Thread.currentThread().getName(), number);
                 number++;
                 notifyAll();
             }
         }

         public synchronized void printOdd() {
             while (number<MAX_NO){
                 while (number%2 == 0) {
                     try{
                         wait();
                     }
                     catch (InterruptedException e){

                     }
                 }
                 log.info("{} : {}", Thread.currentThread().getName(), number);
                 number++;
                 notifyAll();
             }
         }
    }
}

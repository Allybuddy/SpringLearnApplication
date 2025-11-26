package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABCReentrantLock {

    public static void main(String[] args) {

        Print ob = new Print();

        Thread t1 = new Thread(ob::printA);
        Thread t2 = new Thread(ob::printB);
        Thread t3 = new Thread(ob::printC);

        t1.start();
        t2.start();
        t3.start();
    }

    private static class Print{

        private final ReentrantLock lock = new ReentrantLock(true);
        private final Condition condA= lock.newCondition();
        private final Condition condB= lock.newCondition();
        private final Condition condC= lock.newCondition();

        int cycle = 5;
        String control = "A";

        public void printA(){
            lock.lock();
            try {
                for (int i=0 ; i< cycle; i++) {
                    while (!control.equals("A")) {
                            condA.await();
                        }
                    System.out.print("A");
                    control = "B";
                    condB.signal();
                }
            }catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
        }

        public void printB(){
            lock.lock();
            try {
                for (int i=0 ; i< cycle; i++) {
                while (!control.equals("B")) {
                        condB.await();

                }
                System.out.print("B");
                control = "C";
                condC.signal();
            }
            }catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
        }

        public void printC(){
            lock.lock();
            try {
                for (int i=0 ; i< cycle; i++) {
                while (!control.equals("C")) {
                        condC.await();
                }
                System.out.print("C ");
                control = "A";
                condA.signal();
            }
            }catch (InterruptedException e) {
            }finally {
                lock.unlock();
            }
        }
    }
}

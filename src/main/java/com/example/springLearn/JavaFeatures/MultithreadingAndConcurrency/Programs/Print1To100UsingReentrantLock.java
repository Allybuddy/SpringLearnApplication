package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Print1To100UsingReentrantLock {

    public static void main(String[] args) {

        Print ob = new Print();

        for (int i = 0; i< 10; i++){
            int threadNo = i;
            new Thread(() -> ob.printNos(threadNo)).start();
        }
    }

    private static class Print{
        int count = 1;
        int MAX = 100;

        private final ReentrantLock lock = new ReentrantLock();
        private final Condition cond = lock.newCondition();

        public void printNos(int threadNo){
            lock.lock();
            try{
                while ( count <= MAX){

                    while ((count-1) % 10 != threadNo){
                        cond.await();
                        if (count> MAX){
                            return;
                        }
                    }
                    log.info("{} : {}", Thread.currentThread().getName(), count);
                    count++;
                    cond.signalAll();
                }
            }catch (InterruptedException e){

            }finally {
                lock.unlock();
            }
        }
    }
}

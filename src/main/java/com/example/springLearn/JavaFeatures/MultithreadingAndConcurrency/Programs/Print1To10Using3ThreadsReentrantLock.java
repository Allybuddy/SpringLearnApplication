package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Print1To10Using3ThreadsReentrantLock {

    /*Print numbers from 1 to 10 using 3 threads, where:
        Thread T1 prints: 1, 4, 7, 10
        Thread T2 prints: 2, 5, 8
        Thread T3 prints: 3, 6, 9*/

    public static void main(String[] args) {

        Print ob = new Print();
        for (int i=1; i<=3; i++){
            var threadNo = i;
            new Thread(() -> ob.printNos(threadNo)).start();

        }
    }

    private static class Print{
        volatile int count = 1;
        final int MAX = 10;
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition condition1 = lock.newCondition();
        private final Condition condition2 = lock.newCondition();
        private final Condition condition3 = lock.newCondition();

        public void printNos(int threadNo){

            try {
                lock.lock();
                while (count <= MAX) {
                    if (threadNo == 1) {
                        while (count % 3 != 1) {
                            condition1.await();
                        }
                    } else if (threadNo == 2) {
                        while (count % 3 != 2) {
                            condition2.await();
                        }
                    } else {
                        while (count % 3 != 0) {
                            condition3.await();
                        }
                    }
                    if (count > MAX) return;
                    log.info("thread no {} : {}", threadNo, count);
                    count++;

                    if (threadNo == 1){
                        condition2.signal();
                    } else if (threadNo == 2) {
                        condition3.signal();
                    }else if (threadNo == 3) {
                        condition1.signal();
                    }
                }
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }finally{
                    lock.unlock();
                }
            }
    }
}

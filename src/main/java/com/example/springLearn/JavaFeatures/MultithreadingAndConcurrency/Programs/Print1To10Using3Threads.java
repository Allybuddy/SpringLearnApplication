package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Print1To10Using3Threads {

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
        public synchronized void printNos(int threadNo){

            try {

                while (count <= MAX){
                    while (threadNo == 1 && count % 3 !=1){
                        wait();
                    }
                    while (threadNo == 2 && count % 3 !=2){
                        wait();
                    }
                    while (threadNo == 3 && count % 3 !=0){
                        wait();
                    }
                    if (count > MAX) return;
                    log.info("thread no {} : {}",threadNo, count);
                    count++;
                    notifyAll();

                    //logic 2 similar to above
                    /*while (count <= MAX) {
                    while ((count - 1) % 3 != threadNo - 1) {
                        wait();
                        if (count > MAX)
                            return;
                    }
                    log.info("thread no {} : {}",threadNo, count);
                    count++;
                    notifyAll();
                }*/
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

/*
* while (count <= MAX) {

            while ((count - 1) % 3 != threadNo - 1) {
                wait();
                if (count > MAX)
                    return;
            }

            System.out.println("T" + threadNo + " → " + count);
            count++;

            notifyAll();
        }
* */

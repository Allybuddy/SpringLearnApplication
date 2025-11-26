package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {
        int capacity = 5;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

        Thread t1 = new Thread(() -> {
            try {
                for(int i=1; i<=10; i++){
                    queue.put(i);  //remember method names for ArrayBlockingQueue
                    log.info("Producer : {}", i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for(int i=1 ;i<= 10; i++){
                    var value = queue.take();  //remember method names for ArrayBlockingQueue
                    log.info("Consumer : {}", value);
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        });
        t1.start();
        t2.start();
    }
}

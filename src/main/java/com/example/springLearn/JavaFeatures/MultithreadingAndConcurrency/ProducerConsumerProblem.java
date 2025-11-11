package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class ProducerConsumerProblem {

    int capacity;
    Queue<Integer> queue = new LinkedList();

    public ProducerConsumerProblem(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        if (queue.size() == capacity){
            wait();
        }
        queue.add(value);
        log.info("Producer : {}", value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        if (queue.isEmpty()){
            wait();
        }
        var queueValue = queue.poll();
        log.info("Consumer : {}", queueValue);
        notifyAll();
        return queueValue;
    }

    public static void main(String[] args) {

        ProducerConsumerProblem pcQueue = new ProducerConsumerProblem(3);
        Thread t1 = new Thread(() -> {
            for (int i = 1;i<=10; i++){
                try {
                    pcQueue.produce(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i<=10; i++){
                try {
                    pcQueue.consume();
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        });
        t1.start();
        t2.start();
    }

}

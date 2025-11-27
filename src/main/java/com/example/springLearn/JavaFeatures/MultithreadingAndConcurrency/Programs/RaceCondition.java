package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class RaceCondition {

    /*
        Which thread will win?
            (or)
        What will be the final value of counter?

        This is a race condition question.

        Why is it a Race Condition?

        counter++ is not atomic.
        It is broken into 3 steps internally:
            1. Read counter
            2. Increment value
            3. Write back
        Both threads can interleave these steps:
            t1 reads 0
            t2 reads 0
            t1 writes 1
            t2 writes 1
        Final result = 1 (Wrong! Should be 2)

        The result is unpredictable because counter++ is not atomic.
        Use AtomicInteger instead of int to fix the race condition.
     */
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

            new Thread(() -> {
                counter.getAndIncrement();
            }).start();

            new Thread(counter::getAndIncrement).start();

            log.info("counter : {}", counter);

    }

}

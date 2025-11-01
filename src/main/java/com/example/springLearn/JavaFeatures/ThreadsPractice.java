package com.example.springLearn.JavaFeatures;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Test1 implements Runnable{

    @Override
    public void run() {
        log.info("running test 1");
    }
}
@Slf4j
class Test2 extends Thread{

    @Override
    public void run() {
        log.info("running test 2");
    }
}
@Slf4j
public class ThreadsPractice {

    public static void main(String [] args) throws InterruptedException {

        Runnable test1 = new Test1();
        Thread t1 = new Thread(test1);
        Test2 test2 = new Test2();

        log.info("{}",t1.getState());
        t1.start();
        log.info("{}",t1.getState());
        log.info("t2 state : {}",test2.getState());
        Thread.sleep(5000);
        log.info("t2 state : {}",test2.getState());
        log.info("{}",t1.getState());
        log.info("t2 state : {}",test2.getState());
        test2.start();
        log.info("t2 state : {}",test2.getState());

        log.info("{}",t1.getState());
        log.info("t2 state : {}",test2.getState());
    }

}

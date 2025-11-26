package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintABC {

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
        static String controlVariable = "A";
        static int iteration = 1;
        static int cycle = 5;

        public synchronized void printA(){
            while(iteration < cycle) {
                while (!controlVariable.equals("A")) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("A");
                controlVariable = "B";
                notifyAll();
            }
        }

        public synchronized void printB(){
            while(iteration < cycle) {
                while (!controlVariable.equals("B")){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                controlVariable = "C";
                notifyAll();
            }
        }

        public synchronized void printC() {
            while (iteration <= cycle){
                while (!controlVariable.equals("C")) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("C");
                controlVariable = "A";
                iteration++;
                notifyAll();
            }
        }
    }
}

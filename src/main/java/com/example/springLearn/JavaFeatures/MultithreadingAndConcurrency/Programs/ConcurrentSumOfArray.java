package com.example.springLearn.JavaFeatures.MultithreadingAndConcurrency.Programs;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentSumOfArray {

    public static void main(String[] args) {

        int[] intArr = new int[100];
        int length = intArr.length;

        for (int i = 0; i < length; i++) intArr[i] = i + 1;

        //using parallel stream
        System.out.println("using parallel stream : " + Arrays.stream(intArr).parallel().reduce(Integer::sum));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //using CompletableFuture
        ExecutorService pool = Executors.newFixedThreadPool(4);

        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> sumArrayRange(intArr, 0, 24), pool);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> sumArrayRange(intArr, 25, 49), pool);
        CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> sumArrayRange(intArr, 50, 74), pool);
        CompletableFuture<Integer> f4 = CompletableFuture.supplyAsync(() -> sumArrayRange(intArr, 75, 99), pool);

        int sum = 0;
        try {
            sum = f1.thenCombineAsync(f2, Integer::sum).thenCombineAsync(f3, Integer::sum).thenCombineAsync(f4, Integer::sum).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("using completable future : " +  sum);

        pool.shutdown();
    }

    public static int sumArrayRange(int[] arr, int startIndex, int endIndex){
        int sum = 0;
        for (int i = startIndex; i<= endIndex; i++){
            sum += arr[i];
        }
        return sum;
    }
}

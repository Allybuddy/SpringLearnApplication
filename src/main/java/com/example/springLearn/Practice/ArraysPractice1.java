package com.example.springLearn.Practice;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Slf4j
public class ArraysPractice1 {

    public static void main(String[] args) {

        /*
            1. Find the largest and smallest element in an array
            2. Find the second-largest element
            3. Find the sum and average of all elements
            4. Reverse an array
            5. Check if the array is sorted
            6. Count even and odd numbers in an array
            7. Copy one array to another
            8. Find the maximum and minimum difference between elements
         */

        int [] arr = new int[5];
        int arrLength = arr.length;
        for(int i=0; i< arrLength; i++){
            arr[i] = i+1;
        }

        int largest = arr[0];
        int smallest = arr[0];
        int secondLargest = 0;
        int sum = 0;
        int countEven = 0;
        int countOdd = 0;

        for (int j : arr) {
            if (largest < j) {
                secondLargest = largest;
                largest = j;
            }
            if (smallest > j) {
                smallest = j;
            }
            sum += j;
            if(j%2 == 0)countEven ++;
            else countOdd++;
        }
        log.info("largest : {} - smallest : {}", largest, smallest);
        log.info("second largest : {}", secondLargest);
        log.info("sum : {} - average : {}", sum, sum/arrLength);
        log.info("even count : {} - odd count : {}", countEven, countOdd);

        int [] arrReverse = new int[5];
        for(int i=arrLength-1 ; i>=0 ; i--){
            arrReverse[arrLength-1-i] = arr[i];
        }
        log.info("reverse array {}", IntStream.of(arrReverse)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(",")));

        log.info("is array sorted : {}", isSorted(arr));
        int [] newArr = {2,6,9,1,6};
        log.info("is newArr sorted : {}", isSorted(newArr));

        var copyArr1 = Arrays.copyOf(arr,arrLength);
        var copyArr2 = Arrays.stream(arr).toArray();

        log.info("copy arr 1 array {}", IntStream.of(copyArr1).boxed().map(String::valueOf).collect(Collectors.joining(",")));
        log.info("copy arr 2 array {}", IntStream.of(copyArr2).boxed().map(String::valueOf).collect(Collectors.joining(",")));

        int[] part = IntStream.range(0, 3).map(i -> arr[i]).toArray();
        printArr("part array", part);

        Arrays.sort(arr);
        var maxDiff = arr[arrLength-1]- arr[0];
        var minDiff = largest;
        for(int i=0; i< arrLength-1; i++ ){
            int diff = arr[i+1] - arr[i];
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        log.info("minimum difference : {}", minDiff);
        log.info("maximum difference : {}", maxDiff);


        //Collections.sort(ArrayUtils.toObject(arr));

        List<Integer> newArrBoxed = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));

        Collections.sort(newArrBoxed);
        log.info("sorted arr : {}", newArrBoxed);
        newArrBoxed.sort(Collections.reverseOrder());
        //newArrBoxed.sort(Comparator.reverseOrder());
        //Collections.sort(newArrBoxed,Collections.reverseOrder());
        //Collections.sort(newArrBoxed, Comparator.reverseOrder());
        log.info("reverse sorted arr : {}", newArrBoxed);
    }

    public static boolean isSorted(int[] arr){
        for(int i=0; i < arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void printArr(String message, int[] arr){
        var newStr = IntStream.of(arr).boxed().map(String::valueOf).collect(Collectors.joining(","));
        log.info("{} : {}", message, newStr);
    }
}

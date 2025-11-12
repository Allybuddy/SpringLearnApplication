package com.example.springLearn.Algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
public class LinearBinarySearchAlgo {

    public static void main(String[] args) {
        int [] arr = {2,6,3,9,4,7,5,6,8};
        int value = 5;
        Integer index = linearSearch(arr, value);

        if(Objects.isNull(index)){
            log.info("item not found in the array");
        } else {
            log.info("item found at index : {} and position : {}", index, index + 1);
        }

        Arrays.sort(arr);

        index = linearSearch(arr, value);
        log.info("linear search : item found at index : {}", index);
        Integer indexBinary = binarySearch(arr,value);
        log.info("binary search : item found at index : {}", indexBinary);

    }

    public static Integer linearSearch(int [] arr, int value){
        int arrLength = arr.length;
        for(int i = 0; i< arrLength; i++){
            if(arr[i] == value) return i;
        }
        return null;
    }

    public static Integer binarySearch(int [] arr, int value){

        int arrLength = arr.length;
        int left = 0;
        int right = arrLength-1;

        while (left <= right){
          int middle = left + (right - left)/2;

          if(value == arr[middle]){
              return middle;
          }
          if(value < arr[middle]){
              right = middle - 1;
          }else {
              left = middle + 1;
          }
        }
        return null;
    }

}

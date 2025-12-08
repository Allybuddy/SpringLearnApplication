package com.example.springLearn.Practice.SlidingWindow;

public class MaximumSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;

        System.out.println(maxSum(arr, k)); // 19
    }

    private static int maxSum(int[] arr, int k){
        int windowSum = 0;
        int maxSum = 0;

        //first window
        for (int i = 0; i < k; i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;

        //slide window
        for (int i = k; i< arr.length; i++){
            windowSum -= arr[i-k];
            windowSum += arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;

    }
}

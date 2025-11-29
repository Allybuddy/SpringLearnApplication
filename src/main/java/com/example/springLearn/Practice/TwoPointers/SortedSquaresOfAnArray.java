package com.example.springLearn.Practice.TwoPointers;

public class SortedSquaresOfAnArray {
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] ans = sortedSquares(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }

    private static int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        int index = n-1;

        int left = 0;
        int right = n-1;

        while (left <= right){
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq){
                result[index] = leftSq;
                left++;
            }else {
                result[index] = rightSq;
                right--;
            }
            index--;
        }
        return result;
    }
}

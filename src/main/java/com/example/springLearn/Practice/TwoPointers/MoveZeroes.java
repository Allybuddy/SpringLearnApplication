package com.example.springLearn.Practice.TwoPointers;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    private static void moveZeroes(int[] nums){
        int i = 0;

        //move non-zero elements to the front
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }

        //fill the rest with zero
        for (int k = i; k< nums.length; k++){
            nums[k] = 0;
        }
        //same logic
        /*while (i < nums.length) {
            nums[i] = 0;
            i++;
        }*/
    }
}

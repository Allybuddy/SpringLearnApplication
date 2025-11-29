package com.example.springLearn.Practice.TwoPointers;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4};

        //k last index
        //k + 1 unique count
        int k = removeDuplicates(nums);

        System.out.println("Unique count: " + (k + 1));
        System.out.print("Array after removing duplicates: ");

        for (int idx = 0; idx <= k; idx++) {
            System.out.print(nums[idx] + " ");
        }
    }

    private static int removeDuplicates(int [] nums){

        if (nums.length == 0) return -1;
        int i = 0; //slow pointer

        for (int j = 1; j< nums.length ; j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i ; // final unique index
    }
}

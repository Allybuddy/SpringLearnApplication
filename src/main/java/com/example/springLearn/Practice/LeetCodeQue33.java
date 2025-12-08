package com.example.springLearn.Practice;

public class LeetCodeQue33 {

    public static void main(String[] args) {

        //33. Search in Rotated Sorted Array

        /*here is an integer array nums sorted in ascending order (with distinct values).
        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that
        the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
                You must write an algorithm with O(log n) runtime complexity.

        Example 1:
        Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
        Example 2:
        Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
        Example 3:
        Input: nums = [1], target = 0 Output: -1*/


        int[] nums = {4,5,6,7,0,1,2};
        int targetNo = 4;
        var index = rotatedBinarySearch(nums, targetNo);

        if (index == -1){
            System.out.println("target number not found");
        } else {
            System.out.println("number found at position : " + index + 1);
        }


    }

    private static int rotatedBinarySearch(int [] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/ 2;
            if (nums[mid] == target){
                return mid;
            }
            //left sorted
            if (nums[low] <= nums[mid]){
                if (nums[low] <= target  && target < nums[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else { //right sorted
                if (nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }


    private static int binarySearch(int [] nums, int target){
        int first = 0;
        int last = nums.length - 1;

        while (first <= last){
            int mid = first + (last - first) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[target] > nums[mid]){
                first = mid + 1;
            }else {
                last = mid - 1;
            }
        }
        return -1;
    }
}

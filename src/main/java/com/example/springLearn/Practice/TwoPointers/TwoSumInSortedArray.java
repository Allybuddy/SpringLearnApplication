package com.example.springLearn.Practice.TwoPointers;

public class TwoSumInSortedArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11, 15};
        int target = 9;

        var res = twoSum(arr, target);
        System.out.println("value " + arr[res[0]] + "  :  " + arr[res[1]]);
        System.out.println("index " + res[0] + "  :  " + res[1]);
    }

    private static int[] twoSum(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while (left < right){
            int sum = arr[left] + arr[right];

            if (sum == target){
                return new int[]{left, right};
            }else if (sum < target){
                left++;
            }else { // sum > target
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}

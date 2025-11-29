package com.example.springLearn.Practice.TwoPointers;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6, 0, 0, 0};
        int[] nums2 = {2, 4, 6};

        merge(nums1, 4, nums2, 3);

        for (int x : nums1) {
            System.out.print(x + " ");
        }
    }

    private static void merge(int[] num1, int m, int[] num2, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while (i >= 0 && j >= 0){
            if (num1[i] > num2[j]){
                num1[k] = num1[i];
                i--;
            }else {
                num1[k] = num2[j];
                j--;
            }
            k--;
        }
        // If anything left in nums2, copy it
        while (j >= 0) {
            num1[k] = num2[j];
            j--;
            k--;
        }
    }
}

package com.example.springLearn.Practice.TwoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] ans = intersection(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] intersection(int[] num1, int[] num2){
        int i = 0;
        int j = 0;

        //important step
        Arrays.sort(num1);
        Arrays.sort(num2);

        Set<Integer> result = new HashSet<>();

        while (i < num1.length && j < num2.length){
            if (num1[i] == num2[j]){
                result.add(num1[i]);
                i++;
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            }else {
                j++;
            }
        }

        int[] finalResult = new int[result.size()];
        int k =0;
        for(int x : result){
            finalResult[k] = x;
            k++;
        }
        return  finalResult;
    }
}

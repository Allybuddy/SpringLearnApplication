package com.example.springLearn.Practice.TwoPointers;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        reverse(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

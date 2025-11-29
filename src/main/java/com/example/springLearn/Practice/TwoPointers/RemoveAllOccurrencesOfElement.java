package com.example.springLearn.Practice.TwoPointers;

public class RemoveAllOccurrencesOfElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 4, 3, 5};
        int val = 3;

        int newLength = removeElement(nums, val);

        System.out.println("New length: " + newLength);
        System.out.print("Array after removal: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int removeElement(int[] nums, int val){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

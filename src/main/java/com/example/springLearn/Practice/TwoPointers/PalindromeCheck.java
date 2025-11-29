package com.example.springLearn.Practice.TwoPointers;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));

        String str2 = "allvin";
        System.out.println(isPalindrome(str2));
    }

    private static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

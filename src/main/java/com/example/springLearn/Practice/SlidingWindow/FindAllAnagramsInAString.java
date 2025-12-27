package com.example.springLearn.Practice.SlidingWindow;
import java.util.*;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String str, String part) {
        List<Integer> result = new ArrayList<>();

        if (str.length() < part.length()) return result;

        Map<Character, Integer> freq = new HashMap<>();

        // Step 1: Frequency map of p
        for (char c : part.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = part.length();

        // Step 2: Sliding window
        while (right < str.length()) {
            char rightChar = str.charAt(right);

            if (freq.containsKey(rightChar)) {
                if (freq.get(rightChar) > 0) {
                    count--;
                }
                freq.put(rightChar, freq.get(rightChar) - 1);
            }

            right++;

            // Step 3: Check window size
            if (right - left == part.length()) {
                if (count == 0) {
                    result.add(left);
                }

                char leftChar = str.charAt(left);
                if (freq.containsKey(leftChar)) {
                    freq.put(leftChar, freq.get(leftChar) + 1);
                    if (freq.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p)); // [0, 6]
    }

}

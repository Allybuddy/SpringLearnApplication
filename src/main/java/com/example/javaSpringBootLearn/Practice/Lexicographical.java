package com.example.javaSpringBootLearn.Practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lexicographical {

    /*public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        List ls = new ArrayList<String>();
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i = 1; i < s.length() - 3 ; i++) {
            ls.add(s.substring(i, i + 2));
        }
        List<String> sorted = ls.sort();
        return smallest + "\n" + largest;
    }*/


    public static void main(String[] args) {
        String s = "welcometojava";
        int k = 3;
        //System.out.println(getSmallestAndLargest(s, k));
    }
}

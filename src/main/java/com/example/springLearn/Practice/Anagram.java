package com.example.springLearn.Practice;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        String a1 = sortFun(a);
        String b1 = sortFun(b);
        return a1.equalsIgnoreCase(b1);
    }

    public static String sortFun(String input){
        char[] unsorted = input.toLowerCase(Locale.ROOT).toCharArray();
        /*Arrays.sort(unsorted);
        return Arrays.toString(unsorted);*/

        for (int i = 0; i< unsorted.length - 1; i++){
            for (int j=0; j< unsorted.length -1 -i; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    char temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }
        System.out.println("     " + Arrays.toString(unsorted));
        return new String(unsorted);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first word");
        String a = scan.next();
        System.out.println("Enter second word");
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


package com.example.javaSpringBootLearn.Practice;

import java.util.Scanner;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        // Write your code here.
        s = s.replaceAll("[^a-zA-Z]", " ");
        s=s.replaceAll("\\s+"," ");
        s=s.trim();
        if (s.isEmpty()) {
            System.out.println(0);
            return;
        }
        String [] arr = s.split(" ");
        System.out.println(arr.length);
        for (String x : arr){
            System.out.println(x);
        }

        //StringTokenizer tk = new StringTokenizer("string");
    }
}

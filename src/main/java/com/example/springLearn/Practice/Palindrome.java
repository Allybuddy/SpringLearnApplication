package com.example.springLearn.Practice;


public class Palindrome {

    public static void main(String[] args){

        String str = "madam";
        var res = palindrome(str.toCharArray());
        System.out.println(res);
    }

    private static boolean palindrome(char [] str){
        StringBuilder strBuf = new StringBuilder();
        for(int i= str.length-1 ; i>=+0; i--){
            strBuf.append(str[i]);
        }
        return strBuf.toString().equals(new String(str));
    }

}

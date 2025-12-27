package com.example.springLearn.JavaFeatures;

public class Recursion {


    public static void main(String[] args) {

        System.out.println("Sum of n nos : " + sumNos(5));
        // 6 5 4 3 2 1

        System.out.println("factorial of n nos : " + factorial(5));
        // 5 * 4 * 3!

        int count = 0;
        fibonacci(0,1, count);
        //??
        System.out.print("fibonacci of n sequence : " + fib(10));

        System.out.println();
        //string reversal
        String str = "allvin";

        //inefficient
        var strInput = str.toCharArray();
        char [] res = new char[strInput.length];
        int index = strInput.length - 1;
        res = strReverse(strInput, res, index);
        for(char c: res){
            System.out.print(c);
        }
        System.out.println();

        //efficient
        System.out.println("reverse string value : " + str + " is " + reverse(str));



    }

    public static int sumNos(int n){
        if (n == 1){
            return 1;
        }
        return n + sumNos(n - 1);
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void fibonacci(int n, int m, int count){
        if (count == 10){
            return;
        }
        System.out.print(n + " " );
        count++;
        fibonacci(m, n + m, count);
    }

    // didn't understand
    static int fib(int n) {
        // Base conditions
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive calls
        return fib(n - 1) + fib(n - 2);
    }

    //inefficient
    public static char[] strReverse(char[] input, char[] result, int index){
        if(index < 0){
            return result;
        }
        result[index] = input[input.length - 1 - index];
        index--;
        return strReverse(input, result, index);
    }

    //efficient
    public static String reverse(String str){
        if (str == null || str.length() == 0){
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}

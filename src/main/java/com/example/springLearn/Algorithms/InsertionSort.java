package com.example.springLearn.Algorithms;

public class InsertionSort {

    public static void printarr(int arr[]){
        for(int k:arr)System.out.print(k + " ");
        System.out.println();
    }

    public static void main(String [] args){
        int arr[]={7,8,3,1,2};
        printarr(arr);

        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            int num=arr[i];
            int j=i-1;
            while(j>=0 && num<arr[j])
            {
                arr[j+1]=arr[j];
                j--;
            }
            //placement
            arr[j+1]=num;
        }
        printarr(arr);

    }

}

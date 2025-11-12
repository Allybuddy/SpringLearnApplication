package com.example.springLearn.Algorithms;

public class BubbleSort {

    public static void printarr(int arr[])
    {
        for (int k: arr)
        {
            System.out.print(k + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int arr[] = {3,1,4,8,2,6,7,1,9};
        printarr(arr);

        int n=arr.length;
        for(int j=0;j<n-1;j++)
        {
            for(int i=0;i<n-j-1;i++)
            {
                if(arr[i]>arr[i+1])
                {
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }

        }
        printarr(arr);
    }
}

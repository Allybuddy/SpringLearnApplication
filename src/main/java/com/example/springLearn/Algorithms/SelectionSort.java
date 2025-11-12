package com.example.springLearn.Algorithms;

public class SelectionSort {

    public static void printarr(int arr[]){
        for(int k : arr){
            System.out.print(k + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int arr[]={2,1,7,4,6,0,-3,-5,-2};
        int n=arr.length;
        printarr(arr);

        for(int i=0;i<n;i++)
        {
            int smindex=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[smindex]>arr[j])
                {
                    smindex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[smindex];
            arr[smindex]=temp;
        }
        printarr(arr);
    }

}

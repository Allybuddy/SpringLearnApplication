package com.example.springLearn.DesignPatterns.Strategy;

public class QuickSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] arr) {
        System.out.println("sorting using quick sort");
    }
}

package com.example.springLearn.DesignPatterns.Strategy;

public class MergeSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] arr) {
        System.out.println("sorting using merge sort");
    }
}

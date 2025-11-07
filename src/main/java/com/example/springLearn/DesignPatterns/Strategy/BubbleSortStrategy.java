package com.example.springLearn.DesignPatterns.Strategy;

public class BubbleSortStrategy implements SortingStrategy{

    @Override
    public void sort(int[] arr) {
        System.out.println("sorting using bubble sort");
    }
}

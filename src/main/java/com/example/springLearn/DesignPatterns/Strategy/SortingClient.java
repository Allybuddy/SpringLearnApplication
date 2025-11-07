package com.example.springLearn.DesignPatterns.Strategy;

public class SortingClient {

    public static void main(String[] args){

        int[] array1 = {5, 2, 9, 1, 5};

        SortingContext context = new SortingContext(new QuickSortStrategy());
        context.performSort(array1);

        context.setSortingStrategy(new BubbleSortStrategy());
        context.performSort(array1);

        context.setSortingStrategy(new MergeSortStrategy());
        context.performSort(array1);
    }
}

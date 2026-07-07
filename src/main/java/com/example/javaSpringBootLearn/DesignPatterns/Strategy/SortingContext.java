package com.example.javaSpringBootLearn.DesignPatterns.Strategy;

public class SortingContext {

    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy strategy){
        sortingStrategy = strategy;
    }

    public void performSort(int[] arr){
        sortingStrategy.sort(arr);
    }
}

package com.example.springLearn.JavaFeatures;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Features {

    public static void main(String[] args){
        // predicate Supplier consumer function bifunction

        int a = 2;
        Predicate<Integer> condition = (x) -> x%2==0;

        Consumer<Integer> consume = (c) -> System.out.println("Mission Accomplished : "+c);

        Supplier<Integer> supply = ()-> 25;

        Function<Integer, Integer> execute = (x) -> x*x;

        if (condition.test(a)){
            int randomNum = supply.get();
            int newRes = execute.apply(randomNum);
            consume.accept(newRes);
        }


    }
}

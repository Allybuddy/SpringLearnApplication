package com.example.springLearn.JavaFeatures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams2 {

    public static void main(String[] args) {

        List<Integer> intList = List.of(1,2,3,4,5,6);
        var res = intList.stream().collect(Collectors.partitioningBy(a-> a%2==0));
        System.out.println(res.get(true));

        String str = "allvin";
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(a-> a, LinkedHashMap::new, Collectors.counting()))
                .forEach((a,b) -> System.out.print(a + " : " + b + " // "));
        System.out.println();

        System.out.println(intList.stream().sorted((a,b) -> b-a).toList());
        System.out.println(intList.stream().sorted(Comparator.reverseOrder()).toList());

        System.out.println(intList.stream().filter( a-> a%5==0).toList());

        var intList2 = List.of(7,8,9,10);
        System.out.println(Arrays.toString(IntStream.concat(intList.stream().mapToInt(Integer::intValue), intList2.stream().mapToInt(Integer::intValue))
                .sorted().distinct().toArray()));


        System.out.println(intList.stream().sorted().limit(3).toList());

        System.out.println(intList.stream().sorted(Comparator.reverseOrder()).limit(3).toList());

        List<String> listStr = List.of("i", "am", "allvin");
        System.out.println(listStr.stream().sorted(Comparator.comparingInt(String::length).reversed()).toList());

        int[] intArr = {1,2,3,4,5};
        System.out.println(Arrays.stream(intArr).reduce(Integer::sum));

        System.out.println(Arrays.stream(intArr).average());

        System.out.println(Arrays.toString(IntStream.rangeClosed(1,intArr.length).map(a -> intArr[intArr.length - a]).toArray()));

        //palindrome
        String s1 = "abba";
        StringBuilder s2 = new StringBuilder();
        //System.out.println(Arrays.stream(s1.split(""));


        System.out.println(IntStream.rangeClosed(intArr.length, intArr.length).findFirst());
        System.out.println(Arrays.stream(intArr).skip(intArr.length-1).findFirst());
    }
}

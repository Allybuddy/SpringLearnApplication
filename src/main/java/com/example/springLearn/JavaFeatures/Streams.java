package com.example.springLearn.JavaFeatures;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Streams {

    public static void main(String[] args) {

        List<Integer> myList = List.of(1,2,3,4,5,6,7,8,9);

        //Find the second-highest number in a list using streams
        myList.stream().filter(Objects::nonNull)
                .sorted((a, b) -> b - a)
                .distinct()
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        //Count the frequency of each integer in a list using streams.
        myList.stream().filter(Objects::nonNull)
                .distinct()
                .forEach(i -> System.out.println(i + " : " + myList.stream().filter(n -> n.equals(i)).count()));


        List<Integer> list = List.of(1,2,3,4,5,1,3,2,9);

        //Sum of all even numbers in a list using streams.
        var res = list.stream().filter(n -> n%2 ==0).mapToInt(Integer::intValue).sum();
        var res2 = list.stream().filter(n -> n%2 ==0).reduce(Integer::sum);
        log.info("sum in 2 ways - way1 {} and way2 {}", res, res2.get());

        var reverseList = IntStream.range(0, list.size())
                                          .mapToObj(i -> list.get(list.size() - 1 - i))
                                          .collect(Collectors.toList());
        log.info("reverse list : {}", reverseList);

        //reverse a list and dont so

        String name = "Allvin is a good boy";
        List<String> lists = Arrays.asList(name.split(" "));

        var newReverseList = new ArrayList<>(lists);
        Collections.reverse(newReverseList);
        log.info("reversed list {} ", newReverseList);

        String reversed = Arrays.stream(name.split(" ")).collect(Collectors.collectingAndThen(
                        Collectors.toList(), ls -> {
                            Collections.reverse(ls);
                            return String.join(" ", ls);
                        }));

        log.info("solu 2 : reversed list : {} ", reversed);

        var ls = lists.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;
                }));
        log.info(ls.toString());

        var newList = lists.stream().map( stre -> new StringBuilder(stre).reverse().toString()).toList();
        log.info("reverse characters {} ", newList);

        log.info("/////////////////////////////////////////////////////////////////////////////////////////////////////");
        log.info("sum of first 10 even nos : {}", IntStream.rangeClosed(1,20).filter(x-> x%2==0).sum());

        List<Integer> listInt = List.of(1, 2, 3, 4, 5, 6);
        log.info(listInt.stream().filter(x-> x%2 == 0).map(x -> x*x).collect(Collectors.toSet()).toString());

        log.info("max : {}", listInt.stream().reduce(Integer::max).get());
        log.info("min : {}", listInt.stream().reduce(Integer::min).get());
        log.info("sum : {}", listInt.stream().reduce(Integer::sum).get());
        log.info("avg : {}", listInt.stream().collect(Collectors.averagingInt(x -> x)));

        log.info("multiply : " + listInt.stream().reduce((a,b)-> a*b).get());

        log.info("all numbers are even true/false : "+listInt.stream().allMatch(x-> x%2==0));

        log.info("second highest : {}",listInt.stream().sorted((a,b)-> b - a).skip(1).reduce(Integer::max).get());
        log.info("third highest : {}",listInt.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().get());

        var listInt2 = List.of(1,1,2,3,3,4,5,6,6);
        log.info("distinct : {}", listInt2.stream().distinct().collect(Collectors.toList()));
        log.info("distinct : {}", listInt2.stream().collect(Collectors.toSet()));

        String str1 = "Allvin and Adarsh are good friends";
        log.info(Arrays.stream(str1.split(" ")).filter(x -> x.toLowerCase().startsWith("a")).collect(Collectors.toSet()).toString());

        log.info("{}",Arrays.stream(str1.split(" ")).filter(x -> x.length() > 5).count());

        log.info("longest string in list : {}", Arrays.stream(str1.split(" ")).max(Comparator.comparing(String::length)).get());

        var listWords = List.of("Allvin", "Anand", "Mom", "Dad", "Nexon");
        log.info("list to map {}" ,listWords.stream().collect(Collectors.toMap(a -> a, String::length)));

        List<String> fruits = List.of("apple", "banana", "mango", "apple");
        fruits.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .forEach((a, b) -> System.out.println(a + " : " + b));

        var word = "mississippi";                                               //Function.identity()
        word.chars().mapToObj(x -> (char)x).collect(Collectors.groupingBy(x->x, Collectors.counting()))
                .forEach((e,f) -> log.info(e + ":" + f));

        log.info("maintaining the order of the string");
        Arrays.stream(word.split("")).collect(Collectors.groupingBy(a -> a, LinkedHashMap::new, Collectors.counting()))
                .forEach( (a,b) -> System.out.println("key : " + a + " : " + "value : " + b));

        /*Find the first non-repeated character in a string using streams.
👉           Hint: LinkedHashMap + collect() + filter(entry -> entry.getValue() == 1)*/
        String str = "swiss";   //output - w
        Arrays.asList(str.split("")).stream().filter(s -> str.indexOf(s) == str.lastIndexOf(s)).findFirst()
                .ifPresent(s -> System.out.println("using streams : First non-repeating character : " + s));

        /*Find all duplicate elements in a list using streams.
👉           Hint: Use a Set inside filter() to track seen elements.*/

        /*var word2 = "Allvin";
        word2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))*/

        var listOfList = List.of(List.of(1, 2), List.of(3, 4), List.of(5));
        log.info(listOfList.stream().flatMap(Collection::stream).toList().toString());

        var listOfWords = List.of("allvin is a developer", "allvin switch company","join new company");
        log.info(listOfWords.stream().flatMap(a -> Arrays.stream(a.split(" "))).toList().toString());
        //convert to lowercase for sorting alphabetically
        log.info(listOfWords.stream().flatMap(a -> Arrays.stream(a.split(" "))).map(String::toLowerCase).distinct().sorted().toList().toString());

        log.info("sort based on length : {}", listOfWords.stream().flatMap(a -> Arrays.stream(a.split(" "))).map(String::toLowerCase).distinct()
                .sorted(Comparator.comparingInt(String::length)).toList().toString());

        var listOfString = "allvin is a java developer";
        log.info(Arrays.stream(listOfString.split(" ")).collect(Collectors.joining(",")));


    }


    

}

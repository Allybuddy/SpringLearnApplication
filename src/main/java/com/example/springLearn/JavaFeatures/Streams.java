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

        /*var reverseList = myList.stream().mapToInt(Integer::reverse);
        log.info("reverse list : {}", reverseList);*/

        //reverse a list and dont so

        String name = "Allvin is a good boy";
        List<String> lists = Arrays.asList(name.split(" "));

        var newReverseList = new ArrayList<>(lists);
        Collections.reverse(newReverseList);
        log.info("reversed list {} ", newReverseList);

        var newList = lists.stream().map( stre -> new StringBuilder(stre).reverse().toString()).toList();
        log.info("reverse characters {} ", newList);

        var ls = lists.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;
                }));
        log.info(ls.toString());
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

        var word = "mississippi";                                               //Function.identity()
        word.chars().mapToObj(x -> (char)x).collect(Collectors.groupingBy(x->x, Collectors.counting()))
                .forEach((e,f) -> log.info(e + ":" + f));

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



        // Create sample employee dataset
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 75000, "IT"),
                new Employee(2, "Bob", 48000, "HR"),
                new Employee(3, "Charlie", 52000, "IT"),
                new Employee(4, "David", 60000, "Finance"),
                new Employee(5, "Evelyn", 45000, "IT"),
                new Employee(6, "Frank", 82000, "IT"),
                new Employee(7, "Grace", 55000, "Marketing"),
                new Employee(8, "Hannah", 67000, "IT"),
                new Employee(9, "Ian", 49000, "Finance"),
                new Employee(10, "Jasmine", 51000, "IT")
        );

        log.info(" list of emp {}",employees.stream().filter( e -> e.department.equalsIgnoreCase("IT")
                && e.salary > 50000).map(Employee::getName).toList());

        log.info("avg salary : {}", employees.stream().map(Employee::getSalary).collect(Collectors.averagingDouble(x -> x)));

        //employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).forEach(e ->log.info(e.toString()));
        System.out.println();
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((x,y) -> log.info(y.toString()));
        System.out.println();
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((a,b)-> log.info(a +":"+b));
        System.out.println();
        employees.stream().collect(Collectors.partitioningBy(e -> e.salary > 50000)).forEach((a,b)-> {log.info(a +":"+b); System.out.println();});


    }


    
    static class Employee {
        private int id;
        private String name;
        private double salary;
        private String department;

        // Constructor
        public Employee(int id, String name, double salary, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        // toString()
        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
}

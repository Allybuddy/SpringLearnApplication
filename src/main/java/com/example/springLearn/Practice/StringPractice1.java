package com.example.springLearn.Practice;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
public class StringPractice1 {

    public static void main(String[] args) {

        //Q: Find the repeating element in a String

        var name = "Allvin";
        //method 1 part 1
        Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .forEach( (key,value) -> {if (value >1) log.info("repeated element : {} count {}", key, value);});
        //method 1 part 2
        var mapStream = Arrays.stream(name.chars().mapToObj(obj -> (char) obj).toArray())
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        mapStream.forEach((key,value) -> {
            if(value > 1){
                System.out.println("using streams : character " + key + " with count " +  value);
            }
        });
        //method 2
        Map<Character, Integer> map = new HashMap<>();
        for(char c: name.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for ( Character c : map.keySet()){
            if(map.get(c) > 1){
                System.out.println("using array : character " + c + " with count " +  map.get(c));
            }
        }

        //Q: Count number of vowels, consonants, digits, and spaces

        var mixStr = "aaeiou bcdd 123";
        var mapper = mixStr.chars().mapToObj(ob -> (char)ob)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        log.info("map keys {}", mapper.keySet());
        var vowels = 0;
        var consonants = 0;
        var digits = 0;
        var spaces = mixStr.length() - mixStr.replaceAll(" ", "").length();
        for (char c : mapper.keySet()){
            if(List.of('a','e','i','o','u').contains(c)){
                vowels += mapper.get(c);
            } else if (Character.isDigit(c)) {
                digits += mapper.get(c);
            } else if (Character.isLetter(c)) {
                // consonants = total letters - vowels
                consonants += mapper.get(c);
            }
        }
        log.info("space count : {}", spaces);
        log.info("vowels count : {}", vowels);
        log.info("consonants count : {}", consonants);
        log.info("digits count : {}", digits);


        //Q: Reverse a string
        StringBuilder revStr =  new StringBuilder();
        mixStr.chars().mapToObj(ob -> (char) ob).forEach(revStr::append);
        log.info("reversed string : {}",revStr.reverse());

        //Q: Check if a string is palindrome
        var palindrome = "abcba";
        StringBuilder palindromeReverse = new StringBuilder();
        palindrome.chars().mapToObj(c->(char)c).forEach(palindromeReverse::append);
        palindromeReverse.reverse();
        log.info("is string palindrome : {}", palindromeReverse.toString().equals(palindrome));

        //Q: Convert string to char array and vice versa
        char[] charArr = {'a','e','i','o','u'};
        String charStr = new String(charArr);
        log.info("char[] to string {}", charStr);
        log.info("string to char[] {}", charStr.toCharArray());

        var uniqueSet = palindrome.chars().mapToObj(ob -> (char) ob).collect(Collectors.toSet());
        StringBuilder uniqueStrBuilder = new StringBuilder();
        uniqueSet.forEach(uniqueStrBuilder::append);
        log.info("original : {}, set : {}, string : {}",palindrome, uniqueSet, uniqueStrBuilder);

        //Q: Write a java code to remove duplicate character and print remaining string in reverse order
        String str = "programming";
        var uniqueCharSet = Arrays.stream(str.split("")).distinct().collect(Collectors.toList());
        Collections.reverse(uniqueCharSet);
        var finalString = uniqueCharSet.stream().collect(Collectors.joining(""));
        //or String.join("", uniqueCharSet)
        System.out.println(finalString);

    }
}

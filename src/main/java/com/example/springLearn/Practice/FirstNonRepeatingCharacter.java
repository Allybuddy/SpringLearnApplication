package com.example.springLearn.Practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String []args) {

        String str = "swiss";
        //output - w

        Arrays.asList(str.split("")).stream().filter(s -> str.indexOf(s) == str.lastIndexOf(s)).findFirst()
                .ifPresent(s -> System.out.println("using streams : First non-repeating character : " + s));

        Character result = firstNonRepeatingCharacter(str);
        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }
    }

    public static Character firstNonRepeatingCharacter(String str){
        Map<Character,Integer> charCount = new LinkedHashMap<>();
        for(char c : str.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return null;
    }
}

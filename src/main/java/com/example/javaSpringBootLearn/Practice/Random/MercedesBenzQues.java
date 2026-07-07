package com.example.javaSpringBootLearn.Practice.Random;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MercedesBenzQues {

    public static void main(String[] args) {
        System.out.println("Welcome");

        // 5 patterns of recursion
        //db optimisation 

        /*Input : nums = [1, 2, 2]
        Output : [ [ ] , [1] , [1, 2] , [1, 2, 2] , [2] , [2, 2] ]*/

        List<Integer> nums = List.of(1,2,2);

        List<List<Integer>> op = new ArrayList<>();

        int size = nums.size();
            //0-0, 0-1, 0-2
            //1-1, 1-2

        int start = 0;
        int end = 0;

        funct(start,nums, start, end, op);

        log.info(op.toString());

    }

    private static void funct(int size, List<Integer> nums, int start, int end, List<List<Integer>> op){
        List<Integer> ls = new ArrayList<>();

        ls = nums.subList(start, end);
        if (end == size){
            start++;
            end = start;
        }
        op.add(ls);
        end++;

        funct(size, nums, start, end, op);


    }


}

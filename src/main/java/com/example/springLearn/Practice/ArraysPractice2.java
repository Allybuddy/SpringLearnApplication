package com.example.springLearn.Practice;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ArraysPractice2 {

    public static void main(String[] args) {
        int [] arr = {2,6,9,1,6,2,5,1,8,7,9};
        int arrLength = arr.length;

        //Q: Find duplicate elements in an array

        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        var duplicate = map.entrySet().stream()
                .filter( element -> element.getValue() > 1).collect(Collectors.toSet());
        log.info("duplicates : {}", duplicate);

        //Q: Remove duplicates from an array
        var distinct = Arrays.stream(arr).mapToObj( obj -> (Integer )obj).collect(Collectors.toSet());
        log.info("distinct : {}", distinct.stream().map(String::valueOf).collect(Collectors.joining(",")));

        //Q: Count frequency of each element
        log.info(map.toString());

        //Q: Find missing number in an array of 1 to n
        int[] nArray = {1,2,4,5,6,7};
        var arrLengthWithMissingNo = nArray.length;
        var sumOfArrMissingNo = Arrays.stream(nArray).map(obj -> (Integer)obj).reduce(Integer::sum);

        var arrLengthWithoutMissingNo = arrLengthWithMissingNo + 1;
        var sumOfArrWithoutMissingNo = arrLengthWithoutMissingNo * (arrLengthWithoutMissingNo + 1)/2;

        var missingNo = sumOfArrWithoutMissingNo - sumOfArrMissingNo.getAsInt();
        log.info("missing no {}", missingNo);

        //Q: Find all pairs with a given sum
        int [] arrayNos = {5, 7, 1, 9, 2, 12, 3, 8, 4, 11};
        var sum = 10;
        StringBuilder str = new StringBuilder();
        for(int i=0; i < arrayNos.length; i++){
            for (int j=i+1 ; j< arrayNos.length; j++){
                if (arrayNos[i] + arrayNos[j] == sum){
                    str.append(" (" +arrayNos[i] + ","+ arrayNos[j]+") ");
                }
            }
        }
        log.info(str.toString());

        //Q: Move all zeros to the end
        int [] arrayZeros = {5, 7, 0, 9, 0, 0, 3, 8, 0, 11};
        var listZeros = Arrays.stream(arrayZeros).boxed().collect(Collectors.toList());
        List<Integer> ls = new CopyOnWriteArrayList<>(listZeros);
        log.info("before shifting 0 : {}", ls.toString());
        for(int i=0 ; i< ls.size(); i++){
            if (ls.get(i).equals(0)) {
                var removedNo = ls.remove(i);
                ls.add(removedNo);
            }
        }
        log.info("after shifting 0 : {}", ls.toString());

        //Q: Rotate array by k positions
        //nArray
        int k = 3;
        log.info("before rotation {}", nArray);
        for(int i = 1; i<= k; i++){
            var temp = nArray[nArray.length-1];
            for (int j = nArray.length-1; j>0 ; j--){
                nArray[j] = nArray[j-1];
            }
            nArray[0]= temp;
        }
        log.info("after rotation {}", nArray);

        //Q: Find intersection and union of two arrays
        int[] A = {1, 2, 3};
        int[] B = {3, 4, 5};
        var newCombinedList = Stream.concat(Arrays.stream(A).boxed(), Arrays.stream(B).boxed()).collect(Collectors.toSet());
        log.info("union of A and B is : {}", newCombinedList);

        var intersection = Arrays.stream(A).boxed().filter( a -> Arrays.stream(B).boxed().toList().contains(a)).collect(Collectors.toSet());
        log.info("intersection of A and B is : {}", intersection);










    }

}

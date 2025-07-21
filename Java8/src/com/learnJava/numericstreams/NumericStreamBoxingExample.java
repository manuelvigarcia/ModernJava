package com.learnJava.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingExample {
    public static List<Integer> boxing(){
        return IntStream.rangeClosed(1,10)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int unBoxing(List<Integer> intList){
        return intList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    public static void main(String[] args) {
        List<Integer> integerList = boxing();
        System.out.println(integerList);
        System.out.println("unboxing:" + unBoxing(integerList));
    }
}

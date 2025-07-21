package com.learnJava.numericstreams;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NumericStreamMapExample {
    public static List<Integer> mapToObj(){
        return IntStream.rangeClosed(1,5)
                .mapToObj((i) -> {return Integer.valueOf(i);})
                .collect(toList());
    }
    public static long mapToLong(){
        return IntStream.rangeClosed(1,5)
                .mapToLong((i)->i)
                .sum();
    }

    public static double mapToDouble(){
        return IntStream.rangeClosed(1,5)
                .mapToLong((i)-> i)
                .sum();
    }
    public static void main(String[] args) {
        System.out.println("mapToObj: " + mapToObj());
        System.out.println("mapToLong: " + mapToLong());
        System.out.println("mapToDouble: " + mapToDouble());
    }
}

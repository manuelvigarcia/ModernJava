package com.learnJava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int findMaxValue(List<Integer> integers){
        return integers.stream()
                .reduce(0, (x,y)->x>y ? x : y);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integers){
        return integers.stream()
                .reduce((x,y)->x>y ? x : y);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integers){
        return integers.stream()
                .reduce((x,y)->x<y ? x : y);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
        System.out.println("Max for " + integerList);
        System.out.println("is: " + findMaxValue(integerList));
        List<Integer> emptyIntegerList = new ArrayList<>();
        System.out.println("max for an empt y list of integers: " + findMaxValue(emptyIntegerList));
        Optional<Integer> maxOptional = findMaxValueOptional(integerList);
        System.out.println("Now with optional: " + (maxOptional.map(integer -> "<" + integer + ">").orElse("<>")));
        maxOptional = findMaxValueOptional(emptyIntegerList);
        System.out.println("Empty list, now with optional: " + (maxOptional.map(integer -> "<" + integer + ">").orElse("<>")));

        Optional<Integer> minOptional = findMinValueOptional(integerList);
        System.out.println("Min with optional: " + (minOptional.map(integer -> "<" + integer + ">").orElse("<>")));
    }
}

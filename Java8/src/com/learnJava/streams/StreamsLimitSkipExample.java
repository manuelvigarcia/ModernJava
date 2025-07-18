package com.learnJava.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    //sum the first n elements on the list
    public static Optional<Integer> limit(List<Integer> ints){
        return ints.stream().limit(2).reduce((x,y) -> x+y);
    }

    public static Optional<Integer> skip(List<Integer> ints){
        return ints.stream().skip(3).limit(2).reduce((x,y) -> x+y);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6,7,8,9,10);
        // compute the sum of the first 2 elements in the list
        System.out.println("Sum of the first 2 elements: " + limit(integers).map(integer->"<"+integer+">").orElse("<>"));

        //skip 3 elements and compute the sum of the following 2 elements
        System.out.println("Sum of the last 2 elements" + skip(integers).map(integer->"<"+integer+">").orElse("<>"));
    }
}

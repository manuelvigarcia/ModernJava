package com.learnJava.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExamples {

    public static int sumOfNumbers(){
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6);
        return ints.stream()
                .reduce(0, Integer::sum);
    }

    public static int sumOfNumbersIntStream(){
        return IntStream.rangeClosed(1,6).sum();
    }

    public static void main(String[] args) {
        long begin = System.nanoTime();
        System.out.println(sumOfNumbers());
        long middle = System.nanoTime();
        System.out.println(sumOfNumbersIntStream());
        long end = System.nanoTime();
        System.out.println("With array of int:  " + (middle - begin) + "\nWith rangeClosed(): " + (end-middle));
        System.out.println(String.format("%2.2f", (1.0*(end-middle))/(1.0*(middle - begin))*100) + "%");
    }
}

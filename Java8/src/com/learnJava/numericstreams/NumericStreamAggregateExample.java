package com.learnJava.numericstreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamAggregateExample {
    public static void main(String[] args) {
        System.out.println("Sum 1-50 is: " + IntStream.rangeClosed(1,50).sum());
        System.out.println("Max 1-50 is: " + IntStream.rangeClosed(1,50).max());
        System.out.println("Min 1-50 is: " + IntStream.rangeClosed(1,50).max());
        OptionalDouble average = IntStream.rangeClosed(1, 50).average();
        System.out.println("Avg 1-50 is: " + (average.isPresent()? average.getAsDouble():"<>"));
        System.out.println("Factorial calculation: " + String.format("%,d", IntStream.rangeClosed(1,15).reduce(1,(a,b) -> a*b)));
    }
}

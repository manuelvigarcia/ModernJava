package com.learnJava.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {
    public static void main(String[] args) {
        System.out.println("Range " + IntStream.range(1,50).count());
        IntStream.range(1,50).forEach((value-> System.out.print(value+", ")));
        System.out.println();

        System.out.println("RangeClosed " + IntStream.rangeClosed(1,50).count());
        IntStream.rangeClosed(1,50).forEach((value-> System.out.print(value+", ")));
        System.out.println();

        System.out.println("LongRange " + LongStream.range(1,50).count());
        LongStream.range(1,50).forEach((value-> System.out.print(value+", ")));
        System.out.println();

        System.out.println("LongRangeClosed " + LongStream.rangeClosed(1,50).count());
        LongStream.rangeClosed(1,50).forEach((value-> System.out.print(value+", ")));
        System.out.println();

        System.out.println("Double Range " + IntStream.range(1,50).asDoubleStream().count());
        IntStream.range(1,50).asDoubleStream().forEach((value-> System.out.print(value + ", ")));
        System.out.println();

        System.out.println("Double RangeClosed " + IntStream.rangeClosed(1,50).asDoubleStream().count());
        IntStream.rangeClosed(1,50).asDoubleStream().forEach((value-> System.out.print(value + ", ")));
        System.out.println();
    }
}

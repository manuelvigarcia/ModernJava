package com.learnJava.funtionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    static Comparator<Integer> compareInts = (a,b) -> a.compareTo(b);

    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (a,b) -> a*b;
        System.out.println(multiply.apply(3,4));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(compareInts);
        System.out.println("Result of MaxBy: " + maxBy.apply(4, 5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(compareInts);
        System.out.println("Result of MinBy: " + minBy.apply(4, 5));
    }
}

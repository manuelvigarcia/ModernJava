package com.learnJava.lambdas;

import java.util.Comparator;

public class ComparableLambdaExample {

    public static void main(String[] args) {
        // prior to Java 8
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of the comparator is: " + comparator.compare(3,2));

        //Lambda syntax
        Comparator<Integer> comparatorLambda = (Integer o1, Integer o2) -> o1.compareTo(o2);
        System.out.println("Result of Lambda comparator is: " + comparatorLambda.compare(3,2));

        Comparator<Integer> comparatorLambda1 = (a,b) -> a.compareTo(b);
        System.out.println("Result of Lambda comparator1 is: " + comparatorLambda1.compare(3,2));
    }

}

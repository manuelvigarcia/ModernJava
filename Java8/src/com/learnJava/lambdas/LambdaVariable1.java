package com.learnJava.lambdas;

import java.util.function.Consumer;

public class LambdaVariable1 {
    public static void main(String[] args) {
        int i = 3;
        /* You are not allowed to use a variable in the Lambda with the same name as a local one
        Consumer<Integer> c1 = (i) -> {System.out.println("value is: " + i);};                 */
        Consumer<Integer> c1 = (i1) -> {System.out.println("value is: " + (i1 + i));};
        c1.accept(4);
        int value = 3;
        /*You are not allowed to modify any local variable from outside the Lambda
        Consumer<Integer> c2 = (i1) -> {value=7;System.out.println("value is: " + i1 + i);};*/
        Consumer<Integer> c2 = (i1) -> {int value1=7;System.out.println("value is: " + (i1 + i + value));};
        c2.accept(5);
    }
}

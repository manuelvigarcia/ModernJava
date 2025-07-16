package com.learnJava.funtionalInterfaces;

public class FunctionExample1 {

    public static String performConcat(String str){
        return FunctionExample.addSomeString.apply(str);
    }

    public static void main(String[] args) {

        String result = performConcat("Hello");

        System.out.println("Concat result: " + result);

        System.out.println("Capitalize result: " + FunctionExample.capitalize.apply("Hello"));
    }
}

package com.learnJava.funtionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String,String> capitalize = String::toUpperCase;

    static Function<String,String> addSomeString = (name) -> name.concat(" added ");

    public static void main(String[] args) {
        System.out.println(("java8 in capitals is: " + capitalize.apply("java8")));

        System.out.println(("java8 with addition: " + addSomeString.apply("java8")));

        System.out.println("with andThen: " + capitalize.andThen(addSomeString).apply("java8"));

        System.out.println("with compose: " + capitalize.compose(addSomeString).apply("java8"));
    }
}

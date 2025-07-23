package com.learnJava.optional;

import java.util.Optional;

public class OptionalPresentExample {
    /*
    isPresent() return a boolean indicating whether the Optional has a value or not.
    ifPresent() takes as argument a expression that will be executed if the Optional contains a value.
     */
    private static Optional<String> getOptional(String value){
        return Optional.ofNullable(value);
    }

    public static void main(String[] args) {
        // With a valid value
        System.out.println("Valid Optional value");
        Optional<String> optName = getOptional("Name Present");
        printOptional(optName);
        System.out.print("Now printing directly: ");
        optName.ifPresent(System.out::println);
        // With an invalid value
        System.out.println("Empty Optional value");
        optName = getOptional(null);
        printOptional(optName);
        System.out.print("Now printing directly: ");
        optName.ifPresent(System.out::println);
    }

    private static void printOptional(Optional<String> optName) {
        if (optName.isPresent()){
            System.out.println("The name is valid and is: " + optName.get());
        } else {
            System.out.println("Could not get a name.");
        }
    }
}

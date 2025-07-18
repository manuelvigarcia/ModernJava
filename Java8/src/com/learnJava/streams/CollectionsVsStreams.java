package com.learnJava.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreams {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("adam");
        names.add("jim");
        names.add("jenny");

        names.remove(0);

        System.out.println(names);

        // names.stream(). //There is no method to add anything to the stream. You can take out things by filtering and others. . .

        names.add("adam");
        //Iterate several times
        System.out.println("Iterate collections");
        // iterate once
        for(String name:names){
            System.out.println(name);
        }
        // iterate twice
        for(String name:names){
            System.out.println(name);
        }
        // now a stream
        System.out.println("Iterate streams");
        Stream<String> theStream = names.stream();
        // iterate once
        theStream.forEach(System.out::println);
        try{

            theStream.forEach(System.out::println);
            throw new RuntimeException("The stream should not be used twice");
        } catch (IllegalStateException ise) {
            System.out.println("Second use of the stream failed. As expected");
        }
    }
}

package com.learnJava.datetime;

import java.time.Instant;

public class InstantExample {
    /*
    Instant represent the time as elapsed time from 1970/01/01
     */
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant second = Instant.now();
        System.out.println("Is that before this?: " + instant.isBefore(second));
        /*Instant offers an array of possibilities to compare instants and ask about their different units.*/
    }
}

package com.learnJava.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("Current time: " + localTime);

        LocalTime hourMinutes = LocalTime.of(15,15);
        System.out.println("constructed time: " + hourMinutes);
        LocalTime hourMinutesSeconds = LocalTime.of(15,15, 15);
        System.out.println("constructed time: " + hourMinutesSeconds);

        //accessing the fields
        System.out.println("Seconds: " + hourMinutes.getSecond());
        System.out.println("Minutes: " + hourMinutes.getMinute());
        System.out.println("Minutes (ChronoField): " + hourMinutes.get(ChronoField.MINUTE_OF_HOUR));

        //Modify
        System.out.println("Two hours ago: " + hourMinutes.minusHours(2));
        System.out.println("Two hours ago (ChronoUnit): " + hourMinutes.minus(2, ChronoUnit.HOURS));
    }
}

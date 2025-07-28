package com.learnJava.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current timestamp: " + localDateTime);
        LocalDateTime stamp = LocalDateTime.of(2025,7, 23,12,30,22);
        System.out.println("a timestamp: " + stamp);
        System.out.println("Current timestamp (from date + time): " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        //Accessing fields
        System.out.println("Hour: " + stamp.getHour());
        System.out.println("Month: " + stamp.getMonth());
        System.out.println("Day of Month (with ChronoField): " + stamp.get(ChronoField.DAY_OF_MONTH));

        // Modify
        System.out.println("Two hours from: " + stamp.plusHours(2));

        // LocalDateTime from LocalTime or LocalDate
        LocalDate localDate = LocalDate.now();
        LocalDateTime dateWithTime = localDate.atTime(13, 15);
        System.out.println("Giving a time to the date: "+ dateWithTime);
        LocalTime theTime = LocalTime.now();
        LocalDateTime timeWithDate = theTime.atDate(LocalDate.of(2012, 12, 12));
        System.out.println("Giving a date to the time: " + timeWithDate);

        // LocalDate or LocalTime from LocalDateTime
        System.out.println("\nGiven date time: " + localDateTime);
        System.out.println("LocalDate: " + localDateTime.toLocalDate());
        System.out.println("LocalTime: " + localDateTime.toLocalTime());
    }
}

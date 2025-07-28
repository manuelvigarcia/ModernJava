package com.learnJava.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateTimeExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("local Date: " + localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println("Local time: " + localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local date time: " + localDateTime);
    }
}

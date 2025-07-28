package com.learnJava.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalTimeExample {

    public static void parseTime(){
        String time = "15:00";
        LocalTime localTime = LocalTime.parse(time);
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(localTime1);

        // Custom format
        String stringTime = "13_00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH_mm");
        System.out.println(LocalTime.parse(stringTime, dateTimeFormatter));

        stringTime = "13·00·30";
        dateTimeFormatter = DateTimeFormatter.ofPattern("HH·mm·ss");
        System.out.println(LocalTime.parse(stringTime, dateTimeFormatter));
    }

    public static void formatTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH·mm·ss");
        LocalTime now = LocalTime.now();
        System.out.println(now.format(dateTimeFormatter));
    }

    public static void main(String[] args) {
        parseTime();
        formatTime();
    }
}

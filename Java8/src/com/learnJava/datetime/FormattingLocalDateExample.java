package com.learnJava.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateExample {

    public static void parseLocalDate(){
        String dateString = "2025-07-24";
        LocalDate date = LocalDate.parse(dateString);
        System.out.println("LocalDate: " + date);
        LocalDate isoDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(isoDate);

        //no separators date strings
        String basicDateString = "20250724";
        LocalDate basicDate = LocalDate.parse(basicDateString, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(basicDate);

        //Custom date strings
        String customDateString = "24/07/2025";
        LocalDate customDate = LocalDate.parse(customDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(customDate);
    }

    public static void formatLocalDate(){
        LocalDate now = LocalDate.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public static void main(String[] args) {
        parseLocalDate();
        formatLocalDate();
    }
}

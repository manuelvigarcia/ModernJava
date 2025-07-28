package com.learnJava.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTimeExample {

    public static void parseLocalDateTime(){
        String dtString = "2025-07-24T13:20:45";
        System.out.println(LocalDateTime.parse(dtString));
        System.out.println(LocalDateTime.parse(dtString, DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        //custom format
        String customString = "24/07/2025 13·20·45";
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH·mm·ss");
        System.out.println(LocalDateTime.parse(customString, customFormatter));
        String customString2 = "24/07/2025T13·20·45";
        DateTimeFormatter customFormatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH·mm·ss");
        System.out.println(LocalDateTime.parse(customString2, customFormatter2));
    }

    public static void formatLocalDateTime(){
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH·mm·ss");
        System.out.println(LocalDateTime.now().format(customFormatter));
    }

    public static void main(String[] args) {
        parseLocalDateTime();
        formatLocalDateTime();
    }
}

package com.learnJava.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DatesToLocalDateExample {
    public static void main(String[] args) {
        //java.util.Date to LocalDate
        Date date = new Date();
        System.out.println(date);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);

        Date javaDate = Date.from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(javaDate);

        //java.sql.Date to LocalDate
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        System.out.println(sqlDate);
        LocalDate fromSql = sqlDate.toLocalDate();
        System.out.println(fromSql);
    }
}

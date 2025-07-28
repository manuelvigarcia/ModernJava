package com.learnJava.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.*;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate date = LocalDate.of(2025, 07, 24);
        System.out.println(date);
        System.out.println("ofYearDay 365: " + LocalDate.ofYearDay(2024,365));

        //access fields
        System.out.println("getMonth: " + localDate.getMonth());
        System.out.println("getMonthValue: " + localDate.getMonthValue());
        System.out.println("getDayOfWeek: " + localDate.getDayOfWeek());
        System.out.println("getDayOfWeek number: " + localDate.getDayOfWeek().getValue());
        System.out.println("getDayOfYear: " + localDate.getDayOfYear());
        System.out.println("Month using get: " + localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("Month using get: " + localDate.get(ChronoField.DAY_OF_WEEK));
        System.out.println("Month using get: " + localDate.get(ChronoField.DAY_OF_YEAR));

        // Modifying the date
        System.out.println("Two days from now: " + localDate.plusDays(2));
        System.out.println("Day before yesterday: " + localDate.minusDays(2));
        System.out.println("Two months from now: " + localDate.plusMonths(2));
        System.out.println("This day in 1900: " + localDate.withYear(1900));
        System.out.println("This day in 1900 (ChronoField): " + localDate.with(ChronoField.YEAR,1900));
        System.out.println("First day of the month: " + localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("First day of next month: " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("Date of next Tuesday: " + localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
        System.out.println("Date of next Thursday: " + localDate.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)));
        System.out.println("Date of first occurring Thursday: " + localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)));
        System.out.println("Date of next Friday: " + localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.print("Even dates until end of month: "); localDate.datesUntil(localDate.with(TemporalAdjusters.firstDayOfNextMonth()), Period.ofDays(2)).forEach(System.out::println);
        System.out.println("Date of one month ago: " + localDate.minus(1, ChronoUnit.MONTHS));

        //Additional methods
        System.out.println("Is leap year?: " + localDate.isLeapYear());
        System.out.println("Compare dates: " + localDate.isBefore(localDate.withYear(2024)));

    }
}

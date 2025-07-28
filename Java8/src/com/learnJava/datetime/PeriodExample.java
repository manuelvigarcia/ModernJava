package com.learnJava.datetime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    /*
    Period is an amount of time. Usually between two points in time.
    */
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.plusYears(1).plusMonths(2).plusDays(3);
        System.out.println(date1 + ", " + date2);
        Period period = date1.until(date2);
        System.out.println("Time in between: " + period);
        System.out.println("At what magnitude is it?: " + period.getUnits());
        System.out.println("How many days? (Beware: it is not the total days, but the days in excess of years and months) :" + period.getDays());
        System.out.println("How many months? :" + period.getMonths());
        System.out.println("How many months in total?: " + period.toTotalMonths());
        System.out.println("How many years? :" + period.getYears());
        Period period2 = Period.between(date1, date2);
        System.out.println("Are the two periods equal?: " + (period.getChronology().compareTo(period2.getChronology()) == 0));
    }
}

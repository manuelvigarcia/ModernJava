package com.modernjava.enhancedswitch;

import java.time.Month;
import java.time.Year;

public class DaysInMonth {
    public static int getDays(Month month, int year) {
        int noOfDays = 0;
        switch (month) {
            case SEPTEMBER:
            case APRIL:
            case JUNE:
            case NOVEMBER:
                noOfDays = 30;
                //return noOfDays;
                break;
            case FEBRUARY: // this is a code block;
                System.out.println("Checking if " + year + " is a leap year");
                noOfDays = Year.isLeap(year) ? 29 : 28;
                //  return noOfDays;
                break;

            default:
                noOfDays = 31;
        }
        return noOfDays;

    }
    public static int getDaysEnhancedSwitch(Month month, int year) {
        return switch (month){
            case SEPTEMBER, APRIL, JUNE, NOVEMBER -> 30;
            case FEBRUARY -> {
                System.out.println("Checking if " + year + " is a leap year . . .");
                // yield marks the return expression for the multiline case.
                yield Year.isLeap(year)?29:28;
            }
            default -> 31;
        };
    }
    public static int getDaysEnhancedSwitchExhaustive(Month month, int year) {
        return switch (month){
            case SEPTEMBER, APRIL, JUNE, NOVEMBER -> 30;
            case FEBRUARY -> {
                System.out.println("Checking if " + year + " is a leap year . . .");
                // yield marks the return expression for the multiline case.
                yield Year.isLeap(year)?29:28;
            }
            // you may avoid the "default" section of switch if you provide cases for all possible cases.
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
        };
    }
}

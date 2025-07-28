package com.learnJava.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    /*
    Duration is like a period but with precision of nanoseconds up to a magnitude of hours.
     */
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = now
                .minusYears(1)
                .minusMonths(2)
                .minusWeeks(3)
                .minusDays(4)
                .minusHours(5)
                .minusMinutes(6)
                .minusSeconds(7)
                .minusNanos(800000000);
        Duration duration = Duration.between(then, now);
        System.out.println("Duration (as of toString()): " + duration);
        System.out.println("Duration toDays(): " + duration.toDays());
        System.out.println("What units does it have?: " + duration.getUnits());
        System.out.println("We can ignore fractions of minutes: " + duration.truncatedTo(ChronoUnit.MINUTES));
        System.out.println("We can ignore fractions of hours: " + duration.truncatedTo(ChronoUnit.HOURS));
        System.out.println("We can ignore fractions of days: " + duration.truncatedTo(ChronoUnit.DAYS));
    }
}

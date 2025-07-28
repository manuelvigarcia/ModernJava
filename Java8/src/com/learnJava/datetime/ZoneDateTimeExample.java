package com.learnJava.datetime;

import java.time.*;

public class ZoneDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime withTZ = ZonedDateTime.now();
        System.out.println(withTZ);
        System.out.println("The offset for time zone " + withTZ.getZone() + " is: " + withTZ.getOffset());
        ZoneId zoneId = ZoneId.ofOffset("", withTZ.getOffset());
        ZoneId zoneIdGMT = ZoneId.ofOffset("GMT", withTZ.getOffset());
        System.out.println("The zone Id is: " + zoneId.getId() + "(" + zoneIdGMT + ")");
        System.out.println("The zone is: " + zoneId);
        System.out.println("There are " + ZoneId.getAvailableZoneIds().size() + " time zones");
        System.out.println("There are " + ZoneId.getAvailableZoneIds());
        //Get current time in different time zones
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Madrid")) + " Here");
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/London")) + "London");
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Kyiv")) + "Eastern Europe");
        System.out.println(ZonedDateTime.now(ZoneId.of("Atlantic/Azores")) + "Azores");
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")) + "New York");
        System.out.println(ZonedDateTime.now(ZoneId.of("America/Los_Angeles")) + "Los Angeles");
        System.out.println(ZonedDateTime.now(ZoneId.of("Australia/Sydney")) + "Sydney");

        //Convert local DateTime to Zoned DateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        ZonedDateTime zonedNow = now.atZone(ZoneId.of("Europe/Madrid"));
        System.out.println("LocalDateTime.now() with atZone()" + zonedNow);
        ZonedDateTime instantNow = Instant.now().atZone(ZoneId.of("Europe/Madrid"));
        System.out.println("Instant.now() with atZone(): " + instantNow);
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("OffsetDateTime.now(), no zone id: " + offsetDateTime);
    }
}

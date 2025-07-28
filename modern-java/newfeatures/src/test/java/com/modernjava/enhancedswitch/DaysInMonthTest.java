package com.modernjava.enhancedswitch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import com.modernjava.enhancedswitch.DaysInMonth;
import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaysInMonthTest {

    @ParameterizedTest
    @MethodSource("input")
    void getDays(Month month, int year, int expectedNoOfDays) {
        int days = DaysInMonth.getDays(month, year);
        assertEquals(expectedNoOfDays, days);
        int daysEnhanced = DaysInMonth.getDaysEnhancedSwitch(month, year);
        assertEquals(expectedNoOfDays, daysEnhanced);
        int daysEnhancedExhaustive = DaysInMonth.getDaysEnhancedSwitchExhaustive(month, year);
        assertEquals(expectedNoOfDays, daysEnhancedExhaustive);
    }


    private static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(Month.FEBRUARY, 2023, 28),
                Arguments.of(Month.SEPTEMBER, 2023, 30),
                Arguments.of(Month.JANUARY, 2023, 31),
                Arguments.of(Month.FEBRUARY, 2024, 29)
        );
    }
}
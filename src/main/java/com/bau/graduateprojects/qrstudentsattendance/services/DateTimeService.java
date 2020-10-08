package com.bau.graduateprojects.qrstudentsattendance.services;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class DateTimeService {

    private static String zoneId = TimeZone.getDefault().getID();

    public static void initialize(String timeZone) {
        validateTimeZone(timeZone);
        zoneId = timeZone;
    }

    private static void validateTimeZone(String timeZone) {
        try {
            ZonedDateTime.now(ZoneId.of(timeZone));
        } catch (DateTimeException e) {
            throw new DateTimeException("error in date time");
        }
    }

    public static LocalDateTime currentDateTime() {
        return ZonedDateTime.now(ZoneId.of(zoneId)).toLocalDateTime();
    }
}

package com.softserve.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public final static String dateTimePattern = "dd-MM-yyyy HH:mm";

    public static LocalDateTime parseFromString (String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        return localDateTime;
    }

   public static String dateTimeToString (LocalDateTime localDateTime) {
        String dateTime = new String();
        LocalDateTime.now();
        return dateTime;
    }
}



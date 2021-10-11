package com.softserve.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    //parsing from String;
    public static LocalDateTime parseFromString(String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
        return localDateTime;
    }

    //output for user;
    public static String dateTimeToString(LocalDateTime localDateTime) {
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        return formattedDateTime;
<<<<<<< HEAD
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String str = dateTimeToString(localDateTime);
        System.out.println(str);
        LocalDateTime dateTime = parseFromString(str);
        System.out.println(dateTimeToString(dateTime));
=======
>>>>>>> 4a8dbc144bd037397b734487a653e8a41fe5d33d
    }
}
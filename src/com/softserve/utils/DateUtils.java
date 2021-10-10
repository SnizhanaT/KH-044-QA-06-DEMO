package com.softserve.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public final static String dateTimePattern = "dd-MM-yyyy HH:mm";

    //parsing from String;
    public static LocalDateTime parseFromString(String dateTime) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        return localDateTime;
    }

    //output for user;
    public static LocalDateTime dateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        String formattedDateTime = localDateTime.format(formatter);
        //return formattedDateTime;  // тут не совсем понимаю почему Идея просит использовать метод, который на след строке:
        return LocalDateTime.parse(formattedDateTime);
    }

    public static void main(String[] args) throws Exception {
        LocalDateTime localDateTime = parseFromString("2021-11-23T13:43:15");
        System.out.println(localDateTime);

        System.out.println(dateTimeToString(localDateTime));
    }
}



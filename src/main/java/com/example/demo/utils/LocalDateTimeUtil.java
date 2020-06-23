package com.example.demo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {
    public static final String PATTERN_8 = "yyyyMMdd";

    public static final String PATTERN_10 = "yyyy-MM-dd";

    public static final String PATTERN_14 = "yyyyMMddHHmmss";

    public static final String PATTERN_19 = "yyyy-MM-dd HH:mm:ss";

    public static String now() {
        return now(PATTERN_19);
    }

    public static String now(String pattern) {
        return format(LocalDateTime.now(), pattern);
    }

    public static String format(LocalDateTime dateTime) {
        return format(dateTime, PATTERN_19);
    }

    public static String format(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

}

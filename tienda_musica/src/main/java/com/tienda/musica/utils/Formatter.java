package com.tienda.musica.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public static LocalTime formatTime(String time) {
        LocalTime time1 = LocalTime.parse(time);
        return LocalTime.parse(time1.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }

    public static LocalTime formatTime(LocalTime time) {
        return LocalTime.parse(time.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }

    public static LocalTime getTimeNow() {
        LocalTime time1 = LocalTime.now();
        return LocalTime.parse(time1.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }

    public static LocalDate formatDate(String time) {
        LocalDate time1 = LocalDate.parse(time);
        return LocalDate.parse(time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public static LocalDate formatDate(LocalDate time) {
        return LocalDate.parse(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public static LocalDate getDateNow() {
        LocalDate time1 = LocalDate.now();
        return LocalDate.parse(time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public static LocalDateTime formatDateTime(String time) {
        LocalDateTime time1 = LocalDateTime.parse(time);
        return LocalDateTime.parse(time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public static LocalDateTime formatDateTime(LocalDate time) {
        return LocalDateTime.parse(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public static LocalDateTime getDateTimeNow() {
        LocalDateTime time1 = LocalDateTime.now();
        return LocalDateTime.parse(time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}

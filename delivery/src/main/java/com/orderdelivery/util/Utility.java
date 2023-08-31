package com.orderdelivery.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class Utility {

    private Utility() {
    }

    public static String currDateAsString() {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                .appendOffset("+HH:mm", "+05:30")
                .toFormatter(Locale.getDefault());
        return LocalDateTime.now().format(formatter);
    }

    public static String laterDeliveryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy");
        return format.format(calendar.getTime());
    }

    public static String assignDeliveryPerson() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Tony Stark");
        stringSet.add("Farhan Qureshi");
        stringSet.add("Babu Rao");
        stringSet.add("Venugopala Iyer");

        List<String> list = new ArrayList<>(stringSet);
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }
}

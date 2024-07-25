package com.javarush.task.pro.task16.task1615;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/* 
Ой как много методов!
*/

public class Solution {

    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(10);
        System.out.println(instant);
        System.out.println(plusMinutes(instant, 2));
        System.out.println(plusHours(instant, 2));
        System.out.println(plusDays(instant, 2));
        System.out.println(minusMinutes(instant, 2));
        System.out.println(minusHours(instant, 2));
        System.out.println(minusDays(instant, 2));
    }

    static public Instant plusMinutes(Instant instant, long minutes) {
        instant =  instant.plusSeconds(minutes * 60);
        return instant;
    }

    static public Instant plusHours(Instant instant, long hours) {
        instant =  instant.plusSeconds(hours * 3600);
        return instant;
    }

    static public Instant plusDays(Instant instant, long days) {
        instant =  instant.plusSeconds(days * 3600 * 24);
        return instant;
    }

    static public Instant minusMinutes(Instant instant, long minutes) {
        instant =  instant.minusSeconds(minutes * 60);
        return instant;
    }

    static public Instant minusHours(Instant instant, long hours) {
        instant =  instant.minusSeconds(hours * 3600);
        return instant;
    }

    static public Instant minusDays(Instant instant, long days) {
        instant =  instant.minusSeconds(days * 3600 * 24);
        return instant;
    }
}

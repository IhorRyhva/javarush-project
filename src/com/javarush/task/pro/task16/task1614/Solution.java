package com.javarush.task.pro.task16.task1614;

import java.time.Instant;

/* 
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
        Instant Maxmilli = Instant.ofEpochMilli(Long.MAX_VALUE);
        return Maxmilli;
    }

    static Instant getMaxFromSeconds() {
        Instant MaxFromSeconds = Instant.ofEpochSecond(Instant.MAX.getEpochSecond());
        return MaxFromSeconds;
    }

    static Instant getMaxFromSecondsAndNanos() {
       Instant MaxFromSecondsAndNanos = Instant.ofEpochSecond((Instant.MAX.getEpochSecond()), Instant.MAX.getNano());
        return MaxFromSecondsAndNanos;
    }
}

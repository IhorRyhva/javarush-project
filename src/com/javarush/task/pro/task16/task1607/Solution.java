package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        LocalDate data = LocalDate.now();
        return data;
    }

    static LocalDate ofExample() {
        LocalDate data = LocalDate.of(2020, 9, 12);
        return data;
    }

    static LocalDate ofYearDayExample() {
        LocalDate data = LocalDate.ofYearDay(2020, 256);
        return data;
    }

    static LocalDate ofEpochDayExample() {
        LocalDate data = LocalDate.ofEpochDay(18517);
        return data;
    }
}

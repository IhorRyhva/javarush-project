package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(107, 8, 2);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String DayOfWeek = "";
        int weekDay = date.getDay();
        switch (weekDay){
            case (0):
                DayOfWeek = "Воскресенье";
                break;
            case (1):
                DayOfWeek = "Понедельник";
                break;
            case (2):
                DayOfWeek = "Вторник";
                break;
            case (3):
                DayOfWeek = "Среда";
                break;
            case (4):
                DayOfWeek = "Четверг";
                break;
            case (5):
                DayOfWeek = "Пятница";
                break;
            case (6):
                DayOfWeek = "Суббота";
                break;
        }
        return DayOfWeek;
    }
}

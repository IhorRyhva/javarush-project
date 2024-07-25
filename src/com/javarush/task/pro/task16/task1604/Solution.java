package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(2007, Calendar.SEPTEMBER, 2);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String DayOfWeek = "";//Воскресенье Понедельник Вторник Среда Четверг  Пятница Суббота
        switch (day){
            case(1):
                DayOfWeek = "Воскресенье";
                break;
            case(2):
                DayOfWeek = "Понедельник";
                break;
            case(3):
                DayOfWeek = "Вторник";
                break;
            case(4):
                DayOfWeek = "Среда";
                break;
            case(5):
                DayOfWeek = "Четверг";
                break;
            case(6):
                DayOfWeek = "Пятница";
                break;
            case(7):
                DayOfWeek = "Суббота";
                break;
        }
        return DayOfWeek;
    }
}

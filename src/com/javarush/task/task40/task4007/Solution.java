package com.javarush.task.task40.task4007;

/*
Работа с датами
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**G	буде замінено на еру дати (н.е. або до н.е.)
 y	замість цього символу буде підставлено рік
 M	замінюється на місяць
 w	номер тижня на рік
 W	порядковий номер тижня на місяці
 D	номер дня в році
 d	день місяця
 F	номер дня тижня на місяці
 E	день тижня
 a	AM/PM (до обіду чи після)
 H	годину у 24-годинному форматі (0-23)
 k	годину у 24-годинному форматі (1-24)
 K	годину у 12-годинному форматі (0-11)
 h	годину у 12-годинному форматі (1-12)
 m	хвилини
 s	секунди
 S	мілісекунди
 z	годинна зона у форматі Pacific Standard Time, PST
 Z	годинна зона у форматі -0800*/
public class Solution {
    public static void main(String[] args) throws ParseException {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        if(date.contains(".") && date.contains(":")){
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            calendar.setTime(dateFormat.parse(date));
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == Calendar.PM ? "PM" : "AM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }else if(date.contains(".")){
            DateFormat dateFormat = new SimpleDateFormat("dd.M.yyyy");
            calendar.setTime(dateFormat.parse(date));
            System.out.println("День: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }else if(date.contains(":")){
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            calendar.setTime(dateFormat.parse(date));
            String amPm = calendar.get(Calendar.AM_PM) == 1? "PM": "AM";
            System.out.println("AM или PM: " + amPm);
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }
    }
}

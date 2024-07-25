package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths(){
        Month[] array = new Month[3];
        array[0] = Month.values()[0];
        array[1] = Month.values()[1];
        array[2] = Month.values()[11];
        return array;
    }
    public static Month[] getSpringMonths() {
        Month[] array = new Month[3];
        array[0] = Month.values()[2];
        array[1] = Month.values()[3];
        array[2] = Month.values()[4];
        return array;
    }
    public static Month[] getSummerMonths() {
        Month[] array = new Month[3];
        array[0] = Month.values()[5];
        array[1] = Month.values()[6];
        array[2] = Month.values()[7];
        return array;
    }
    public static Month[] getAutumnMonths() {
        Month[] array = new Month[3];
        array[0] = Month.values()[8];
        array[1] = Month.values()[9];
        array[2] = Month.values()[10];
        return array;
    }
}

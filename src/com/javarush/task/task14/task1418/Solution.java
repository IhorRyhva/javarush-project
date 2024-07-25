package com.javarush.task.task14.task1418;

import java.util.LinkedList;
import java.util.List;

/* 
Исправь четыре ошибки
*/

public class Solution {
    public static void main(String[] args) {
        List<Number> numbers = new LinkedList<>();
        numbers = initList(numbers);
        processCastedObjects(numbers);
        printListValues(numbers);
    }

    public static void printListValues(List<Number> list){
        list.forEach(System.out::println);
    }

    public static void processCastedObjects(List<Number> list){
        for (Number object : list) {
            if (object instanceof Double) {
                Double a = (Double) object;
                System.out.println("Is double value infinite? " + a.isInfinite());
            } else if (object instanceof Float) {
                Float a = (Float) object;
                System.out.println( "Is float value defined? " + !(a.isNaN()));
            }
        }
    }
    public static List<Number> initList(List<Number> list){
        list.add(Double.valueOf(1000d));
        list.add(Double.parseDouble("123e-445632d"));
        list.add(Float.valueOf(-90 / -3f));
        list.remove(Double.parseDouble("123e-445632"));
        return list;
    }
}

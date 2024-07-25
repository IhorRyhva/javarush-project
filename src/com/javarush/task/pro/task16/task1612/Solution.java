package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        ArrayList<LocalDate> key = new ArrayList<>(sourceMap.keySet());
        ArrayList<List<LocalTime>> value = new ArrayList<>(sourceMap.values());
        Set<LocalDateTime> converts = new HashSet<>();
        for(int i = 0; i < key.size(); i++){
            LocalDateTime newTemp = null;
            LocalDate data = LocalDate.of(key.get(i).getYear(), key.get(i).getMonth(), key.get(i).getDayOfMonth());
            for(int j = 0; j < value.get(i).size(); j++){
                LocalTime time = LocalTime.of(value.get(i).get(j).getHour(), value.get(i).get(j).getMinute(), value.get(i).get(j).getSecond(), value.get(i).get(j).getNano());
                newTemp = LocalDateTime.of(data, time);
                converts.add(newTemp);
            }
        }

        return converts;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}
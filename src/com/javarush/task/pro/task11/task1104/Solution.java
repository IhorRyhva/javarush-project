package com.javarush.task.pro.task11.task1104;

/* 
Конвертер строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "12.84";
        double result = Double.parseDouble(string);
       int results = (int) Math.round(result);
        System.out.println(results);
    }
}

package com.javarush.task.pro.task13.task1302;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.Arrays.asList;

/* 
Проверка присутствия
*/

public class Solution {
    public static HashSet<String> words = new HashSet<>(asList("Если бы меня попросили выбрать язык на замену Java я бы не выбирал".split(" ")));

    public static void checkWords(String word) {
        boolean tf = false;
        if(words.contains(word))
            tf = true;

        if(tf == true){
            String str = String.format("Слово %s есть в множестве", word);
            System.out.println(str);
        } else{
            String str = String.format("Слова %s нет в множестве", word);
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        checkWords("JavaScript");
        checkWords("Java");
    }
}

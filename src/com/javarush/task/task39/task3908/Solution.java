package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Я несу гусеня"));
    }

    public static boolean isPalindromePermutation(String s) {
        boolean tf = true;
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toLowerCase().toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.merge(array[i], 1, Integer::sum);
        }
        if (s.length() % 2 == 0) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0)
                    tf = false;
            }
        }else{
            int count = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    count++;
                    if(count == 2){
                        tf = false;
                    }
                }
            }
        }
        return tf;
    }
}

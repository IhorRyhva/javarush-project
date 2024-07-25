package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if(s == null || s.isEmpty())
            return 0;
        TreeSet<Integer> counts = new TreeSet<>();
        HashSet<Character> check = new HashSet<>();
        int count = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if(check.contains(array[i])){
                counts.add(count);
                count = 1;
                check = new HashSet<>();
                check.add(array[i]);
            }else{
                check.add(array[i]);
                count++;
            }
        }
        counts.add(count);
        return Collections.max(counts);
    }
}

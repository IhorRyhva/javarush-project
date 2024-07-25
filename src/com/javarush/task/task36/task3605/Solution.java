package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeSet<Character> treeSet = new TreeSet<>();
        while (reader.ready()){
            char[] chars = reader.readLine().toLowerCase().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(Character.isLetter(chars[i]))
                    treeSet.add(chars[i]);
            }
        }
        if(treeSet.size() < 5){
            int count = 0;
            for(char c: treeSet){
                if(count < treeSet.size()) {
                    count++;
                    System.out.print(c);
                }
            }
        }else{
            int count = 0;
            for(char c: treeSet){
                if(count < 5) {
                    count++;
                    System.out.print(c);
                }
            }
        }
    }
}

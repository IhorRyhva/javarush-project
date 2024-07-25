package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try(FileReader buffer = new FileReader(args[0])){
            TreeMap<Integer, Integer> count = new TreeMap<>();
            while (buffer.ready()){
                int key = buffer.read();
                count.merge(key, 1, Integer::sum);
            }
            count.forEach((key, values) -> System.out.println((char) (int) key + " " + values));
        }
    }
}

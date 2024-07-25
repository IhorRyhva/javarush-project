package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(file.readLine()));
        String result = "";
        while(reader.ready()){
            result += reader.readLine() + " ";
        }
        String[] array = result.split("\\W");
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].trim().equalsIgnoreCase("world"))
                count++;
        }
        System.out.println(count);
        reader.close();
    }
}

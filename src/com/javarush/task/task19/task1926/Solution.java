package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(link.readLine()));
        link.close();
        while (reader.ready()){
            StringBuilder builder = new StringBuilder(reader.readLine());
            System.out.println(builder.reverse());
        }
        reader.close();
    }
}

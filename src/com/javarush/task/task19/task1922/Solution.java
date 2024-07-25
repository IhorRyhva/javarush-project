package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(link.readLine()));
        link.close();

        ArrayList<String> strings = new ArrayList<>();
        while(reader.ready()){
            int count = 0;
            String toConsole = reader.readLine();
            String[] array = toConsole.split(" ");
            for (int j = 0; j < words.size(); j++) {
                for (int i = 0; i < array.length; i++) {
                    if (words.get(j).equals(array[i]))
                        count++;
                }
            }
            if(count == 2)
                System.out.println(toConsole);
        }
        reader.close();
    }
}

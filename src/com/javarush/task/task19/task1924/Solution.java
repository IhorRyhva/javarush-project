package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(link.readLine()));
        link.close();
        while(reader.ready()){
            String[] array = reader.readLine().split(" ");
            for(Map.Entry<Integer, String> result: map.entrySet()){
                for (int i = 0; i < array.length; i++) {
                    try{
                        int point = 0;
                        String str = "";
                        char[] chars = array[i].toCharArray();
                        for (int j = 0; j < chars.length; j++) {
                            if(chars[j] == '.') {
                                point = 1;
                                continue;
                            }
                            else{
                                str += chars[j];
                            }
                        }
                        int integer = Integer.parseInt(str);
                        if(integer == result.getKey()){
                            if(point == 1) {
                                array[i] = result.getValue() + ".";
                            }else{
                                array[i] = result.getValue() + " ";
                            }
                        }
                    }catch (Exception e){
                    }
                }
            }

            String string = "";
            for (int i = 0; i < array.length; i++) {
                string += array[i] + " ";
            }
            System.out.println(string);
        }
        reader.close();
    }
}

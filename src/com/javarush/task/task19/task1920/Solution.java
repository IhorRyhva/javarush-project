package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();
        double max = -300000000;
        while (reader.ready()){
            String[] strings = reader.readLine().split(" ");
            double value = Double.valueOf(strings[1]);
            map.merge(strings[0], value, Double::sum);
        }
        reader.close();
        for(Map.Entry<String, Double> res: map.entrySet()){
            max = Math.max(max, res.getValue());
        }
        for(Map.Entry<String, Double> findMax: map.entrySet()){
            if(max == findMax.getValue())
                System.out.println(findMax.getKey());
        }
    }
}

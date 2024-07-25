package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //link.close();
        TreeMap<String, Double> sort = new TreeMap<>();
        while (reader.ready()){
            String[] forSort = reader.readLine().split(" ");
            double value = Double.valueOf(forSort[1]);
            sort.merge(forSort[0], value, Double::sum);
        }
        for(Map.Entry<String, Double> map: sort.entrySet()){
            System.out.print(map.getKey() + " ");
            System.out.println(map.getValue());
        }
        reader.close();
    }
}

package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
    
    static{
        labels.put(9.8, "Vava");
        labels.put(5.5, "Bibi");
        labels.put(6.8, "Abrakadabra");
        labels.put(45312.8956, "Full");
        labels.put(22.22, "Senior");
    }
}

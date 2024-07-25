package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String url = new Scanner(System.in).nextLine();
        try(FileInputStream input  = new FileInputStream(url)){
//            Map<Integer, Integer> forUse = new HashMap<>();
//            int min = 257;
//            while (input.available() > 0){
//                int most = input.read();
//                forUse.merge(most, 1, Integer::sum);
//                Math.min(min, forUse.get(min));
//            }
//
//            for(Map.Entry<Integer, Integer> foundMin: forUse.entrySet()){
//                if(Objects.equals(min, forUse.values()))
//                    System.out.println(foundMin.getKey());
//            }
                        Map <Integer, Integer> map = new HashMap<>();
            int min = 257;
            while (input.available()>0) {
                int current = input.read();
                map.merge(current, 1, Integer::sum);
            }
            for (Map.Entry <Integer,Integer> en : map.entrySet()) {
                min = Math.min(min, en.getValue());
            }

            for(Map.Entry <Integer, Integer> en: map.entrySet()){
                if(min == en.getValue()){
                    System.out.print(en.getKey() + " ");
                }
            }

        }catch (Exception e){

        }
    }
}

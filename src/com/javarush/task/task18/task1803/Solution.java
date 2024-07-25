package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> mostOften = new HashMap<>();
        String url = new Scanner(System.in).nextLine();
        try(BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(url)))
        /*FileInputStream fileInputStream = new FileInputStream(url)*/){

//            Map <Integer, Integer> map = new HashMap<>();
//            int max = 0;
//            while (fileInputStream.available()>0) {
//                int current = fileInputStream.read();
//                map.merge(current, 1, Integer::sum);
//                max = Math.max(map.get(current),max);
//            }
//            for (Map.Entry <Integer,Integer> en : map.entrySet()) {
//                if (en.getValue() == max) System.out.print(en.getKey() + " ");
//            }
            ArrayList<String> often = new ArrayList<>();
            while(buffer.ready()){
                often.add(buffer.readLine());
            }
            int time = 0;
            for (int i = 0; i < often.size(); i++) {
                String key = often.get(i);
                for (int j = 0; j < often.size(); j++) {
                    if(key.equals(often.get(j))) {
                        time++;
                        often.remove(often.get(j));
                        j--;
                    }
                }
                i--;
                mostOften.put(key, time);
                time = 0;
            }

            int max = 0;

            for(String findMax: mostOften.keySet()){
                max = Math.max(max, mostOften.get(findMax));
            }

            for(Map.Entry<String, Integer> forUse: mostOften.entrySet()){
                if(Objects.equals(max, forUse.getValue())) {
                    int res = forUse.getKey().charAt(0);
                    System.out.println(res + " ");
                }
            }
        }catch (Exception e){

        }
    }
}

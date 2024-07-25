package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while(!string.equals("exit")){
            ReadThread read = new ReadThread(string);
            string = scanner.nextLine();
        }

        for(Map.Entry<String, Integer> result: resultMap.entrySet()){
            System.out.print(result.getKey() + " -> ");
            System.out.println(result.getValue());
        }
    }

    public static class ReadThread extends Thread {
        String fileName = "";
        public ReadThread(String fileName){
            this.fileName = fileName;
            start();
        }
        @Override
        public void run() {
            try(FileInputStream buffer = new FileInputStream(fileName)){
                TreeMap<Integer, Integer> map = new TreeMap<>();
                int max = 0;
                while(buffer.available() > 0){
                    int key = buffer.read();
                    map.merge(key, 1, Integer::sum);
                    max = Math.max(max, map.get(key));
                }

                for(Map.Entry<Integer, Integer> maxTime: map.entrySet()) {
                    if(maxTime.getValue() == max)
                        resultMap.put(fileName, maxTime.getKey());
                }
            }catch (IOException e){
                new RuntimeException();
            }
        }
    }
}

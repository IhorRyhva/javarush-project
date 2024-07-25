package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(link.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(link.readLine()));
        link.close();
        String res = "";
        while(reader.ready()){
            res += reader.readLine() + " ";
        }
        String[] result = res.split(" ");
        ArrayList<Integer> integer = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            try{
                int forArray = Integer.parseInt(result[i]);
                integer.add(forArray);
            }catch (Exception e){
                System.out.println("Ok");
            }
        }
        String results = "";
        for(int i: integer){
            results += i + " ";
        }
        System.out.println(results);
        writer.write(results);
        writer.close();
        reader.close();
    }
}

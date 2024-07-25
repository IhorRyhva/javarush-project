package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(link.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(link.readLine()));
        link.close();
        String res = "";
        while(reader.ready()){
            res += reader.readLine() + "";
        }
        res = res.replaceAll("\\p{Punct}", "");
        writer.write(res);
        reader.close();
        writer.close();
    }
}

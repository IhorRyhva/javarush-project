package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(link.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(link.readLine()));
        link.close();
        String forUse = "";
        while (reader.ready()){
            forUse += reader.readLine();
        }
        char[] res = forUse.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if(res[i] == '.'){
                res[i] = '!';
            }
        }
        reader.close();
        writer.write(res);
        writer.close();
    }
}

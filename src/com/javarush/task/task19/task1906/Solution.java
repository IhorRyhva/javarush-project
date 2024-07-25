package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(scanner.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.readLine()));
        int count = 1;
        while (reader.ready()){
            if(count > 2)
                count = 1;
            if(count == 2){
                int forWriter = reader.read();
                writer.write(forWriter);
                count++;
            }else{
                int skip = reader.read();
                count++;
            }
        }
        reader.close();
        writer.close();
    }
}

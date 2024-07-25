package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader((args[0])));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder forWriter = new StringBuilder();
        while (reader.ready()){
            String[] string = reader.readLine().split(" ");
            for (int i = 0; i < string.length; i++) {
                String str = string[i];
                if(str.length() > 6) {
                    str += ",";
                    forWriter.append(str);
                }
            }
        }
        int length = forWriter.length();
        forWriter.delete(length - 1, length);
        writer.write(String.valueOf(forWriter));
        reader.close();
        writer.close();
    }
}

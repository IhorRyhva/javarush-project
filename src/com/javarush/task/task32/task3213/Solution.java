package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter writer = new StringWriter();
        if(reader != null) {
            BufferedReader reader1 = new BufferedReader(reader);
            char[] array = reader1.readLine().toCharArray();
            String temp = "";
            for (int i = 0; i < array.length; i++) {
                char chars = (char) (array[i] + key);
                temp += chars;
            }
            writer.write(temp);
        }
        return writer.toString();
    }
}

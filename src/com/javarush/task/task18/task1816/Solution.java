package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String forChar = "";
        while (reader.ready()){
            forChar += reader.readLine();
        }
        char[] chars = forChar.toCharArray();

        //65
        //90
        //97
        //122
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int integer = chars[i];
            if(integer >= 65 && integer <= 90 || integer >= 97 && integer <= 122)
                count++;
        }
        System.out.println(count);
        reader.close();
    }
}

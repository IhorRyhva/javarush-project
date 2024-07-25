package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args)throws IOException {
        try(BufferedReader buffer = new BufferedReader(new FileReader(args[0]))){
            String forCount = "";
            while(buffer.ready()){
                forCount += buffer.readLine();
            }

            char[] allChars = forCount.toCharArray();
            int allChar = allChars.length;
            int spaceChar = 0;
            for (int i = 0; i < allChar; i++) {
                if(allChars[i] == ' ')
                    spaceChar++;
            }
            
            double result = (double) spaceChar / allChar * 100;
            DecimalFormat form = new DecimalFormat("#.##");
            System.out.print(form.format(result));
        }
    }
}

package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(FileInputStream findComa = new FileInputStream(new Scanner(System.in).nextLine())){
            byte[] coma = new byte[findComa.available()];

            while (findComa.available() > 0){
                findComa.read(coma);
            }
            int count = 0;
            for(byte win: coma){
                if(win == 44){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

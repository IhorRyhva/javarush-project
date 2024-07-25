package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args)throws IOException {
        try(Scanner scanner = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new FileReader(scanner.nextLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.nextLine()))) {
            String forList = "";
            while (buffer.ready()){
                forList += buffer.readLine();
            }
            String[] temp = forList.split(" ");
            forList = "";
            for (int i = 0; i < temp.length; i++) {
                int integer = Math.round(Float.parseFloat(temp[i]));
                forList += integer + " ";
            }

            writer.write(forList);
        }

    }
}

package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();

        String forWrite = "";

        try(BufferedReader bufferFile2 = new BufferedReader(new FileReader(file2))){
            while (bufferFile2.ready()){
                forWrite += bufferFile2.readLine();
            }
        }

        try(BufferedReader bufferFile1 = new BufferedReader(new FileReader(file1))){
            while (bufferFile1.ready()){
                forWrite += bufferFile1.readLine();
            }
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file1))){
            writer.write(forWrite);
        }
    }
}

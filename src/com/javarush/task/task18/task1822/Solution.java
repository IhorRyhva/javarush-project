package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try(Scanner scanner = new Scanner(System.in);
            BufferedReader buffer = new BufferedReader(new FileReader(scanner.nextLine()))){
            int index = Integer.parseInt(args[0]);
            while(buffer.ready()){
                String str = buffer.readLine();
                String[] row = str.split(" ");
                int forFindIndex = Integer.parseInt(row[0]);
                if(index == forFindIndex){
                    System.out.print(str);
                }
            }
        }
    }
}

package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
            FileOutputStream outputFile = new FileOutputStream(scanner.nextLine());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputFile))){

            String info = "";
            while (!info.equals("exit")){
                info = scanner.nextLine();
                writer.write(info + "\n");

            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}

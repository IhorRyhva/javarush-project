package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        BufferedReader buffer = new BufferedReader(new InputStreamReader(fileInputStream))){
            while (buffer.ready()) {
                System.out.println(buffer.readLine());
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
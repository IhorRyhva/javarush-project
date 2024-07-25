package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)
        /*var reader = Files.newBufferedReader(Paths.get(scanner.nextLine()))*/){
            Path ura = Path.of(scanner.nextLine());
            List<String> result = Files.readAllLines(ura);
            for(String el: result){
                char[] res = el.toCharArray();
                for (int i = 0; i < res.length; i++) {
                    if(res[i] != ',' && res[i] != '.' && (res[i] != ' ')){
                        System.out.print(res[i]);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        try(FileInputStream input = new FileInputStream(scan.nextLine())){
            TreeSet<Integer> unique = new TreeSet<>();
            while(input.available() > 0){
                unique.add(input.read());
            }

            for(int res: unique){
                System.out.print(res + " ");
            }
        }
    }
}

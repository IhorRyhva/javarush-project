package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(scanner.nextLine()));
            BufferedReader buffer = new BufferedReader(inputStreamReader)){

            ArrayList<Integer> list = new ArrayList<>();
            while (buffer.ready()){
                list.add(Integer.valueOf(buffer.readLine()));
            }

            List<Integer> newList = list.stream().filter(o -> o % 2 == 0).sorted((integer1, integer2) -> integer1 - integer2).collect(Collectors.toList());
            newList.forEach(System.out::println);
        }catch (Exception e){
            throw new RuntimeException();
        }

    }
}

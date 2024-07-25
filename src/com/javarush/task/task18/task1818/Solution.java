package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/*
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        String name3 = scanner.nextLine();

        try(BufferedWriter forName1 = new BufferedWriter(new FileWriter(name1));
            BufferedReader forName2 = new BufferedReader(new FileReader(name2));
            BufferedReader forName3 = new BufferedReader(new FileReader(name3))) {
            while (forName2.ready()){
                forName1.write(forName2.readLine());
            }
            while (forName3.ready()){
                forName1.write(forName3.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
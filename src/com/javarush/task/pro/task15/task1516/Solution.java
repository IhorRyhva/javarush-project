package com.javarush.task.pro.task15.task1516;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        try(InputStream input = System.in;
        Scanner scanner = new Scanner(input)){
            Path path = Path.of(scanner.nextLine());
            while (Files.exists(path)) {
                if (Files.isDirectory(path)) {
                    System.out.println(path + THIS_IS_DIR);
                } else if (Files.isRegularFile(path)) {
                    System.out.println(path + THIS_IS_FILE);
                }
                path = Path.of(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


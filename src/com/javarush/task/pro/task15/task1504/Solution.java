package com.javarush.task.pro.task15.task1504;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
        InputStream input = Files.newInputStream(Paths.get(scanner.nextLine()));
        OutputStream output = Files.newOutputStream(Paths.get(scanner.nextLine()))) {

            byte[] buffer = input.readAllBytes();
            for (int i = 0; i < buffer.length - 1; i += 2) {
                    byte temp = buffer[i];
                    buffer[i] = buffer[i + 1];
                    buffer[i + 1] = temp;
            }
                output.write(buffer);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}


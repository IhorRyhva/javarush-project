package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String link = scanner.nextLine();
            try(BufferedReader buffer = new BufferedReader(new FileReader(link))){
                System.out.println("Successful");
            }catch (FileNotFoundException e) {
                System.out.println(link);
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

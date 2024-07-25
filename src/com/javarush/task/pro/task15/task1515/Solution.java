package com.javarush.task.pro.task15.task1515;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path path = Path.of(str);
        boolean tf = path.isAbsolute();
        if(tf == true){
            System.out.println(path);
        }else{
           Path newPath = path.toAbsolutePath();
            System.out.println(newPath);
        }
    }
}


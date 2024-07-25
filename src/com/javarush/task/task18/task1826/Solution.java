package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        if (args[0].equals("-e")) {
            cod(args[1], args[2]);
        } else if (args[0].equals("-d")) {
            encod(args[1], args[2]);
        }
    }

    public static void cod(String input, String output){
        try {
            FileInputStream Fileinput = new FileInputStream(input);
            FileOutputStream Fileoutput = new FileOutputStream(output);
            while (Fileinput.available() > 0){
                Fileoutput.write(Fileinput.read() + 8);
            }
            Fileinput.close();
            Fileoutput.close();
        }catch (IOException e){
            System.out.println("ok");
        }
    }

    public static void encod(String input, String output){
        try {
            FileInputStream Fileinput = new FileInputStream(input);
            FileOutputStream Fileoutput = new FileOutputStream(output);
            while (Fileinput.available() > 0){
                Fileoutput.write(Fileinput.read() - 8);
            }
            Fileinput.close();
            Fileoutput.close();
        }catch (IOException e){
            System.out.println("ok");
        }
    }
}

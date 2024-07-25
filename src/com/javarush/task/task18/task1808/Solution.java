package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try(Scanner scanner = new Scanner(System.in);
        FileInputStream input = new FileInputStream(scanner.nextLine());
        FileOutputStream file2 = new FileOutputStream(scanner.nextLine());
        FileOutputStream file3 = new FileOutputStream(scanner.nextLine())){
            byte[] forUse = new byte[input.available()];
            while (input.available() > 0){
                input.read(forUse);
            }

            int length = forUse.length;
            if(forUse.length % 2 == 0){
                file2.write(forUse, 0, length / 2);
                byte[] forFile3 = new byte[length / 2];

                for (int i = 0; i < forFile3.length; i++) {
                    forFile3[i] = forUse[i + length / 2];
                }
                file3.write(forFile3, 0, forFile3.length);
            }else{
                file2.write(forUse, 0, (length / 2) + 1);
                byte[] forFile3 = new byte[(length / 2)];

                for (int i = 0; i < forFile3.length; i++) {
                    forFile3[i] = forUse[i + (length / 2) + 1];
                }
                file3.write(forFile3, 0, forFile3.length);
            }
        }
    }
}

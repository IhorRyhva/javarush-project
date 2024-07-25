package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String str = new Scanner(System.in).nextLine();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        int res = 0;
        byte[] byteKeeper = new byte[64000];
        while (buffer.ready()){
            byteKeeper = buffer.readLine().getBytes();
        }

        for (int i = 0; i < byteKeeper.length; i++) {
            res = Math.max(res, byteKeeper[i]);
        }
        buffer.close();
        System.out.println(res);
    }
}

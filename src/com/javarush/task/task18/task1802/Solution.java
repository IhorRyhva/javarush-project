package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String url = new Scanner(System.in).nextLine();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(url)));
        byte[] minByte = buffer.readLine().getBytes();;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < minByte.length; i++) {
            res = Math.min(minByte[i] ,res);
        }

        buffer.close();
        System.out.println(res);
    }
}

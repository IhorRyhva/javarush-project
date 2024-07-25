package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Long.toBinaryString(20l));
        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        StringBuilder forLong = new StringBuilder(Long.toBinaryString(number));
        if(forLong.length() < i || forLong.length() < j){
            int temp = Math.max(i, j) - forLong.length();
            StringBuilder forTemp = new StringBuilder();
            for (int k = 0; k <= temp; k++) {
                forTemp.append("0");
            }
            forLong = forTemp.append(forLong);
        }
        char[] binary = forLong.reverse().toString().toCharArray();
        char swap = binary[i];
        binary[i] = binary[j];
        binary[j] = swap;
        StringBuilder res = new StringBuilder(String.copyValueOf(binary));
        number = Long.parseLong(res.reverse().toString(), 2);
        return number;
    }
}

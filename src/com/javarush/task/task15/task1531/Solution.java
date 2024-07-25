package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        String result = "";
        result += n;
        BigInteger forUse = new BigInteger(result);
        if(n == 0){
            result = "1";
        }else if(n <= 150 && n > 0){
            for (int i = n - 1; i > 0; i--) {
                String cycleString = "";
                cycleString += i;
                BigInteger cycle = new BigInteger(cycleString);
                forUse =  forUse.multiply(cycle);
            }
            result = "";
            result += forUse;
        }else{
            result = "0";
        }
        return result;
    }
}

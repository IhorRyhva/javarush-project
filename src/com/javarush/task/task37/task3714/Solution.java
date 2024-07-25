package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }
    // I = 1, X = 10, С = 100, М = 1000 та їх половин V = 5, L = 50, D = 500
    public static int romanToInteger(String s) {
        int res = 0;
        char[] toInteger = s.toCharArray();

        for (int i = 0; i < toInteger.length; i++) {
            if(i == 0){
                res += Solution.value(toInteger[i]);
            }
            else{
                int temp = 0;
                if(Solution.value(toInteger[i - 1]) > Solution.value(toInteger[i])) {
                    temp += Solution.value(toInteger[i]);
                }else if(Solution.value(toInteger[i - 1]) < Solution.value(toInteger[i])){
                    temp += Solution.value(toInteger[i]) - Solution.value(toInteger[i - 1]) * 2;
                }else{
                    temp += Solution.value(toInteger[i]);
                }
                res += temp;
            }
        }

        return res;
    }

    private static int value(char c){
        if(c == 'I'){
            return 1;
        }else if(c == 'V'){
            return 5;
        }else if(c == 'X'){
            return 10;
        }else if(c == 'L'){
            return 50;
        }else if(c == 'C'){
            return 100;
        }else if(c == 'D'){
            return 500;
        }else if(c == 'M'){
            return 1000;
        }else{
            return 0;
        }
    }
}

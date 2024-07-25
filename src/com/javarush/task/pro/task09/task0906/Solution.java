package com.javarush.task.pro.task09.task0906;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 522;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1011";//1000001010
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        String strBinary = "";
        if(decimalNumber > 0){
            ArrayList<Integer> list = new ArrayList<>();
            while (decimalNumber > 0){
                int binary = decimalNumber % 2;
                list.add(binary);
                decimalNumber /= 2;
            }

            for (int i = list.size() - 1; i >= 0 ; i--) {
                strBinary += list.get(i);
            }
        }
        return strBinary;
    }

    public static int toDecimal(String binaryNumber) {
        int finals = 0;
        if(binaryNumber == null || binaryNumber.equals("")){
            return 0;
        }
        else{
            String[] list = binaryNumber.split("");
            for (int i = 0, j = list.length - 1; i < list.length && j >= 0; i++, j--) {
                int newFinals = Integer.parseInt(list[i]);
                if(newFinals == 1){
                    newFinals *= 2;
                    newFinals = (int) Math.pow(newFinals, j);
                    finals += newFinals;
                }else if(newFinals != 0){
                    return 0;
                }

            }
        }
        return finals;
    }
}

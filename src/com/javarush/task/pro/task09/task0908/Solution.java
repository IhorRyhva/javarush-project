package com.javarush.task.pro.task09.task0908;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9b0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String cool = "";
        if(binaryNumber == null || binaryNumber == ""){
            return "";
        }
        else{
            String[] binaryList = binaryNumber.split("");
            boolean tf = true;
            for (int i = 0; i < binaryList.length; i++) {
                if(binaryList[i].equals("1") || binaryList[i].equals("0")){
                    tf = true;
                }else{
                    tf = false;
                    break;
                }
            }
            if(tf == true) {
                int result = 0;

                for (int i = 0, j = binaryList.length - 1; i < binaryList.length && j >= 0; i++, j--) {
                    int curentNumber = Integer.parseInt(binaryList[i]);
                    if (curentNumber == 1) {
                        int res = 0;
                        res = (int) Math.pow(2, j);
                        result += res;
                    } else if (curentNumber != 0) {
                        return "";
                    }
                }
                ArrayList<Integer> newArray = new ArrayList<>();
                while (result >= 1) {
                    int forUse = result % 16;
                    newArray.add(forUse);
                    result /= 16;
                }
                for (int i = newArray.size() - 1; i >= 0; i--) {
                    if (newArray.get(i) == 10) {
                        cool += "a";
                    } else if (newArray.get(i) == 11) {
                        cool += "b";
                    } else if (newArray.get(i) == 12) {
                        cool += "c";
                    } else if (newArray.get(i) == 13) {
                        cool += "d";
                    } else if (newArray.get(i) == 14) {
                        cool += "e";
                    } else if (newArray.get(i) == 15) {
                        cool += "f";
                    } else {
                        cool += newArray.get(i);
                    }
                }
            }
        }
        return cool;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.isEmpty()) {
            return "";
        }

        for (char c : hexNumber.toCharArray()) {
            if (!Character.isDigit(c) && (c < 'a' || c > 'f')) {
                return "";
            }
        }

        StringBuilder binary = new StringBuilder();
        for (char c : hexNumber.toCharArray()) {
            int decimalValue;
            if (Character.isDigit(c)) {
                decimalValue = c - '0';
            } else {
                decimalValue = c - 'a' + 10;
            }

            StringBuilder fourBits = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                fourBits.insert(0, decimalValue % 2);
                decimalValue /= 2;
            }

            binary.append(fourBits);
        }

        return binary.toString();
    }


}

package com.javarush.task.pro.task09.task0907;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 458;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        String use = "";
        if(decimalNumber > 0) {
            ArrayList<Integer> forUse = new ArrayList<>();
            while (decimalNumber >= 1) {
                int uses = decimalNumber % 16;
                forUse.add(uses);
                decimalNumber /= 16;
            }

            for (int i = forUse.size() - 1; i >= 0; i--) {
                if (forUse.get(i) == 10) {
                    use += "a";
                } else if (forUse.get(i) == 11) {
                    use += "b";
                } else if (forUse.get(i) == 12) {
                    use += "c";
                } else if (forUse.get(i) == 13) {
                    use += "d";
                } else if (forUse.get(i) == 14) {
                    use += "e";
                } else if (forUse.get(i) == 15) {
                    use += "f";
                } else {
                    use += forUse.get(i);
                }
            }
        }
        return use;
    }

    public static int toDecimal(String hexNumber) {
        int use = 0;
        if (hexNumber == null || hexNumber.isEmpty()) {
            return 0;
        }

        else{
            int uses = 0;
            String[] forUse = hexNumber.split("");
            for (int i = 0, a = forUse.length - 1; i < forUse.length && a >= 0; i++, a--) {
                int curentInteger = 0;
                if (forUse[i].equalsIgnoreCase("a")) {
                    curentInteger = 10;
                } else if (forUse[i].equalsIgnoreCase("b")) {
                    curentInteger = 11;
                } else if (forUse[i].equalsIgnoreCase("c")) {
                    curentInteger = 12;
                } else if (forUse[i].equalsIgnoreCase("d")) {
                    curentInteger = 13;
                } else if (forUse[i].equalsIgnoreCase("e")) {
                    curentInteger = 14;
                } else if (forUse[i].equalsIgnoreCase("f")) {
                    curentInteger = 15;
                } else if(forUse[i].equals("0") || forUse[i].equals("1") || forUse[i].equals("2") || forUse[i].equals("3") || forUse[i].equals("4") || forUse[i].equals("5") || forUse[i].equals("6") || forUse[i].equals("7") || forUse[i].equals("8") || forUse[i].equals("9")){
                    curentInteger = Integer.parseInt(forUse[i]);
                }
                else{
                    return 0;
                }
                int newUse = (int) Math.pow(16, a);
                uses += curentInteger*newUse;
            }
            use = uses;
        }
        return use;
    }
}

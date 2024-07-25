package com.javarush.task.pro.task09.task0905;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 83;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 123;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        int res = 0;
        if(decimalNumber > 0){
        int wr = 0;
        int use = 0;
        int i = -1;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (decimalNumber > 0){
            i++;
            use = decimalNumber / 8;
            wr = decimalNumber % 8;
            list.add(wr);
            decimalNumber = use;
        }
        String str = "";
        for(int a = list.size() - 1; a >= 0 ; a--){
            str += list.get(a);
        }
        res = Integer.parseInt(str);
        }
        return res;
    }

    public static int toDecimal(int octalNumber) {
        int res = 0;
        if(octalNumber > 0) {
            int count = 0;
            int move = octalNumber;
            while (move > 10) {
                move = move / 10;
                count++;
            }
            ArrayList<Integer> newNumber = new ArrayList<Integer>();
            for (int i = count; i >= 0; i--) {
                int action = (int) Math.pow(10, count);
                int newAction = (int) Math.pow(8, count);
                int result = octalNumber / action;
                int use = result;
                use *= newAction;
                newNumber.add(use);
                octalNumber = octalNumber - result * action;
                count--;
            }


            for (int i = 0; i < newNumber.size(); i++) {
                res += newNumber.get(i);
            }
        }
        return res;
    }
}

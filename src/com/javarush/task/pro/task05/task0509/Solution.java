package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
       MULTIPLICATION_TABLE = new int[10][10];
       for(int i = 0, o = 1; i < 10 && o < 11; i++, o++){
           for(int p = 0, a = 1; p < 10 && a <11; p++, a++){
               MULTIPLICATION_TABLE[i][p] =  o * a;
               System.out.print(MULTIPLICATION_TABLE[i][p] + " ");
           }
           System.out.println();
       }
    }
}

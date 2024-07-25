package com.javarush.task.pro.task05.task0510;

/* 
Треугольный массив
*/

import java.util.Arrays;

public class Solution {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {

        for(int i = 0; i < result.length; i ++){
            result[i] = new int[i + 1];
            for (int b = 0; b <result[i].length; b++){
                result[i][b] = i + b;
            }
        }

        for(int i = 0; i < result.length; i++ ){
            for(int b = 0; b < result[i].length; b++){
                System.out.print(result[i][b] + " ");
            }
            System.out.println();
        }
    }
}

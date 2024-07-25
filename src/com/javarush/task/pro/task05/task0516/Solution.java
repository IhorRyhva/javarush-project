package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[21];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        int length = array.length / 2;
        if(array.length % 2 == 0){
            Arrays.fill(array,0, length, valueStart);
            Arrays.fill(array, length, array.length, valueEnd);
        }
        else {
            Arrays.fill(array,0, length + 1, valueStart);
            Arrays.fill(array, length + 1, array.length, valueEnd);
        }

        System.out.println(Arrays.toString(array));
    }
}

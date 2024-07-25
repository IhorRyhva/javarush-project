package com.javarush.task.pro.task05.task0504;

/* 
Объединяем массивы
*/

public class Solution {
    public static int[] firstArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int[] resultArray;

    public static void main(String[] args) {
        int length = firstArray.length + secondArray.length;
        int first = firstArray.length;
        int second = secondArray.length;
        int a = 0;
        resultArray = new int[length];
        for (int i = 0; i < first; i++){
            resultArray[i] = firstArray[i];
            a = i;
        }
        for (int i = 0, j = a + 1;j < length && i < second; i++, j++){
        resultArray[j] = secondArray[i];
        }
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + ", ");
        }
    }
}

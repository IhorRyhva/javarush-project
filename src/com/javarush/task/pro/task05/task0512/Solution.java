package com.javarush.task.pro.task05.task0512;

/* 
Создаем мультимассив
*/

public class Solution {

    public static int[][][] multiArray = new int[][][]{{{4, 8, 15}, {16}}, {{23, 42}, {}}, {{1}, {2}, {3}, {4, 5}}};

    public static void main(String[] args) {
        for(int a = 0; a < multiArray.length; a++){
            for(int b = 0; b < multiArray[a].length; b++){
                for (int c = 0; c < multiArray[a][b].length; c++){
                    System.out.println(multiArray[a][b][c]);
                }

            }
        }
    }
}

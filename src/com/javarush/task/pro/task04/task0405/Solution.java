package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int height = 0;
        while(height < 10){
            while(height == 0 || height == 9){
                System.out.println("ББББББББББББББББББББ");
                height++;
            }
            while(height > 0 && height < 9){
                System.out.println("Б                  Б");
                height++;
            }
            //height++;
        }
    }
}
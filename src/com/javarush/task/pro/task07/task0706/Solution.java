package com.javarush.task.pro.task07.task0706;

/* 
Странное деление
*/

public class Solution {
    public static void main(String[] args) {
        double a = 1.0/0.0;
        div(a, a);
    }

    public static void div(double a, double b){
        System.out.println(b/a);
    }
}

package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        Scanner consol = new Scanner(System.in);
        int jar = consol.nextInt();
        int people = consol.nextInt();
        double x = (jar * 1.0 / people);
        System.out.println(x);
    }
}
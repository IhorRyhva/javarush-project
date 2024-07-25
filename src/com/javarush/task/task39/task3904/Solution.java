package com.javarush.task.task39.task3904;

/*
Лестница
*/

public class Solution {
    private static int n = 7;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if(n < 0)
            return 0;
        else if(n == 1 || n == 0)
            return 1;
        else if(n == 2)
            return 2;
        else if(n == 3)
            return 4;
        else {
            long first = 1;
            long second = 2;
            long third = 4;
            long res = 0;
            for (int i = 0; i < n - 3; i++) {
                res = third + second + first;
                first = second;
                second = third;
                third = res;
            }
            return res;
        }
    }
}


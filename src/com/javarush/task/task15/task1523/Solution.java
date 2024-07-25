package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    public static void main(String[] args) {
    }
    Solution(){
    }
    public Solution(long k) {
        System.out.println("SubSolution");
    }

    protected Solution(int a) {
        System.out.println("SubSolution " + a);
    }

    private Solution(int a, int b){
        System.out.println("SubSolution " + a +", " + b);
    }
}


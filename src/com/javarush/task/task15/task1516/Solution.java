package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print();
    }

    public void print(){
        System.out.println(intVar);
        System.out.println(doubleVar);
        System.out.println(DoubleVar);
        System.out.println(booleanVar);
        System.out.println(ObjectVar);
        System.out.println(ExceptionVar);
        System.out.println(StringVar);}
    public int intVar;
    public double doubleVar;
    Double DoubleVar;
    boolean booleanVar;
    Object ObjectVar;
    Exception ExceptionVar;
    String StringVar;
}

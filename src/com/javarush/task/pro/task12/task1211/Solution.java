package com.javarush.task.pro.task12.task1211;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Сортировка пузырьком
*/

public class Solution {

    public static int[] numbers = new int[] {56, 45, 89, 1, 45, 13, 4, 69, 11, -89};

    public static void main(String[] args) {
        print();
        sort();
        System.out.println("\nОтсортированные числа в натуральном порядке:");
        print();
    }

    public static void sort() {
        for(int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers.length; j++) {
                if(numbers[j] > numbers[i]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void print() {
        for (int number : numbers) {
            System.out.print(number + "\t");
        }
    }
}

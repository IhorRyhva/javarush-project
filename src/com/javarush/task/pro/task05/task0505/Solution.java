package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //System.out.print("Enter number of array: ");
        int n = scan.nextInt();
        if(n > 0) {
            int[] array = new int[n];
            for(int i = 0; i < array.length; i++){
                array[i] = scan.nextInt();
            }
            if(n % 2 == 0){
                for (int i = n - 1; i >= 0; i--) {
                    System.out.println(array[i]);
                }
            }
            else{
                for(int i = 0; i < n; i++){
                    System.out.println(array[i]);
                }
            }
        }
    }
}

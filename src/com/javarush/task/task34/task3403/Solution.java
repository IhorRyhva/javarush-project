package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        new Solution().recurse(132);
    }
    public void recurse(int n) {
        boolean tf = false;
        if(n > 1){
            for (int i = 2; i < n; i++) {
                if(n % i == 0){
                    System.out.print(i + " ");
                    n = n / i;
                    tf = true;
                    break;
                }
            }

            if(tf) {
                recurse(n);
            }else{
                System.out.print(n);
            }
        }
    }
}

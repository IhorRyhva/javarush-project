package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner consol = new Scanner(System.in);
        strings = new String[6];

        for(int i = 0; i < strings.length; i++){
            strings[i] = consol.nextLine();
        }

          for(int i = 0; i < strings.length; i++){
              String res = strings[i];
              if(res != null){
                  for(int j = i + 1; j < strings.length; j++){
                      if(res.equals(strings[j])){
                          strings[j] = null;
                          strings[i] = null;
                      }
                  }
              }
          }


        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}

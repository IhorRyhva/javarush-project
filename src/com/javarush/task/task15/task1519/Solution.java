package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String string = buffer.readLine();
        while (!string.equals("exit")){
            try {
                if(string.contains(".")) {
                    Double doubles = Double.parseDouble(string);
                    print(doubles);
                }else{
                    if(Integer.parseInt(string) > 0 && Integer.parseInt(string) < 128){
                        short ura = Short.parseShort(string);
                        print(ura);
                    }else{
                        int a = Integer.parseInt(string);
                        Integer integer = a;
                        print(integer);
                    }
                }
            }catch (NumberFormatException e){
                print(string);
            }
            string = buffer.readLine();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

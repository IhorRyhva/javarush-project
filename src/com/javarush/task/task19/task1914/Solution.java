package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standard = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(array);
        System.setOut(stream);
        testString.printSomething();
        String[] string = array.toString().split(" ");
        int first = Integer.parseInt(string[0]);
        int second = Integer.parseInt(string[2]);
        String result = "";
        if(string[1].equals("+")){
            int equals = first + second;
            result = String.format("%d + %d = %d", first, second, equals);
        }else if(string[1].equals("-")){
            int equals = first - second;
            result = String.format("%d - %d = %d", first, second, equals);
        }else if(string[1].equals("*")){
            int equals = first * second;
            result = String.format("%d * %d = %d", first, second, equals);
        }
        System.setOut(standard);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


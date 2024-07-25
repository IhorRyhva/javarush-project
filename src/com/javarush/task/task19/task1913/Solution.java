package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standard = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(array);
        System.setOut(stream);
        testString.printSomething();
        String onlyNumber = array.toString();
        char[] result = onlyNumber.toCharArray();
        onlyNumber = "";
        for (int i = 0; i < result.length; i++) {
            if(Character.isDigit(result[i])){
                onlyNumber += result[i];
            }
        }
        System.setOut(standard);
        System.out.println(onlyNumber);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}

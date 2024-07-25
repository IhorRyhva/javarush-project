package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standard = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(array);
        System.setOut(output);
        testString.printSomething();
        String[] res = array.toString().split("\\W");
        System.setOut(standard);
        int count = 1;
        for (int i = 0; i < res.length; i++) {
            if(res[i].equals("")){
                continue;
            }
            if(count % 2 == 0){
                System.out.println(res[i]);
                System.out.println("JavaRush - курсы Java онлайн");
                count++;
            }else{
                System.out.println(res[i]);
                count++;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

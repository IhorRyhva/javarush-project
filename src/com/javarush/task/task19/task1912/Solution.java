package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream standard = System.out;
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        testString.printSomething();
        String res = output.toString();
        char[] forRes = res.toCharArray();
        res = "";
        String forUse = "";
        for (int i = 0; i < forRes.length - 1; i++) {
            forUse += forRes[i];
            forUse += forRes[i + 1];
            if(forUse.equals("te")) {
                forRes[i] = '?';
                forRes[i + 1] = '?';
            }
            forUse = "";
        }
        for (int i = 0; i < forRes.length; i++) {
            res += forRes[i];
        }
        System.setOut(standard);
        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

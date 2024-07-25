package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        BufferedReader filePath = new BufferedReader(new InputStreamReader(System.in));
        String link = filePath.readLine();
        FileOutputStream writer = new FileOutputStream(link);
        filePath.close();
        PrintStream standard = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(array);
        System.setOut(stream);
        testString.printSomething();
        String forConsoleAndFile = array.toString();
        byte[] bytes = forConsoleAndFile.getBytes();
        writer.write(bytes);
        writer.close();
        System.setOut(standard);
        System.out.println(forConsoleAndFile);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}


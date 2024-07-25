package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int A = 0;

    static {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(null));
            bufferedReader.readLine();
        }catch(IOException | ExceptionInInitializerError ex){
            System.out.println("Exception in thread \"main\" java.lang.ExceptionInInitializerError at java.lang.Class.forName0(Native Method) at java.lang.Class.forName(Class.java:186) at com.intellij.rt.execution.application.AppMain.main(AppMain.java:113) Caused by: java.lang.RuntimeException: at com.javarush.task.task15.task1517.Solution.<clinit>(Solution.java:22)\n");
        }
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}

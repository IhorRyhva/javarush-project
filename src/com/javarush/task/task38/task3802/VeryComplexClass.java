package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileWriter;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        new FileWriter("");
    }

    public static void main(String[] args) {

    }
}

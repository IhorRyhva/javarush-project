package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object integer = new Integer(12);
        String s = (String) integer;
    }

    public void methodThrowsNullPointerException() {
        VeryComplexClass veryComplexClass = null;
        veryComplexClass.methodThrowsClassCastException();
    }

    public static void main(String[] args) {
        new VeryComplexClass().methodThrowsNullPointerException();
    }
}

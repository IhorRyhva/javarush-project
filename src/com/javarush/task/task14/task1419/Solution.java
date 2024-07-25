package com.javarush.task.task14.task1419;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {//1
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }


        exceptions.add(new FileNotFoundException());
        exceptions.add(new IOException());
        exceptions.add(new CloneNotSupportedException());
        exceptions.add(new SQLException());
        exceptions.add(new RemoteException());
        exceptions.add(new MalformedURLException());
        exceptions.add(new IllegalAccessException());
        exceptions.add(new EOFException());
        exceptions.add(new RuntimeException());
    }
}

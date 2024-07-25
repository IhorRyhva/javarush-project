package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;/*
Используем RandomAccessFile
*/
import java.util.Arrays;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        randomAccessFile.seek(Integer.parseInt(args[1]));
        byte[] name = args[2].getBytes();
        byte[] fromFile = new byte[name.length];

        randomAccessFile.read(fromFile, 0, name.length);

        randomAccessFile.seek(randomAccessFile.length());
        if(Arrays.equals(name, fromFile)){
            randomAccessFile.write("true".getBytes());
        }else{
            randomAccessFile.write("false".getBytes());
        }

        randomAccessFile.close();
    }
}

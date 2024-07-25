package com.javarush.task.task32.task3201;

/*
Запись в существующий файл
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        long length = randomAccessFile.length();
        if(Integer.parseInt(args[1]) > length){
            randomAccessFile.seek(length);
        }else{
            randomAccessFile.seek(Integer.parseInt(args[1]));
        }

        String text = args[2];
        randomAccessFile.write(text.getBytes());
        randomAccessFile.close();
    }
}

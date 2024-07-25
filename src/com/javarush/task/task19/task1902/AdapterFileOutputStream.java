package com.javarush.task.task19.task1902;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* 
Адаптер
*/

public class AdapterFileOutputStream implements AmigoStringWriter{

    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream outputStream = new FileOutputStream(new Scanner(System.in).nextLine());
        AmigoStringWriter amigoStringWriter = new AdapterFileOutputStream(outputStream);
    }

    private FileOutputStream fileOutputStream;
    public AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        char[] forStream = s.toCharArray();
        byte[] res = new byte[forStream.length];
        for (int i = 0; i < forStream.length; i++) {
            res[i] = (byte) forStream[i];
        }
        fileOutputStream.write(res);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}


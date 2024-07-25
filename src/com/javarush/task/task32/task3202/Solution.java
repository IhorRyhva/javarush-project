package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\sers\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task31\\a"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        writer.write("");

        if(is != null) {
            while (is.available() > 0) {
                writer.write(is.read());
            }
        }
        return writer;
    }
}

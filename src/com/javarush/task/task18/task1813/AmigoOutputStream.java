package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    FileOutputStream output;
    public static String fileName = "C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task18\\task1813\\Bytes";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream output){
        super(new FileDescriptor());
        this.output = output;
    }

    @Override
    public void close() throws IOException {
        output.flush();
        output.write( "JavaRush © All rights reserved.".getBytes());
        output.close();
    }

    @Override
    public void write(int b) throws IOException {
        output.write(b);
    }

    @Override
    public void flush() throws IOException {
        output.flush();
    }

    @Override
    public void write(byte[] b) throws IOException {
        output.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        output.write(b, off, len);
    }
}
/* public AmigoOutputStream(FileOutputStream output) throws FileNotFoundException {
        super(fileName);
        this.output = output;
    }

    @Override
    public void close() throws IOException {
        flush();
        output.write( "JavaRush © All rights reserved.".getBytes());
        close();
    }

    @Override
    public void write(int b) throws IOException {
        output.write(b);
    }
*/
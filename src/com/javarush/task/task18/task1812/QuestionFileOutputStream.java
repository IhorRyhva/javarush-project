package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    public static void main(String[] args) throws IOException {
        QuestionFileOutputStream questionFileOutputStream = new QuestionFileOutputStream(new AmigoMolodeth());
        questionFileOutputStream.close();
    }
    private AmigoOutputStream Amigo;
    public QuestionFileOutputStream(AmigoOutputStream amigo){
        Amigo = amigo;
    }
    @Override
    public void flush() throws IOException {
        Amigo.flush();
    }

    @Override
    public void write(int b) throws IOException {
        Amigo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        Amigo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        Amigo.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String yn = new Scanner(System.in).nextLine();
        if(yn.equals("Д")){
            Amigo.close();
        }
    }

    public static class AmigoMolodeth implements  AmigoOutputStream{

        @Override
        public void flush() throws IOException {

        }

        @Override
        public void write(int b) throws IOException {

        }

        @Override
        public void write(byte[] b) throws IOException {

        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {

        }

        @Override
        public void close() throws IOException {

        }
    }
}


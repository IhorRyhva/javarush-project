package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static{
        firstFileName = new Scanner(System.in).nextLine();
        secondFileName = new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFileName = "";
        private String res = "";
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return res;
        }


        @Override
        public void start() {
            if(fullFileName != null){
                this.run();
            }else{
                System.out.println("");
            }
        }

        @Override
        public void run() {
           setFileName(fullFileName);

            String getFileContent = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));){
                while (reader.ready()){
                    getFileContent += reader.readLine() + " ";
                }
            } catch (Exception e) {
                System.out.println("");
            }

           res = getFileContent;
        }
    }
}

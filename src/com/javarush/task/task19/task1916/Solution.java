package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(link.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(link.readLine()));
        link.close();
        String first = "";
        String second = "";
        while (file1.ready()){
            first += file1.readLine() + " ";
        }
        while(file2.ready()){
            second += file2.readLine() + " ";
        }
        file1.close();
        file2.close();
        String[] forFile1 = first.split(" ");
        String[] forFile2 = second.split(" ");
        for(int i = 0; i < forFile1.length; i++){
            boolean tf = true;
            for (int j = 0; j < forFile2.length; j++){
                if(forFile1[i].equals(forFile2[j])) {
                    LineItem line = new LineItem(Type.SAME, forFile1[i]);
                    lines.add(line);
                    forFile1[i] = "";
                    forFile2[j] = "";
                    tf = false;
                    break;
                }
            }
            if(tf){
                LineItem item = new LineItem(Type.REMOVED, forFile1[i]);
                lines.add(item);
            }
        }
        for (int i = 0; i < forFile2.length; i++) {
            if(!forFile2[i].equals("")){
                LineItem item = new LineItem(Type.ADDED, forFile2[i]);
                lines.add(item);
            }
        }

        for(LineItem item: lines){
            System.out.println(item.getLine() + " " + item.getType() + "; ");
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public Type getType() {
            return type;
        }

        public String getLine() {
            return line;
        }

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

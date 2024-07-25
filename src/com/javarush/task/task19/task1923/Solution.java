package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        //link.close();
        String result = "";
        while (reader.ready()){
            String[] array = reader.readLine().split(" ");
            for (int i = 0; i < array.length; i++) {
                boolean tf = false;
                char[] chars = array[i].toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    int a = chars[j];
                    if(Character.isDigit(a)) {
                        tf = true;
                        break;
                    }
                }
                if(tf){
                    result += array[i] + " ";
                }
            }
        }
        writer.write(result);
        reader.close();
        writer.close();
    }
}

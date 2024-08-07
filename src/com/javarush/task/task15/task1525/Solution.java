package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try(BufferedReader br = new BufferedReader(new FileReader(Statics.FILE_NAME))){
            while (br.ready()){
                lines.add(br.readLine());
            }

        } catch (FileNotFoundException ex){
            System.out.println("Ti gho dolboyob?");
        } catch (IOException ex){
            System.out.println("Ti gho dolboyob?");
        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}

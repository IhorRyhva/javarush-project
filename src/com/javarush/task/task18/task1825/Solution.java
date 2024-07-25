package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))){
            Set<String> refuge = new TreeSet<>();
            String string = buffer.readLine();
            String forWriter = "";
            while(!string.equals("end")){
                refuge.add(string);
                forWriter = string;
                string = buffer.readLine();

            }

            int forName = forWriter.lastIndexOf(".part");
            String link = forWriter.substring(0, forName);
            try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(link, true))){
                for(String forReader: refuge){
                    try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(forReader))){
                        byte[] bytes = new byte[64000];
                        while (reader.available() > 0){
                            int index = reader.read(bytes);
                            writer.write(bytes, 0, index);
                        }
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Chotot pishlo ne tak :( ;)");
        }
    }
}

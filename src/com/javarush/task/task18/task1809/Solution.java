package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args)throws IOException {
        try(Scanner scanner = new Scanner(System.in);
            FileInputStream input = new FileInputStream(scanner.nextLine());
            FileOutputStream output = new FileOutputStream(scanner.nextLine())){
            byte[] revers = new  byte[input.available()];

            if(input.available() > 0){
                input.read(revers);
            }

            List<Byte> forRevers = new ArrayList<>();
            for(byte res: revers){
                forRevers.add(res);
            }

            Collections.reverse(forRevers);

            for (int i = 0; i < forRevers.size(); i++) {
                revers[i] = forRevers.get(i);
            }

            output.write(revers);
        }
    }
}

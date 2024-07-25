package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.equals("-u") && args.length == 4){
            BufferedWriter writer = getBufferedWriter(args);
            writer.close();
        }else if(args[0].equals("-d") && args.length == 2){
            BufferedReader forLink = new BufferedReader(new InputStreamReader(System.in));
            String link = forLink.readLine();
            forLink.close();
            ArrayList<String> find = new ArrayList<>();

            try(BufferedReader reader = new BufferedReader(new FileReader(link))){
                while (reader.ready()){
                    find.add(reader.readLine());
                }
                for(String looking: find) {
                    if (looking.substring(0, 8).trim().equals(args[1])) {
                        find.remove(find.indexOf(looking));
                    }
                }
            }

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(link))){
                for(String win: find){
                    writer.write(win);
                    writer.newLine();
                }
            }
        }
    }

    private static BufferedWriter getBufferedWriter(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String link = scanner.nextLine();
        ArrayList<String> list;
        try (BufferedReader reader = new BufferedReader(new FileReader(link))) {
            list = new ArrayList<>();

            while (reader.ready()) {
                list.add(reader.readLine());
            }
            reader.close();
        }
        for(String find: list){
            if(find.substring(0, 8).equals(args[0])){
                int index = list.indexOf(find);
                String result = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]);
                list.set(index, result);
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(link));
        for(String res: list){
            writer.write(res);
            writer.newLine();
        }
        writer.flush();
        return writer;
    }
}

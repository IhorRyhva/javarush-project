package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader readAllLines = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())));
        BufferedReader readForRemoveLines = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())));
        String element = "";
        while (readAllLines.ready()) {
            element = readAllLines.readLine();
            allLines.add(element);
        }
        while (readForRemoveLines.ready()) {
            element = readForRemoveLines.readLine();
            forRemoveLines.add(element);
        }

        readAllLines.close();
        readForRemoveLines.close();
        scanner.close();

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {
            if(allLines.containsAll(forRemoveLines)){
                allLines.removeAll(forRemoveLines);
            }else{
                allLines.clear();
                throw new CorruptedDataException();
            }
    }
}

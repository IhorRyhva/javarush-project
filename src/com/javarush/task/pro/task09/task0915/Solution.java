package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer str = new StringTokenizer(query, delimiter);
        int tocen = str.countTokens();
        String[] res = new String[tocen];
        int i = 0;
        while (str.hasMoreTokens()){
            String a = "";
            a += str.nextToken();
            res[i] = a;
            i++;
        }
        return res;
    }
}

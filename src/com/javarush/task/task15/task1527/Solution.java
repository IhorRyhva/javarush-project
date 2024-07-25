package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] strURl = url.split("\\?");
        url = strURl[1];
        strURl = url.split("&");
        url = "";
        for(String str: strURl){
            url += " " + str;
        }
        String[] Finally = url.split(" ");

        String res = "";
        ArrayList<Object> ObjectArrayList = new ArrayList<>();

        for (int i = 1; i < Finally.length; i++) {
            String[] mig = Finally[i].split("=");

            if(mig.length == 2){
                if(mig[0].equals("obj")){
                    res += mig[0] + " ";
                        char[] Ch = mig[1].toCharArray();
                        StringBuilder lama = new StringBuilder();
                        for (int j = 0; j < Ch.length; j++) {
                            if(Ch[j] != '.') {
                                String string = String.valueOf(Ch[j]);
                                lama.append(string);
                            }
                        }
                        String string = "";
                        for (int j = 0; j < lama.length(); j++) {
                            string += lama.charAt(j);
                        }

                        if(string.matches("\\d+")) {
                            double doubles = Double.parseDouble(mig[1]);
                            ObjectArrayList.add(doubles);
                        }
                    else{
                        ObjectArrayList.add(mig[1]);
                    }
                }else{
                   res += mig[0] + " ";
                }
            }else{
                res += Finally[i] + " ";
            }
        }

        System.out.println(res);
        for (int i = 0; i < ObjectArrayList.size(); i++) {
            if(ObjectArrayList.get(i) instanceof Double){
                double doubles = Double.parseDouble(String.valueOf(ObjectArrayList.get(i)));
                alert(doubles);
            }else{
                String ura = ObjectArrayList.get(i).toString();
                alert(ura);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

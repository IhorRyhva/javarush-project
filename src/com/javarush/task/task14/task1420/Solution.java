package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        int min = Math.min(first, second);
        int max = Math.max(first, second);

        int NSD = 0;

        if(max % min == 0){
            NSD = min;
        }else{

            ArrayList<Integer> joint = getIntegers(min, max);

            NSD = joint.stream().max((i1, i2) -> i1 - i2).get();
        }

        System.out.println(NSD);
    }

    private static ArrayList<Integer> getIntegers(int min, int max) {
        ArrayList<Integer> forFirst = new ArrayList<>();
        ArrayList<Integer> forSecond = new ArrayList<>();

        for (int i = 1; i < min; i++) {
            if(max % i == 0)
                forFirst.add(i);
        }

        for (int i = 1; i < min; i++) {
            if(min % i == 0)
                forSecond.add(i);
        }

        ArrayList<Integer> joint = new ArrayList<>();

        for (int f = 0; f < forFirst.size(); f++) {
            for (int s = 0; s < forSecond.size(); s++) {
                if(forFirst.get(f) == forSecond.get(s))
                    joint.add(forSecond.get(s));
            }
        }
        return joint;
    }
}

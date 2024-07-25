package com.javarush.task.task20.task2028;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int i = 1;
        for(int res: arrayList){
            while (i < 3) {
                i++;
                arrayList.add(i);
            }
            break;
        }

        arrayList.forEach(System.out::println);
    }
}

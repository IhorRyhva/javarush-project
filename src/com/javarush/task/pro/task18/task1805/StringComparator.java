package com.javarush.task.pro.task18.task1805;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    public int compare (String  first, String  second){
        return first.length() - second.length();
    }
}

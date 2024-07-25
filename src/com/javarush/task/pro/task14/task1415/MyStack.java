package com.javarush.task.pro.task14.task1415;

import java.util.LinkedList;
import java.util.List;

/* 
Стек в домашних условиях
*/

public class MyStack {

    private final List<String> storage = new LinkedList<>();

    public void push(String s) {
        List<String> storageTemp = new LinkedList<>();
        storageTemp.add(s);
        for(String el: storage){
            storageTemp.add(el);
        }
        storage.clear();
        for (String el: storageTemp){
            storage.add(el);
        }
    }

    public String pop() {
        int index = storage.size();
        String str = storage.get(0);
        storage.remove(str);
        return str;
    }

    public String peek() {
        int index = storage.size();
        String str = storage.get(0);
        return str;
    }

    public boolean empty() {
        int index = storage.size();
        boolean tf = true;
        if(index != 0)
            tf = false;
        return tf;
    }

    public int search(String s) {
        int res = -1;
        for(String el: storage){
            if(el.equals(s))
                res = storage.indexOf(el);
        }
        return res;
    }
}

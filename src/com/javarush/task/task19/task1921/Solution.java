package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        //BufferedReader link = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
        //link.close();
        while (buffer.ready()){
            String[] array = buffer.readLine().split(" ");
            int length = array.length - 1;
            String name = "";
            int year = Integer.parseInt(array[length]);
            int month = Integer.parseInt(array[length - 1]);
            int datas = Integer.parseInt(array[length - 2]);
            for (int i = 0; i < length - 2; i++) {
                name += array[i] + " ";
            }
            Date data = new Date(year - 1900, month - 1, datas);
            Person person = new Person(name.trim(), data);
            PEOPLE.add(person);
            //System.out.println(person.getName());
        }
        buffer.close();
    }
}

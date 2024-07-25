package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        boolean tf = true;

        while (tf) {
            key = reader.readLine();
            if(!key.equals("user") && !key.equals("loser") && !key.equals("coder") && !key.equals("proger"))
                tf = false;
            person = null;

            switch (key){
                case("user"):
                    person = new Person.User();
                    doWork(person);
                    break;
                case("loser"):
                    person = new Person.Loser();
                    doWork(person);
                    break;
                case("coder"):
                    person = new Person.Coder();
                    doWork(person);
                    break;
                case("proger"):
                    person = new Person.Proger();
                    doWork(person);
                    break;
            }
        }
    }

    public static void doWork(Person person) {
        if(person instanceof Person.User){
            Person.User user = (Person.User) person;
            user.live();
        }else if(person instanceof Person.Loser){
            Person.Loser loser = (Person.Loser) person;
            loser.doNothing();
        }else if(person instanceof Person.Coder){
            Person.Coder coder = (Person.Coder) person;
            coder.writeCode();
        }else if(person instanceof Person.Proger){
            Person.Proger proger = (Person.Proger) person;
            proger.enjoy();
        }
    }
}

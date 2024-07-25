package com.javarush.task.task17.task1710;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Date date = null;
        if(args[0].equals("-c")){
            Person persona = null;
            date = dateFormat.parse(args[3]);
            if(args[2].equals("м")){
                persona = Person.createMale(args[1], date);
                allPeople.add(persona);
            }else if(args[2].equals("ж")){
                persona = Person.createFemale(args[1], date);
                allPeople.add(persona);
            }
            int index = allPeople.indexOf(persona);
            System.out.println(index);
        }else if(args[0].equals("-r")){
            int index = Integer.parseInt(args[1]);
            System.out.print(allPeople.get(index).getName() + " ");
            if (allPeople.get(index).getSex() == Sex.MALE){
                System.out.print("м" + " ");
            }else if(allPeople.get(index).getSex() == Sex.FEMALE){
                System.out.print("ж" + " ");
            }

            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String result = format.format(allPeople.get(index).getBirthDate());
            System.out.print(result);
        }else if(args[0].equals("-u")){
            int index = Integer.parseInt(args[1]);
            allPeople.get(index).setName(args[2]);

            if(args[3].equals("м")){
                Sex sex = Sex.MALE;
                allPeople.get(index).setSex(sex);
            }else if(args[3].equals("ж")){
                Sex sex = Sex.FEMALE;
                allPeople.get(index).setSex(sex);
            }

            Date dates = dateFormat.parse(args[4]);
            allPeople.get(index).setBirthDate(dates);
        }else if(args[0].equals("-d")){
            int index = Integer.parseInt(args[1]);
            allPeople.get(index).setName(null);
            allPeople.get(index).setBirthDate(null);
            allPeople.get(index).setSex(null);
        }
    }
}

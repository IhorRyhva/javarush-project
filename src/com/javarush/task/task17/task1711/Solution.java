package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    Sex sex = null;
                    Person person = null;
                    Date date;
                    String name = "";
                    int cycles = 0;
                    for (int i = 1; i < args.length; i++) {
                        if (cycles == 0) {
                            name = args[i];
                            cycles++;
                        } else if (cycles == 1) {
                            if (args[i].equals("м")) {
                                sex = Sex.MALE;
                            } else if (args[i].equals("ж")) {
                                sex = Sex.FEMALE;
                            }
                            cycles++;
                        } else if (cycles == 2) {
                            date = dateFormat.parse(args[i]);
                            if (sex == Sex.MALE) {
                                person = Person.createMale(name, date);
                                allPeople.add(person);
                                int res = allPeople.indexOf(person);
                                System.out.println(res);
                            } else if (sex == Sex.FEMALE) {
                                person = Person.createFemale(name, date);
                                allPeople.add(person);
                                int res = allPeople.indexOf(person);
                                System.out.println(res);
                            }
                            cycles = 0;
                        }
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    int index = 0;
                    Date dateu;
                    int cyclesu = 0;
                    for (int i = 1; i < args.length; i++) {
                        if (cyclesu == 0) {
                            index = Integer.parseInt(args[i]);
                            cyclesu++;
                        } else if (cyclesu == 1) {
                            allPeople.get(index).setName(args[i]);
                            cyclesu++;
                        } else if (cyclesu == 2) {
                            if (args[i].equals("м")) {
                                allPeople.get(index).setSex(Sex.MALE);
                            } else if (args[i].equals("ж")) {
                                allPeople.get(index).setSex(Sex.FEMALE);
                            }
                            cyclesu++;
                        } else if (cyclesu == 3) {
                            dateu = dateFormat.parse(args[i]);
                            allPeople.get(index).setBirthDate(dateu);
                            cyclesu = 0;
                        }
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    int indexd;
                    for (int i = 1; i < args.length; i++) {
                        indexd = Integer.parseInt(args[i]);
                        allPeople.get(indexd).setName(null);
                        allPeople.get(indexd).setSex(null);
                        allPeople.get(indexd).setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized(allPeople) {
                    int indexi;
                    for (int i = 1; i < args.length; i++) {
                        indexi = Integer.parseInt(args[i]);
                        System.out.print(allPeople.get(indexi).getName() + " ");
                        if (allPeople.get(indexi).getSex() == Sex.MALE) {
                            System.out.print("м" + " ");
                        } else if (allPeople.get(indexi).getSex() == Sex.FEMALE) {
                            System.out.print("ж" + " ");
                        }
                        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String dateF = simpleFormat.format(allPeople.get(indexi).getBirthDate());
                        System.out.println(dateF);
                    }
                    break;
                }
        }
    }
}

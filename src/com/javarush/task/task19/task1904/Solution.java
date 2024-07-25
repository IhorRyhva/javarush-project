package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScanner scanner = new PersonScannerAdapter(new Scanner(System.in));
        scanner.read();
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String res = fileScanner.nextLine();
            String[] array = res.split(" ", 4);
            String firstName = array[1];
            String middleName = array[2];
            String lastName = array[0];
            Date birthday;
            try {
                birthday = new SimpleDateFormat("dd M yyyy").parse(array[3]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Person person = new Person(firstName, middleName, lastName, birthday);
            System.out.println(person.toString());
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}

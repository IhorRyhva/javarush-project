package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
//            OutputStream outputStream = new FileOutputStream(yourFile);
//            InputStream inputStream = new FileInputStream(yourFile);
//
//            JavaRush javaRush = new JavaRush();
//            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            javaRush.save(outputStream);
//            outputStream.flush();
//
//            JavaRush loadedObject = new JavaRush();
//            loadedObject.load(inputStream);
//            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
//
//            outputStream.close();
//            inputStream.close();
            OutputStream writer = new FileOutputStream(new Scanner(System.in).nextLine());
            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Ananas");
            user.setLastName("Banas");
            Date date = new Date(84651230);
            user.setBirthDate(date);
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            javaRush.save(writer);
            writer.close();

            InputStream reader = new FileInputStream(new Scanner(System.in).nextLine());
            javaRush.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            String yn = users.size() > 0?"Yes":"No";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(yn);
            writer.newLine();
            writer.flush();
            if(users != null){
                String size = "" + users.size();
                writer.write(size);
                writer.newLine();
                writer.flush();
                for(User user: users) {
                    String firstName = user.getFirstName();
                    writer.write(firstName);
                    writer.newLine();
                    writer.flush();
                    String lastName = user.getLastName();
                    writer.write(lastName);
                    writer.newLine();
                    writer.flush();
                    long bd = user.getBirthDate().getTime();
                    String birthDate = "" + bd;
                    System.out.println(bd);
                    writer.write(birthDate);
                    writer.newLine();
                    writer.flush();
                    String isMale = "" + user.isMale();
                    writer.write(isMale);
                    writer.newLine();
                    writer.flush();
                    String country = "" + user.getCountry();
                    writer.write(country);
                    writer.flush();
                    writer.newLine();
                }
                writer.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
                String yn = reader.readLine();
                int size = Integer.parseInt(reader.readLine());
                if(yn.equals("Yes")){
                    for(int i = 0; i < size; i++){
                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        long date = Long.parseLong(reader.readLine());
                        Date date1 = new Date();
                        date1.setTime(date);
                        user.setBirthDate(date1);
                        boolean tf = reader.readLine().equals("true");
                        user.setMale(tf);
                        user.setCountry(User.Country.valueOf(reader.readLine()));
                        users.add(user);
                        System.out.println(user.getFirstName());
                        System.out.println(user.getLastName());
                        System.out.println(user.getBirthDate());
                        System.out.println(user.isMale());
                        System.out.println(user.getCountry());
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

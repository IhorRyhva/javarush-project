package com.javarush.task.pro.task14.task1401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Поработай обработчиком
*/

public class Solution {

    public static final String INPUT_NAME = "\nВведите имя: ";
    public static final String INPUT_AGE = "Введите возраст пользователя '%s': ";

    public static final String CANNOT_BE_NULL = "Имя не может быть null.";
    public static final String CANNOT_BE_EMPTY = "Имя не может быть пустым.";
    public static final String CANNOT_CONTAIN_DIGIT = "Имя не может содержать цифры.";
    public static final String CANNOT_BE_NEGATIVE = "Возраст не может быть меньше 0.";
    public static final String CANNOT_BE_TOO_BIG = "Возраст не может быть больше 150.";
    public static final String UNKNOWN_ERROR = "Неизвестная ошибка.";

    public static final String FOUND = "\nПользователь '%s' найден под индексом %d.\n";
    public static final String NOT_FOUND = "\nПользователь '%s' не найден.\n";

    static List<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            addUser(new User());
        }

        User userToSearch = new User();
        userToSearch.setName("Рафаэль");

        findUserIndex(userToSearch);
    }

    static void addUser(User user) {
        System.out.print(INPUT_NAME);
        String name = scanner.nextLine();

        System.out.printf(INPUT_AGE, name);
        int age = Integer.parseInt(scanner.nextLine());

        int result = user.setName(name);
        switch(result){
            case(0):
                user.setName(name);
                break;
            case(-1):
                System.out.println(CANNOT_BE_NULL);
                break;
            case(-2):
                System.out.println(CANNOT_BE_EMPTY);
                break;
            case(-3):
                System.out.println(CANNOT_CONTAIN_DIGIT);
                break;
            default:
                System.out.println(UNKNOWN_ERROR);
        }
        int forUse = user.setAge(age);
        switch (forUse){
            case(0):
                user.setAge(age);
                break;
            case(-1):
                System.out.println(CANNOT_BE_NEGATIVE);
                break;
            case(-2):
                System.out.println(CANNOT_BE_TOO_BIG);
                break;
            default:
                System.out.println(UNKNOWN_ERROR);
        }

        users.add(user);
    }

    static void findUserIndex(User user) {
        int tf = users.indexOf(user);
        if(tf == -1){
            System.out.printf(NOT_FOUND, user.getName());
        }else{
        System.out.printf(FOUND, user.getName(), users.indexOf(user));
        }
    }
}

package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return Factory.class;
    }

    public static void main(String[] args) {
        Factory exFab=new Factory();
        System.out.println(exFab.getException(ApplicationExceptionMessage.UNHANDLED_EXCEPTION));
        System.out.println(exFab.getException(ApplicationExceptionMessage.SOCKET_IS_CLOSED));
        System.out.println(exFab.getException(DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS));
        System.out.println(exFab.getException(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT));
        System.out.println(exFab.getException(UserExceptionMessage.USER_DOES_NOT_EXIST));
        System.out.println(exFab.getException(UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS));
        System.out.println(exFab.getException(null));
    }
}
package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = PropertyResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException{
        try {
            String res = bis.readLine();
            if(res.equalsIgnoreCase("EXIT"))
                throw new InterruptOperationException();
            return res;
        } catch (IOException e) {
            System.out.println("OPPS");
        }
        return null;
    }
    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
    public static String askCurrencyCode() throws InterruptOperationException {
        boolean tf = true;
        String res = "";
        while (tf){
            System.out.println("Enter code of money");
            String temp = readString();
            if(temp.length() == 3){
                res = temp.toUpperCase();
                tf = false;
            }
        }
        return res;
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage("Enter par and count: ");
        String par = readString();
        String[] array = par.split(" ");
        try{
            if(array.length == 2) {
                int parTemp = Integer.parseInt(array[0]);
                int countTemp = Integer.parseInt(array[1]);
                if (parTemp < 0 || countTemp < 0) {
                    System.out.println("Par and count must be more 0");
                    array = getValidTwoDigits(currencyCode);
                }
                System.out.println("Successful");
            }else{
                System.out.println("repeat");
                array = getValidTwoDigits(currencyCode);
            }
        }catch (NumberFormatException e){
            writeMessage("Please repeat");
            array = getValidTwoDigits(currencyCode);
        }
        return array;
    }
    public static Operation askOperation() throws InterruptOperationException {
        try{
            int integer = Integer.parseInt(readString());
            return Operation.getAllowableOperationByOrdinal(integer);
        }catch (IllegalArgumentException e){
            System.out.println("Choose: 1 or 2 or 3 or 4");
            return askOperation();
        }
    }
}

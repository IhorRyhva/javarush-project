package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        String[] firstMove = "+38(050)123-45-67".split("\\(");
        StringBuilder res = new StringBuilder();
        for(String forRes: firstMove){
            res.append(forRes);
        }
        firstMove = res.toString().split("\\)");
        res = new StringBuilder();
        for(String forRes: firstMove){
            res.append(forRes);
        }
        firstMove = res.toString().split("-");
        res = new StringBuilder();
        for(String forRes: firstMove){
            res.append(forRes);
        }
        System.out.println(res);
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String code = "";
            for(Map.Entry<String, String> map: countries.entrySet()){
                if(map.getValue().equals(customer.getCountryName())){
                    code = map.getKey();
                }
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String firstName = "";
            String[] result = contact.getName().split(", ");
            firstName = result[1];
            return firstName;
        }

        @Override
        public String getContactLastName() {
            String secondName = "";
            String[] result = contact.getName().split(", ");
            secondName = result[0];
            return secondName;
        }

        @Override
        public String getDialString() {
            String[] firstMove = contact.getPhoneNumber().split("\\(");
            StringBuilder res = new StringBuilder();
            for(String forRes: firstMove){
                res.append(forRes);
            }
            firstMove = res.toString().split("\\)");
            res = new StringBuilder();
            for(String forRes: firstMove){
                res.append(forRes);
            }
            firstMove = res.toString().split("-");
            res = new StringBuilder();
            for(String forRes: firstMove){
                res.append(forRes);
            }
            return "callto://" + res;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
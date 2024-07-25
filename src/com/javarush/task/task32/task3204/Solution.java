package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/*
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }

    }
//49
//57
//65
//90
//97
//122
    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(8);
        int count = 0;
        int randomChar = (int)(Math.random()*122);
        boolean tf = false;

        boolean A = false;
        boolean a = false;
        boolean one = false;

        while (count < 8){
            if(count == 6 || count == 7){
                if(!one){
                    while (randomChar <= 49 || randomChar >= 57){
                        randomChar = (int) (Math.random() * 58);
                    }
                    tf = true;
                    one = true;
                    outputStream.write(randomChar);
                }else if(!A){
                    A = true;
                    while (randomChar <= 65 || randomChar >= 90){
                        randomChar = (int) (Math.random() * 91);
                    }
                    tf = true;
                    outputStream.write(randomChar);
                }else if(!a){
                    a = true;
                    while (randomChar <= 97 || randomChar >= 122){
                        randomChar = (int) (Math.random() * 122);
                    }
                    tf = true;
                    outputStream.write(randomChar);
                }else{
                    randomChar = (int) (Math.random()*122);
                    if (randomChar >= 49 && randomChar <= 57) {
                        outputStream.write(randomChar);
                        //System.out.println("1");
                        tf = true;
                        one = true;
                    } else if (randomChar >= 65 && randomChar <= 90) {
                        tf = true;
                        outputStream.write(randomChar);
                        //System.out.println("A");
                        A = true;
                    } else if (randomChar >= 97 && randomChar <= 122) {
                        a = true;
                        tf = true;
                        outputStream.write(randomChar);
                        //System.out.println("a");
                    }
                }
            }else {
                if (randomChar >= 49 && randomChar <= 57) {
                    outputStream.write(randomChar);
                    //System.out.println("1");
                    tf = true;
                    one = true;
                } else if (randomChar >= 65 && randomChar <= 90) {
                    tf = true;
                    outputStream.write(randomChar);
                    //System.out.println("A");
                    A = true;
                } else if (randomChar >= 97 && randomChar <= 122) {
                    a = true;
                    tf = true;
                    outputStream.write(randomChar);
                    //System.out.println("a");
                }
            }

            if(tf) {
                count++;
            }
            tf = false;
            randomChar = (int)(Math.random()*122);
        }
        return outputStream;
    }
}

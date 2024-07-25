package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    public static String generateRandomString(){
//        int leftLimitNumber = 80;
//        int rightLimitNumber = 89;
//        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
//        int targetStringLength = (int) (Math.random()*100);
//        Random random = new Random();
//        StringBuilder buffer = new StringBuilder(targetStringLength);
//        for (int i = 0; i < targetStringLength; i++) {
//            if (i % 5 == 0){
//                int randomNumber = leftLimitNumber + (int) (random.nextFloat() * (rightLimitNumber - leftLimitNumber + 1));
//                buffer.append((char) randomNumber);
//            }else {
//                int randomLimitedInt = leftLimit + (int)
//                        (random.nextFloat() * (rightLimit - leftLimit + 1));
//                buffer.append((char) randomLimitedInt);
//            }
//        }
//        String generatedString = buffer.toString();
//        return generatedString;
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}

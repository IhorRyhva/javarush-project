package com.javarush.task.pro.task12.task1201;

/* 
Автоупаковка
*/

public class Solution {
    static byte byteValue;
    static short shortValue;
    static int intValue;
    static long longValue;

    static float floatValue;
    static double doubleValue;

    static char charValue;
    static boolean booleanValue;


    Byte byteValueBox = Byte.valueOf(byteValue);
    Short shortValueBox = Short.valueOf(shortValue);
    Integer integerValueBox = Integer.valueOf(intValue);
    Long longValueBox = Long.valueOf(longValue);
    Float floatValueBox = Float.valueOf(floatValue);
    Double doubleValueBox = Double.valueOf(doubleValue);
    Character characterValueBox = Character.valueOf(charValue);
    Boolean booleanValueBox = Boolean.valueOf(booleanValue);


}

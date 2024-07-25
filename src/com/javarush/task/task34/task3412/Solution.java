package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        logger.debug("DEBUG");
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(5, "7", new Date());
        solution.divide(5, 4);
    }

    public void calculateAndSetValue3(long value) {
        logger.trace("TRACE");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            logger.debug("DEBUG");
            value1 = (int) (value / Integer.MAX_VALUE);
        } else {
            logger.debug("DEBUG");
            value1 = (int) value;
        }
    }

    public void printString() {
        logger.trace("TRACE");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("TRACE");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("TRACE");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("ERROR " + e);
        }
    }

    public void setValue1(int value1) {
        logger.debug("DEBUG");
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("DEBUG");
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("DEBUG");
        this.value3 = value3;
    }
}

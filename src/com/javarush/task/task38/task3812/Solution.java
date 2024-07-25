package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Arrays;

import static java.util.Optional.ofNullable;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            Arrays.stream(ofNullable((PrepareMyTest) c.getAnnotation(PrepareMyTest.class))
                    .orElseThrow(RuntimeException::new)
                    .fullyQualifiedNames()).forEach(System.out::println);
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            Arrays.stream(ofNullable((PrepareMyTest) c.getAnnotation(PrepareMyTest.class))
                    .orElseThrow(RuntimeException::new)
                    .value()).forEach(System.out::println);
            return true;
        }
        return false;
    }
}

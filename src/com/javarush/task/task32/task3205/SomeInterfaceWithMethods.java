package com.javarush.task.task32.task3205;

import java.lang.reflect.Method;

public interface SomeInterfaceWithMethods {
    void voidMethodWithoutArgs();

    String stringMethodWithoutArgs();

    void voidMethodWithIntArg(int i);

    default void output(Method method){
        System.out.println(method.getName() + " out");
    }
}

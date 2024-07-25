package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class[] classes = Collections.class.getDeclaredClasses();
        Class result = null;
        for(Class clas: classes){
            if (Modifier.isStatic(clas.getModifiers()) && Modifier.isPrivate(clas.getModifiers())){
                try{
                    Constructor<?> constructor = clas.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    List<?> list = (List<?>) constructor.newInstance();
                    list.get(0);
                }catch (IndexOutOfBoundsException e) {
                    return clas;
                }catch (Exception e){
                }
            }
        }
        return result;
    }
}

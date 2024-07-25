package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> tClass;

    public Generator(Class<T> eventClass) {
        tClass = eventClass;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return tClass.newInstance();
    }
}

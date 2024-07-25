package com.javarush.task.task38.task3810;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(value = MyContainer.class)
public @interface Author {
    String value();
    Position position() default Position.OTHER;
}
@Retention(RetentionPolicy.RUNTIME)
@interface MyContainer {
    Author[] value();
}

package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту
*/

public class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2){
        int result = 0;
        if(student1.getAge() > student2.getAge()) {
            result = -1;
        }else if(student1.getAge() < student2.getAge()){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }
}

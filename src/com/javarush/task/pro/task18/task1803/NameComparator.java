package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor>{
    public int compare(JavaRushMentor firstSt, JavaRushMentor secondSt){
        int first = firstSt.getName().length();
        int second = secondSt.getName().length();
        if(first < second) {
            return -1;
        }else if(first > second){
            return 1;
        }else{
            return 0;
        }
    }
}

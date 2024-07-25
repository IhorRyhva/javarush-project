package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread specialThread1 = new SpecialThread();
        SpecialThread specialThread2 = new SpecialThread();
        SpecialThread specialThread3 = new SpecialThread();
        SpecialThread specialThread4 = new SpecialThread();
        SpecialThread specialThread5 = new SpecialThread();

        Thread Thread1 = new Thread(specialThread1);
        Thread Thread2 = new Thread(specialThread2);
        Thread Thread3 = new Thread(specialThread3);
        Thread Thread4 = new Thread(specialThread4);
        Thread Thread5 = new Thread(specialThread5);

        Collections.addAll(list, Thread1, Thread2, Thread3, Thread4, Thread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}

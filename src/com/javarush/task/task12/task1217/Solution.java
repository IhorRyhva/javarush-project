package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly{
        byte flyTime();
    }

    public interface CanRun{
        byte runTime();
    }

    public interface CanSwim{
        byte swimTime();
    }
}

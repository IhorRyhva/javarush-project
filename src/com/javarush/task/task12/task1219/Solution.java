package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public class Human implements CanRun, CanSwim{
        @Override
        public void run(){
            System.out.println("run");
        }
        @Override
        public void swim(){
            System.out.println("swim");
        }
    }

    public class Duck implements CanRun, CanSwim, CanFly{
        @Override
        public void run(){
            System.out.println("run");
        }
        @Override
        public void swim(){
            System.out.println("swim");
        }
        @Override
        public void fly(){
            System.out.println("Fly");
        }
    }

    public class Penguin implements CanSwim, CanRun{
        @Override
        public void run(){
            System.out.println("run");
        }
        @Override
        public void swim(){
            System.out.println("swim");
        }
    }

    public class Airplane implements CanFly{
        @Override
        public void fly(){
            System.out.println("Fly");
        }
    }
}
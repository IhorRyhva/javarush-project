package com.javarush.task.task12.task1227;

/* 
CanFly, CanRun, CanSwim для классов Duck, Penguin, Toad
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

    public class Duck implements CanSwim, CanRun, CanFly{

        @Override
        public void fly() {
            System.out.println("Fly");
        }

        @Override
        public void run() {
            System.out.println("Run");
        }

        @Override
        public void swim() {
            System.out.println("Swim");
        }
    }

    public class Penguin implements CanSwim, CanRun{
        @Override
        public void run() {
            System.out.println("Run");
        }

        @Override
        public void swim() {
            System.out.println("Swim");
        }
    }

    public class Toad implements CanSwim{
        @Override
        public void swim() {
            System.out.println("Swim");
        }
    }
}

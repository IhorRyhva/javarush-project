package com.javarush.task.task12.task1223;

/* 
И снова Пушистик…
*/

import java.util.SplittableRandom;

public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public final String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {
        public String nullString(String string){
            return "";
        }

        @Override
        public void setName(String string){
            String str = nullString(string);
            this.name = str;
        }
    }
}

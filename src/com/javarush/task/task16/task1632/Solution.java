package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }
    }

    static{
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static class Thread1 extends Thread{
        @Override
        public void run(){
            while(true){
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run(){
            while(!isInterrupted()){
            }
            System.out.println("InterruptedException");
        }
    }

    public static class Thread3 extends Thread{
        @Override
        public void run(){
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        @Override
        public void run(){
            while (isAlive()){
                System.out.println("Я жиииивиииййй");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    this.interrupt();
                    return;
                }
            }
        }

        @Override
        public void showWarning() {
            System.out.println("Stop");
            this.interrupt();
            return;
        }
    }

    public static class Thread5 extends Thread {

        @Override
        public void run(){
            String waitToN = new Scanner(System.in).nextLine();
            int nUseAlready = 0;

            while(!waitToN.equals("N")){
                nUseAlready += Integer.parseInt(waitToN);
                waitToN = new Scanner(System.in).nextLine();
            }

            System.out.println(nUseAlready);
        }
    }
}
package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            if(numSeconds >= 3.5){
                while(!this.isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        System.out.print(numSeconds + " ");
                        numSeconds--;
                    } catch (InterruptedException e) {
                        System.out.print(numSeconds + " ");
                        System.out.println("Прервано!");
                        this.interrupt();
                    }
                }
            }else{
                while (numSeconds >= 0){
                    try {
                        if(numSeconds == 0) {
                            System.out.print("Марш!");
                            break;
                        }
                        Thread.sleep(1000);
                        System.out.print(numSeconds + " ");
                        numSeconds--;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

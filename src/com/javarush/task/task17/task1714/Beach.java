package com.javarush.task.task17.task1714;

/* 
Comparable
*/

import java.util.Comparator;

public class Beach implements Comparable<Beach>{
    public static volatile int count = 50;
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality){
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void  setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Best best = new Best();
        new Thread(best).start();
        Best best1 = new Best();
        new Thread(best1).start();
        Best best2 = new Best();
        new Thread(best2).start();
        Best best3 = new Best();
        new Thread(best3).start();
        Best best4 = new Best();
        new Thread(best4).start();
        Best best5 = new Best();
        new Thread(best5).start();
        Best best6 = new Best();
        new Thread(best6).start();
    }

    @Override
    public synchronized int compareTo(Beach o) {
//        double d1 = o.getDistance() + o.getQuality();
//        double d2 = this.getDistance() + this.getQuality();
//        int compare = Double.compare(d1, d2);
        return Float.compare(o.getDistance(), this.getDistance()) + Integer.compare(this.getQuality(), o.getQuality());
    }

    public static class Best implements Runnable{
        @Override
        public void run() {
            int res = count + 1;
            Beach beach = new Beach("best", 54.0F, 2);
            Beach beach1 = new Beach("best", 55.0F, 3);
            System.out.println(beach.compareTo(beach1));
        }
    }
}

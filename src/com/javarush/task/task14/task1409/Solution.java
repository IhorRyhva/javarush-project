package com.javarush.task.task14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    public static void println(Bridge bridge){
        if(bridge instanceof  SuspensionBridge){
            SuspensionBridge bridge1 = (SuspensionBridge) bridge;
            System.out.println(bridge1.getCarsCount());
        }else if(bridge instanceof WaterBridge){
            WaterBridge bridge2 = (WaterBridge) bridge;
            System.out.println(bridge2.getCarsCount());
        }
    }
}
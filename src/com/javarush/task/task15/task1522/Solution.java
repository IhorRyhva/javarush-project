package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(thePlanet.getClass().getSimpleName());
    }

    public static Planet thePlanet;

    static{
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planet;
        try {
            planet = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(planet.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();
        }else if(planet.equals(Planet.MOON)){
            thePlanet = Moon.getInstance();
        }else if(planet.equals(Planet.SUN)){
            thePlanet = Sun.getInstance();
        }else{
            thePlanet = null;
        }
    }
}

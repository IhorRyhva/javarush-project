package com.javarush.task.pro.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Вилларибо и Виллабаджо.
*/

public class Solution {
    static List<MusicalInstrument> orchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playOrchestra();
    }

    public static void createKeyboardOrchestra() {
        MusicalInstrument oran = new Organ();
        MusicalInstrument piano1 = new Piano();
        MusicalInstrument piano2 = new Piano();
        MusicalInstrument piano3 = new Piano();
        orchestra.add(oran);
        orchestra.add(piano1);
        orchestra.add(piano2);
        orchestra.add(piano3);
    }

    public static void createStringedOrchestra() {
        MusicalInstrument violin1 = new Violin();
        MusicalInstrument violin2 = new Violin();
        MusicalInstrument guitar = new Guitar();
        orchestra.add(violin1);
        orchestra.add(violin2);
        orchestra.add(guitar);
    }

    public static void playOrchestra() {
        for(MusicalInstrument instrument: orchestra){
            if(instrument instanceof Organ){
                Organ organ = (Organ) instrument;
                organ.play();
            }else if(instrument instanceof Piano){
                Piano piano = (Piano) instrument;
                piano.play();
            }else if(instrument instanceof Guitar){
                Guitar guitar = (Guitar) instrument;
                guitar.play();
            }else if(instrument instanceof Violin){
                Violin violin = (Violin) instrument;
                violin.play();
            }
        }
    }
}

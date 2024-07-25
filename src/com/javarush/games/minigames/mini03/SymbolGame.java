package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Простая программа
*/

public class SymbolGame extends Game {
    public void initialize(){
        setScreenSize(8,3);
        String JavaRush = "JAVARUSH";
        String[] JavaRushChar = JavaRush.split("");
        for (int i = 0; i < JavaRushChar.length; i++) {
            setCellValueEx(i,1, Color.ORANGE, JavaRushChar[i]);
        }
    }
}

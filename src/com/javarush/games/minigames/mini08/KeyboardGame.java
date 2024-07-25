package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    @Override
    public void onKeyPress(Key key){
        if(key == Key.LEFT){
            for (int x = 0; x < 1; x++) {
                for (int y = 0; y < 3; y++) {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }else if(key == Key.RIGHT){
            for (int x = 2; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }else if(key == Key.UP){
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 1; y++) {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }else if(key == Key.DOWN){
            for (int x = 0; x < 3; x++) {
                for (int y = 2; y < 3; y++) {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }
    }

    @Override
    public void onKeyReleased(Key key){
        if(key == Key.LEFT || key == Key.RIGHT || key == Key.UP || key == Key.DOWN){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    setCellColor(i, j, Color.WHITE);
                }
            }
        }
    }
}

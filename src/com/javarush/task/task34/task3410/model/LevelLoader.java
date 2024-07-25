package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;
    public LevelLoader(Path levels) {
        this.levels = levels;
    }
    public GameObjects getLevel(int level){
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        if(level > 60){
            level = level % 60;
        }
        try (BufferedReader reader = Files.newBufferedReader(levels)){
            boolean levelMap = false;
            int levels = 0;
            int y = Model.FIELD_CELL_SIZE / 2;
            int x;
            while (reader.ready()){
                String string = reader.readLine();
                if(string == null){
                    break;
                }
                while (levels !=level) {
                    if (string.contains("Maze")) {
                        levels = Integer.parseInt(string.split(" ")[1]);
                    }
                    string = reader.readLine();
                }
                if(string.length() == 0){
                    levelMap = !levelMap;
                    if(!levelMap)
                        break;
                }

                if(levelMap){
                    x = Model.FIELD_CELL_SIZE / 2;
                    char[] array = string.toCharArray();
                    for (int i = 0; i < array.length; i++) {
                        switch (array[i]){
                            case ('X'):
                                walls.add(new Wall(x, y));
                                break;
                            case ('*'):
                                boxes.add(new Box(x, y));
                                break;
                            case ('.'):
                                homes.add(new Home(x, y));
                                break;
                            case ('&'):
                                boxes.add(new Box(x, y));
                                homes.add(new Home(x, y));
                                break;
                            case ('@'):
                                player = new Player(x, y);
                                break;
                        }
                        x += Model.FIELD_CELL_SIZE;
                    }
                    y += Model.FIELD_CELL_SIZE;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new GameObjects(walls, boxes, homes, player);
    }
}

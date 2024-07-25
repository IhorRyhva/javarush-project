package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {
    private EventListener eventListener;
    public static final int FIELD_CELL_SIZE = 20;
    private  int currentLevel = 4;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\Users\\Admin\\javarush\\3349704\\javarush-project\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));
    private GameObjects gameObjects = levelLoader.getLevel(1);
    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
    public GameObjects getGameObjects(){
        return gameObjects;
    }
    public void restart(){
        restartLevel(currentLevel);
    }
    public void startNextLevel(){
        currentLevel++;
        restart();
    }
    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
        currentLevel = level;
    }
    public void move(Direction direction) {
        if(checkWallCollision(gameObjects.getPlayer(), direction) || (checkBoxCollisionAndMoveIfAvailable(direction))){
            return;
        }
        int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
        int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
        gameObjects.getPlayer().move(dx, dy);

        checkCompletion();
    }
    public  boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        boolean tf = false;
        Set<Wall> walls = gameObjects.getWalls();
        for(Wall wall: walls){
            if(gameObject.isCollision(wall, direction))
                tf = true;
        }
        return tf;
    }
    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        for (Box box : gameObjects.getBoxes()) {
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                for (Box item : gameObjects.getBoxes()) {
                    if(!box.equals(item)) {
                        if(box.isCollision(item, direction)) {
                            return true;
                        }
                    }
                    if (checkWallCollision(box, direction)) {
                        return true;
                    }
                }
                int dx = direction == Direction.LEFT ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT ? FIELD_CELL_SIZE : 0);
                int dy = direction == Direction.UP ? -FIELD_CELL_SIZE : (direction == Direction.DOWN ? FIELD_CELL_SIZE : 0);
                box.move(dx, dy);
            }
        }
        return false;
    }
    public void checkCompletion(){
        int count = 0;
        int size = gameObjects.getHomes().size();
        for(Home home: gameObjects.getHomes()){
            for(Box box: gameObjects.getBoxes()){
                if(home.getX() == box.getX() && home.getY() == box.getY()){
                    count++;
                }
            }
        }
        if(count == size){
            eventListener.levelCompleted(currentLevel);
        }
    }

//    public boolean near(GameObject o1, GameObject o2){
//        int maxY = Math.max(o1.getY(), o2.getY());
//        int minY = Math.min(o1.getY(), o2.getY());
//
//        int maxX = Math.max(o1.getX(), o2.getX());
//        int minX = Math.min(o1.getX(), o2.getX());
//        return maxY - minY == 0 && maxX - minX == 0;
//    }
}

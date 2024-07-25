package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

public class Space{
    public static void main(String[] args) {
        Space space = new Space(5, 5);
    }
    public static Space game;
    private int width;
    private int height;
    private SpaceShip ship;
    private List<Ufo> ufos;
    private List<Rocket> rockets;
    private List<Bomb> bombs;

    public Space(int width, int height){
        this.width = width;
        this.height = height;
        ufos = new ArrayList<>();
        rockets = new ArrayList<>();
        bombs = new ArrayList<>();
    }

    public void createUfo(){
        if(ufos.size() == 0){
            ufos.add(new Ufo(2, 2));
        }
    }

    public void checkRockets(){
        for(Rocket rocket: rockets){
            for(Ufo ufo: ufos){
            if(ufo.isIntersect(rocket)){
                rocket.die();
                ufo.die();
            }

            if(rocket.y < 0){
                rocket.die();
            }
        }
        }
    }

    public void checkBombs(){
        for(Bomb bomb: bombs){
            if(ship.isIntersect(bomb)){
                ship.die();
                bomb.die();
            }

            if(bomb.y > height){
                bomb.die();
            }
        }
    }
    public void removeDead(){
        for (int i = 0; i < ufos.size(); i++) {
            if(!ufos.get(i).isAlive()){
                ufos.remove(i);
                i--;
            }
        }

        for (int i = 0; i < bombs.size(); i++) {
            if(!bombs.get(i).isAlive()){
                bombs.remove(i);
                i--;
            }
        }

        for (int i = 0; i < rockets.size(); i++) {
            if(!rockets.get(i).isAlive()){
                rockets.remove(i);
                i--;
            }
        }
    }
    public void moveAllItems(){
        for(BaseObject baseObject: game.getAllItems()){
            baseObject.move();
        }
    }

    public List<BaseObject> getAllItems() {
        ArrayList<BaseObject> list = new ArrayList<>(ufos);
        list.add(ship);
        list.addAll(bombs);
        list.addAll(rockets);
        return list;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public void run(){

    }
    public void draw(){

    }

    public void sleep(int ms){

    }
}

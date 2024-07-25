package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.Controller;
import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.GameObjects;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field = new Field(this);
    public View(Controller controller) {
        this.controller = controller;
        field.setEventListener(controller);
    }
    public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }
    public void update(){
        field.repaint();
    }
    public GameObjects getGameObjects() {
        return controller.getGameObjects();
    }
    public void completed(int level){
        update();
        JOptionPane.showMessageDialog(this, "Рівень " + level + "пройдено", "ви перемогли!",JOptionPane.INFORMATION_MESSAGE);
        controller.startNextLevel();
    }
}

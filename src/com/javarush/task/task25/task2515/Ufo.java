package com.javarush.task.task25.task2515;

public class Ufo extends BaseObject{
    public Ufo(double x, double y) {
        super(x, y, 3);
    }
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };
    public void draw(Canvas canvas){
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }
    double dx;
    double dy;
    public void move(){
        dx = Math.random() * 2 - 1;
        dy = Math.random() * 2 - 1;
        y += dy;
        x += dx;
        checkBorders(0, y, 0, x);

        int random = (int) (Math.random() * 10);
        if(random == 5){
            fire();
        }
    }
    public void fire(){
        Space.game.getBombs().add(new Bomb(x, y + 3));
    }
}

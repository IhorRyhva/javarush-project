package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{
    private int x;
    private int y;
    public CollisionObject(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }
    public boolean isCollision(GameObject gameObject, Direction direction){;
        switch (direction){
            case LEFT:
                return (x - Model.FIELD_CELL_SIZE) == gameObject.getX() && y == gameObject.getY();
            case RIGHT:
                return (x + Model.FIELD_CELL_SIZE) == gameObject.getX() && y == gameObject.getY();
            case UP :
                return (y - Model.FIELD_CELL_SIZE) == gameObject.getY() && x == gameObject.getX();
            case DOWN:
                return (y + Model.FIELD_CELL_SIZE) == gameObject.getY() && x == gameObject.getX();
        }
        return false;
    }
}

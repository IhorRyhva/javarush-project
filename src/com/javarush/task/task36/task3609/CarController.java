package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;
    private int speed;
    private int maxSpeed;
    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
        speed = model.getSpeed();
        maxSpeed = model.getMaxSpeed();
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return speed;
    }

    public int getCarMaxSpeed() {
        return maxSpeed;
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

    public void increaseSpeed(int seconds) {
        if (speed < maxSpeed) {
            speed += (3.5 * seconds);
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
    }

    public void decreaseSpeed(int seconds) {
        if (speed > 0) {
            speed -= (12 * seconds);
        }
        if (speed < 0) {
            speed = 0;
        }
    }
}
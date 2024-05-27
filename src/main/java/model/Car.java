package model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String nameModel;
    private String color;
    private int speed;

    public Car(String nameModel, String color, int speed) {
        this.nameModel = nameModel;
        this.color = color;
        this.speed = speed;
    }


    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameModel='" + nameModel + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }
}

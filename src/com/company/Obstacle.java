package com.company;

import java.awt.*;

public class Obstacle {
    //Attributes of an obstacle
    String sign;
    Point position = new Point();

    //Creation of an obstacle
    public Obstacle(){
        this.sign = "#";
    }

    //To get the obstacle's information
    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    //To set the obstacle's position
    void setPosition(Point a){
        this.position.setLocation(a);
    }
}

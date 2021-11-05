package com.company;

import java.awt.*;

public class Obstacle {
    String sign;
    Point position = new Point();

    public Obstacle(){
        this.sign = "#";
    }

    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }
}

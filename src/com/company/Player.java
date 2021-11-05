package com.company;

import java.awt.*;

public class Player {
    String sign;
    Point position = new Point();

    public Player(){
        this.sign = "@";
    }

    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }

    String isDead(){
        this.sign = "_";
        return this.sign;
    }

    void movePlayer(){ //move the player according to the key the player clicked on on the keyboard

    }
}

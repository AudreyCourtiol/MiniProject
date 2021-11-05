package com.company;

import java.awt.*;

public class Enemy {
    String sign;
    Point position = new Point();
    Player player = new Player(); //so the enemies have their position

    public Enemy(){
        this.sign = "*";
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

    //To be called in a loop
    void moveEnemy(){ //move the enemies in the direction of the player
        Point playerPos = this.player.getPosition();

    }
}

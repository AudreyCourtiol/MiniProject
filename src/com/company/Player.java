package com.company;

import java.awt.*;
import java.util.Random;

public class Player {
    String sign;
    Point position = new Point();

    public Player(){
        this.sign = "A";
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

    void movePlayer()throws java.io.IOException{
        //move the player according to the key the player clicked on the keyboard

        System.out.println("Where do you want to go? ");
        //char input;
        //input= (char) System.in.read();

        int ascii;
        ascii= System.in.read();
        switch (ascii){
            case 24:    //up
                this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY()+1));
                break;
            case 25:    //down
                this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY()-1));
                break;
            case 26:    //right
                this.setPosition(new Point((int) this.getPosition().getX()+1, (int) this.getPosition().getY()));
                break;
            case 27:    //left
                this.setPosition(new Point((int) this.getPosition().getX()-1, (int) this.getPosition().getY()));
                break;

        }

    }
}

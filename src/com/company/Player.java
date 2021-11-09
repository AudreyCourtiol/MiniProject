package com.company;
import java.util.Scanner;

import java.awt.*;

public class Player {
    Scanner in = new Scanner(System.in);
    String sign;
    Point position = new Point();
    boolean win=true;
    boolean isJumping = false;

    public Player(){
        this.sign = "A";
    }

    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }
    Boolean getIsJumping(){return this.isJumping; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }

    String isDead(){
        this.sign = "_";
        return this.sign;
    }

    void movePlayer()throws java.io.IOException{
        //move the player according to the key the player clicked on the keyboard

        this.isJumping = false; //we put the player back on the board
        System.out.println("Where do you want to go? ");
        String input;
        input= in.nextLine();

        switch (input){
            case "d":    //right
                this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY()+1));
                break;
            case "a":    //left
                this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY()-1));
                break;
            case "s":    //down
                this.setPosition(new Point((int) this.getPosition().getX()+1, (int) this.getPosition().getY()));
                break;
            case "w":    //up
                this.setPosition(new Point((int) this.getPosition().getX()-1, (int) this.getPosition().getY()));
                break;
            case "j": //jump
                this.isJumping = true;
                break;
        }

    }
}

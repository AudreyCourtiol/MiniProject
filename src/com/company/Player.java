package com.company;
import java.util.Scanner;

import java.awt.*;

public class Player {
    Scanner in = new Scanner(System.in);
    String sign;
    Point position = new Point();
    boolean win=true;
    boolean isJumping = false;
    int numberJumps;

    public Player(){

        this.sign = "A";
        this.numberJumps = 0;
    }

    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }

    void movePlayer()throws java.io.IOException{
        //move the player according to the key the player clicked on the keyboard

        this.isJumping = false; //we put the player back on the board
        System.out.println("Where do you want to go? ");
        String input;
        input= in.nextLine();
        boolean menu=true;
        while (menu) {
            switch (input) {
                case "d" -> {    //right
                    this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY() + 1));
                    menu = false;
                }
                case "a" -> {    //left
                    this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY() - 1));
                    menu = false;
                }
                case "s" -> {    //down
                    this.setPosition(new Point((int) this.getPosition().getX() + 1, (int) this.getPosition().getY()));
                    menu = false;
                }
                case "w" -> {    //up
                    this.setPosition(new Point((int) this.getPosition().getX() - 1, (int) this.getPosition().getY()));
                    menu = false;
                }
                case "j" -> {    //jump
                    this.isJumping = true;
                    this.numberJumps++;
                    if (this.numberJumps >= 5) {
                        System.out.println("You can't jump anymore. You have used your 5 jumps");
                        this.isJumping = false;
                    }
                    menu = false;
                }
                default -> System.out.println("You didn't click the correct letter, try again");
            }
        }

    }
}

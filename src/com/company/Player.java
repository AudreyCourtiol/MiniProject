package com.company;
import java.util.Scanner;

import java.awt.*;

public class Player {
    //Attributes of the player
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

    //To get the player's information
    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }

    //This method moves the player according to the key the user clicked on the keyboard
    //We use an exception so that we can call this method in a try/catch in case of an error
    void movePlayer()throws java.io.IOException{

        this.isJumping = false; //the player is not jumping

        //We ask the user which way they want to go
        System.out.println("Where do you want to go? ");
        String input;
        input= in.nextLine(); //we take in their input
        boolean menu=true;

        //While an action hasn't been chosen by the user
        while (menu) {
            switch (input) { //depending on the input
                case "d" -> {    //the player moves to the right
                    this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY() + 1));
                    menu = false; //To get out of the while loop
                }
                case "a" -> {    //the player moves to the left
                    this.setPosition(new Point((int) this.getPosition().getX(), (int) this.getPosition().getY() - 1));
                    menu = false; //To get out of the while loop
                }
                case "s" -> {    //the player moves to the down
                    this.setPosition(new Point((int) this.getPosition().getX() + 1, (int) this.getPosition().getY()));
                    menu = false; //To get out of the while loop
                }
                case "w" -> {    //the player moves to the up
                    this.setPosition(new Point((int) this.getPosition().getX() - 1, (int) this.getPosition().getY()));
                    menu = false; //To get out of the while loop
                }
                case "j" -> {    //the player jumps
                    this.isJumping = true; //the player is jumping
                    this.numberJumps++; //We increase the number of jumps made during the game

                    //The player can jump maximum 5 times per game
                    //If the player can't jump anymore, we tell the user so and they can choose another action
                    if (this.numberJumps >= 5) {
                        System.out.println("You can't jump anymore. You have used your 5 jumps");
                        this.isJumping = false;
                    }
                    //We get out of the while loop only if the player jumped
                    menu = false;
                }
                //In the case where no key presented above has been used, an error of input is recognized
                //We ask the user to select another action
                default -> System.out.println("The key entered is not valid, please try again");
            }
        }
    }
}

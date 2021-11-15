package com.company;

import java.awt.*;

public class Enemy {
    String sign;
    Point position = new Point();
    Player player; //so the enemies have their position

    public Enemy(){
        this.sign = "X";
    }

    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }

    //To be called in a loop
    Point moveEnemy(){ //move the enemies in the direction of the player

        //We select the position the enemy needs to move to

        if((this.player.position.x < this.position.x) && (this.player.position.y == this.position.y)){ //if the player is to the strict left of the enemy moves one field to the left
            System.out.println("1");
            return new Point((int) this.position.getX() -1, (int) this.position.getY());
        }
        else if((this.player.position.x > this.position.x) && (this.player.position.y == this.position.y)){ //if the player is to the strict right of the enemy moves one field to the right
            System.out.println("2");
            return new Point((int) this.position.getX() +1, (int) this.position.getY());
        }
        else if((this.player.position.y> this.position.y) && (this.player.position.x == this.position.x)){ //if the player is to the strict upway of the enemy moves one field up
            System.out.println("3");
            return new Point((int) this.position.getX(), (int) this.position.getY() + 1);
        }
        else if(this.player.position.y < this.position.y && (this.player.position.x== this.position.x)) { //if the player is to the strict downway of the enemy moves one field down
            System.out.println("4");
            return new Point((int) this.position.getX(), (int) this.position.getY() - 1);
        }
        else if((this.player.position.y > this.position.y) && (this.player.position.x > this.position.x)) { //if the player is to the up right of the enemy moves one field up right
            System.out.println("5");
            return new Point((int) this.position.getX() +1, (int) this.position.getY() + 1);
        }
        else if((this.player.position.y> this.position.y) && (this.player.position.x < this.position.x)) { //if the player is to the up left of the enemy moves one field up left
            System.out.println("6");
            return new Point((int) this.position.getX() -1, (int) this.position.getY() + 1);
        }
        else if((this.player.position.y< this.position.y) && (this.player.position.x< this.position.x)) { //if the player is to the down left of the enemy moves one field down left
            System.out.println("7");
            return new Point((int) this.position.getX() -1, (int) this.position.getY() - 1);
        }
        else if((this.player.position.y < this.position.y) && (this.player.position.x > this.position.x)) { //if the player is to the down right of the enemy moves one field down right
            System.out.println("8");
            return new Point((int) this.position.getX() +1, (int) this.position.getY() - 1);
        }
        return this.position;
    }
}

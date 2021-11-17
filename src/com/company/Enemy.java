package com.company;

import java.awt.*;

public class Enemy {
    //Attributes of an enemy
    String sign;
    Point position = new Point();
    Player player; //We give access to the player's position to the enemy

    public Enemy(){
        this.sign = "X";
    }

    //To get an enemy's information
    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }

    //This method returns the best position an enemy could take to go in the player's direction
    Point moveEnemy(){

        //if the player is to the strict left of the enemy, it moves one field to the left
        if((this.player.getPosition().x < this.getPosition().x) && (this.player.getPosition().y == this.getPosition().y)){
            return new Point((int) this.position.getX() -1, (int) this.position.getY());
        }
        //if the player is to the strict right of the enemy, it moves one field to the right
        else if((this.player.getPosition().x > this.getPosition().x) && (this.player.getPosition().y == this.getPosition().y)){
            return new Point((int) this.position.getX() +1, (int) this.position.getY());
        }
        //if the player is to the strict up way of the enemy, it moves one field up
        else if((this.player.getPosition().y> this.getPosition().y) && (this.player.getPosition().x == this.getPosition().x)){
            return new Point((int) this.position.getX(), (int) this.position.getY() + 1);
        }
        //if the player is to the strict down way of the enemy, it moves one field down
        else if(this.player.getPosition().y < this.getPosition().y && (this.player.getPosition().x== this.getPosition().x)) {
            return new Point((int) this.position.getX(), (int) this.position.getY() - 1);
        }
        //if the player is to the up right of the enemy, it moves one field up right
        else if((this.player.getPosition().y > this.getPosition().y) && (this.player.getPosition().x > this.getPosition().x)) {
            return new Point((int) this.position.getX() +1, (int) this.position.getY() + 1);
        }
        //if the player is to the up left of the enemy, it moves one field up left
        else if((this.player.getPosition().y> this.getPosition().y) && (this.player.getPosition().x < this.getPosition().x)) {
            return new Point((int) this.position.getX() -1, (int) this.position.getY() + 1);
        }
        //if the player is to the down left of the enemy, it moves one field down left
        else if((this.player.getPosition().y< this.getPosition().y) && (this.player.getPosition().x< this.getPosition().x)) {
            return new Point((int) this.position.getX() -1, (int) this.position.getY() - 1);
        }
        //if the player is to the down right of the enemy, it moves one field down right
        else if((this.player.getPosition().y < this.getPosition().y) && (this.player.getPosition().x > this.getPosition().x)) {
            return new Point((int) this.position.getX() +1, (int) this.position.getY() - 1);
        }

        //In case of an error, the enemy isn't moved
        return this.position;
    }
}

package com.company;

import java.awt.*;

public class Enemy {
    String sign;
    Point position = new Point();
    Player player = new Player(); //so the enemies have their position

    public Enemy(){
        this.sign = "X";
    }

    String getSign(){return this.sign; }
    Point getPosition(){return this.position; }

    void setPosition(Point a){
        this.position.setLocation(a);
    }

    String isDead(){
        this.sign = " ";
        return this.sign;
    }

    //To be called in a loop
    Point moveEnemy(){ //move the enemies in the direction of the player
        Point playerPos = this.player.getPosition();

        //We select the position the enemy needs to move to

        if(playerPos.getX() < this.position.getX() && playerPos.getY() == this.position.getY()){ //if the player is to the strict left of the enemy
            //the enemy moves one field to the left
            return new Point((int) this.position.getX() -1, (int) this.position.getY());

        } else if(playerPos.getX() > this.position.getX() && playerPos.getY() == this.position.getY()){ //if the player is to the strict right of the enemy
            //the enemy moves one field to the right
            return new Point((int) this.position.getX() +1, (int) this.position.getY());

        } else if(playerPos.getY() > this.position.getY() && playerPos.getX() == this.position.getX()) { //if the player is to the strict upway of the enemy
            //the enemy moves one field up
            return new Point((int) this.position.getX(), (int) this.position.getY() + 1);

        } else if(playerPos.getY() < this.position.getY() && playerPos.getX() == this.position.getX()) { //if the player is to the strict downway of the enemy
            //the enemy moves one field down
            return new Point((int) this.position.getX(), (int) this.position.getY() - 1);

        } else if(playerPos.getY() > this.position.getY() && playerPos.getX() > this.position.getX()) { //if the player is to the up right of the enemy
            //the enemy moves one field up right
            return new Point((int) this.position.getX() +1, (int) this.position.getY() + 1);

        }else if(playerPos.getY() > this.position.getY() && playerPos.getX() < this.position.getX()) { //if the player is to the up left of the enemy
            //the enemy moves one field up left
            return new Point((int) this.position.getX() -1, (int) this.position.getY() + 1);

        }else if(playerPos.getY() < this.position.getY() && playerPos.getX() < this.position.getX()) { //if the player is to the down left of the enemy
            //the enemy moves one field down left
            return new Point((int) this.position.getX() -1, (int) this.position.getY() - 1);

        } else if(playerPos.getY() < this.position.getY() && playerPos.getX() > this.position.getX()) { //if the player is to the down right of the enemy
            //the enemy moves one field down right
            return new Point((int) this.position.getX() +1, (int) this.position.getY() - 1);
        }

        return this.position;
    }
}

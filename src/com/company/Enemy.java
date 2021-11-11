package com.company;

import java.awt.*;

public class Enemy {
    String sign;
    Point position = new Point();
    Player player = new Player(); //so the enemies have their position
    double distanceToPlayer;

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
        Point playerPos = this.player.getPosition();

        //we calculate the distance to the player
        this.distanceToPlayer = Math.sqrt((this.player.getPosition().getX() - this.position.getX()) * (this.player.getPosition().getX() - this.position.getX()) + ((this.player.getPosition().getY() - this.position.getY()) * (this.player.getPosition().getY() - this.position.getY())));

        double newDistanceToPlayer = 0;

        //We select the position the enemy needs to move to

        if(playerPos.getX() < this.position.getX() && playerPos.getY() == this.position.getY()){ //if the player is to the strict left of the enemy moves one field to the left
            Point potPos = new Point((int) this.position.getX() -1, (int) this.position.getY());

            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }

        } else if(playerPos.getX() > this.position.getX() && playerPos.getY() == this.position.getY()){ //if the player is to the strict right of the enemy moves one field to the right
            Point potPos = new Point((int) this.position.getX() +1, (int) this.position.getY());
            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }

        } else if(playerPos.getY() > this.position.getY() && playerPos.getX() == this.position.getX()) { //if the player is to the strict upway of the enemy moves one field up
           Point potPos = new Point((int) this.position.getX(), (int) this.position.getY() + 1);

            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }

        } else if(playerPos.getY() < this.position.getY() && playerPos.getX() == this.position.getX()) { //if the player is to the strict downway of the enemy moves one field down
            Point potPos = new Point((int) this.position.getX(), (int) this.position.getY() - 1);

            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }


        } else if(playerPos.getY() > this.position.getY() && playerPos.getX() > this.position.getX()) { //if the player is to the up right of the enemy moves one field up right
            Point potPos = new Point((int) this.position.getX() +1, (int) this.position.getY() + 1);

            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }


        }else if(playerPos.getY() > this.position.getY() && playerPos.getX() < this.position.getX()) { //if the player is to the up left of the enemy moves one field up left
            Point potPos = new Point((int) this.position.getX() -1, (int) this.position.getY() + 1);

            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }


        }else if(playerPos.getY() < this.position.getY() && playerPos.getX() < this.position.getX()) { //if the player is to the down left of the enemy moves one field down left
            Point potPos = new Point((int) this.position.getX() -1, (int) this.position.getY() - 1);

            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }


        } else if(playerPos.getY() < this.position.getY() && playerPos.getX() > this.position.getX()) { //if the player is to the down right of the enemy moves one field down right
            Point potPos = new Point((int) this.position.getX() +1, (int) this.position.getY() - 1);

            //we calculate the new distance
            newDistanceToPlayer = Math.sqrt((this.player.getPosition().getX() - potPos.getX()) * (this.player.getPosition().getX() - potPos.getX()) + ((this.player.getPosition().getY() - potPos.getY()) * (this.player.getPosition().getY() - potPos.getY())));

            //If this move gets the enemy closer to the player, we do it
            if(newDistanceToPlayer <= this.distanceToPlayer){
                return potPos;
            }

        }

        //If none of these are fulfilled, there is an error so we just don't move the enemy
        return this.position;
    }
}

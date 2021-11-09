package com.company;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Board {
    Player player= new Player();
    final int SIZE = 12;
    String[][] m_2DBoard = new String[SIZE][SIZE];
    Boolean[][] isFieldEmpty = new Boolean[SIZE][SIZE];

    //We randomize the number of initial objects
    Random R_nbOfEnemies = new Random();
    Random R_nbOfObstacles = new Random();
    int nbOfEnemies = R_nbOfEnemies.nextInt((SIZE - 2) + 1) + 2; // we get maximum half of the board filled with animals and min. 2
    int nbOfObstacles = R_nbOfObstacles.nextInt(SIZE); //we get maximum half of the board filled with obstacles

    ArrayList<Enemy> m_enemies = new ArrayList<>(nbOfEnemies); //we keep track of all our animals
    ArrayList<Obstacle> m_obstacles = new ArrayList<>(nbOfObstacles);


    public Board(){
        //We create a board with 10x10 fields
        for (int i = 0; i < this.SIZE; i++){
            for(int j = 0; j < this.SIZE; j++){
                //If it's a border, we put a star
                if(j == 0 || i == 0 || j == this.SIZE -1 || i == this.SIZE -1){
                    m_2DBoard[i][j] = "*";
                } else { //else we just put a space
                    m_2DBoard[i][j] = " ";
                }
            }
        }
        //We set every field as empty at the creation of the board
        for(int j = 0; j < this.SIZE-1; j++){
            for(int k = 0; k < this.SIZE-1; k++){
                this.isFieldEmpty[j][k] = false;
            }
        }
    }

    void displayBoard(){
        //We display the board line by line
        for (int i = 0; i < this.SIZE; i++){
            for(int j = 0; j < m_2DBoard[i].length; j++){
                System.out.print(m_2DBoard[i][j]);
            }
            System.out.println();
        }
    }

    //We put randoms numbers of obstacles and enemies on the board
    void fillBoardAtTheStart(){
        Random R_start_x = new Random();
        Random R_start_y = new Random();
        //we put the enemy on the board
        int x1 = R_start_x.nextInt(SIZE - 2) + 1;
        int y1 = R_start_y.nextInt(SIZE - 2) + 1;
        this.m_2DBoard[x1][y1] = this.player.getSign();
        this.player.setPosition(new Point(x1,y1));

        for(int i = 0; i < this.nbOfEnemies; i++){
            Enemy a = new Enemy();

            //we randomize the position of our enemy
            Random R_line = new Random();
            Random R_column = new Random();

            //we put the enemy on the board
            int x = R_line.nextInt(SIZE - 2) + 1;
            int y = R_column.nextInt(SIZE - 2) + 1;

            this.m_2DBoard[x][y] = a.getSign();

            //we keep track of this enemy's position
            a.setPosition(new Point(x,y));

            this.m_enemies.add(a);
        }

        for(int i = 0; i < this.nbOfObstacles; i++){
            Obstacle o = new Obstacle();

            //we randomize the position of our obstacle
            Random R_line2 = new Random();
            Random R_column2 = new Random();

            //we put the obstacle on the board
            //if this position is taken by an enemy, the enemy dies and the obstacle takes its place
            int x = R_line2.nextInt(SIZE - 2) + 1;
            int y = R_column2.nextInt(SIZE - 2) + 1;
            this.m_2DBoard[x][y] = o.getSign();

            o.setPosition(new Point(x,y));
            this.m_obstacles.add(o);
        }
    }

    void moveEnemies(){
        //we go through the board
        for(int i = 0; i < this.SIZE; i++){
            for(int j = 0; j < this.SIZE; j++){
                if(Objects.equals(this.m_2DBoard[i][j], "X")){ //if there is an enemy printed
                    this.m_2DBoard[i][j] = " "; //we take it off the board
                }
            }
        }

        ArrayList<Enemy> toDelete = new ArrayList<>();

        //We make all enemies move in the player's direction
        for(Enemy e : this.m_enemies){
            Point oldPos = e.getPosition(); //we keep the current position
            Point potentialNewPos = e.moveEnemy(); //we get the next position the enemy could go to

            //If the position is NOT on a border, we show the enemy on the board at its new position
            if (((potentialNewPos.x >0) && (potentialNewPos.x <11)) && ((potentialNewPos.y>0) && (potentialNewPos.y<11)))
            {
                if(Objects.equals(this.m_2DBoard[potentialNewPos.x][potentialNewPos.y], "#")){ //if there is an obstacle the enemy dies
                    toDelete.add(e); //we plan to delete the enemy
                }
                else{
                    e.setPosition(potentialNewPos); //the enemy is officially there
                    this.m_2DBoard[e.getPosition().x][e.getPosition().y]= e.getSign(); //we draw it on the board
                }
            }
            else //if new pos is a border
            {
                this.m_2DBoard[oldPos.x][oldPos.y]= e.getSign(); //we redraw the enemy where it was before, and it doesn't move
            }
        }

        //If an enemy has been added to toDelete, we remove it from the list of enemies using an iterator
        this.m_enemies.removeIf(toDelete::contains);
    }

    Integer checkNumberOfEnemies(){ //The game ends if there are no more enemies
        int EnemiesLeft = 0;
        //we go through our board
        for (String[] strings : m_2DBoard) {
            for (int j = 0; j < m_2DBoard.length; j++) {
                if (Objects.equals(strings[j], "X")) { //if there is an enemy
                    EnemiesLeft++; //we increase our number of animals left
                }
            }
        }
        return EnemiesLeft;
    }

    void MovesP(){ //to move the player on the board
        Point oldPlayer=new Point(this.player.getPosition().x,this.player.getPosition().y); //we store the current position of the player
        this.m_2DBoard[this.player.getPosition().x][this.player.getPosition().y]= " "; //we set that position as empty on the board
        int test=1;

        try {
            while (test!=0)
            {
                this.player.movePlayer(); //move the player

                //if the player is jumping, we just jump for turn this
                if(this.player.getIsJumping()){
                    this.m_2DBoard[this.player.getPosition().x][this.player.getPosition().y]= " ";

                }
                else if (((this.player.getPosition().x >0) && (this.player.getPosition().x <11)) && ((this.player.getPosition().y>0) && (this.player.getPosition().y<11)))
                { //If the position is NOT on a border, we show the player on the board at its new position
                    this.m_2DBoard[this.player.getPosition().x][this.player.getPosition().y]= this.player.sign;
                    test=0;
                }
                else //if new pos is a border
                {
                    System.out.println("Out of game board try again");
                    this.m_2DBoard[this.player.getPosition().x][this.player.getPosition().y]= "*";
                    this.m_2DBoard[oldPlayer.x][oldPlayer.y]= this.player.sign;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void playGame() throws IOException {
        int EnemiesLeft;
        boolean play=true;
        while (play){
            this.MovesP();
            this.moveEnemies();
            this.displayBoard();

            for(Enemy e : this.m_enemies){

                if(this.player.position.equals(e.getPosition())) { //if the player and an enemy are on the same position
                    //the player dies, game is over
                    System.out.println("Game over! An enemy killed you.");
                    this.player.win = false;
                    play=false;
                }
            }


            for(Obstacle o : m_obstacles){
                if(this.player.position.equals(o.getPosition())){ //if the player and an obstacle are on the same position
                    //the player dies, game is over
                    System.out.println("Game over! You walked into an obstacle and died.");
                    this.player.win = false;
                    play=false;
                }
            }


            EnemiesLeft= this.checkNumberOfEnemies();
            if(EnemiesLeft == 0){
                System.out.println("The game is over, you killed all the enemies. Congratulations!");
                this.player.win=true;
                play=false;
            }
        }
        if(this.player.win)
            System.out.println("You won congratulations!");
        else
            System.out.println("LOSER!!");
    }
}


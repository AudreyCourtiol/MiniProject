package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;


public class Board {
    final int SIZE = 8;
    String[][] m_2DBoard = new String[SIZE][SIZE];
    Boolean[][] isFieldEmpty = new Boolean[SIZE][SIZE];

    //We randomize the number of initial objects
    Random R_nbOfObstacles = new Random();

    int nbOfObstacles = R_nbOfObstacles.nextInt(SIZE); //we get maximum half of the board filled with obstacles


    ArrayList<Obstacle> m_obstacles = new ArrayList<>(nbOfObstacles);


    public Board(){
        //We create a board with 8x8 fields
        for (int i = 0; i < this.SIZE; i++){
            for(int j = 0; j < this.SIZE; j++){
                m_2DBoard[i][j] = "_";
            }
        }
        //We set every field as empty at the creation of the board
        for(int j = 0; j < this.SIZE; j++){
            for(int k = 0; k < this.SIZE; k++){
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

    //We put randoms numbers of obstacles and animals on the board
    void fillBoardAtTheStart(){

       //add player

        for(int i = 0; i < this.nbOfObstacles; i++){
            Obstacle o = new Obstacle();

            //we randomize the position of our obstacle
            Random R_line = new Random();
            Random R_column = new Random();

            //we put the obstacle on the board
            //if this position is taken by an animal, the animal dies and the obstacle takes its place
            int x = R_line.nextInt(SIZE);
            int y = R_column.nextInt(SIZE);
            this.m_2DBoard[x][y] = o.getSign();

            o.setPosition(new Point(x,y));
            this.m_obstacles.add(o);
        }
    }

    Integer isPositionOccupied(Point pos){
        if(!Objects.equals(this.m_2DBoard[pos.x][pos.y], "_")){ //if the position is occupied
            if(Objects.equals(this.m_2DBoard[pos.x][pos.y], "X")){ //if it's an obstacle
                return 2;
            } else if(Objects.equals(this.m_2DBoard[pos.x][pos.y], "*")){ //if it's an animal
                return 3;
            }
        }else{
            return 1;
        }
        return 0;
    }

}


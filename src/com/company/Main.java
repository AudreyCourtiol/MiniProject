package com.company;

//To allow us to easily catch errors
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        //Initialization
        board.fillBoardAtTheStart();
        board.displayBoard();

        //Running the game
        try {
            board.playGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("The game has been initialized.");
        board.fillBoardAtTheStart();
        board.displayBoard();
        
    }
}

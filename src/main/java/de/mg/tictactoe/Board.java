package de.mg.tictactoe;

/**
 * Board.java
 *
 * Description: Interface for various types of game boards
 *  to be created. Designed for game boards that are playable
 *  in the command line.
 */
public interface Board {
    public void move(int index, char symbol);
    public String displayCurrentBoard();
    public String displayPreviousBoard();
}
package de.mg.tictactoe;

import java.io.IOException;

public class TicTacToeApplication {
    /**
     * The entry main method (the program starts here)
     * - Initialize the game-TicTacToeBoard and start the game.
     */
    public static void main(String[] args) throws IOException {

        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.launchGame();
    }
}

package de.mg.tictactoe;

import static de.mg.tictactoe.constants.BoardGameConstants.*;

public class BoardGameDisplayer {

    public void printTicTacToeBoard(char[] placeholderBoard, TicTacToeBoard ticTacToeBoard) {
        String output = "";
        output += GAME_BOARD_TITLE_MESSAGE;
        output += PLEASE_ENTER_YOUR_POSITION_MESSAGE;
        output += TicTacToeBoard.displayBoard(placeholderBoard);
        output += PREVIOUS_GAME_BOARD + ticTacToeBoard.displayPreviousBoard();
        output += CURRENT_GAME_BOARD + ticTacToeBoard.displayCurrentBoard();
        output += "*---------------Tic-Tac-Toe---------------*\n";
        System.out.println(output);
    }
}

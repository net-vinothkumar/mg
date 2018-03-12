package de.mg.tictactoe;

public class GameDecisionMaker {
    /**
     * Return true if the game was just won
     */
    public boolean isGameOver(TicTacToeBoard ticTacToeBoard) {
        return ticTacToeBoard.currBoard[0] == ticTacToeBoard.currBoard[1] && ticTacToeBoard.currBoard[1] == ticTacToeBoard.currBoard[2] ||
                ticTacToeBoard.currBoard[3] == ticTacToeBoard.currBoard[4] && ticTacToeBoard.currBoard[4] == ticTacToeBoard.currBoard[5] ||
                ticTacToeBoard.currBoard[6] == ticTacToeBoard.currBoard[7] && ticTacToeBoard.currBoard[7] == ticTacToeBoard.currBoard[8] ||
                ticTacToeBoard.currBoard[0] == ticTacToeBoard.currBoard[3] && ticTacToeBoard.currBoard[3] == ticTacToeBoard.currBoard[6] ||
                ticTacToeBoard.currBoard[1] == ticTacToeBoard.currBoard[4] && ticTacToeBoard.currBoard[4] == ticTacToeBoard.currBoard[7] ||
                ticTacToeBoard.currBoard[2] == ticTacToeBoard.currBoard[5] && ticTacToeBoard.currBoard[5] == ticTacToeBoard.currBoard[8] ||
                ticTacToeBoard.currBoard[0] == ticTacToeBoard.currBoard[4] && ticTacToeBoard.currBoard[4] == ticTacToeBoard.currBoard[8] ||
                ticTacToeBoard.currBoard[2] == ticTacToeBoard.currBoard[4] && ticTacToeBoard.currBoard[4] == ticTacToeBoard.currBoard[6];
    }

    /**
     * Return true if it is a draw (no more empty cell)
     */
    public boolean tie(TicTacToeBoard ticTacToeBoard) {
        for (int i = 0; i < ticTacToeBoard.currBoard.length; ++i)
            if (ticTacToeBoard.currBoard[i] == (i + '0')) return false;
        return true;
    }
}

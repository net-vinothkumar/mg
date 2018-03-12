package de.mg.tictactoe;

/**
 * TicTacToeGame.java
 * <p>
 * Description: This is the driver class for the TicTacToeGame game.
 * Requires: TicTacToeBoard.java as that file serves
 * as the ticTacToeBoard to be played on as well as
 * the implementation of the AI.
 * <p>
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import static de.mg.tictactoe.PositionMapper.resolveInputBoardPosition;
import static de.mg.tictactoe.constants.BoardGameConstants.*;

/**
 * Tic-Tac-Toe: Two-player + Computer console version.
 */
public class TicTacToeGame {

    public TicTacToeGame() {
    }

    public TicTacToeBoard ticTacToeBoard;

    public static char[] placeholderBoard = {'0', '2', '3', '4', '5', '6', '7', '8', '9'};

    public Scanner input = new Scanner(System.in); // the input Scanner
    public boolean playerOneTurn = true; // true if player 1's turn
    public boolean playerTwoTurn = true; // true if player 2's turn
    private GameDecisionMaker gameDecisionMaker = new GameDecisionMaker();
    private BoardGameDisplayer boardGameDisplayer = new BoardGameDisplayer();

    public void launchGame() throws IOException {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(GAME_START_MESSAGE);
        //TODO
        //String sizeOfPlayField = readSizeOfTheGamePlayField();
        ticTacToeBoard = new TicTacToeBoard();
        Player playerOne = new Player('X', 1);
        Player playerTwo = new Player('#', 2);
        Player computer = new Player('O', 3);
        startGameWithPlayersAndComputer(playerOne, playerTwo, computer);
        System.out.print(GAME_OVER_MESSAGE);
    }

    private void startGameWithPlayersAndComputer(Player playerOne, Player playerTwo, Player computer) {
        boardGameDisplayer.printTicTacToeBoard(placeholderBoard, ticTacToeBoard);
        play(playerOne, playerTwo, computer);
        displayGameWinner();
    }

    private void displayGameWinner() {
        if (gameDecisionMaker.isGameOver(ticTacToeBoard)) {
            if (!playerTwoTurn) {
                displayTheWinner(PLAYER_TWO_WON_MESSAGE);
            } else if (!playerOneTurn) {
                displayTheWinner(PLAYER_ONE_WON_MESSAGE);
            } else {
                displayTheWinner(COMPUTER_WON_MESSAGE);
            }
        } else
            System.out.println(GAME_ENDED_IN_DRAW_MESSAGE);
    }

    private void displayTheWinner(String s) {
        System.out.printf("%s\n", s);
    }

    private void play(Player playerOne, Player playerTwo, Player computer) {
        do {
            if (playerOneTurn) {
                getHumanBoardPosition(playerOne);
                playerOneTurn = !playerOneTurn;
            } else if (playerTwoTurn) {
                getHumanBoardPosition(playerTwo);
                playerTwoTurn = !playerTwoTurn;
            } else {
                getComputerPosition(computer);
            }
        } while (!gameDecisionMaker.isGameOver(ticTacToeBoard) && !gameDecisionMaker.tie(ticTacToeBoard));
    }

    private void getHumanBoardPosition(Player player) {
        boolean validInput = false;
        do {
            System.out.printf(ITS_PLAYER_TURN_NOW_MESSAGE, player.getPlayerPosition());
            System.out.print(USER_INPUT_MESSAGE);
            if (input.hasNext()) {
                String inputBoardPosition = input.next();
                int spot = resolveInputBoardPosition(inputBoardPosition);
                if (spot >= 1 && spot <= 9 && spot - 1 == Character.getNumericValue(ticTacToeBoard.currBoard[spot - 1])) {
                    ticTacToeBoard.move(spot - 1, player.getPlayerSymbol());
                    boardGameDisplayer.printTicTacToeBoard(placeholderBoard, ticTacToeBoard);
                    validInput = true;
                } else
                    System.out.println(INVALID_BOARD_POSITION_ERROR_MESSAGE);
            } else {
                input.next();
                System.out.println(INVALID_BOARD_POSITION_ERROR_MESSAGE);
                continue;
            }
        } while (!validInput);
    }

    private void getComputerPosition(Player computer) {
        cpuDelay();
        ticTacToeBoard.run_with_pruning(ticTacToeBoard, computer.getPlayerSymbol());
        if (TicTacToeBoard.nextState != null) {
            TicTacToeBoard temp = TicTacToeBoard.nextState;
            temp.prevBoard = ticTacToeBoard.currBoard;
            ticTacToeBoard = temp;
            boardGameDisplayer.printTicTacToeBoard(placeholderBoard, ticTacToeBoard);
            playerOneTurn = true;
            playerTwoTurn = true;
        } else
            throw new RuntimeException(COMPUTER_CANNOT_FIND_NEXT_POSITION);
    }

    private void cpuDelay() {
        try {
            System.out.println(COMPUTER_THINKING_MESSAGE);
            Random rn = new Random();
            Thread.sleep(rn.nextInt(1000) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Configurable size of the field - not completed the other field sizes.
     * @return
     * @throws IOException
     */
    private String readSizeOfTheGamePlayField() throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "resources/application.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        return appProps.getProperty("playfield.size");
    }
}


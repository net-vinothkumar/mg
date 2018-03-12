package de.mg.tictactoe;

public class Player {

    private char playerSymbol;
    private Integer playerPosition;

    public Player(char playerSymbol, int playerPosition) {
        this.playerSymbol = playerSymbol;
        this.playerPosition = playerPosition;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public Integer getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Integer playerPosition) {
        this.playerPosition = playerPosition;
    }
}

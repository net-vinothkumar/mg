package de.mg.tictactoe;

public class PositionMapper {

    static int resolveInputBoardPosition(String inputSpot) {
        switch (inputSpot) {
            case "0,0":
                return 1;
            case "0,1":
                return 2;
            case "0,2":
                return 3;
            case "1,0":
                return 4;
            case "1,1":
                return 5;
            case "1,2":
                return 6;
            case "2,0":
                return 7;
            case "2,1":
                return 8;
            case "2,2":
                return 9;
            default:
                return -1;
        }
    }
}

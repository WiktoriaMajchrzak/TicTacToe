package mainGame;

public class Board {

    static final int gameSize = 3;

    static final String[][] board = new String[gameSize][gameSize];

    public void printTheBoard() {
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                System.out.print(board[i][j]);
                if (j < gameSize - 1) {
                    System.out.print("|");
                }
            }
            if (i < gameSize - 1) {
                System.out.println("");
                for (int k = 0; k < gameSize - 1; k++) {
                    System.out.print("-+");
                }
                System.out.println("-");
            }
        }
        System.out.println("");
    }

    public void initEmptyBoard() {
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                board[i][j] = " ";
            }
        }
    }

}

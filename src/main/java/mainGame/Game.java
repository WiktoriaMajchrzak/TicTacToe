package mainGame;

public class Game {

    private static final int gameSize = 3;

    private static final String[][] board = new String[gameSize][gameSize];

    private static void printTheBoard() {
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                System.out.print(board[i][j]);
                if (j < gameSize - 1) {
                    System.out.print("|");
                }
            }
            if (i < gameSize - 1) {
                System.out.println("");
                System.out.println("-+-+-");
            }
        }
        System.out.println("");
    }

    private void initEmptyBoard() {
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                board[i][j] = " ";
            }
        }
    }


}

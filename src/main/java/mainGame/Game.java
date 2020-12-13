package mainGame;


public class Game {

    private static final int gameSize = 3;
    private static int playerNumber = 1;

    private static final String[][] board = new String[gameSize][gameSize];

    public void play() {
        System.out.println(Messages.WELCOME_MESSAGE);
        initEmptyBoard();
        printTheBoard();
        callPlayerMove(playerNumber);
        printTheBoard();
        System.out.println(Messages.WIN_GAME);
    }

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

    private void callPlayerMove(int player) {
        if (player == 1) {
            System.out.println(Messages.FIRST_PLAYER_MOVE);
        } else {
            System.out.println(Messages.SECOND_PLAYER_MOVE);
        }
    }

}

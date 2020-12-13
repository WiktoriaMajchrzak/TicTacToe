package mainGame;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    private static final int gameSize = 3;
    private static int playerNumber = 1;
    private static final String firstSymbol = "O";
    private static final String secondSymbol = "X";
    private static int row;
    private static int col;
    private static boolean endGame = false;

    private static final String[][] board = new String[gameSize][gameSize];

    public void play() {
        System.out.println(Messages.WELCOME_MESSAGE);
        initEmptyBoard();
        printTheBoard();
        while (!endGame) {
            callPlayerMove(playerNumber);
            playerMove();
            printTheBoard();
            endGame = playerWon(row, col);
        }
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

    private void enterRow() {
        System.out.println(Messages.ENTER_ROW);
        row = scanner.nextInt() - 1;
    }

    private void enterCol() {
        System.out.println(Messages.ENTER_COL);
        col = scanner.nextInt() - 1;
    }

    private void playerMove() {
        enterRow();
        enterCol();
        fillTheCell();
    }

    private void fillTheCell() {
        if (board[row][col].equals(" ")) {
            if (playerNumber == 1) {
                board[row][col] = firstSymbol;
                playerNumber = 2;
            } else {
                board[row][col] = secondSymbol;
                playerNumber = 1;
            }
        } else {
            System.out.println(Messages.NOT_EMPTY_CELL);
        }
    }

    private boolean playerWon(int row, int col) {
        if ((board[row][0].equals(board[row][1])) && (board[row][0].equals(board[row][2]))) {
            return true;
        }
        if ((board[0][col].equals(board[1][col])) && (board[0][col].equals(board[2][col]))) {
            return true;
        }
        if ((row == col) && ((board[0][0].equals(board[1][1])) && (board[0][0].equals(board[2][2])))) {
            return true;
        }
        if ((row + col == 4) && ((board[0][2].equals(board[1][1])) && (board[0][2].equals(board[2][0])))) {
            return true;
        }
        return false;
    }

}

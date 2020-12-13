package mainGame;

import java.util.Scanner;

public class Player extends Board {

    Scanner scanner = new Scanner(System.in);

    private final String firstSymbol = "O";
    private final String secondSymbol = "X";
    public int row;
    public int col;
    private int playerNumber = 1;

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

    public void playerMove() {
        callPlayerMove(playerNumber);
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

    public boolean playerWon() {
        if (checkRow() || checkCol() || checkFirstDiagonal() || checkSecondDiagonal()) {
            return true;
        }
        return false;
    }

    private boolean checkRow() {
        for (int i = 0; i < gameSize - 1; i++) {
            if (!(board[row][i].equals(board[row][i + 1]))) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    private boolean checkCol() {
        for (int i = 0; i < gameSize - 1; i++) {
            if (!(board[i][col].equals(board[i + 1][col]))) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    private boolean checkFirstDiagonal() {
        if (board[0][0].equals(" ")) {
            System.out.println("false");
            return false;
        }
        for (int i = 0; i < gameSize - 1; i++) {
            if (!(board[i][i].equals(board[i + 1][i + 1]))) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    private boolean checkSecondDiagonal() {
        if (board[0][gameSize - 1].equals(" ")) {
            System.out.println("false");
            return false;
        }
        for (int i = 0; i < gameSize - 2; i++) {
            if (!(board[i][gameSize - 1 - i].equals(board[i + 1][gameSize - 1 - i - 1]))) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

}

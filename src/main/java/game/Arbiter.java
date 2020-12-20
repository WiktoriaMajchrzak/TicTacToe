package game;

public class Arbiter {

    public boolean playerWon(String[][] board, int row, int col) {
        return checkRow(row, board) || checkCol(col, board) || checkFirstDiagonal(board) || checkSecondDiagonal(board);
    }

    private boolean checkRow(int row, String[][] board) {
        for (int i = 0; i < board.length - 1; i++) {
            if (!(board[row][i].equals(board[row][i + 1]))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, String[][] board) {
        for (int i = 0; i < board.length - 1; i++) {
            if (!(board[i][col].equals(board[i + 1][col]))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFirstDiagonal(String[][] board) {
        if (board[0][0].equals(" ")) {
            return false;
        }
        for (int i = 0; i < board.length - 1; i++) {
            if (!(board[i][i].equals(board[i + 1][i + 1]))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondDiagonal(String[][] board) {
        if (board[0][board.length - 1].equals(" ")) {
            return false;
        }
        for (int i = 0; i < board.length - 1; i++) {
            if (!(board[i][board.length - 1 - i].equals(board[i + 1][board.length - 1 - i - 1]))) {
                return false;
            }
        }
        return true;
    }

}

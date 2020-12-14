package game;

public class Board {

    private final int gameSize;
    private final String[][] board;

    public Board(int gameSize) {
        this.gameSize = gameSize;
        this.board = new String[gameSize][gameSize];
    }

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

    public boolean playerWon(int row, int col) {
        return checkRow(row) || checkCol(col) || checkFirstDiagonal() || checkSecondDiagonal();
    }

    private boolean checkRow(int row) {
        for (int i = 0; i < gameSize - 1; i++) {
            if (!(board[row][i].equals(board[row][i + 1]))) {
                System.out.println("check row : false");
                return false;
            }
        }
        System.out.println("check row : true");
        return true;
    }

    private boolean checkCol(int col) {
        for (int i = 0; i < gameSize - 1; i++) {
            if (!(board[i][col].equals(board[i + 1][col]))) {
                System.out.println("check col : false");
                return false;
            }
        }
        System.out.println("check col : true");
        return true;
    }

    private boolean checkFirstDiagonal() {
        if (board[0][0].equals(" ")) {
            System.out.println("check first diagonal : false");
            return false;
        }
        for (int i = 0; i < gameSize - 1; i++) {
            if (!(board[i][i].equals(board[i + 1][i + 1]))) {
                System.out.println("check first diagonal : false");
                return false;
            }
        }
        System.out.println("check first diagonal : true");
        return true;
    }

    private boolean checkSecondDiagonal() {
        if (board[0][gameSize - 1].equals(" ")) {
            System.out.println("check second diagonal : false");
            return false;
        }
        for (int i = 0; i < gameSize - 1; i++) {
            if (!(board[i][gameSize - 1 - i].equals(board[i + 1][gameSize - 1 - i - 1]))) {
                System.out.println("check second diagonal : false");
                return false;
            }
        }
        System.out.println("check second diagonal : true");
        return true;
    }

    public boolean fillCell(int row, int col, String symbol) {
        if (board[row][col].equals(" ")) {
            board[row][col] = symbol;
            return true;
        } else {
            System.out.println(Messages.NOT_EMPTY_CELL);
            return false;
        }
    }

}

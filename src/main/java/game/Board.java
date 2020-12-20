package game;

public class Board {


    private final int gameSize;
    private final String[][] board;

    public Board(int gameSize) {
        this.gameSize = gameSize;
        this.board = new String[gameSize][gameSize];
        initEmptyBoard();
    }

    public int getGameSize() {
        return gameSize;
    }

    public String[][] getBoard(){
        return board;
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
                System.out.println();
                for (int k = 0; k < gameSize - 1; k++) {
                    System.out.print("-+");
                }
                System.out.println("-");
            }
        }
        System.out.println();
    }

    private void initEmptyBoard() {
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                board[i][j] = " ";
            }
        }
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

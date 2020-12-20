package game;

import java.io.InputStream;
import java.util.Scanner;

public class Player {

    private Scanner scanner;

    private final String symbol;
    private final Board board;
    private final Arbiter arbiter;
    private final int playerNumber;


    public Player(String symbol, Board board, Arbiter arbiter, int playerNumber) {
        this.symbol = symbol;
        this.board = board;
        this.arbiter = arbiter;
        this.playerNumber = playerNumber;
        this.scanner = new Scanner(System.in);
    }

    public void setInput(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    private void callPlayerMove() {
        if (playerNumber == 1) {
            System.out.println(Messages.FIRST_PLAYER_MOVE);
        } else {
            System.out.println(Messages.SECOND_PLAYER_MOVE);
        }
    }

    public boolean playerMove() {
        boolean filled = false;
        int row = 0;
        int col = 0;
        while (!filled) {
            callPlayerMove();
            row = enterRow();
            col = enterCol();
            filled = board.fillCell(row, col, symbol);
        }
        return arbiter.playerWon(board.getBoard(), row, col);
    }

    private int enterRow() {
        System.out.println(Messages.ENTER_ROW);
        int row = scanner.nextInt() - 1;
        while (row < 0 || row >= board.getGameSize()) {
            System.out.println(Messages.ENTER_ROW);
            row = scanner.nextInt() - 1;
        }
        return row;
    }

    private int enterCol() {
        System.out.println(Messages.ENTER_COL);
        int col = scanner.nextInt() - 1;
        while (col < 0 || col >= board.getGameSize()) {
            System.out.println(Messages.ENTER_COL);
            col = scanner.nextInt() - 1;
        }
        return col;
    }

}

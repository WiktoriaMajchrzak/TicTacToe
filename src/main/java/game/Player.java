package game;

import java.util.Scanner;

public class Player {


    Scanner scanner = new Scanner(System.in);

    private final String symbol;
    private final Board board;
    private final int playerNumber;
    private static int ordinalNumber = 1;

    public Player(String symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
        this.playerNumber = ordinalNumber++;
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
        return board.playerWon(row, col);
    }

    private int enterRow() {
        System.out.println(Messages.ENTER_ROW);
        return scanner.nextInt() - 1;
    }

    private int enterCol() {
        System.out.println(Messages.ENTER_COL);
        return scanner.nextInt() - 1;
    }

}

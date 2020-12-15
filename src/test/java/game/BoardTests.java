package game;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardTests {

    private Board board;

    @BeforeMethod
    public void setBoard() {
        this.board = new Board(3);
        board.initEmptyBoard();
    }

    @Test
    public void shouldReturnTrueForWinningGameInRow() {
        board.fillCell(0,0,"X");
        board.fillCell(1,0,"O");
        board.fillCell(0,1,"X");
        board.fillCell(1,1,"O");
        board.fillCell(0,2,"X");
        Assert.assertTrue(board.playerWon(0, 2));
    }

    @Test
    public void shouldReturnTrueForWinningGameInCol() {
        board.fillCell(0,1,"X");
        board.fillCell(1,0,"O");
        board.fillCell(1,1,"X");
        board.fillCell(1,2,"O");
        board.fillCell(2,1,"X");
        Assert.assertTrue(board.playerWon(2, 1));
    }

    @Test
    public void shouldReturnTrueForWinningGameInFirstDiagonal() {
        board.fillCell(0,0,"X");
        board.fillCell(1,0,"O");
        board.fillCell(1,1,"X");
        board.fillCell(2,0,"O");
        board.fillCell(2,2,"X");
        Assert.assertTrue(board.playerWon(2, 2));
    }

    @Test
    public void shouldReturnTrueForWinningGameInSecondDiagonal() {
        board.fillCell(0,2,"X");
        board.fillCell(1,0,"O");
        board.fillCell(1,1,"X");
        board.fillCell(2,1,"O");
        board.fillCell(2,0,"X");
        Assert.assertTrue(board.playerWon(2, 0));
    }

    @Test
    public void shouldReturnFalseForFirstVersionOfBoard() {
        board.fillCell(0,1,"X");
        board.fillCell(0,2,"O");
        board.fillCell(1,1,"X");
        board.fillCell(1,2,"O");
        board.fillCell(2,0,"X");
        Assert.assertFalse(board.playerWon(2, 0));
    }

    @Test
    public void shouldReturnFalseForSecondVersionOfBoard() {
        board.fillCell(0,0,"X");
        board.fillCell(1,2,"O");
        board.fillCell(1,0,"X");
        board.fillCell(2,0,"O");
        board.fillCell(1,1,"X");
        Assert.assertFalse(board.playerWon(1, 1));
    }

    @Test
    public void shouldReturnTrueIfCellCouldBeOverwritten(){
        Assert.assertTrue(board.fillCell(1,1, "X"));
    }

    @Test
    public void shouldReturnTrueIfCellCouldNotBeOverwritten(){
        board.fillCell(1,1, "O");
        Assert.assertFalse(board.fillCell(1,1, "X"));
    }

}

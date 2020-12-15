package game;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;


public class PlayerTests {

    private Board board;
    private Player player;

    @BeforeMethod
    public void setUp() {
        this.board = new Board(3);
        this.player = new Player("X", board, 1);
    }

    @Test
    public void shouldReturnFalseForMoveWithoutWinning() {
        String data = "1\r\n2\r\n";
        player.setInput(new ByteArrayInputStream(data.getBytes()));
        Assert.assertFalse(player.playerMove());
    }

    @Test
    public void shouldReturnFalseForMoveWithoutWinningWithFirstMoveOutOfRange() {
        String data = "5\r\n2\r\n3\r\n";
        player.setInput(new ByteArrayInputStream(data.getBytes()));
        Assert.assertFalse(player.playerMove());
    }

    @Test
    public void shouldReturnTrueForWinningMoves() {
        String data = "1\r\n1\r\n" +
                "1\r\n2\r\n" +
                "1\r\n3\r\n";
        player.setInput(new ByteArrayInputStream(data.getBytes()));
        Assert.assertFalse(player.playerMove());
        Assert.assertFalse(player.playerMove());
        Assert.assertTrue(player.playerMove());
    }
}

package game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static boolean endGame = false;

    private final Board board = new Board(3);
    private final List<Player> players = new ArrayList<>();
    private final Arbiter arbiter = new Arbiter();

    public Game() {
        players.add(new Player("O", board, arbiter, 1));
        players.add(new Player("X", board, arbiter, 2));
    }

    public void play() {
        System.out.println(Messages.WELCOME_MESSAGE);
        board.printTheBoard();
        while (!endGame) {
            for (Player player : players) {
                endGame = player.playerMove();
                board.printTheBoard();
                if (endGame) {
                    break;
                }
            }
        }
        System.out.println(Messages.WIN_GAME);
    }


}

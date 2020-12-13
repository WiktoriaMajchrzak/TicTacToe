package mainGame;

public class Game extends Player{


    private static boolean endGame = false;

    Board board = new Board();

    public void play() {
        System.out.println(Messages.WELCOME_MESSAGE);
        board.initEmptyBoard();
        board.printTheBoard();
        while (!endGame) {
            playerMove();
            board.printTheBoard();
            endGame = playerWon();
        }
        System.out.println(Messages.WIN_GAME);
    }



}

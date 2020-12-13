package mainGame;

public enum Messages {
    WELCOME_MESSAGE("Hello Players! It's the Tic Tac Toe game!"),
    ENTER_ROW("Enter the row number"),
    ENTER_COL("Enter the col number"),
    FIRST_PLAYER_MOVE("First player!"),
    SECOND_PLAYER_MOVE("Second player!"),
    NOT_EMPTY_CELL("This cell is not empty, choose another one"),
    WIN_GAME("Congratulation! You are the winner!");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}

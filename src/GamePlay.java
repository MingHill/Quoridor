package src;

// Abstract class Gameplay
public abstract class GamePlay {
    // checkwin
    public abstract int[] check_win(Player currentPlayer);

    //game move
    public abstract void makeMove(Player currentPlayer);

    public abstract Player getWinner();

    //




}

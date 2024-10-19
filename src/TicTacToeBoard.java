package src;

public class TicTacToeBoard extends Board{
    private boolean game_over;
    public TicTacToeBoard(int size){
        super(size);
        game_over = false;
    }
}

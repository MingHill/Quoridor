package src;

// Class that provided logic and rules for TicTacToe
public class TTTGamePlay extends GamePlay {
    private Board b;
    private Player player1;
    private Player player2;
    private Player winner;

    public TTTGamePlay(Board board, Player player1, Player player2) {
        this.b = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    //checks the win condition for tictactoe
    public int[] check_win(Player currentPlayer){
        int state = currentPlayer.getState();
        boolean win = checkRows(state) || checkColumns(state) || checkMainDiagonal(state) || checkAntiDiagonal(state);
        if (win){
            this.winner = currentPlayer;
            return new int [] {1, currentPlayer.getState()};
        }
        return new int[]{-1, currentPlayer.getState()};
    }

    private boolean checkRows(int state){
        int n = this.b.getSize();
        for (int r = 0; r < n; r++) {
            boolean rowWin = true;
            for (int c = 0; c < n; c++) {
                if (this.b.board[r][c].getState() != state) {
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) {
                return true;
            }
        }
        return false;
    }
    private boolean checkColumns(int state) {
        int n = this.b.getSize();
        for (int c = 0; c < n; c++) {
            boolean colWin = true;
            for (int r = 0; r < n; r++) {
                if (this.b.board[r][c].getState() != state) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) {
                return true;
            }
        }
        return false;
    }
    private boolean checkMainDiagonal(int state) {
        int n = this.b.getSize();
        for (int i = 0; i < n; i++) {
            if (this.b.board[i][i].getState() != state) {
                return false;
            }
        }
        return true;
    }
    private boolean checkAntiDiagonal(int state) {
        int n = this.b.getSize();
        for (int i = 0; i < n; i++) {
            if (this.b.board[i][n - 1 - i].getState() != state) {
                return false;
            }
        }
        return true;
    }

    public void makeMove(Player currentPlayer){
        int marker = currentPlayer.getState();
        String prompt = currentPlayer.getName() + ". " + "Please enter your coordinates: ";
        Coordinate newMove = getInput.inputCoord(prompt);
        while(!this.b.make_move(newMove.getRow(), newMove.getCol(), marker)){
            String invalid_move = "Please try again: ";
            newMove = getInput.inputCoord(invalid_move);
        }
    }

    public Player getWinner(){
        return this.winner;
    }




}

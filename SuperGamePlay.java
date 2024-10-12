// Logic and rules for super tic tac toe
public class SuperGamePlay extends GamePlay{
    private Board b;
    private Player player1;
    private Player player2;
    private Player winner;

    public SuperGamePlay(Board board, Player player1, Player player2) {
        this.b = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int[] check_win(Player currentPlayer){
        Board current_board = b.get_win_board();
        int state = currentPlayer.getState();
        boolean win = checkRows(state, current_board) || checkColumns(state, current_board) || checkMainDiagonal(state, current_board) || checkAntiDiagonal(state, current_board);
        if (win){
            this.winner = currentPlayer;
            return new int [] {1, currentPlayer.getState()};
        }
        return new int[]{-1, currentPlayer.getState()};

    }

    private boolean checkRows(int state, Board current_board){
        int n = current_board.getSize();
        for (int r = 0; r < n; r++) {
            boolean rowWin = true;
            for (int c = 0; c < n; c++) {
                if (current_board.getTile(r, c).getState() != state) {
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

    private boolean checkColumns(int state, Board current_board) {
        int n = current_board.getSize();
        for (int c = 0; c < n; c++) {
            boolean colWin = true;
            for (int r = 0; r < n; r++) {
                if (current_board.getTile(r, c).getState() != state) {
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
    private boolean checkMainDiagonal(int state, Board current_board) {
        int n = current_board.getSize();
        for (int i = 0; i < n; i++) {
            if (current_board.getTile(i, i).getState() != state) {
                return false;
            }
        }
        return true;
    }
    private boolean checkAntiDiagonal(int state, Board current_board) {
        int n = current_board.getSize();
        for (int i = 0; i < n; i++) {
            if (current_board.getTile(i, i).getState() != state) {
                return false;
            }
        }
        return true;
    }


    public void makeMove(Player currentPlayer){
        int marker = currentPlayer.getState();
        String prompt = currentPlayer.getName() + ". " + "Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column";
        int[] newMove = getInput.inputSuperCoord(prompt);
        while(!this.b.make_super_move(newMove[0], newMove[1], newMove[2], newMove[3], marker, currentPlayer)){
            String invalid_move = "Please try again: ";
            newMove = getInput.inputSuperCoord(invalid_move);
        }
    }

    public Player getWinner() {
        return this.winner;
    }
}

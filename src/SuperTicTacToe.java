package src;

import java.util.HashMap;
// board class for superticatactoe
public class SuperTicTacToe extends Board {
    private Board[][] board;
    private static final HashMap<String, int[]> giant_coord = new HashMap<>();
    private Board win_board;
    private int board_size;
    private HashMap<Coordinate, TTTGamePlay> gameplays = new HashMap<>();

    static {
        giant_coord.put("A", new int[]{1, 1});
        giant_coord.put("B", new int[]{1, 2});
        giant_coord.put("C", new int[]{1, 3});
        giant_coord.put("D", new int[]{2, 1});
        giant_coord.put("E", new int[]{2, 2});
        giant_coord.put("F", new int[]{2, 3});
        giant_coord.put("G", new int[]{3, 1});
        giant_coord.put("H", new int[]{3, 2});
        giant_coord.put("I", new int[]{3, 3});
    }

    public SuperTicTacToe(int size) {
        this.board_size = size;
        this.board = this.initializeSuperBoard();
        this.win_board = new Board(3);
    }

    private Board[][] initializeSuperBoard() {
        Board[][] board = new TicTacToeBoard[this.board_size][this.board_size];
        for (int r = 0; r < this.board_size; r++) {
            for (int c = 0; c < this.board_size; c++) {
                board[r][c] = new TicTacToeBoard(3);
                this.gameplays.put(new Coordinate(r, c), new TTTGamePlay(board[r][c], null, null));
            }
        }
        return board;
    }

    public boolean is_full() {
        for (int r = 0; r < this.board_size; r++) {
            for (int c = 0; c < this.board_size; c++) {
                if (!this.board[r][c].is_full()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int r = 0; r < this.board_size; r++) {
            for (int c = 0; c < this.board_size; c++) {
                this.board[r][c].resetBoard();
            }
        }
    }

    public Board get_win_board() {
        return this.win_board;
    }

    public String toString() {
        String h_line = "+--+--+--+ +--+--+--+ +--+--+--+ \n";
        String output = "";

        for (int r = 0; r < this.board_size; r++) {
            output += h_line;
            for (int rowInBoard = 0; rowInBoard < 3; rowInBoard++) {
                for (int c = 0; c < 3; c++) {
                    output += getRow(this.board[r][c], rowInBoard);
                }
                output += "\n" + h_line;
            }
            output += "\n";
        }
        return output;
    }

    public String getRow(Board board, int row) {
        String output = "| ";
        for (int c = 0; c < 3; c++) {
            output += board.getTile(row, c).toString() + "| ";
        }
        return output;
    }

    public boolean make_super_move(int gr, int gc, int r, int c, int state, Player currentplayer) {
        if (r < 1 || r > 3 || c < 1 || c > 3) {
            System.out.println("src.Tile does not exist. ");
            return false;
        }
        if (!this.board[gr - 1][gc - 1].getTile(r - 1, c - 1).isEmpty()) {
            System.out.println("There is already a tile there");
            return false;
        }
        this.board[gr - 1][gc - 1].getTile(r - 1, c - 1).changeState(state);
        int[] val = this.gameplays.get(new Coordinate(gr - 1, gc - 1)).check_win(currentplayer);
        if (val[0] > 0) {
            this.win_board.getTile(gr - 1, gc - 1).changeState(currentplayer.getState());
            this.board[gr - 1][gc - 1].fill_board(currentplayer.getState());
        }
        return true;
    }

    public static int[] getSuperCoord(String coord) {
        return giant_coord.get(coord);
    }
}

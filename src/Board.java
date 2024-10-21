package src;

import java.util.HashMap;

// Super class board class
public class Board{
    protected int board_size;
    protected Tile[][] board;
    protected int turn;


    public Board(int size){
        this.board_size = size;
        this.board = initializeBoard();
    }

    public Board(){}

    // initializes the board class
    public Tile[][] initializeBoard(){
        Tile[][] new_board = new Tile[this.board_size][this.board_size]; // use arrayList instead
        for(int r = 0; r < this.board_size; r++){
            for(int c = 0; c < this.board_size; c++){
                new_board[r][c] = new Tile(r, c);
            }
        }
        return new_board;
    }

    // clears the board of all markers
    public void resetBoard(){
        for(int r = 0; r < this.board_size; r++){
            for(int c = 0; c < this.board_size; c++){
                this.board[r][c].changeState(0);
            }
        }
    }

    // return tile of given coordinates
    public Tile getTile(int r, int c) {
        return this.board[r][c];
    }

    public void setTile(int r, int c, int state){
        this.board[r][c].changeState(state);
    }

    // return true if board is full and false otherwise
    public boolean is_full(){ // checks if the current board is full
        for(int r = 0; r < this.board_size; r++){
            for(int c = 0; c < this.board_size; c++){
                if(this.board[r][c].isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize(){
        return this.board_size;
    }

    public String toString(){
        String output = "    ";
        for(int i = 0; i < this.board_size; i++){
            output = output + (i + 1) + "   ";
        }
        output = output + "\n";
        String line = "  ";
        for(int i = 0; i < this.board_size; i++){
            line = line + "+---";
        }
        line = line;

        for (int r = 0; r < this.board_size; r++){
            output = output + line + "+\n" + (r + 1);
            for(int c = 0; c < this.board_size; c++){
                output = output + " | " + this.board[r][c].toString();
            }
            output = output + " |\n";
        }
        output = output + line + "+";
        return output;
    }


    // places a marker onto the board, checking validity
    public boolean make_move(int r, int c, int state){
        if (r < 0 || r > this.getSize() - 1|| c < 0 || c > this.getSize() - 1){
            System.out.print("src.Tile does not exist. ");
            return false;
        }
        if(!(this.board[r][c].isEmpty())){
            System.out.print("There is already a tile there.");
            return false;
        }
        this.board[r][c].changeState(state);
        return true;
    }

    public boolean make_super_move(int gr, int gc, int r, int c, int state, Player currentplayer){return true;}

    public Board get_win_board(){return null;}

    public void fill_board(int state){
        for (int r = 0; r < this.board_size; r++){
            for (int c = 0; c < this.board_size; c++){
                this.board[r][c].changeState(state);
            }
        }
    }

    public void changeVertFence(FenceCoordinate[] newFences, boolean remove){}

    public void changeHorizontalFence(FenceCoordinate[] newFences, boolean remove){}

    public boolean isFenceBlocked(FenceCoordinate f) {return false;}
    
    public HashMap<FenceCoordinate, Fence> getInstanceofFence(boolean horizontal){
        return null;
    }
}
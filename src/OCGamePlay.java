package src;

import java.util.HashMap;

// Rules and Logic for Order and Chaos
public class OCGamePlay extends GamePlay{
    Board b;
    Player player1;
    Player player2;
    Player winner;
    private static final HashMap<Integer, String> symbols = new HashMap<>();
    static{
        symbols.put(0, " ");
        symbols.put(1, "X");
        symbols.put(2, "0");
        symbols.put(3, "X");
    }
    public OCGamePlay(Board board, Player player1, Player player2) {
        Marker.SetNewSymbol(this.symbols);
        this.b = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int[] check_win(Player currentPlayer){
        int state = currentPlayer.getState();

        // checking connections
        if(check_rows() || check_diag(0,0) || check_diag(1,0) || check_diag(0,1) || check_diag(1,1)){
            this.winner = this.player1;
            return new int[]{1,this.player1.getState()};
        }
        //checking fill
        if (b.is_full()){
            this.winner = this.player2;
            return new int[]{1,this.player2.getState()};
        }
        return new int[]{-1, currentPlayer.getState()};
    }

    private boolean check_rows(){
        for (int state = 1; state < 3; state++){
            for(int i = 0; i < b.getSize(); i++){
                if(this.b.board[i][0].getState() == state && this.b.board[i][1].getState() == state && this.b.board[i][2].getState() == state && this.b.board[i][3].getState() == state&& this.b.board[i][4].getState() == state){
                    return true;
                }
                if(this.b.board[i][1].getState() == state && this.b.board[i][2].getState() == state && this.b.board[i][3].getState() == state && this.b.board[i][4].getState() == state&& this.b.board[i][5].getState() == state){
                    return true;
                }
                if(this.b.board[0][i].getState() == state && this.b.board[1][i].getState() == state && this.b.board[2][i].getState() == state && this.b.board[3][i].getState() == state && this.b.board[4][i].getState() == state){
                    return true;
                }
                if(this.b.board[1][i].getState() == state && this.b.board[2][i].getState() == state && this.b.board[3][i].getState() == state && this.b.board[4][i].getState() == state && this.b.board[5][i].getState() == state){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check_diag(int r, int c){
        for (int state = 1; state < 3; state++){
            if(this.b.board[r][c].getState() == state && this.b.board[r + 1][c + 1].getState() == state && this.b.board[r + 2][c + 2].getState() == state && this.b.board[c + 3][c + 3].getState() == state&& this.b.board[r + 4][r + 4].getState() == state){
                return true;
            }
            if(this.b.board[r][b.getSize() - 1 - c].getState() == state && this.b.board[r + 1][b.getSize() - 2 - c].getState() == state && this.b.board[r + 2][b.getSize() - 3 - c].getState() == state && this.b.board[c + 3][b.getSize() - 4 - c].getState() == state&& this.b.board[r + 4][b.getSize() - 5 - c].getState() == state){
                return true;
            }
        }
        return false;
    }

    public void makeMove(Player currentPlayer){
        System.out.println(this.b.toString());
        int marker = getInput.inputMarker(currentPlayer);
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

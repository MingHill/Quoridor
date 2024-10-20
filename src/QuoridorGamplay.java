package src;

import java.util.Arrays;
import java.util.HashMap;

public class QuoridorGamplay extends GamePlay{
    private Player winner;
    private Player player1;
    private Player player2;
    private Board b;
    private static final HashMap<Integer, String> symbols = new HashMap<>();
    static{
        symbols.put(0, " ");
        symbols.put(1, "\u265B");
        symbols.put(2, "\u265A");
    }

    public QuoridorGamplay(Board board, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.b = board;

        Marker.SetNewSymbol(this.symbols);
        refreshBoard();
    }
    public Player getWinner(){
        return this.winner;
    }


    /** Checks win condition by getting the current players and checking if they
    are in the winning row **/
    public int[] check_win(Player currentPlayer){
        int state = currentPlayer.getState();
        Coordinate playerCoordinate = null;
        int row;
        switch (state){
            case 1:
                playerCoordinate = player1.getPlayerCoordinate();
                row = playerCoordinate.getRow();
                if (row == this.b.getSize() - 1){
                    System.out.println("Player 1 has won!");
                    this.winner = currentPlayer;
                    return new int[]{1,state};
                }
                break;
            case 2:
                playerCoordinate = player2.getPlayerCoordinate();
                row = playerCoordinate.getRow();
                if (row == 0){
                    this.winner = currentPlayer;
                    return new int[]{1,state};
                }
                break;
        }
        return new int[] {-1, state};
    }

    public void makeMove(Player currentPlayer){
        System.out.println("Current walls left : " + currentPlayer.getWalls_left());
        int decision = getInput.inputMoveDecision(currentPlayer.getWalls_left());

        switch(decision){
            case 1:
                while(true){
                    String[] fenceInput = getInput.inputFence();
                    int tile1 = Integer.parseInt(fenceInput[0]);
                    int tile2 = Integer.parseInt(fenceInput[1]);

                    FenceCoordinate[] coordinates = getCoordinates(tile1, tile2);

                    if(isValidFence(tile1, tile2, coordinates)){
                        if (isHorizontal(tile1, tile2)){
                            b.changeHorizontalFence(coordinates);
                        }else{
                            b.changeVertFence(coordinates);
                        }
                        currentPlayer.decreaseWall_left();
                        break;
                    }
                }
                break;
            case 2:
                while(true) {
                    int move = getInput.inputMove(1, b.getSize() * b.getSize());
                    boolean moveSuccess = movePlayer(currentPlayer, move);

                    if (moveSuccess) {
                        break;
                    }
                }
        }
        refreshBoard();
    }

    private boolean movePlayer(Player currentPlayer, int move) {
        Coordinate moveCoordinate = new Coordinate(move, b.getSize(), 1);

        if (!isValidMove(currentPlayer, moveCoordinate)){
            System.out.println("Invalid move, please try again");
            return false;
        }

        // Update the player's coordinate
        currentPlayer.setPlayerCoordinate(new Coordinate(move, b.getSize(), 1));
        return true;
    }

    private boolean isValidMove(Player currentPlayer, Coordinate moveCoordinate) {
        if (isValidAdjacentMove(currentPlayer, moveCoordinate)) {
            return true;
        }

        if (isAdjacentPlayer(currentPlayer)) {
            Player OtherPlayer = getOtherPlayer(currentPlayer);
            if (isValidAdjacentMove(OtherPlayer, moveCoordinate)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValidAdjacentMove(Player currentPlayer, Coordinate moveCoordinate){
        Coordinate playerCoordinate = currentPlayer.getPlayerCoordinate();

        // Check for same tile move
        if (playerCoordinate.getRow() == moveCoordinate.getRow() && playerCoordinate.getCol() == moveCoordinate.getCol()){
            return false;
        }

        // Check that the move is within one tile
        int rowDiff = Math.abs(playerCoordinate.getRow() - moveCoordinate.getRow());
        int colDiff = Math.abs(playerCoordinate.getCol() - moveCoordinate.getCol());

        // Check if the move is within one tile
        if (rowDiff > 1 || colDiff > 1){
            return false;
        }

        // Check if only moving in one direction
        if ((rowDiff == 1) && (colDiff == 1)){
            return false;
        }

        // Check if blocked by fence
        FenceCoordinate f = new FenceCoordinate(playerCoordinate, moveCoordinate);
        if (b.isFenceBlocked(f)){
            return false;
        }

        // Check if there is a player on the move tile
        Coordinate otherPlayerCoordinate = getOtherPlayer(currentPlayer).getPlayerCoordinate();
        if (otherPlayerCoordinate.getRow() == moveCoordinate.getRow() && otherPlayerCoordinate.getCol() == moveCoordinate.getCol()){
            return false;
        }

        return true;
    }

    private boolean isAdjacentPlayer(Player currentPlayer){
        Coordinate playerCoordinate = currentPlayer.getPlayerCoordinate();
        Coordinate otherPlayerCoordinate = getOtherPlayer(currentPlayer).getPlayerCoordinate();

        int rowDiff = Math.abs(playerCoordinate.getRow() - otherPlayerCoordinate.getRow());
        int colDiff = Math.abs(playerCoordinate.getCol() - otherPlayerCoordinate.getCol());

        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
    }

    /* Parses the inputted string array and returns the 2 fences are are inputted */

    private FenceCoordinate[] getCoordinates(int tile1, int tile2){
        //1 and 3 are 1 fence and 2 and 4 are another
        Coordinate coord1 = new Coordinate(tile1, 9, 1);
        Coordinate coord2 = new Coordinate(tile2, 9, 1);
        Coordinate coord3;
        Coordinate coord4;

        if(isHorizontal(tile1, tile2)){
            coord3 = new Coordinate(coord1.getRow() + 1, coord1.getCol());
            coord4 = new Coordinate(coord2.getRow() + 1, coord2.getCol());
        }else{
            coord3 = new Coordinate(coord1.getRow(), coord1.getCol() + 1);
            coord4 = new Coordinate(coord2.getRow(), coord2.getCol() + 1);
        }
        FenceCoordinate fenceCoordinate1 = new FenceCoordinate(coord1, coord3);
        FenceCoordinate fenceCoordinate2 = new FenceCoordinate(coord2, coord4);

        return new FenceCoordinate[] {fenceCoordinate1, fenceCoordinate2};
    }

    /* Refresh the Quoridor board with current player positions */
    private void refreshBoard(){
        b.resetBoard();
        Coordinate player1Coord = player1.getPlayerCoordinate();
        Coordinate player2Coord = player2.getPlayerCoordinate();
        this.b.setTile(player1Coord.getRow(), player1Coord.getCol(), 1);
        this.b.setTile(player2Coord.getRow(), player2Coord.getCol(), 2);
    }
    
    private boolean isHorizontal(int tile1, int tile2){
        return Math.abs(tile1 - tile2) == 1;
    }

    private boolean isValidFence(int tile1, int tile2, FenceCoordinate[] coordinates){

        //Checks if the tiles exist
        if (tile1 > 81 || tile1 < 1 || tile2 > 81 || tile2 < 1){
            System.out.println("Invalid Tile, please choose between the range of 1 - 81");
            return false;
        }

        //Checks if tiles are next to each other
        if(!(Math.abs(tile1 - tile2) == 1 || Math.abs(tile1 - tile2) == 9)){
            System.out.println("Invalid Input, please choose 2 tiles next to each other");
            return false;
        }

        boolean isHoriz = this.isHorizontal(tile1, tile2);
        HashMap <FenceCoordinate, Fence> instanceofFence = b.getInstanceofFence(isHoriz);

        FenceCoordinate fc1 = coordinates[0];
        FenceCoordinate fc2 = coordinates[1];

        if((!instanceofFence.containsKey(fc1) || !instanceofFence.containsKey(fc2))){
            System.out.println("Fence does not exist, remember you can't select edges");
            return false;
        }
        // Checks if the fences are not already blocked
        if (instanceofFence.get(fc1).isBlock() || instanceofFence.get(fc2).isBlock()){
            System.out.println("Fence is already blocked, please choose a new fence");
            return false;
        }
        return true;
    }

    public Player getOtherPlayer(Player currentPlayer){
        if(currentPlayer.getState() == this.player1.getState()){
            return this.player2;
        }else{
            return this.player1;
        }
    }

}

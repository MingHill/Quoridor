package src;

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
        return new Player(0, "0", 0);
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
                    return new int[]{1,state};
                }
                break;
            case 2:
                playerCoordinate = player2.getPlayerCoordinate();
                row = playerCoordinate.getRow();
                if (row == 0){
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
                currentPlayer.decreaseWall_left();
                String[] fenceInput = getInput.inputFence();
                String orientation = fenceInput[0];
                FenceCoordinate[] coordinates = getCoordinates(fenceInput);

                // Changes the fences on board class
                if (orientation.equalsIgnoreCase("v")){
                    b.changeVertFence(coordinates);
                }else{
                    b.changeHorizontalFence(coordinates);
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
    private FenceCoordinate[] getCoordinates(String[] fenceInput){
        String orientation = fenceInput[0];
        int r1  = Integer.parseInt(fenceInput[1]);
        int c1 = Integer.parseInt(fenceInput[2]);
        int r2 = Integer.parseInt(fenceInput[3]);
        int c2 = Integer.parseInt(fenceInput[4]);
        String direction = fenceInput[5].toLowerCase();

        Coordinate coord1 = new Coordinate(r1, c1);
        Coordinate coord2 = new Coordinate(r2, c2);
        FenceCoordinate fenceCoordinate1 = new FenceCoordinate(coord1, coord2);

        Coordinate coord3;
        Coordinate coord4;
        FenceCoordinate fenceCoordinate2 = null;
        switch(direction){
            case "l":
                coord3 = new Coordinate(r1, c1 - 1);
                coord4 = new Coordinate(r2, c2 - 1);
                fenceCoordinate2 = new FenceCoordinate(coord3, coord4);
                break;
            case "r":
                coord3 = new Coordinate(r1, c1 + 1);
                coord4 = new Coordinate(r2, c2 + 1);
                fenceCoordinate2 = new FenceCoordinate(coord3, coord4);
                break;
            case "u":
                coord3 = new Coordinate(r1 - 1, c1);
                coord4 = new Coordinate(r2 - 1, c2 );
                fenceCoordinate2 = new FenceCoordinate(coord3, coord4);
                break;
            case "d":
                coord3 = new Coordinate(r1 + 1, c1);
                coord4 = new Coordinate(r2 + 1, c2 );
                fenceCoordinate2 = new FenceCoordinate(coord3, coord4);
                break;
        }
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

    public Player getOtherPlayer(Player currentPlayer){
        if(currentPlayer.getState() == this.player1.getState()){
            return this.player2;
        }else{
            return this.player1;
        }
    }

}

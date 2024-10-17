// Class for a player, are instantiated at the beginning of the game
public class Player{
    protected int state;
    protected int wins;
    protected String name;
    protected int GameID;
    private int walls_left;
    private Coordinate coord;


    public Player(int state, String player_name, int GameID){
        this.state = state;
        this.wins = 0;
        this.name = player_name;
        this.GameID = GameID;
        this.walls_left = 10;
        this.setPlayerCoordinate();
    }

    private void setPlayerCoordinate(){
        if (this.state == 1){
            this.coord = new Coordinate(0,5);
        }else{
            this.coord = new Coordinate(9, 5);
        }

    }

    public Coordinate getPlayerCoordinate(){return this.coord;}

    public int getWalls_left(){return this.walls_left;}

    public void decreaseWall_left(){this.walls_left -= 1;}

    public int getState(){
        return this.state;
    }

    public int getWins(){
        return this.wins;
    }

    public void addWin(){
        this.wins++;
    }

    public void changeState(int state_change){
        this.state = state_change;
    }

    public String getName(){
        return this.name;
    }
    //static method to initialize a player in the main class
    public static Player setPlayer(int GameID, int player_num){
        String name;
        if (GameID == 2){
            if (player_num == 1){
                name = "Player Order";
            }else{
                name = "Player Chaos";
            }
        }else{
            if (player_num == 1){
                name = "Player X";
            }else{
                name = "Player O";
            }
        }
        return new Player(player_num,name,GameID);
    }



}

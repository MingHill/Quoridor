// Class for a player, are instantiated at the beginning of the game
public class Player{
    protected int state;
    protected int wins;
    protected String name;
    protected int GameID;


    public Player(int state, String player_name, int GameID){
        this.state = state;
        this.wins = 0;
        this.name = player_name;
        this.GameID = GameID;
    }


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

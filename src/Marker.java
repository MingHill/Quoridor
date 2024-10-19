package src;

import java.util.HashMap;
// that that represent a marker that is placed on a tile
public class Marker {
    private int state;
    private static final HashMap<Integer, String> repr = new HashMap<>();

    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";


    public Marker(int state){
        this.state = state;
    }

    static {
        repr.put(0, " ");
        repr.put(1, "X");
        repr.put(2, "O");
    }

    public void changeState(int state){
        this.state = state;
    }

    public int getState(){
        return this.state;
    }

    public String toString(){
        if(this.state == 1){
            return GREEN + repr.get(this.state) + RESET;
        }else if (this.state == 2){
            return RED + repr.get(this.state) + RESET;
        }else{
            return repr.get(this.state);
        }
    }
}

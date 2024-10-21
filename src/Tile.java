package src;

import java.util.HashMap;
// class that represents a single tile on the board class
public class Tile{
     private Marker marker; // 0 = empty, 1 = player 1, 2 = player 2

     private Coordinate coordinate; //src.Coordinate class to keep track of location of tile
     public static final HashMap<Integer, String> map = new HashMap<>();


     //src.Tile constructor
     public Tile(int col, int row){
         this.marker = new Marker(0);
         this.coordinate = new Coordinate(row, col);
     }

     //changes the state of tile, throws exception if new state is not valid
     public void changeState(int state_change){
        if (state_change < 0 || state_change > 3){
            throw new IllegalArgumentException();
        }
        this.marker.changeState(state_change);
     }

     //changes coordinate of tile
     public void moveCoordinate(int r, int c){ // may not need
         this.coordinate.setCoordinate(r, c);
     }

     public boolean isEmpty(){
         return this.marker.getState() == 0;
     }

     public int getState(){
         return this.marker.getState();
     }

     public String toString(){
         return this.marker.toString();
     }
}
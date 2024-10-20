package src;

import java.util.Objects;


// src.FenceCoordinate object that take 2 tile coordinates as inputs


public class FenceCoordinate {
    private Coordinate coordinate_one;
    private Coordinate coordinate_two;

    public FenceCoordinate(Coordinate coordinate_one, Coordinate coordinate_two) {
        this.coordinate_one = coordinate_one;
        this.coordinate_two = coordinate_two;
    }


    public int hashCode() {
        return Objects.hash(this.coordinate_one, this.coordinate_two);
    }

    public Coordinate getCoordinate(int i){
        if (i == 1){
            return this.coordinate_one;
        }else{
            return this.coordinate_two;
        }
    }

    @Override
    public boolean equals(Object obj){
        FenceCoordinate other = (FenceCoordinate) obj;
        return this.coordinate_one.equals(other.coordinate_one) && this.coordinate_two.equals(other.coordinate_two);
    }

    public String toString(){
        return "Coord 1: " + coordinate_one.toString() + "Coord 2: " + coordinate_two.toString();
    }
}

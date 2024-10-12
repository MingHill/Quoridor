import java.util.Objects;
// Coordinate class which represents location on the board
public class Coordinate {
    private int row;
    private int col;
    public Coordinate(int r, int c){
        setCoordinate(r, c);
    }
    public String toString(){
        return "Row: " + this.row + " Col: " + this.col;
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        Coordinate other = (Coordinate) obj;// Check if they are the same reference
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public void setCoordinate(int r, int c){
        this.row = r;
        this.col = c;
    }

    // processes a coordinate string and returns a coordinate object
    public static Coordinate processCoordinate(String coord){
        String[] parts = coord.split(",");
        int r = Integer.parseInt(parts[0]) - 1;
        int c = Integer.parseInt(parts[1]) - 1;
        return new Coordinate(r, c);
    }



    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }



}

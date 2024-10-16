public class Fence {
    private boolean block;
    private final boolean vert;
    private final FenceCoordinate coord;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public Fence(boolean vert, FenceCoordinate coordinate) {
        this.block = false;
        this.vert = vert;
        this.coord = coordinate;
    }

    public boolean isBlock(){
        return this.block;
    }

    public void setBlock(boolean block){
        this.block = block;
    }

    public String toString(){
        if(this.vert){
            if (this.block){
                return ANSI_RED +  "#" + ANSI_RESET;
            }else{
                return "|";
            }
        }else{
            if (this.block){
                return ANSI_RED +  "+###" + ANSI_RESET;
            }else{
                return "+***";
            }
        }
    }

    public boolean equals(Fence other){
        return this.coord.equals(other.coord);
    }

}

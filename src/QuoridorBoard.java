package src;

import java.util.HashMap;

public class QuoridorBoard extends Board{
    private HashMap<FenceCoordinate, Fence> HorizontalFences = new HashMap<> ();
    private HashMap<FenceCoordinate, Fence> VerticalFences = new HashMap<>();

    public QuoridorBoard(){
        super(9);
        this.initializeFences();
    }


    // Right now all walls are being added but need to specify specific ones later. e.g. left most columns should not be able to be blocked
    private void initializeFences(){
        for (int r = 0; r < this.getSize(); r++){
            for (int c = 0; c < this.getSize(); c++){

                Coordinate c1 = new Coordinate(r, c);
                Coordinate c2 = new Coordinate(r + 1, c);
                FenceCoordinate f1 = new FenceCoordinate(c1, c2);
                this.HorizontalFences.put(f1, new Fence(false, f1));


                Coordinate c3 = new Coordinate(r, c);
                Coordinate c4 = new Coordinate(r, c + 1);
                FenceCoordinate f2 = new FenceCoordinate(c3, c4);
                this.VerticalFences.put(f2, new Fence(true, f2));
            }
        }
    }

    private String printRow(int r){
        String line = "  ";
        for(int c = 0; c < this.getSize(); c++){
            Coordinate c1 = new Coordinate(r, c);
            Coordinate c2 = new Coordinate(r + 1, c);
            FenceCoordinate f1 = new FenceCoordinate(c1, c2);
            Fence fence = this.HorizontalFences.get(f1);
            line = line + fence.toString();
        }
        line = line ;
        return line;
    }

    private String printColumn(int r, int c){
        String line = "";
        Coordinate c1 = new Coordinate(r, c);
        Coordinate c2 = new Coordinate(r , c + 1);
        FenceCoordinate f1 = new FenceCoordinate(c1, c2);
        Fence fence = this.VerticalFences.get(f1);
        line = line + fence.toString();
        return line;
    }

    public String toString(){
        String output = "       ";
        int tileCounter = 0;

        output = output + "\n";
        for (int r = 0; r < this.board_size; r++){
            String currentRow = this.printRow(r);
            output = output + currentRow + "+\n ";
            for(int c = 0; c < this.board_size; c++){
                String col = this.printColumn(r, c);
                String tileHeader = (++tileCounter) + (tileCounter < 10 ? " " : "");
                output = output + " " + col + tileHeader;
            }
            output = output + " |\n ";
            for(int c = 0; c < this.board_size; c++){
                String col = this.printColumn(r, c);
                output = output + " " + col + " " + this.board[r][c].toString();
            }
            if (r == 0){
                output = output + " | P1 BASE \n";
            }else if(r == this.getSize() - 1){
                output = output + " | P2 BASE \n";
            }else {
                output = output + " |\n";
            }
        }
        output = output + this.printRow(this.getSize() - 1) + "+";
        return output;
    }

    public void changeVertFence(FenceCoordinate[] newFences){
        for(FenceCoordinate f : newFences){
            Fence fence = this.VerticalFences.get(f);
            if (fence != null){
                fence.setBlock(true);
            }

        }
    }

    public void changeHorizontalFence(FenceCoordinate[] newFences){
        for(FenceCoordinate f : newFences){
            Fence fence = this.HorizontalFences.get(f);
            if (fence != null){
                fence.setBlock(true);
            }
        }
    }

    public boolean isFenceBlocked(FenceCoordinate f) {
        Fence fence = this.VerticalFences.get(f);
        if (fence != null){
            return fence.isBlock();
        }
        fence = this.HorizontalFences.get(f);
        if (fence != null){
            return fence.isBlock();
        }
        return false;
    }

    public HashMap<FenceCoordinate, Fence> getInstanceofFence(boolean horizontal){
        if (horizontal){
            return this.HorizontalFences;
        }else{
            return this.VerticalFences;
        }
    }
}

public class QuoridorGamplay extends GamePlay{
    public QuoridorGamplay(){
    }
        public Player getWinner(){
            return new Player(0, "0", 0);
        }

        public int[] check_win(Player currentPlayer){
            return new int[]{1,1};
        }

        public void makeMove(Player currentPlayer){

        }
}

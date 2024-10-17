import java.util.Scanner;
// Keeps track of turns, wins and called upon certain gameplay methods to run the game.
public class Interface{
    private int[] score;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private final int gameID;

    public Interface(Board b, int GameID){
        this.board = b;
        this.score = new int[]{0, 0};
        this.player1 = Player.setPlayer(GameID, 1);
        this.player2 = Player.setPlayer(GameID, 2);
        this.currentPlayer = this.player1;
        this.gameID = GameID;
    }


    // runs the given game either tictactoe or order and chaos or super tictactoe.
    public void startGame(){
        this.currentPlayer = this.player1;
        GamePlay currentGame = null;
        System.out.println("Welcome Players! ");
        switch(this.gameID){
            case 1:
                currentGame = new TTTGamePlay(this.board, this.player1, this.player2);
                System.out.println("To place a marker down, please enter the coordinate in the following format: x,y (x = row, y = column)");
                break;
            case 2:
                currentGame = new OCGamePlay(this.board, this.player1, this.player2);
                System.out.println("To place a marker down, please enter the coordinate in the following format: x,y (x = row, y = column)");
                break;
            case 3:
                currentGame = new SuperGamePlay(this.board, this.player1, this.player2);
                System.out.println("To place a marker down, please enter the coordinate in the following format: A x,y (x = row, y = column) and A is a value between A/a - I/i");
                System.out.println("A = tictactoe board in (1,1) section, B = tictactoe board in (1,2) section etc while (x, y) is the tile on that certain board section");
                break;
            case 4:
                currentGame = new QuoridorGamplay(this.board, this.player1, this.player2);
                System.out.println("In Q game");
                break;

        }
        System.out.println(this.board.toString());

        while(true){
            currentGame.makeMove(this.currentPlayer);
            System.out.println(this.board.toString());

            int[] win_outcome = currentGame.check_win(this.currentPlayer);
            if(win_outcome[0] > 0){
                System.out.println("GAME OVER! " + currentGame.getWinner().getName() + " has won!");
                this.score[currentGame.getWinner().getState() - 1]++;
                System.out.println("The score is now " + this.player1.getName() + ": " + this.score[0] + " | " + this.player2.getName() + ": " + this.score[1]);
                this.endGame();
                break;
            }
            if(this.board.is_full()) {
                    System.out.println("The board is full, it's a TIE!");
                    this.endGame();
                    break;
            }
            this.switchTurn();
        }
    }

    // called after each turn to keep track of current player
    public void switchTurn(){
        if(this.currentPlayer.getState() == this.player1.getState()){
            this.currentPlayer = this.player2;
        }else{
            this.currentPlayer = this.player1;
        }
    }

    //called when there is either a tie or winner of a game, asks players to restart or end game
    public void endGame(){
        System.out.print("Input Y/y to play again, any other key to exit: ");
        Scanner input = new Scanner(System.in);
        String result = input.nextLine();
        if (result.equals("Y") || result.equals("y")){
            this.board.resetBoard();
            this.startGame();
        }else{
            System.out.println("Thanks for playing! Goodbye!");
            System.out.println("The final score is" + this.player1.getName() + ": " + this.score[0] + " | " + this.player2.getName() + ": " + this.score[1]);
        }
    }
}

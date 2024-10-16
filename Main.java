import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        src.Misc.AudioPlayer audio = new src.Misc.AudioPlayer("220870__diboz__ibrkr01.wav");
        audio.loop();
        System.out.println("\nWelcome to Ming's Game Shop! We have three game to play today");
        boolean quit = false;
        while(!quit){

            Board board;
            int game = getInput.chooseGame();

            if (game == 1){
                int size = getInput.validIntRange(3, 9);
                board = new TicTacToeBoard(size);
            }else if (game == 3){
                board = new SuperTicTacToe(3);
            }else if (game == 2){
                board = new OrderandChaosBoard();
            }else{
                board = new QuoridorBoard();
                System.out.println(board.toString());
                System.exit(0);
            }
            Interface newgame = new Interface(board, game);
            newgame.startGame();
            Scanner input = new Scanner(System.in);
            if(!getInput.chooseNewGame()){
                quit = true;
                System.out.println("Thanks for playing! Goodbye!");
            }

        }
        audio.stop();
    }
}

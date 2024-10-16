import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;
// class to get all the input I/O from terminal

public final class getInput {
    public static int validIntRange(int start, int end){
        Scanner scanner = new Scanner(System.in);
        int size = 0;

        while (true){
            System.out.println("What size board would you like, please enter a single integer between 3 - 9: ");
            if (scanner.hasNextInt()){
                size = scanner.nextInt();
                if (size >= start && size <= end){
                    break;
                }
                System.out.println("That is not a valid integer between 3 - 9");
            }else{
                System.out.println("That is not a valid integer between 3 - 9");
                scanner.next();
            }
        }
        return size;
    }

    public static int chooseGame(){
        System.out.println("Input 1 to play TicTacToe \nInput 2 to play Order & Chaos \nInput 3 to player Super TicTacToe \nInput 4 to play Quoridor ");
        Scanner input = new Scanner(System.in);
        String game = input.nextLine();
        while(!(game.equals("1") || game.equals("2") || game.equals("3") || game.equals("4"))){
            System.out.println("Please enter a valid input: ");
            input = new Scanner(System.in);
            game = input.nextLine();
        }
        return Integer.parseInt(game);
    }

    public static boolean chooseNewGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play a new game or exit the application. Input Y/y for new game or any other key for exit: ");
        String result = scanner.nextLine();
        return result.equals("Y") || result.equals("y");
    }

    // selects Marker type for order and chaos
    public static Integer inputMarker(Player currentPlayer){
        String prompt = currentPlayer.getName() + ", please input X or O marker";
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        String marker = input.next();
        while (!(marker.equalsIgnoreCase("X")|| marker.equalsIgnoreCase("O"))){
            System.out.println("Please enter valid marker");
            input = new Scanner(System.in);
            marker = input.nextLine();
        }
        int state;
        if (marker.equalsIgnoreCase("X")) {
            state = 1;
        }else{
            state = 2;
        }
        return state;
    }

    // collects coordinates from players
    public static Coordinate inputCoord(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        String coord = input.nextLine();
        while(!isValidFormat(coord)){
            System.out.println("This is not a valid format, please try again in the format: x,y (x = row, y = column)");
            input = new Scanner(System.in);
            coord = input.nextLine();
        }
        return Coordinate.processCoordinate(coord);
    }

    public static int[] inputSuperCoord(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        String superCoord = input.nextLine();
        while(!isValidFormatSuper(superCoord)){
            System.out.println("This is not a valid format, please try again");
            input = new Scanner(System.in);
            superCoord = input.nextLine();
        }
        String[] parts = superCoord.split(" ");
        String letter = parts[0].toUpperCase();

        int[] giantCoord = SuperTicTacToe.getSuperCoord(letter);
        String[] coordinates = parts[1].split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        return new int[]{giantCoord[0], giantCoord[1], x, y};
    }

    //checks the validFormat for coordinates
    private static boolean isValidFormat(String input){
        return input.matches("\\d+,\\d+");
    }

    private static boolean isValidFormatSuper(String input){
        return input.matches("[a-iA-I] \\d+,\\d+");
    }

}


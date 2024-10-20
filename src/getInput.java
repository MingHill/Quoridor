package src;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    // selects src.Marker type for order and chaos
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

    // Get user decision to play a wall or make a move
    public static int inputMoveDecision(int walls_left){
        if(walls_left < 1){
            System.out.println("You don't have walls left, therefore you will make a move");
            return 2;
        }
        System.out.println("To place a wall INPUT 1 | To make a move INPUT 2: ");
        Scanner input = new Scanner(System.in);
        String move = input.nextLine();
        while(!(move.equals("1") || move.equals("2"))){
            System.out.println("Please enter a valid move");
            input = new Scanner(System.in);
            move = input.nextLine();
        }
        return Integer.parseInt(move);
    }

    // Gets input for fence
    public static String[] inputFence() {
        System.out.println("Input the fence you want to block in the following format: ");
        System.out.println("A (x1, y1) (x2, y2) b");
        System.out.println("A : is either V (vertical fence) or H (horizontal fence) \n" +
                "(x1, y1) (x2, y2) : the coordinates tiles that sandwich the walls  \n" +
                "b : l (left) and r (right) for H, u (up) and d (down) for V of where you want the second wall to be placed");
        Scanner input = new Scanner(System.in);
        String fence = input.nextLine();
        if (!isValidFenceFormat(fence)) {
            input = new Scanner(System.in);
            fence = input.nextLine();
        }
        return parseFence(fence);

    }

    public static char inputMove() {
        System.out.println("Input move direction (W/A/S/D): ");
        System.out.println("W: UP, A: LEFT, S: DOWN, D: RIGHT");
        Scanner input = new Scanner(System.in);
        String move = input.nextLine();
        while(!(move.equalsIgnoreCase("W") || move.equalsIgnoreCase("A")
                || move.equalsIgnoreCase("S") || move.equalsIgnoreCase("D"))){
            System.out.println("Please enter a valid move");
            move = input.nextLine();
        }
        System.out.println("You have moved " + move);

        return Character.toLowerCase(move.charAt(0));
    }

    // parses the inputed fence into String array
    private static String[] parseFence(String fence) {
        // Corrected regex with capturing groups
        String regex = "^([VHvh]) \\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\) ([lrudLRUD])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fence);

        // Check if the matcher finds a match
        if (matcher.matches()) {
            // Correctly capture the groups
            String orientation = matcher.group(1);  // V/H
            String x1 = matcher.group(2);           // x1
            String y1 = matcher.group(3);           // y1
            String x2 = matcher.group(4);           // x2
            String y2 = matcher.group(5);           // y2
            String direction = matcher.group(6);    // l/r/u/d

            return new String[]{orientation, x1, y1, x2, y2, direction};
        } else {
            throw new IllegalArgumentException("Invalid fence format");
        }
    }


    // Checks if the inputted fence format matches the format asked for and check if V/H are accompanied with correct l/r/d/u
    private static boolean isValidFenceFormat(String input){
        String regex = "^[VHvh] \\(\\d+,\\d+\\) \\(\\d+,\\d+\\) [lrudLRUD]$";
        if (!input.matches(regex)){
            System.out.println("Please enter a valid format A (x1, y1) (x2, y2) b");
            return false;
        }
        String[] parsed = parseFence(input);
        String orientation = parsed[0];
        String direction = parsed[5];
        System.out.println(Arrays.toString(parsed));
        while ((orientation.equalsIgnoreCase("V") && !(direction.equalsIgnoreCase("u") || direction.equalsIgnoreCase("d"))) ||
                (orientation.equalsIgnoreCase("H") && !(direction.equalsIgnoreCase("l") || direction.equalsIgnoreCase("r")))) {
            System.out.println("Please enter a valid orientation, V must be accompanied with u/d and H must be accompanied with l/r");
            return false;
        }
        return true;
    }

    //checks the validFormat for coordinates
    private static boolean isValidFormat(String input){
        return input.matches("\\d+,\\d+");
    }

    // valid format for src.SuperTicTacToe
    private static boolean isValidFormatSuper(String input){
        return input.matches("[a-iA-I] \\d+,\\d+");
    }



    // Input for either a wall or move


}


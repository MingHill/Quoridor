# CS611 - Assignment 3
## Adding Quoridor
---------------------------------------------------------------------------
- Name: Soong Ming Hill
- Email: minghill@bu.edu
- Student ID: U50983276

- Name: Nitin Mathai
- Email: nmathai@bu.edu
- Student ID: U70592980

## Files
---------------------------------------------------------------------------
This section should be all of the source code files that have a .java extension. You should also include a brief description of what the class does.
 - AudioPlayer.java
   - AudioPlayer is a class that plays music during the game. It starts when it is called by src.Main and ends when the players decide to stop playing. 
 - src.Board.java 
   - src.Main board class that uses Tiles to represent a nxn grid type board. Has methods to check fullness, reset and toString. 
 - src.Coordinate.java
   - A simple class that keeps track of the tile coordinate within the board. 
 - src.Interface.java
   - src.Main class that run the game program. Acts as a game control system, tracking wins, switching turns. 
 - src.Main.java
   - src.Main class that start the program, used to choose which game to play. 
 - src.OrderandChaosBoard.java
   - Inherits the board class and automatically creates a 6x6 board.
 - src.TicTacToeBoard.java
   - Inherits the board class and automatically creates a 3x3 board.
 - src.Tile.java
   - src.Tile class builds the given board. Uses Coordinates to mark the location within the board and src.Marker class as a state. 
 - src.Player.java 
   - src.Main player class thats created when a game is initialized. Used to make moves during the game. 
 - src.Marker.java
   - src.Marker class that represent a specific piece. Holds a state 0 = empty, 1 = X, 2 = O
 - Gameplay.java: 
   - Abstract class for gameplay rules and logic. Defines, check_win, make_move and get_winner 
 - TTTGameplay.java
   - Extends gameplay class and implements logic and rules for tictactoe. 
 - src.OCGamePlay.java 
   - Extends gameplay class and implements logic and rules for OrderandChaos. 
 - src.SuperGamePlay.java
   - Extendes gameplay class and implements logic and rules for src.SuperTicTacToe. 
 - src.SuperTicTacToe.java
   - Extends board class. Overrided a lot of classes defined in src.Board.java having different logic. These include toString, make_move, resetBoard etc
 


## Notes
---------------------------------------------------------------------------



## How to compile and run
---------------------------------------------------------------------------
Your directions on how to run the code. Make sure to be as thorough as possible!
run:

Unzip the file and cd into the folder. 

javac -d out src/*.java
java -cp out src.Main


## Input/Output Example
---------------------------------------------------------------------------
Please give us a full execution of what we should see on the screen. Label each text with input and output. For example:


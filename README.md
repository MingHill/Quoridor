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

New Classes:
- src.QuoridorGamePlay.java
  - Extends the gameplay class and implements logic and rules for Quoridor.
- src.QuoridorBoard.java
  - Inherits the board class and automatically creates a 9x9 board for Quoridor.
- src.Fence.java
  - Fence class that represents a fence. Stores the coordinates and orientation of a fence (horizontal/vertical), along with it’s state (blocked or unblocked).
- src.FenceCoordinate.java
  - A simple class that keeps track of the fence coordinate within the board.

Previously added:
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
- ASCII art displayed when a player wins any game.
- Background music plays during gameplay.
- A BFS check is added to prevent the game from becoming unwinnable for any player.
- Valid move options for each player within Quoridor are marked with an "X". Jump-over-player mechanics have also been implemented, and displayed using these markers.
  ```
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   | X | ♚ | X |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+
  ```


How we merged our assignments: 
- We decided to implement Ming’s code base. Our decision to do this was based on the fact that we had similar implementations for our previous assignments and it would have been easier to just go off one.
- For this assignment, we did not make any major modifications. Instead, we extended some classes and created a Fence/FenceCoordinate class to work with our new game. We did not alter much of the high-level design/classes but added much lower-level stuff. 


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

```shell

Welcome to Ming and Nitin's Game Shop! We have three game to play today
Input 1 to play TicTacToe
Input 2 to play Order & Chaos
Input 3 to player Super TicTacToe
Input 4 to play Quoridor
4
Welcome Players!
In Q game

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   | X | ♛ | X |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   | ♚ |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 14

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   | ♛ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   | X | ♚ | X |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 68

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   | X |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   | X | ♛ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   | ♚ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 23

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   | ♛ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   | X | ♚ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   | X |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 59

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   | X | ♛ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   | ♚ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 32

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   | ♛ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   | X | ♚ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 50

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   | X | ♛ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   | ♚ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
1
Input the fence you want to block in the following format: N1, N2
To place a horizontal wall, the walls will be placed below the 2 numbers.
To place a vertical wall, the walls will be placed to the right of the 2 numbers
41,42

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   | ♛ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   | X | ♚ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 49

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   | X | ♛ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   | ♚ |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 9
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 31

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   | ♛ |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   | X | ♚ | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 40

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   | X | ♛ | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   | X | ♚ | X |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 9
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 49

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   | X | ♚ | X |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   | X | ♛ | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 50

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   | X | ♛ | ♚ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   | X | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 9
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 49
Invalid move, please try again
Enter tile number for move (1 to 81): 58

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   | X | ♚ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   | ♛ | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 10
To place a wall INPUT 1 | To make a move INPUT 2:
1
Input the fence you want to block in the following format: N1, N2
To place a horizontal wall, the walls will be placed below the 2 numbers.
To place a vertical wall, the walls will be placed to the right of the 2 numbers
68,69

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   | X | ♚ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   | X | ♛ | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   | X |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 9
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 67

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   | X | ♚ | X |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57| 58| 59| 60| 61| 62| 63|
  |   |   |   |   | X |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66| 67| 68| 69| 70| 71| 72|
  |   |   |   | ♛ |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   |   |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 9
To place a wall INPUT 1 | To make a move INPUT 2:
1
Input the fence you want to block in the following format: N1, N2
To place a horizontal wall, the walls will be placed below the 2 numbers.
To place a vertical wall, the walls will be placed to the right of the 2 numbers
57,66

  +---+---+---+---+---+---+---+---+---+
  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
  |   |   |   |   |   |   |   |   |   |  P1 BASE
  +---+---+---+---+---+---+---+---+---+
  | 10| 11| 12| 13| 14| 15| 16| 17| 18|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 19| 20| 21| 22| 23| 24| 25| 26| 27|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 28| 29| 30| 31| 32| 33| 34| 35| 36|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 37| 38| 39| 40| 41| 42| 43| 44| 45|
  |   |   |   |   |   |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 46| 47| 48| 49| 50| 51| 52| 53| 54|
  |   |   |   |   | ♚ |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 55| 56| 57# 58| 59| 60| 61| 62| 63|
  |   |   |   # X |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+---+
  | 64| 65| 66# 67| 68| 69| 70| 71| 72|
  |   |   |   # ♛ | X |   |   |   |   |
  +---+---+---+---+###+###+---+---+---+
  | 73| 74| 75| 76| 77| 78| 79| 80| 81|
  |   |   |   | X |   |   |   |   |   |  P2 BASE
  +---+---+---+---+---+---+---+---+---+

Current walls left : 9
To place a wall INPUT 1 | To make a move INPUT 2:
2
Enter tile number for move (1 to 81): 76
Player 1 has won!
GAME OVER! Player X has won!
██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗    ██╗    ██╗
╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║    ██║    ██║
 ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║    ██║    ██║
  ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║    ╚═╝    ╚═╝
   ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║    ██╗    ██╗
   ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝    ╚═╝    ╚═╝

The score is now Player X: 1 | Player O: 0
Input Y/y to play again, any other key to exit:
Thanks for playing! Goodbye!
The final score isPlayer X: 1 | Player O: 0
Would you like to play a new game or exit the application. Input Y/y for new game or any other key for exit:
y
Input 1 to play TicTacToe
Input 2 to play Order & Chaos
Input 3 to player Super TicTacToe
Input 4 to play Quoridor
1
What size board would you like, please enter a single integer between 3 - 9:
3
Welcome Players!
To place a marker down, please enter the coordinate in the following format: x,y (x = row, y = column)
    1   2   3
  +---+---+---+
1 |   |   |   |
  +---+---+---+
2 |   |   |   |
  +---+---+---+
3 |   |   |   |
  +---+---+---+
Player X. Please enter your coordinates:
1,1

```

# CS611-Assignment 2
## Adding SuperTicTacToe
---------------------------------------------------------------------------
- Name: Soong Ming Hill
- Email: minghill@bu.edu
- Student ID: U50983276

## Files
---------------------------------------------------------------------------

This section should be all of the source code files that have a .java extension. You should also include a brief description of what the class does.
 - AudioPlayer.java
   - AudioPlayer is a class that plays music during the game. It starts when it is called by Main and ends when the players decide to stop playing. 
 - Board.java 
   - Main board class that uses Tiles to represent a nxn grid type board. Has methods to check fullness, reset and toString. 
 - Coordinate.java
   - A simple class that keeps track of the tile coordinate within the board. 
 - Interface.java
   - Main class that run the game program. Acts as a game control system, tracking wins, switching turns. 
 - Main.java
   - Main class that start the program, used to choose which game to play. 
 - OrderandChaosBoard.java
   - Inherits the board class and automatically creates a 6x6 board.
 - TicTacToeBoard.java
   - Inherits the board class and automatically creates a 3x3 board.
 - Tile.java
   - Tile class builds the given board. Uses Coordinates to mark the location within the board and Marker class as a state. 
 - Player.java 
   - Main player class thats created when a game is initialized. Used to make moves during the game. 
 - Marker.java
   - Marker class that represent a specific piece. Holds a state 0 = empty, 1 = X, 2 = O
 - Gameplay.java: 
   - Abstract class for gameplay rules and logic. Defines, check_win, make_move and get_winner 
 - TTTGameplay.java
   - Extends gameplay class and implements logic and rules for tictactoe. 
 - OCGamePlay.java 
   - Extends gameplay class and implements logic and rules for OrderandChaos. 
 - SuperGamePlay.java
   - Extendes gameplay class and implements logic and rules for SuperTicTacToe. 
 - SuperTicTacToe.java
   - Extends board class. Overrided a lot of classes defined in Board.java having different logic. These include toString, make_move, resetBoard etc
 


## Notes
---------------------------------------------------------------------------
Please explain the cool features of your program. Anything that you feel like you did a good job at or were creative about, explain it in bullets here. Additionally, any design decisions should be made here.
- Color: 
  - I decided to make each of the tiles different colors. Doing this makes it easier to players to see which type of marker is on the board
- Coordinate System: 
  - When the board is shown on the terminal screen, I have the coordinates shown for each row and each column. Only applicable to TicTacToe and OrderandChaos.  
- Music: 
  - When players are playing they are able to enjoy music. Who doesn't like music.
- Win board; 
  - For supertictactoe, when a player wins a sub board, the entire board turns into that players marker making it easier to play the game. 


## How to compile and run
---------------------------------------------------------------------------
Your directions on how to run the code. Make sure to be as thorough as possible!
run:

Unzip the file and cd into the folder. 

javac *.java
java Main


## Input/Output Example
---------------------------------------------------------------------------
Please give us a full execution of what we should see on the screen. Label each text with input and output. For example:

```
Output: 
[+] Welcome to Ming's Game Shop! We have two game options to play today: TicTacToe or Order & Chaos: 
[+] Input 1 to play TicTacToe | Input 2 to play Order & Chaos: 

Input: 
1

Output:
[+] What size board would you like, please enter a single integer: 

Input: 
3

Output:
[+] Welcome Players! 
[+] To place a marker down, please enter the coordinate in the following format: x,y (x = row, y = column)
   1  2  3  
  +--+--+--+
1 |  |  |  |
  +--+--+--+
2 |  |  |  |
  +--+--+--+
3 |  |  |  |
  +--+--+--+
  
[+] Player X. Please enter your coordinates: 

Input: 
1,1

Output:
 1  2  3  
  +--+--+--+
1 |X |  |  |
  +--+--+--+
2 |  |  |  |
  +--+--+--+
3 |  |  |  |
  +--+--+--+

Player O. Please enter your coordinates: 

Input: 
2,2

Output:
  1  2  3  
  +--+--+--+
1 |X |  |  |
  +--+--+--+
2 |  |O |  |
  +--+--+--+
3 |  |  |  |
  +--+--+--+

[+] Player X. Please enter your coordinates: 

Input: 
1,2

Output:
 1  2  3  
  +--+--+--+
1 |X |X |  |
  +--+--+--+
2 |  |O |  |
  +--+--+--+
3 |  |  |  |
  +--+--+--+

[+] Player O. Please enter your coordinates: 

Input:
2,1

Output:
  1  2  3  
  +--+--+--+
1 |X |X |  |
  +--+--+--+
2 |O |O |  |
  +--+--+--+
3 |  |  |  |
  +--+--+--+

[+] Player X. Please enter your coordinates: 

Input:
1,3

Output:
   1  2  3  
  +--+--+--+
1 |X |X |X |
  +--+--+--+
2 |O |O |  |
  +--+--+--+
3 |  |  |  |
  +--+--+--+

[+] GAME OVER! Player X has won!
[+] The score is now Player X: 1 | Player O: 0
[+] Input Y/y to play again, any other key to exit:

Input: 
l

Output:
[+] Thanks for playing! Goodbye!
[+] The final score isPlayer X: 1 | Player O: 0
[+] Would you like to play a new game or exit the application. Input Y/y for new game or any other key for exit: 

Input: 
y

Output:
Input 1 to play TicTacToe | Input 2 to play Order & Chaos | Input 3 to player Super TicTacToe

Input: 
3

Output: 
[+] Welcome Players! 
[+] To place a marker down, please enter the coordinate in the following format: A x,y (x = row, y = column) and A is a value between A/a - I/i
[+] A = tictactoe board in (1,1) section, B = tictactoe board in (1,2) section etc while (x, y) is the tile on that certain board section
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+] Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input: 

A 1,1

Output:
[+] This is not a valid format, please try again

Input:
A 1,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X|  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+] Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column
A 2,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X|  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| O|  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+] Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
A 1,2

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X|  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| O|  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+] Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column
A 2,2

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X|  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| O| O|  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
A 1,3

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
B 2,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | O|  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
B 1,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X|  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | O|  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
B 2,2

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X|  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | O| O|  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
B 1,2
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X|  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | O| O|  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
B 3,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X|  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | O| O|  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | O|  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
B 1,3

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
C 2,2

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  | O|  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
C 1,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | X|  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  | O|  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
C 2,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | X|  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | O| O|  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
C 1,2

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | X| X|  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | O| O|  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player O. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
C 3,1

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | X| X|  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | O| O|  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | O|  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]Player X. Please enter your coordinates in the format (A x,y) where A is a value between A/a - I/i and x = row and y = column

Input:
C 1,3

Output:
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | X| X| X| 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | X| X| X| 
+--+--+--+ +--+--+--+ +--+--+--+ 
| X| X| X| | X| X| X| | X| X| X| 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 

+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 
|  |  |  | |  |  |  | |  |  |  | 
+--+--+--+ +--+--+--+ +--+--+--+ 


[+]GAME OVER! Player X has won!
[+]The score is now Player X: 1 | Player O: 0
[+]Input Y/y to play again, any other key to exit: 

Input:
l

Output:
[+]Thanks for playing! Goodbye!
[+]The final score isPlayer X: 1 | Player O: 0
[+]Would you like to play a new game or exit the application. Input Y/y for new game or any other key for exit: 

Input:
l

Output
[+]Thanks for playing! Goodbye!

```

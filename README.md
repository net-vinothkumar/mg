#TIC TAC TOE 2.0
We want to bring the pen-and-paper game Tic-tac-toe to the digital age,
but with a little twist: the size of the playfield should be
configurable between 3x3 and 10x10. And we also want the symbols
(usually O and X) to be configurable. Also it should be for 3 players
instead of just 2.

General Rules: https://en.wikipedia.org/wiki/Tic-tac-toe

The two users will play against each other and against the computer.

Who is starting is random. In and output should be on the console.

After each move, the new state of the playfield is displayed and the
player can enter the next position of their character one after
another. The next position should be provided in a format like 3,2.

Invalid inputs are expected to be handled appropriately.

#Requirements:

- Use the programming language you feel most comfortable with
- The game takes 3 inputs:
- Size of the playground. Valid values are between 3 and 10.
- Play character 1, 2 and 3:
- A single character for the human player 1
- A single character for the human player 2
- A single character for the computer
- These configurations should come from a file
- Software design is more important than a highly developed AI
- Please put the completed assignment on GitHub.

#Rules:

- You may use external libraries only for testing or building purposes
e.g. JUnit, Gradle, Rspec, Rake, GulpJS, etc.
- Please provide an explanation how to run your code
- Please explain your design decisions and assumptions
- Don't include executables* in your submission.
- Please write your solution in a way, that you would feel comfortable
handing this over to a colleague and deploy it into production.
- We especially look at design aspects (e.g. OOP) and if the code is
well tested and understandable.

#Solution :
--------
2 Human players with computer command line based Tic-Tac-Toe game with an AI implemented using minimax with alpha-beta pruning.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

- To begin game:
```
Build the Board Game Application :
----------------------------------

./gradlew clean build

Start the Board Game Application :
----------------------------------

java -jar build/libs/tictactoe-0.0.1-SNAPSHOT.jar

Sample Tic Tac Toe Board Game Output :
--------------------------------------
---------------Tic-Tac-Toe---------------*
Please enter your position: (ex- [0,2])
 0 | 2 | 3
===+===+===
 4 | 5 | 6
===+===+===
 7 | 8 | 9

Previous TicTacToeBoard:
 X | # | #
===+===+===
 O | X | #
===+===+===
 X | _ | O

Current TicTacToeBoard:
 X | # | #
===+===+===
 O | X | #
===+===+===
 X | O | O
*---------------Tic-Tac-Toe---------------*

Game ended in a draw.
Game over. Thanks for playing.
*---------------Tic-Tac-Toe---------------*
```
## Code Structure
The code was designed specifically to fulfill the requirements for this task while providing the flexibility to change and scale if needed to.
```
Board.java and Minimax.java
```
are the blueprint for any game to be created that wishes to use another variation of board and that also wishes to apply the Minimax algorithm as an Computer player.

### TicTacToeGame.java:
This is the driver class as well as the user facing class. This class instantiates all the required components.
This class contains all functionalities that relate to the command line (i/o).
### TicTacToeBoard.java:
This is the implementation of board specifically for tic-tac-toe.
In here, it implements the required methods as laid forth by the interface.
In the second half of the file, It define for Minimax what it means to win the game (how scoring works) and how pieces move (getSuccessors).

## Minimax with Alpha Beta Pruning
For the computer player, Its implemented a variation of the minimax algorithm with alpha beta pruning.

The motivation for applying alpha-beta pruning is to disregard states (iterations) that is already known to the algorithm to not be chosen.
This can significantly reduce the number of iterations in the minimax algorithm.


# Pending Tasks / Improvements:
------------------------------
1. Support for multiple field size from 3 by 3 to 10 by 10.
2. Test cases should be written.
3. OO design should be improved.
4. Package structure should be improved.
5. All the configurations should be read from the properties file rather than hard coded in code.


### Sudoku

##Sudoku implementation in Java

‘Sudoku is a single-player game. "The objective is to fill a 9×9 grid with digits 1 to 9, so that each column, each row, and each of the nine 3×3 sub-grids contains all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a well-posed puzzle has a unique solution." ’

##Soft Requirements (Subject to Change):  
9x9 grid created in a simple GUI at the very least (ie printing | and _ to create the grids)
Randomly generated puzzle with variable number of empty spaces per sub-grid
Make a solution for generated puzzle (may have multiple solutions so multiple states may be required)
Maintain track of user input
Verify user input against generated solution(s) per input
Maintain track of selected position on board
(Optional)  debugging mode to show solution <- would make life a lot easier for us.
A Readme file documenting how to run the program

##Technical Requirements (In Progress):
Object for each subgrid 
Methods for each criterion for success

##Initial Problems:
For each sub-grid how many empty positions are we going to have.
The GUI - how complex should we make it. Keep in mind that the if it's an event driven GUI  ( ie clicking buttons) it would be so much more easier to test.
Multiple solutions - we should make the randomly generated code only have one possible solutions. It would simplify the scope of the project so we don't have to account for multiple states.
For the solution itself we need to track success based on each individual sub-grid and each row and column
	
	
Useful links:
http://mrbool.com/how-to-implement-java-code-for-making-a-mind-game-sudoku/27013   - only for reference
http://www.vogella.com/tutorials/EclipseGit/article.html
https://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2FgettingStarted%2Fqs-3.htm
http://fileadmin.cs.lth.se/cs/Education/EDA040/common/java21.pdf


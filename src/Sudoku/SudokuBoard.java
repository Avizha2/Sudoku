package Sudoku;

import java.util.Random;

public class SudokuBoard {
	private int randStart;
	private gridSpace[][] board;
	
	public SudokuBoard ()
	{
		board = new gridSpace[9][9];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board[i][j].num ='0';
				board[i][j].hidden = false;
				board[i][j].rowNum = j + 1;
				board[i][j].colNum = i + 1;
			}
		}
			
	}
	
	//let me know if this algorithm makes sense to you guys, i had to build it and its kinda sloppy
	int findsubGridNum(int i, int j) {
		for(int x = 1; x <= 3; x++) {
		if(i > 3 * x) {
			if(j < 3)
				return 1 + x*(x-1);
			if(j < 6)
				return 2 + x*(x-1);
			if(j < 9)
				return 3 + x*(x-1);
		}}
		return 0;
	}
	
	
	void draw () {
		//draw 9*9 board
	}
		
	void populate (){//solution sol) {
		//randomly select 6 numbers in each box to populate board with
	}
	
	int randGen() {
		//generating random number 1-9
	    Random rand = new Random();
	    int randnum = rand.nextInt((9 - 1) + 1) + 1;
	    return randnum;
	}
	//generate random solution
	/* commented out to get rid of errors
	void check(location loc, response res) {
		//checks answer to solution
	}*/
}

class gridSpace {
	char num;
	boolean hidden;
	int colNum, rowNum, subGrid;
}


package Sudoku;

//Samrudhi Vaghmare, 651085488
//Sriya Potham, 678480010
//Alex Vizhalil, 673129827

//SUDO CODE
//ugh

import java.util.Random;
import java.awt.*;

public class sudoku {
	static boolean debugMode = false;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
} 

class board {
	private int rows;
	private int cols;
	private int randStart;
	
	public board()
	{
		rows = 9;
		cols = 9;
		
	}
	void draw () {
		//draw 9*9 board
	}
	
	void populate (solution sol) {
		//randomly select 6 numbers in each box to populate board with
	}
}

class solution{
	
	int numbers() {
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

class environment {
	//generate environment
	//includes background, buttons
}


class play{
	//
}

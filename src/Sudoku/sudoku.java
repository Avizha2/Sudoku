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
		SudokuBoard s = new SudokuBoard();
		SudokuBoard solved = s;
		s.draw();
		s.emptyCells();
		GUI game = new GUI(s);
		System.out.println("To play this game please enter the correct number into each sudoku cell and press enter");
		System.out.println("Red is wrong | Green is correct");
	}
} 


package Sudoku;

import java.util.*;

public class SudokuBoard {
	public Cell[][] board;
	
	public SudokuBoard ()
	{
		board = new Cell[9][9];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board[i][j] = new Cell();
			}
		}
		generate(0,0);
	}
	
	public SudokuBoard(SudokuBoard solved)
	{
		this.board = solved.board;
	}
	

	//method to place numbers in a cells randomly
	public boolean generate(int x, int y){
		int nextX = x;
		int nextY = y;
		char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		Random r = new Random();
		char temp = '0';
		int cur = 0;
		int top = nums.length;

   		for(int i=top-1;i>0;i--){
		    cur = r.nextInt(i);
		    temp = nums[cur];
		    nums[cur] = nums[i];
		    nums[i] = temp;
    	}
		
		for(int i=0;i<nums.length;i++){
			if(checker(x, y, nums[i])){
				board[x][y].num = nums[i];
				board[x][y].rowNum = y + 1;
				board[x][y].colNum = x + 1;
				board[x][y].subGrid = findsubGridNum(x,y);
				if(x == 8){
					if(y == 8)
						return true;
					else{
						nextX = 0;
						nextY = y + 1;
					}
				}
				else {
					nextX = x + 1;
				}
				if(generate(nextX, nextY))
					return true;
			}
		}
		board[x][y].num = '0';
		return false;
	}
	
	//checks if placement is valid 
	private boolean checker(int x, int y, char cur) {
		for(int i=0;i<9;i++){
			char test = board[x][i].num;
			if(cur == test)
				return false;
		}
		for(int i=0;i<9;i++){
			if(cur == board[i][y].num)
				return false;
		}
		int gridVertex_X = 0;
		int gridVertex_Y = 0;
		if(x > 2)
			if(x > 5)
				gridVertex_X = 6;
			else
				gridVertex_X = 3;
		if(y > 2)
			if(y > 5)
				gridVertex_Y = 6;
			else
				gridVertex_Y = 3;
		for(int i=gridVertex_X;i<10 && i<gridVertex_X+3;i++)
			for(int j=gridVertex_Y;j<10 && j<gridVertex_Y+3;j++)
				if(cur == board[i][j].num)
					return false;
		return true;
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
	//replace completed board with "empties" 0s
	public void emptyCells(){
		int empties = 20;
		double subgrids = 81;
		double cells = (double)empties;
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++){
				double probabilityCell = cells/subgrids;
					if(Math.random() <= probabilityCell){
						board[i][j].hidden = true;
						cells--;
					}
					subgrids--;
				}
		}
			
	//prints board
	public void draw(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j].num + "  ");
			}
		System.out.println();
		}
	System.out.println();
	}
}

class Cell {
	char num;
	boolean hidden;
	int colNum, rowNum, subGrid;	
	
	public Cell() {
        num = 'x';
        hidden = false;
        colNum = rowNum = subGrid = 0;
    }
}


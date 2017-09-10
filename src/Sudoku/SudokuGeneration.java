package Sudoku;
import java.util.*;
import java.text.*; 
	
public class SudokuGeneration {
	public static final int NUM_ROWS = 9;
	public static final int NUM_COLS = 9;
	int[][] board;
	private int operations;
	  
		public SudokuGeneration() {
			board = new int[NUM_ROWS][NUM_COLS];
		}

		public int[][] nextBoard(){
			board = new int[NUM_ROWS][NUM_COLS];
			nextCell(0,0);
			//emptyCells();
			return board;
		}
		public SudokuGeneration(SudokuGeneration solved)
		{
			this.board = solved.board;
		}
		
		//method to place numbers in a cells randomly
		public boolean nextCell(int x, int y){
			int nextX = x;
			int nextY = y;
			int[] options = {1,2,3,4,5,6,7,8,9};
			Random r = new Random();
			int temp = 0;
			int cur = 0;
			int top = options.length;

	   		for(int i=top-1;i>0;i--){
			    cur = r.nextInt(i);
			    temp = options[cur];
			    options[cur] = options[i];
			    options[i] = temp;
	    	}
			
			for(int i=0;i<options.length;i++){
				if(checker(x, y, options[i])){
					board[x][y] = options[i];
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
					if(nextCell(nextX, nextY))
						return true;
				}
			}
			board[x][y] = 0;
			return false;
		}
		
		//checks if placement is valid 
		private boolean checker(int x, int y, int cur) {
			for(int i=0;i<9;i++){
				if(cur == board[x][i])
					return false;
			}
			for(int i=0;i<9;i++){
				if(cur == board[i][y])
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
					if(cur == board[i][j])
						return false;
			return true;
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
						board[i][j] = 0;
						cells--;
					}
					subgrids--;
				}
		}
		
		//prints board
		public void print(){
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++)
					System.out.print(board[i][j] + "  ");
				System.out.println();
			}
			System.out.println();
		}
		
		public static void main(String[] args){
			SudokuGeneration sg = new SudokuGeneration();
			sg.nextBoard();
			SudokuGeneration unsolved = new SudokuGeneration(sg);
			
			sg.print();
			unsolved.emptyCells();
			unsolved.print();
			sg.print();
		}
	}
	


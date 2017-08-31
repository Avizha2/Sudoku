//Sam
//Sriya
//Alex

//SUDO CODE
import java.util.Random;

class board {
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
	
	void check(location loc, response res) {
		//checks answer to solution
	}
	
}

class environment {
	//generate environment
	//includes background, buttons
}


class play{
	//
}

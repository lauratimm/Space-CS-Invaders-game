import java.util.*;
// The avatar class creates a ship initially located in row; 9 and column; 5.
// It assigns 'S' to the ship as the identifying letter.
// There are getter methods for all instance variables.
// And two method to either move the ship Up/Down or Left/Right.
public class Avatar{
	
	// instance variables
	private char name = 'S';
	private int row = 9;
	private int column = 5;

	// gets the letter assigned to the ship
	public char getName() {
		return this.name;
	}
	
	// gets the row of the ship
	public int getRow(){
		return this.row;
		}

	// get the column of the ship
	public int getColumn(){
		return this.column;
		}

	// moves the ship up or down, based on input; by changing the row
	public int moveShipUD(char input, int row, int column) {
		if (input == 'w') {
			row -= 1;
		}
		else if (input == 's') {
			row += 1;
		}
		return row;
	  	}
	
	// moves the ship left or right based on input, by changing the column
	public int moveShipLR(char input, int row, int column) {
		if (input == 'd') {
			column += 1;
		}
		else if (input == 'a') {
			column -= 1;
		}
		return column;
		}
	}

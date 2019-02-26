import java.util.*;

// The class creates a grid of objects, and has methods to remove, place, and get objects
// It also has a method to print the board
// The main method runs the game
public class Space_Board {
	
	// instance variables
	public char[][] grid = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R1
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R2
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},	//R3
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R4
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R5
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R6
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R7
				 	 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R8
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R9
					 		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}}; //R10
				   		  	//C 1   2   3   4   5   6   7   8   9   10  11
	// default constructor
	public Space_Board(){
	}
	
	// copy constructor
	public Space_Board(Space_Board board){
		Space_Board newBoard = new Space_Board();
		this.grid = board.grid;
	}

	// this method places a specified object on the specified row and column
	public void placeObject(char object, int row, int column) {
		grid[row][column] = object;
	}

	// this method removes a object from the specified row and column
	public void removeObject(int row, int column) {
		grid[row][column] = ' ';
	}
	
	// this method gets the letter of the object on the specified row and column
	public char getObject(int row, int column){
		return grid[row][column];
	}

	// this method prints the grid
	public void print(){
		for (int row = 0; row < 10; row++){
			for (int column = 0; column < 11; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}

	// this is the main method 
	public static void main(String [] args){
		// creates Enemies object, Space_Board object (with random enemies), and Avatar object, and Scanner
		Enemies enemy = new Enemies();
		Space_Board board = new Space_Board(enemy.generateEnemies());
		Avatar ship = new Avatar();
		Scanner reader = new Scanner(System.in);
		
		
		// sets the ship's row and column by using getter methods of Avatar
		int ship_row = ship.getRow();
		int ship_column = ship.getColumn();
		
		// place the ship on the board and print the base board with only the enemies and ship
		board.placeObject(ship.getName(), ship_row, ship_column);
		board.print();
		
		int maxEnemies = 5; 
		
		// as long as there are enemies alive, keep running the program
		while (maxEnemies > 0){
			// get input from the user
			char c = reader.next().charAt(0);
			
			// moving the ship up or down
			if (c=='w' || c=='s'){

				// if the requested position where the ship will move is out of bounds request another input
				if (ship_row <= 7 && c=='w') {
					System.out.println("The ship can't move higher");
				}
				else if (ship_row >= 9 && c=='s') {
					System.out.println("The ship can't move lower");
				}
				
				// if the position is within the board, remove the ship from the initial place and add it to the requested place
				else {
					board.removeObject(ship_row , ship_column);
					ship_row = ship.moveShipUD(c,ship_row,ship_column);
					board.placeObject('S', ship_row,ship_column);
					board.print();
					}
				}
			
			// moving the ship left or right
			else if (c=='d'||c=='a') {

				// if the requested position where the ship will move is out of bounds request another input
				if (ship_column <= 0 && c=='a') {
					System.out.println("The ship can't more right");
				}
				else if (ship_column >= 10 && c == 'd') {
					System.out.println("The ship can't move left");
					}
				
				// if the position is within the board, remove the ship from the initial place and add it to the requested place
				else {
					board.removeObject(ship_row , ship_column);
					ship_column = ship.moveShipLR(c,ship_row,ship_column);
					board.placeObject('S', ship_row,ship_column);
					board.print();
					}
				}
			
			// shooting the bullet
			else if (c== 'l'){

				// create variables for the bullet's row and column
				int bullet_row = ship_row-1;
				int bullet_column = ship_column;
				
				// create variable for when bullet disappears
				boolean empty = false;
				
				// while the bullet has not hit anything keep running the loop
				while (empty == false){
					
					// if the bullet will go out of bounds, report that the bullet did not collide with anything
					if (bullet_row <= -1) {
						System.out.println("The bullet didn't hit anything");
						empty = true;
						board.removeObject(bullet_row+1, bullet_column);
						}
					
					// if the space above the bullet is empty, move the bullet up once and remove previous bullet
					else if (board.getObject(bullet_row, bullet_column) == ' '){
						board.placeObject('|', bullet_row, bullet_column);
						if (board.getObject(bullet_row+1, bullet_column)=='|'){
							board.removeObject(bullet_row+1, bullet_column);
						}
						board.print();
						bullet_row-=1;
						}

					// if there is an enemy in the space above the bullet, remove the enemy and bullet
					else{
						board.removeObject(bullet_row,bullet_column);
						board.removeObject(bullet_row+1, bullet_column);
						empty = true;
						maxEnemies -= 1;
						}
					}
				board.print();
				}
			
			// if user wants to exit the game, change the number of enemies to 0 to exit the loop
			else if (c=='p') {		
				maxEnemies = 0;
			}

			// if something unrecognizable is input, show the user the instructions
			else {
				System.out.println("Use 'wasd' to move and 'l' to shoot, 'p' to quit");
				}
			}
		// if enemies are all gone end the game
		System.out.println("You Won!");
		}
	}

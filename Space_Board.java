import java.util.*;
public class Space_Board {
	public char[][] grid = {{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R1
					 				 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R2
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},	 //R3
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R4
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R5
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R6
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R7
				 	 		 	 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R8
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R9
					 			 	 {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}}; //R10
				   		  	//C 1   2   3   4   5   6   7   8   9   10  11
public Space_Board(){

}
	public Space_Board(Space_Board board){
		Space_Board newBoard = new Space_Board();
		this.grid = board.grid;
	}

	public void placeObject(char object, int row, int column) {
		grid[row][column] = object;
	}

	public void removeObject(int row, int column) {
		grid[row][column] = ' ';
	}
	public char getObject(int row, int column){
		return grid[row][column];
	}

public void print(){
		for (int row = 0; row < 10; row++){
			for (int column = 0; column < 11; column++){
				System.out.print(grid[row][column]);
			}
			System.out.println();
		}
	}


public static void main(String [] args){
	Enemies any = new Enemies();
	Space_Board grix = new Space_Board(any.generateEnemies());
	int ship_row = 9;
	int ship_column = 5;
	grix.placeObject('S', ship_row, ship_column);

	grix.print();
	Scanner reader = new Scanner(System.in);
	
	Avatar one = new Avatar();
	int maxEnemies = 5; //this should be change to 5 if only doing five enemies
	while (maxEnemies > 0){
		char c = reader.next().charAt(0);
	if (c=='w' || c=='s'){
			grix.removeObject(ship_row , ship_column);
			ship_row = one.moveShipUD(c,ship_row,ship_column);
			grix.placeObject('S', ship_row,ship_column);
			grix.print();

	}
	else if (c=='d'||c=='a') {
		grix.removeObject(ship_row , ship_column);
		ship_column = one.moveShipLR(c,ship_row,ship_column);
		grix.placeObject('S', ship_row,ship_column);
		grix.print();
	}
	else if (c== 'l'){
		int bullet_row = ship_row-1;
		int bullet_column = ship_column;
		boolean empty = false;
		while (empty == false){
			if (grix.getObject(bullet_row, bullet_column) == ' '){// the problem is around here, since both the ship and bullet use the same row and colmn variable
				grix.placeObject('|', bullet_row, bullet_column);
			if (grix.getObject(bullet_row+1, bullet_column)=='|'){
				grix.removeObject(bullet_row+1, bullet_column);
				
		}
			grix.print();
		bullet_row-=1;
	}
	else{
		grix.removeObject(bullet_row,bullet_column);
		grix.removeObject(bullet_row+1, bullet_column);

		empty = true;
		maxEnemies -= 1;
	}

}
		
	grix.print();

}
	else if (c=='p') {
		
	}
	else {
		System.out.println("Use 'wasd' to move and 'l' to shoot, 'p' to quit");
	}

	if (c=='p') {
		maxEnemies = 0;
	}
	else {
	}
}
	System.out.println("You Won!");
}
}

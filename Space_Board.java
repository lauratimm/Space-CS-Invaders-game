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
	int row = 9;
	int column = 5;
	grix.placeObject('S', row,column);

	grix.print();
	Scanner reader = new Scanner(System.in);
	char c = reader.next().charAt(0);
	Avatar one = new Avatar();
	int maxEnemies = 15; //this should be change to 5 if only doing five enemies
	while (maxEnemies > 0){

	if (c=='w' || c=='s'){
			grix.removeObject(row , column);
			row = one.moveShipUD(c,row,column);
			grix.placeObject('S', row,column);
			grix.print();

	}
	else if (c=='d'||c=='a') {
		grix.removeObject(row , column);
		column = one.moveShipLR(c,row,column);
		grix.placeObject('S', row,column);
		grix.print();
	}
	else if (c== 'l'){
		boolean empty = false;
		while (empty == false){
			if (grix.getObject(row-1, column) == ' '){// the problem is around here, since both the ship and bullet use the same row and colmn variable
				grix.placeObject('|', row-1, column);
				grix.print();
			if (grix.getObject(row, column)=='|'){
				grix.removeObject(row, column);
		}
		row-=1;
	}
	else{
		grix.removeObject(row-1, column);
		grix.removeObject(row,column);

		empty = true;
		maxEnemies -= 1;
	}

}
	grix.print();

}
c = reader.next().charAt(0);
}
}
}

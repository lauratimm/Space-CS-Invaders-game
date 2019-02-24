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
	grix.removeObject(9,5);

	if (c=='w' || c=='s'){
	row = one.moveShipUD(c,row,column);
}
else if (c=='d'||c=='a') {
	column = one.moveShipLR(c,row,column);

}
	grix.placeObject('S', row,column);
	grix.print();
}
}

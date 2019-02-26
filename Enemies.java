import java.util.Random;
// Enemies class creates a group of enemies located within rows 1-7 of the space board grid and columns 1-11
// By extending the space board class

public class Enemies extends Space_Board {
	
	//instance variables
	char alien = 'Z';
	int MAXENEMIES = 5;
	int ROW = 6;
	int COLUMN =10;

	// randomly generates 'MAXENEMIES' enemies by extending Space_Board  
	public Space_Board generateEnemies(){
		Random rand = new Random();
		int enemies = 0;
		Space_Board grid = new Space_Board();
		while (enemies<MAXENEMIES){
			int row = rand.nextInt(ROW);
			int column = rand.nextInt(COLUMN);
			if (grid.getObject(row,column)== ' '){
				grid.placeObject(alien, row, column);
				enemies++;
			}
		}
		return grid;
		}
	}

package Text;

import Logic.Enemy_Logic;

/**
 * This class is for the enemies in our game and it extends off
 * the logic Enemy_Logic class.
 * they are represented by the char 'E' in our text version of the game
 * The methods in this class controls the random placement of the enemies
 */
public class Enemy_Text extends Enemy_Logic{
	final private int X_BOUNDS = 7; //a constant used so that the enemies will spawn in bounds
	final private int Y_BOUNDS = 6; //a constant used so that the enemies will spawn in bounds
	private int num_Enemies = 5;
	private char enemy_Char = 'E';
	/**
	 * Constructor create a enemy with the the coordinates used from the logic
	 * Enemy_Logic class, using gridErrorCheck to make sure the are not 0 or the max values
	 * 
	 * @param x_coordinate The x coordinate from the logic Enemy_Logic class.
	 * @param y_coordinate The y coordinate from the logic Enemy_Logic class.
	 */
	public Enemy_Text(int x_coordinate, int y_coordinate) {
		super(x_coordinate,y_coordinate);
		gridErrorCheck();
	}
	/**
	 * Gets the character which is used for the enemy
	 * 
	 * @return enemy_Char Which is used as the enemy in the text game
	 */
	public char getEnemy_Char() {
		return enemy_Char;
	}
	/**
	 * Sets the location of the enemies using a loop from 0 to num_Enemies
	 * if the random coordinate give the object '.' then an enemy is placed at that location
	 * if it is something else the loop runs again and new coordinates are generated
	 * when an enemy is places, it resets a new random x and y coordinate which is error checked with
	 * the gridErrorCheck method and then used for the next enemy in the loop.
	 * 
	 * @param grid Is used to place the char on the game board at the random location generated
	 * by Math.random
	 */
	public void placeEnemies(Grid_Text grid) {
		int counter = 0;
		while (counter < num_Enemies) {
			if (grid.getObject(super.getY_coordinate(), super.getX_coordinate()) == '.') {
				grid.placeObject(getEnemy_Char(), super.getY_coordinate(), super.getX_coordinate());
				counter++;
			}
			setX_coordinate((int) (Math.random() * X_BOUNDS));
			setY_coordinate((int) (Math.random() * Y_BOUNDS));
			gridErrorCheck();
		}
		grid.print();
	}
	/**
	 * This method checks the random x and y coordinates and makes sure that they are
	 * not 0, X_BOUNDS, or Y_BOUNDS, if they are are it sets them to 1
	 */
	public void gridErrorCheck() {
		while (super.getX_coordinate() == 0 || super.getX_coordinate() == X_BOUNDS) {
			super.setX_coordinate(1);
		}
		while (super.getY_coordinate() == 0 || super.getY_coordinate() == Y_BOUNDS) {
			super.setY_coordinate(1);
		}

	}
	
}

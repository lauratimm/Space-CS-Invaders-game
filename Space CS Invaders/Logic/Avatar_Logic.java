package Logic;

/**
 * This class is the logic base for the ship in both the text based
 * and GUI versions. It contains methods for movement as well as methods
 * to determine what actions the avatar should take.
 */
public class Avatar_Logic {
	final int DELETE_COORD = -1000;
	final int RIGHT_BOUNDS = 540;
	final int BOTTOM_BOUNDS = 740;
	private int x_coordinate = 0;
	private int y_coordinate = 0;
	private int movement = 10;
	private int enemies_killed = 0;
	private int life = 5;
	private boolean avatar_hit = false;
	private boolean shoots = false;

	/**
	 * This constructor creates an avatar with a location.
	 * 
	 * @param x_coordinate The x coord for Avatar_Logic.
	 * @param y_coordinate The y coord for Avatar_Logic.
	 */
	public Avatar_Logic(int x_coordinate, int y_coordinate) {
		setX_coordinate(x_coordinate);
		setY_coordinate(y_coordinate);
	}

	/**
	 * This getter method returns the x coordinate of the avatar
	 * 
	 * @return x_coordinate Which is used to place the Avatar_Logic.
	 */
	public int getX_coordinate() {
		return x_coordinate;
	}
	
	/**
	 * This getter method returns the y coordinate of the avatar
	 * 
	 * @return y_coordinate Which is used to place the Avatar_Logic.
	 */
	public int getY_coordinate() {
		return y_coordinate;
	}
	
	/**
	 * This getter method gets the int amount the avatar should move
	 * each time
	 * 
	 * @return movement Which is the amount the Avatar_Logic moves each time.
	 */
	public int getMovement() {
		return movement;
	}
	
	/**
	 * This getter method gets the number of enemies the avatar has killed
	 * 
	 * @return enemies_killed The number of enemies the user has killed.
	 */
	public int getEnemies_killed() {
		return enemies_killed;
	}
	
	/**
	 * This getter method gets the number of lives the avatar has
	 * 
	 * @return life The number of lives the Avatar_Logic has remaining.
	 */
	public int getLife() {
		return life;
	}

	/**
	 * This getter method gets if the avatar should shoot or not
	 * 
	 * @return shoots Which is true if the Avatar_Logic should continue shooting and
	 * false otherwise.
	 */
	public boolean getShoots() {
		return shoots;
	}

	/**
	 * This setter method sets the x coordinate of the avatar
	 * 
	 * @param x_coordinate The x coord for Avatar_Logic.
	 */
	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}

	/**
	 * This setter method sets the y coordinate of the avatar
	 * 
	 * @param y_coordinate The y coord for Avatar_Logic.
	 */
	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}

	/**
	 * This setter method sets the amount the avatar will move each time
	 * 
	 * @param movement Sets how much the Avatar_Logic will move.
	 */
	public void setMovement(int movement) {
		this.movement = movement;
	}	

	/**
	 * This setter sets the number of enemies the avatar has killed
	 * 
	 * @param add_Enemies_Killed Esed to increase the number of enemies the
	 * user has killed.
	 */
	public void setEnemies_killed(int add_Enemies_Killed) {
		if (add_Enemies_Killed >= 0) {
			enemies_killed = add_Enemies_Killed;
		}
		else {
			enemies_killed = 0;
		}
	}

	
	/**
	 * This sets whether the avatar can shoot or not
	 * 
	 * @param shoots Sets whether or not the ship shoots a bullet.
	 */
	public void setShoots(boolean shoots) {
		this.shoots = shoots;
	}

	/**
	 * This returns if avatar is hit or not
	 * 
	 * @return avatar_hit Which is a boolean for if the avatar has been shot by
	 * an enemy.
	 */
	public boolean isAvatar_hit() {
		return avatar_hit;
	}

	/**
	 * This method changes the x and y coordinates to a location 
	 * out of view of the screen.
	 */
	public void delete() {
		setX_coordinate(DELETE_COORD);
		setY_coordinate(DELETE_COORD);
	}

	/**
	 * This method move the avatar left
	 * If the x coorinate is within the bounds of the screen, moves the ship
	 * left by subtracting the value stored in movement from the x coordinate
	 * of Avatar_Logic.
	 */
	public void moveLeft() {
		if (getX_coordinate()> 0) {
			setX_coordinate(getX_coordinate() - getMovement());
		}
	}

	/**
	 * This method moves the avatar right
	 * If the x coorinate is within the bounds of the screen, moves the ship
	 * right by adding the value stored in movement to the x coordinate
	 * of Avatar_Logic.
	 */
	public void moveRight() {
		if (getX_coordinate() < RIGHT_BOUNDS) {
			setX_coordinate(getX_coordinate() + getMovement());
		}
	}

	/**
	 * This method moves the avatar up
	 * If the y coorinate is within the bounds of the screen, moves the ship
	 * up by subtracting the value stored in movement from the y coordinate
	 * of Avatar_Logic.
	 */
	public void moveUp() {
		if (getY_coordinate() > 0) {
			setY_coordinate(getY_coordinate() - getMovement());
		}
	}

	/**
	 * This method moves the avatar down
	 * If the y coorinate is within the bounds of the screen, moves the ship
	 * down by adding the value stored in movement to the y coordinate
	 * of Avatar_Logic.
	 */
	public void moveDown() {
		if (getY_coordinate() < BOTTOM_BOUNDS) {
			setY_coordinate(getY_coordinate() + getMovement());
		}
	}
}

package Text;

import Logic.Bullet_Logic;

/**
 * This class is for the bullet for our game and it extends off
 * the logic Bullet_Logic class.
 * It is represented by the char '|' in our text version of the game
 * The methods in this class control the movement of the bullet and removes
 * an enemy when the bullet intersects with it
 * */
public class Bullet_Text extends Bullet_Logic {
	private char bullet_Char = '|';
	/**
	 * Constructor create a bullet with the instance bullet_Char.
	 * 
	 * @param x_coordinate The x coordinate from the logic Bullet_Logic class.
	 * @param y_coordinate The y coordinate from the logic Bullet_Logic class.
	 */
	public Bullet_Text(int x_coordinate, int y_coordinate) {
		super(x_coordinate, y_coordinate);
	}
	/**
	 * Gets the character which is used for the bullet
	 * 
	 * @return bullet_Char Which is used as the bullet in the text game
	 */
	public char getBullet_Char() {
		return bullet_Char;
	}
	/**
	 * This method moves a bullet from the avatars location upward until
	 * it either hits an enemy or goes out of bounds then it removes
	 * the bullet from the board and the enemy if it is hit.
	 * 
	 * @param grid Is used to get information from the game board
	 * @param avatar Is used to get the number of enemies and set a new enemy count if one
	 * is hit
	 */
	public void shoot(Grid_Text grid, Avatar_Text avatar) {
		boolean enemy_hit = true;
		grid.placeObject(getBullet_Char(), getY_coordinate(), getX_coordinate());
		grid.print();
		while ((enemy_hit)) {
			if ((grid.getObject(getY_coordinate() - 1, getX_coordinate()) == 'E')) {
				enemy_hit = false;
				super.setY_coordinate(super.getY_coordinate() - 1);
				grid.placeObject(getBullet_Char(), getY_coordinate(), getX_coordinate());
				grid.removeObject(super.getY_coordinate() + 1, super.getX_coordinate());
				grid.removeObject(super.getY_coordinate(), super.getX_coordinate());
				grid.print();
				avatar.setEnemies_killed(avatar.getEnemies_killed() + 1);
			}
			else {
				super.setY_coordinate(super.getY_coordinate() - 1);
				grid.placeObject(getBullet_Char(), getY_coordinate(), getX_coordinate());
				grid.removeObject(super.getY_coordinate() + 1, super.getX_coordinate());
				grid.print();
			}
			if (grid.getObject(getY_coordinate() - 1, getX_coordinate()) == '#') {
				enemy_hit = false;
				grid.removeObject(super.getY_coordinate() + 1, super.getX_coordinate());
				grid.removeObject(super.getY_coordinate(), super.getX_coordinate());
				grid.print();
			}

		}
	}
}

import java.util.ArrayList;
import javafx.scene.image.Image;

//This class creates and Enemy by extending Character. There are methods
//which move the Enemy randomly, and makes them shoot.
public class Enemy extends Character{

	// Instance Variables
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>(); // An Array List of enemies

	static final int doesEnemyShoot = 0.01;

	// The only constructor, which creates an Enemy based on the constructor
	// in Character
	public Enemy(int xCoord, int yCoord, int width, int height, String type, Image image) {
		super(xCoord, yCoord, width, height, type, image);
		}

	// Getter method for the enemy list
	public ArrayList<Enemy> getEnemyList(){
		return enemyList;
	}

	// Method which moves the Enemy randomly
	public void moveRan(){
		double randomNum = Math.random();
		if (randomNum < 0.25 && getX() > 0){
			setX(getX() - 3);
			}
		else if (randomNum < 0.5 && getX() < 600){
			setX(getX() + 3);
			}
		else if (randomNum < 0.75 && getY() > 0){
			setY(getY() - 3);
			}
		else if (randomNum < 0.99 && getY() < 500){
			setY(getY() + 3);
			}
		}

	// Adds the specified enemies into a list
	public void setEnemyList(Enemy enemy1, Enemy enemy2, Enemy enemy3, Enemy enemy4, Enemy enemy5){
			enemyList.add(enemy1);
			enemyList.add(enemy2);
			enemyList.add(enemy3);
			enemyList.add(enemy4);
			enemyList.add(enemy5);
			}

	// Method which randomly decides whether the enemy shoots or not
	public boolean enemyShoot() {
		boolean shoot = false;
		if (Math.random() < doesEnemyShoot && !this.dead) {
				shoot = true;
			}
		return shoot;
		}
}

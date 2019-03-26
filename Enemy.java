import java.util.ArrayList;
import javafx.scene.image.Image;

/*This class creates and Enemy by extending Character. There are methods
  which move the Enemy randomly, and makes them shoot. */
public class Enemy extends Character{

	// Instance Variables
	static final double doesEnemyShoot = 0.01;
	static final double doesBossShoot = 0.1;
	static final int boundary_y = 400;
	static final int boundary_x = 500;
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>(); // An Array List of enemies

	// This constructor is for the boss which extends off enemy
	public Enemy(int xCoord, int yCoord, int width, int height, String type, Image image) {
		super(xCoord, yCoord, width, height, type, image);
		}

	// This constructor allows the enemies to move randomly
	public Enemy(int width, int height, String type, Image image) {
		super(width, height, type, image);
		setX(Math.random() * boundary_x);
		setY(Math.random() * boundary_y);
	}

	public ArrayList<Enemy> getEnemyList(){
		return enemyList;
	}

	// Method which moves the Enemy randomly
	public void moveRan(){
		double r = Math.random();
		if (r < 0.25 && getX() > 0){
			setX(getX() - 3);
			}
		else if (r < 0.5 && getX() < 600){
			setX(getX() + 3);
			}
		else if (r < 0.75 && getY() > 0){
			setY(getY() - 3);
			}
		else if (r < 0.99 && getY() < 500){
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
		if (Math.random() < doesEnemyShoot && !this.getDead()) {
				shoot = true;
		}
		return shoot;
	}
	
	// Method which randomly decides whether the boss shoots or not
	public boolean bossShoot() {
		boolean shoot = false;
		if (Math.random() < doesBossShoot && !this.getDead()) {
				shoot = true;
		}
		return shoot;
	}
}

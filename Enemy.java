import java.util.ArrayList;
import javafx.scene.image.Image;

//This class creates and Enemy by extending Character. There are methods
//which move the Enemy randomly, and makes them shoot.
public class Enemy extends Character{
	
	// Instance Variables 
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>(); // An Array List of enemies
	
	// The only constructor, which creates an Enemy based on the constructor
	// in Character
	public Enemy(int x, int y, int w, int h, String t, Image image) {
		super(x, y, w, h, t, image);
		}
	
	// Getter method for the enemy list
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
	public void setEnemyList(Enemy e1, Enemy e2, Enemy e3, Enemy e4, Enemy e5){
			enemyList.add(e1);
			enemyList.add(e2);
			enemyList.add(e3);
			enemyList.add(e4);
			enemyList.add(e5);
			}
	
	// Method which randomly decides whether the enemy shoots or not
	public boolean enemyShoot() {
		boolean shoot = false;
		if (Math.random()<0.01) {
			if (!this.dead) {
				shoot = true;
				}
			}
		return shoot;
		}
	}

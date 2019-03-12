import java.util.ArrayList;

import javafx.scene.image.Image;

public class Enemy extends Character{
	int numE = 5;
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

	public Enemy(int x, int y, int w, int h, String t, Image image) {
		super(x, y, w, h, t, image);
		
	}
	
	//public void numEnemies() {
		

	// Enemy Movements (random)
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
	
	public void setEnemyList(Enemy e1, Enemy e2, Enemy e3, Enemy e4, Enemy e5){
			enemyList.add(e1);
			enemyList.add(e2);
			enemyList.add(e3);
			enemyList.add(e4);
			enemyList.add(e5);
	}
	public ArrayList<Enemy> getEnemyList(){
		return enemyList;
	}
	
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

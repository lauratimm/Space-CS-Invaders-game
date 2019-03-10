import java.util.ArrayList;

import javafx.scene.image.Image;

public class Enemy extends Character{

	public Enemy(int x, int y, int w, int h, String t, Image image) {
		super(x, y, w, h, t, image);
		
	}
	
	//public void numEnemies() {
		

	// Enemy Movements (random)
	public void moveRan(){
		
		double r = Math.random();
	    
		if (r < 0.25 && getX() > 0){
			setX(getX() - 4);
			}
		else if (r < 0.5 && getX() < 600){
			setX(getX() + 4);
			}
		else if (r < 0.75 && getY() > 0){
				setY(getY() - 4);
		}
		else if (r < 0.99 && getY() < 500){
			setY(getY() + 4);
		}
	}
	
	public void delete() {
		setFitWidth(1);
		setFitHeight(1);
		setX(-100);
		setY(-100);
	}
	
	
}
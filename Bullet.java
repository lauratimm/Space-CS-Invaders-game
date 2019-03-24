import java.util.ArrayList;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

//This class creates a Bullet object. The class extends Rectangle.
//When a Bullet is created, the width, height and color are used by the Rectangle
//parent class and and x and y coordinates of the object, and a String are assigned
//to the Bullet object. The class has methods to move the bullet up, down
//and for when Avatar shoots
public class Bullet extends Rectangle {

	// Instance Variables
	static final int bulletUp = 5;
	static final int bulletDown = 3;
	private String type; // indicates the name of the object

	// The constructor creates a Bullet with width, height, and color by
	// calling rectangle and assigns an x and y coordinate to the rectangle
	// with a String type
	public Bullet(int xCoord, int yCoord, int width, int height, String type, Color color){
		super(width, height, color);
		this.type = type;
		setTranslateX(xCoord);
		setTranslateY(yCoord);
		}

	// Setter method for the type
	public void setType(String type) {
		this.type = type;
		}

	// Getter method for the type
	public String getType() {
		return type;
		}

	// Moves the Bullet up
	public void moveUp(){
		setTranslateY(getTranslateY() - bulletUp);
		}
	// Move the Bullet Down
	public void moveDown(){
		setTranslateY(getTranslateY() + bulletDown);
		}

	// This method is called when the Avatar or Enemy shoots, and uses the Avatar,
	// the Pane, Heart, list of Hearts, and the image of hearts to move the
	// Bullet up, detect collision with an enemy or with Avatar, to revmoe the Enemy
	// or lose a heart. And returns whether the Avatar was hit or not
	public boolean shooter (Avatar avatar, ArrayList<Enemy> enemyList, Pane layout, Heart heart,
			ArrayList<Character>numli, Image image3) {

		boolean avatar_hit = false; // boolean for if avatar is hit

		// for every single enemy
		for (int i = 0; i < 5; i++) {

			// if the type of bullet is from an Avatar
			if (this.getType().equals("avatarBullet")){
				// if the bullet does not intersect with an enemy, move the bullet up
				// https://www.youtube.com/watch?v=FVo1fm52hz0&feature=youtu.be
				if (!this.getBoundsInParent().intersects(enemyList.get(i).getBoundsInParent())
						&& this.getTranslateY() > -20) {
					this.moveUp();
					}
				// if the bullet does intersect with an enemy, set enemy to dead, remove the bullet and enemy
				// from the Pane, delete enemy from the list, and add one to number of enemies avatar has killed
				else if (this.getBoundsInParent().intersects(enemyList.get(i).getBoundsInParent()) ){
					enemyList.get(i).dead = true;
					layout.getChildren().remove(enemyList.get(i));
					layout.getChildren().remove(this);
					enemyList.get(i).delete();
					avatar.setEnemiesKilled(avatar.getEnemiesKilled() ++);
					}
				}

			// if the type of bullet is from an Enemy
			else if (this.getType().equals("enemyBullet") ){
				// if the bullet does not intersect with the Avatar, move the bullet down
				if (!this.getBoundsInParent().intersects(avatar.getBoundsInParent())
						&& this.getTranslateY() < 800){
					this.moveDown();
					}
				// if the bullet does intersect with the Avatar, remove the bullet,
				// and set avatar to true
				else if (this.getBoundsInParent().intersects(avatar.getBoundsInParent())){
					layout.getChildren().remove(this);
					avatar_hit = true;
					}
				}
			}

		// if the bullet does intersect with the Avatar, and the life is greater than
		// 0, then decrease the life, remove the hearts then add the new number of hearts
		// This is outside the for loop as it is not supposed to loop for every single enemy
		// Only for one bullet
		if (this.getBoundsInParent().intersects(avatar.getBoundsInParent())){
			if (avatar.getLife() > 0){
				avatar.loseLife();
				layout.getChildren().removeAll(numli);
				heart.removeHeart(numli, avatar, image3);
				layout.getChildren().addAll(numli);
				}
			}
		return avatar_hit;
		}

	public boolean bossShooter (Avatar avatar, Boss boss, Pane layout, Heart heart, ArrayList<Character>numli, Image image3) {
		boolean ret = false;
		if (this.getType().equals("avatarBullet")){
			if (!this.getBoundsInParent().intersects(boss.getBoundsInParent()) && this.getTranslateY() > -20) {
				this.moveUp();
			}
			else if (this.getBoundsInParent().intersects(boss.getBoundsInParent()) ) {
				if (boss.getBLife()>0){
					layout.getChildren().remove(this);
					layout.getChildren().remove(boss.t);
					boss.loseBLife();
					boss.removeHp();
					boss.setHp();
					layout.getChildren().add(boss.t);
					System.out.println(boss.shp());

					ret = true;
				}
			}
		}
		return ret;
	}

}

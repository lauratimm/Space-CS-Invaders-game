package Gui;

import java.util.ArrayList;
import Logic.Bullet_Logic;
import Logic.Avatar_Logic;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This is the GUI class of our bullet for our game (enemy level)
 * It creates an ImageView of an image provided and extends off the 
 * Bullet_Logic logic class to use the parent class' instance variables to 
 * set the position, more, and delete the ImageView object
 * It also sets the width and height of the ImageView object
 * and moves ImageView of bullet until it hits something
 */
public class Bullet_Gui extends Bullet_Logic {
	final int TOP_BOUND = -20;
	final int BOTTOM_BOUND= 800;
	final int NUM_ENEMIES = 5;
	private Image bullet_image;
	private ImageView bullet_iv = new ImageView();
	private int bullet_width;
	private int bullet_height;
	private String type;

	/**
     * This constructor creates an instance of Bullet_Gui
     * by creating an ImageView with the specific width, height,
     * and calls Bullet_Logic constructor to set the X and Y coordinate
     * 
     * @param image The image file that the bullet will use
     * @param width The width of the bullet
     * @param height The height of the bullet
     * @param x_coordinate The x-coordinate of the bullet
     * @param y_coordinate The y-coordinate of the bullet
     * @param type The type of bullet (avatar or enemy)
     */
	public Bullet_Gui(Image image, int width, int height, int xCoord, int yCoord, String type) {
		super(xCoord, yCoord);
		setBullet_image(image);
		bullet_iv.setImage(getBullet_image());
		bullet_iv.setX(getX_coordinate());
		bullet_iv.setY(getY_coordinate());
		setBullet_width(width);
		setBullet_height(height);
		setType(type);
	}

	/**
     * This getter method returns the ImageView instance of the bullet
     * 
     * @return bullet_iv The ImageView of the bullet
     */
	public ImageView getBullet_iv() {
		return bullet_iv;
	}

	/**
     * This getter method returns the Image instance of the bullet
     * 
     * @return bullet_iamge The Image of the bullet
     */
	public Image getBullet_image() {
		return bullet_image;
	}
	
	/**
     * This is a getter method which returns the type of the bullet
     * 
     * @return type This bullet's type String
     */
	public String getType() {
		return type;
	}

	/**
     * This setter method sets the type of bullet based 
     * on String provided
     * 
     * @param type The String type of bullet
     */
	public void setType(String type) {
		this.type = type;
	}


	/**
     * This sets the image of the bullet
     * 
     * @param image the image that the bullet will use
     */
	public void setBullet_image(Image image) {
		this.bullet_image = image;
	}

	/**
	 * This method sets the width of the bullet and the width
	 * of the ImageView of bullet based on the integer width 
	 * provided
	 * 
	 * @param bullet_width The integer width to set the bullet_width to
	 */
	public void setBullet_width(int width) {
		bullet_iv.setFitWidth(width);
		this.bullet_width = width;
	}

	/**
	* This method sets the height of the bullet and the height
	* of the ImageView of bullet based on the integer height 
	* provided
	* 
	* @param bullet_height The integer width to set the bullet_height to
	*/
	public void setBullet_height(int height) {
		bullet_iv.setFitHeight(height);
		this.bullet_height = height;
	}

	/**
	 * This method is used to remove the ImageView object of bullet
	 * from the boundaries of the Pane that the ImageView is in
	 * It calls the parent delete method to change x and y values
	 */
	public void delete() {
		super.delete();
		bullet_iv.setX(getX_coordinate());
		bullet_iv.setY(getY_coordinate());
	}

	/**
	 * This method checks which type of bullet is shot and then calls the respective method
     * and run shootAvatar or shootEnemy accordingly
     * 
	 * @param enemy_list The list containing current enemies
	 * @param pane The layout Pane for the Spaces_Gui
	 * @param avatar The object Avatar_Gui that is being used
	 * @param heart The Heart_Gui of the avatar
	 * @param bulletTimer The AnimationTimer of the bullets
	 */
	public void shoot(ArrayList<Enemy_Gui> enemy_list, Pane pane, Avatar_Gui avatar, Heart_Gui heart, AnimationTimer bulletTimer) {
		if (getType().equals("avatar")) {
			this.shootAvatar(enemy_list, pane, avatar);
		} else {
			this.shootEnemy(avatar, pane, heart, bulletTimer);
		}
	}

	/**
	 * This method moves the avatar bullet up until it intersects with ImageView of 
	 * an enemy and then removes enemy and increase number of enemies killed by one 
     * 
	 * @param enemy_list The list containing current enemies
	 * @param pane The layout Pane for the Spaces_Gui
	 * @param avatar The object Avatar_Gui that is being used
	 */
	public void shootAvatar(ArrayList<Enemy_Gui> enemy_list, Pane pane, Avatar_Logic avatar) {
		// runs the for loop of the enemy_list so it checks interaction of avatar bullet with every enemy alive
		for (int i = 0; i < NUM_ENEMIES; i++) {
			// if the avatar bullet is within the bound and hasn't hit any enemy, it will continue to move up
			if (!bullet_iv.getBoundsInParent().intersects(enemy_list.get(i).getEnemy_iv().getBoundsInParent())
					&& bullet_iv.getTranslateY() > TOP_BOUND) {
				this.moveUp();
				bullet_iv.setX(getX_coordinate());
				bullet_iv.setY(getY_coordinate());
			}
			// if the bullet does intersect with an enemy, set enemy to dead, remove the bullet and enemy
			// from the Pane, delete enemy from the list, and add one to number of enemies avatar has killed
			else if (bullet_iv.getBoundsInParent().intersects(enemy_list.get(i).getEnemy_iv().getBoundsInParent())) {
				pane.getChildren().remove(enemy_list.get(i).getEnemy_iv());
				pane.getChildren().remove(bullet_iv);
				enemy_list.get(i).delete();
				enemy_list.get(i).setDead(true);
				this.delete();
				avatar.setEnemies_killed(avatar.getEnemies_killed() + 1);
			}
		}
	}

	/**
	 * This method moves the enemy bullet down until it intersects with ImageView of avatar
     * and then decreases the avatar's hearts by 1 
     * 
	 * @param avatar The object Avatar_Gui that is being used
	 * @param pane The layout Pane for the Spaces_Gui
	 * @param heart The Heart_Gui of the avatar
	 * @param bulletTimer The AnimationTimer of the bullets
	 */
	public void shootEnemy(Avatar_Gui avatar, Pane pane, Heart_Gui heart, AnimationTimer bulletTimer) {
		// if the enemy's bullet is within the bound and hasn't hit avatar, continue to move up
		if (!bullet_iv.getBoundsInParent().intersects(avatar.getAvatar_iv().getBoundsInParent())
				&& bullet_iv.getTranslateY() < BOTTOM_BOUND) {
			this.moveDown();
			bullet_iv.setX(getX_coordinate());
			bullet_iv.setY(getY_coordinate());
		}
		// if the bullet does intersect with the Avatar_Logic, remove the bullet and avatar will lose life
		else if (bullet_iv.getBoundsInParent().intersects(avatar.getAvatar_iv().getBoundsInParent())) {
			pane.getChildren().remove(bullet_iv);
			heart.loseLife();
			bulletTimer.stop();
			heart.addHearts(pane, 10);
		}
	}
}

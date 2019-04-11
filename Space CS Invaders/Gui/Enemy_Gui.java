package Gui;

import Logic.Enemy_Logic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This is the GUI class of our enemy for our game
 * It creates an ImageView of an image provided and extends off the 
 * Enemy_Logic logic class to use the parent class' instance variables to
 * set the position, move and delete the ImageView object
 * It also sets the width and height of the ImageView
 */
public class Enemy_Gui extends Enemy_Logic {
	private Image enemy_image;
	private ImageView enemy_iv = new ImageView();
	private int enemy_width;
	private int enemy_height;
	
	/**
	 * This is a constructor which creates an instance of Enemy_Gui
	 * by creating an ImageView with the specified width, height,
	 * and calls the Enemy_Gui constructor to set the X and Y coordinate
	 * 
	 * @param image The Image of the ImageView enemy object
	 * @param width	The width of the ImageView enemy object
	 * @param height The height of the ImageView enemy object
	 * @param x_Coordinate The location of the Enemy_Logic in it's x-axis
	 * @param y_Coordinate The location of the Enemy_logic in it's y axis 
	 */
	public Enemy_Gui(Image image, int width, int height, int x_coordinate, int y_coordinate) {
		super(x_coordinate, y_coordinate);
		setEnemy_image(image);
		enemy_iv.setImage(getEnemy_image());
		enemy_iv.setX(getX_coordinate());
		enemy_iv.setY(getY_coordinate());
		setEnemy_width(width);
		setEnemy_height(height);
	}
	
	/**
	 * This getter method gets the ImageView instance of the enemy
	 * 
	 * @return enemy_iv The ImageView of the enemy
	 */
	public ImageView getEnemy_iv() {
		return enemy_iv;
	}
	
	/**
	 * This getter method returns the Image instance of the enemy
	 * 
	 * @return enemy_image The Image of the enemy
	 */
	public Image getEnemy_image() {
		return enemy_image;
	}
	
	/**
	 * This setter method sets the Image instance of the enemy
	 * based on the provided Image object
	 * 
	 * @param image The Image instance to set the enemy Image to
	 */
	public void setEnemy_image(Image image) {
		this.enemy_image = image;
	}
	
	/**
	 * This method sets the width of the enemy and the width
	 * of the ImageView of enemy based on the integer width 
	 * provided
	 * 
	 * @param width The integer width to set the enemy_width to
	 */
	public void setEnemy_width(int width) {
		enemy_iv.setFitWidth(width);
		this.enemy_width = width;
	}
	
	/**
	 * This method sets the height of the enemy and the height
	 * of the ImageView of enemy based on the integer height 
	 * provided
	 * 
	 * @param height The integer width to set the enemy_height to
	 */
	public void setEnemy_height(int height) {
		enemy_iv.setFitHeight(height);
		this.enemy_height = height;
	}
	
	/**
	 * This method invokes the moveRan() function from the Class 'Enemy_Logic'
	 * Which causes the enemy to move randomly and then updates ImageView
	 */
	public void moveRan() {
		super.moveRan();
		enemy_iv.setX(getX_coordinate());
		enemy_iv.setY(getY_coordinate());
	}
	
	/**
	 * This method is used to remove the ImageView object of enemy
	 * from the boundaries of the Pane that the ImageView is in
	 * It changes the height and width of the ImageView to small values
	 * and calls the parent delete method to change x and y values
	 */
	public void delete() {
		super.delete();
		setEnemy_width(1);
		setEnemy_height(1);
		enemy_iv.setX(getX_coordinate());
		enemy_iv.setY(getY_coordinate());
	}
}

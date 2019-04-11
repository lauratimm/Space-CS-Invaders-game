package Gui;

import Logic.Boss_Logic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This is the GUI class of our boss (enemy) for our game
 * It creates an ImageView of an image provided and extends off the 
 * Boss_Logic logic class to use the parent class' instance variables to
 * set the position, move and delete the ImageView object
 * It also sets the width and height of the ImageView
 */
public class Boss_Gui extends Boss_Logic {
	private Image boss_image;
	private ImageView boss_iv = new ImageView();
	private int boss_width;
	private int boss_height;
	
	/**
	 * This is a constructor which creates an instance of Boss_Gui
	 * by creating an ImageView with the specified width, height,
	 * and calls the Boss_Logic constructor to set the X and Y coordinate
	 * 
	 * @param image The Image of the ImageView boss object
	 * @param width	The width of the ImageView boss object
	 * @param height The height of the ImageView boss object
	 * @param x_Coordinate The location of the Boss_Logic in it's x-axis
	 * @param y_Coordinate The location of the Boss_Logic in it's y axis 
	 */
	public Boss_Gui(Image image, int width, int height, int x_Coordinate, int y_Coordinate) {
		super(x_Coordinate, y_Coordinate);
		setBoss_image(image);
		boss_iv.setImage(getBoss_image());
		boss_iv.setX(getX_coordinate());
		boss_iv.setY(getY_coordinate());
		setBoss_width(width);
		setBoss_height(height);
	}
	
	/**
	 * This getter method gets the ImageView instance of the boss
	 * 
	 * @return boss_iv The ImageView of the boss
	 */
	public ImageView getBoss_iv() {
		return boss_iv;
	}
	
	/**
	 * This getter method returns the Image instance of the boss
	 * 
	 * @return boss_image The Image of the boss
	 */
	public Image getBoss_image() {
		return boss_image;
	}
	
	/**
	 * This setter method sets the Image instance of the boss
	 * based on the provided Image object
	 * 
	 * @param image The Image instance to set the boss Image to
	 */
	public void setBoss_image(Image image) {
		this.boss_image = image;
	}
	
	/**
	 * This method sets the width of the boss and the width
	 * of the ImageView of boss based on the integer width 
	 * provided
	 * 
	 * @param width The integer width to set the boss_width to
	 */
	public void setBoss_width(int width) {
		boss_iv.setFitWidth(width);
		this.boss_width = width;
	}
	
	/**
	 * This method sets the height of the boss and the height
	 * of the ImageView of boss based on the integer height 
	 * provided
	 * 
	 * @param height The integer width to set the boss_height to
	 */
	public void setBoss_height(int height) {
		boss_iv.setFitHeight(height);
		this.boss_height = height;
	}
	
	/**
	 * This method invokes the moveRan() function from the Class 'Boss_Logic'
	 * Which causes the enemy to move randomly and then updates ImageView
	 */
	public void moveRan() {
		super.moveRan();
		boss_iv.setX(getX_coordinate());
		boss_iv.setY(getY_coordinate());
	}
}

package Gui;

import Logic.Avatar_Logic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

/**
 * This is the GUI class of our avatar (spaceship) for our game
 * It creates an ImageView of an image provided and extends off the 
 * Avatar_Logic logic class to use the parent class' instance variables to
 * set the position, move and delete the ImageView object
 * It also sets the width and height of the ImageView
 */
public class Avatar_Gui extends Avatar_Logic {
	private Image avatar_image;
	private ImageView avatar_iv = new ImageView();
	private int avatar_width;
	private int avatar_height;

	/**
	 * This is a constructor which creates an instance of Avatar_Gui
	 * by creating an ImageView with the specified width, height,
	 * and calls the Avatar_Logic constructor to set the X and Y coordinate
	 * 
	 * @param image The Image of the ImageView avatar object
	 * @param width The width of the ImageView avatar object
	 * @param height The height of the ImageView avatar object
	 * @param x_cooridante The x coordinate for the logic Avatar_Logic class
	 * @param y_coordinate The y coordinate for the logic Avatar_Logic class
	 */
	public Avatar_Gui(Image image, int width, int height, int x_cooridante, int y_coordinate) {
		super(x_cooridante, y_coordinate);
		setAvatar_image(image);
		avatar_iv.setImage(getAvatar_image());
		avatar_iv.setX(getX_coordinate());
		avatar_iv.setY(getY_coordinate());
		setAvatar_width(width);
		setAvatar_height(height);
	}

	/**
	 * This getter method gets the ImageView instance of the avatar
	 * 
	 * @return avatar_iv The ImageView of the avatar
	 */
	public ImageView getAvatar_iv() {
		return avatar_iv;
	}

	/**
	 * This getter method returns the Image instance of the avatar
	 * 
	 * @return avatar_image The Image of the avatar
	 */
	public Image getAvatar_image() {
		return avatar_image;
	}

	/**
	 * This setter method sets the Image instance of the avatar
	 * based on the provided Image object
	 * 
	 * @param avatar_image The Image instance to set the avatar Image to
	 */
	public void setAvatar_image(Image avatar_image) {
		this.avatar_image = avatar_image;
	}

	/**
	 * This method sets the width of the avatar and the width
	 * of the ImageView of avatar based on the integer width 
	 * provided
	 * 
	 * @param avatar_width The integer width to set the avatar_width to
	 */
	public void setAvatar_width(int avatar_width) {
		avatar_iv.setFitWidth(avatar_width);
		this.avatar_width = avatar_width;
	}
	
	/**
	 * This method sets the height of the avatar and the height
	 * of the ImageView of avatar based on the integer height 
	 * provided
	 * 
	 * @param avatar_height The integer width to set the avatar_height to
	 */
	public void setAvatar_height(int avatar_height) {
		avatar_iv.setFitHeight(avatar_height);
		this.avatar_height = avatar_height;
	}

	/**
	 * This method gets the KeyCode provided and then calls the 
	 * Avatar_Logic parent class to change the x or y coordinate based
	 * on the switch case and will set wether or not the avatar shoots
	 * based on the KeyCode input then changes the avatar ImageView 
	 * x and y coordinates to their new values
	 * 
	 * @param code The KeyCode value provided as input
	 */
	public void movement(KeyCode code) {
		switch (code) {
			case A:
				moveLeft();
				setShoots(false);
				break;
			case D:
				moveRight();
				setShoots(false);
				break;
			case W:
				moveUp();
				setShoots(false);
				break;
			case S:
				moveDown();
				setShoots(false);
				break;
			case SPACE:
				setShoots(true);
				break;
			default:
				break;

		}
		avatar_iv.setX(getX_coordinate());
		avatar_iv.setY(getY_coordinate());
	}

	/**
	 * This method is used to remove the ImageView object of avatar
	 * from the boundaries of the Pane that the ImageView is in
	 * It changes the height and width of the ImageView to small values
	 * and calls the parent delete method to change x and y values
	 */
	public void delete() {
		super.delete();
		setAvatar_width(1);
		setAvatar_height(1);
		avatar_iv.setX(getX_coordinate());
		avatar_iv.setY(getY_coordinate());
	}


}

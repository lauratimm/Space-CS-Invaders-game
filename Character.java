import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/* This class is a parent class for Avatar and Enemy, which creates a
   Character object. The class extends ImageView. When a character is created,
   an image is assigned to the object, along with the width, height, and x and y
   coordinates of the object, and a String */

public class Character extends ImageView {

	static final int delete_width = 1;
	static final int delete_height = 1;
	static final int delete_x = -100;
	static final int delete_y = -100;
	private boolean dead; // indicates whether the object is dead or not
	private String type; // indicates the name of the object

	/* Constructor which assigns an image to the object, along with the width,
	   height, and x and y coordinates of the object, and String type */
 public Character(int xCoord, int yCoord, int width, int height, String type, Image image){
	 super(image);
	 setFitWidth(width);
	 setFitHeight(height);
	 setX(xCoord);
	 setY(yCoord);
	 this.type = type;
	 dead = false;
	}

	// Constructor for the enemies that doesn't set the x and y coordinates 
	public Character(int width, int height, String type, Image image) {
		super(image);
		setFitWidth(width);
		setFitHeight(height);
		this.type = type;
		dead = false;
	}

	/* Method which 'deletes' the object from the main stage by moving the object
	   outside the viewable stage */
	public void delete() {
		setFitWidth(delete_width);
		setFitHeight(delete_height);
		setX(delete_x);
		setY(delete_y);
		}

	public boolean getDead(){
		return dead;
	}
	public void setDead(boolean dead){
		this.dead = dead;
	}
	public String getType(){
		return type;
	}

}

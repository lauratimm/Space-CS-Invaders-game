import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// This class is a parent class for Avatar and Enemy, which creates a
// Character object. The class extends ImageView. When a character is created,
// an image is assigned to the object, along with the width, height, and x and y
// coordinates of the object, and a String

public class Character extends ImageView {

	// Instance variables
	public boolean dead; // indicates whether the object is dead or not
	public String type; // indicates the name of the object

	// Constructor which assigns an image to the object, along with the width,
	// height, and x and y coordinates of the object, and String type
	public Character(int xCoord, int yCoord, int width, int height, String type, Image image){
		super(image);
		setFitWidth(width);
		setFitHeight(height);
		setX(xCoord);
		setY(yCoord);
		this.type = type;
		dead = false;
		}

	// Method which 'deletes' the object from the main stage by moving the object
	// outside the viewable stage
	public void delete() {
		setFitWidth(1);
		setFitHeight(1);
		setX(-100);
		setY(-100);
		}
}

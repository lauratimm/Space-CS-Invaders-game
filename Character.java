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

	static final int deleteWidth = 1;
	static final int deleteHeight = 1;
	static final int deleteX = -100;
	static final int deleteY = -100;

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

		public Character(int width, int height, String type, Image image) {
			super(image);
			setFitWidth(width);
			setFitHeight(height);
			this.type = type;
			dead = false;
		}

	// Method which 'deletes' the object from the main stage by moving the object
	// outside the viewable stage
	public void delete() {
		setFitWidth(deleteWidth);
		setFitHeight(deleteHeight);
		setX(deleteX);
		setY(deleteY);
		}
}

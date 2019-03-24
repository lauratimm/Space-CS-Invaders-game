import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

// This class creates and Avatar by extending Character. There are methods
// which move the Avatar based on input.
public class Avatar extends Character {

	//Instance Variables
	static private int amtToMove = 10;
	static private int maxY = 740;
	static private int maxX = 540;
	private int life = 5; // the number of hearts the Avatar has left
	private int enemiesKilled = 0; // the number of enemies the Avatar has killed;

	// The only constructor, which creates an Avatar based on the constructor
	// in Character
	public Avatar(int xCoord, int yCoord, int width, int height, String type, Image image) {
		super(xCoord, yCoord, width, height, type, image);
		}

	// Getter method for the number of enemies killed
	public int getEnemiesKilled() {
		return enemiesKilled;
		}

	// Getter method for the life
	public int getLife() {
		return life;
		}

	// Setting method for the number of enemies killed
	public void setEnemiesKilled(int enemiesKilled) {
		this.enemiesKilled = enemiesKilled;
		}

	// Method which removes a life from the Avatar
	public void loseLife() {
		life --;
		}

	//Method for moving the Avatar left
	public void moveLeft(){
		if (getX() > 0){
			setX(getX() - amtToMove);
			}
		}

	//Method for moving the Avatar Right
	public void moveRight(){
		if (getX() < maxX){
			setX(getX() + amtToMove);
			}
		}

	//Method for moving the Avatar Up
	public void moveUp(){
		if (getY() > 0){
			setY(getY() - amtToMove);
			}
		}

	//Method for moving the Avatar Down
	public void moveDown(){
		if (getY() < maxY){
			setY(getY() + amtToMove);
			}
		}

	// Method which takes a KeyCode as a parameter, and uses it
	// to call movement methods. It also returns whether or not
	// the Avatar should shoot, based on input
	public boolean movement (KeyCode code) {
		boolean shoot = false;
   		switch (code){
		case A:
			moveLeft();
			return shoot;
		case D:
			moveRight();
			return shoot;

		case W:
			moveUp();
			return shoot;
		case S:
			moveDown();
			return shoot;

		case SPACE:
			shoot = true;
			return shoot;
		default:
			return shoot;
			}
   		}
}

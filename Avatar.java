import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

// This class creates and Avatar by extending Character. There are methods
// which move the Avatar based on input.
public class Avatar extends Character{

	//Instance Variables
	private int life = 5; // the number of hearts the Avatar has left
	private int e_killed = 0; // the number of enemies the Avatar has killed;

	// The only constructor, which creates an Avatar based on the constructor
	// in Character
	public Avatar(int x, int y, int w, int h, String t, Image image) {
		super(x, y, w, h, t, image);
		}
	
	// Getter method for the number of enemies killed
	public int getE_killed() {
		return e_killed;
		}
	
	// Getter method for the life
	public int getLife() {
		return life;
		}

	// Setting method for the number of enemies killed
	public void setE_killed(int e_killed) {
		this.e_killed = e_killed;
		}

	// Method which removes a life from the Avatar
	public void loseLife() {
		life -= 1;
		}

	//Method for moving the Avatar left
	public void moveLeft(){
		if (getX() > 0){
			setX(getX() - 10);
			}
		}
	
	//Method for moving the Avatar Right
	public void moveRight(){
		if (getX() < 540){
			setX(getX() + 10);
			}
		}
	
	//Method for moving the Avatar Up
	public void moveUp(){
		if (getY() > 0){
			setY(getY() - 10);
			}
		}

	//Method for moving the Avatar Down
	public void moveDown(){
		if (getY() < 740){
			setY(getY() + 10);
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

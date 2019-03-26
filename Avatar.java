import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

/* This class creates and Avatar by extending Character. There are methods
   which move the Avatar based on input. */
public class Avatar extends Character {
	
	static final int amtToMove = 10;
	static final int max_y = 740;
	static final int max_x = 540;
	static final int min_y = 0;
	static final int min_x = 0;
	private int life = 5;
	private int enemiesKilled = 0;

	// The only constructor, creates an Avatar based on the constructor in Character
	public Avatar(int xCoord, int yCoord, int width, int height, String type,
								Image image) {
		super(xCoord, yCoord, width, height, type, image);
		}

	public int getEnemiesKilled() {
		return enemiesKilled;
		}

	public int getLife() {
		return life;
		}

	public void setEnemiesKilled(int enemiesKilled) {
		this.enemiesKilled = enemiesKilled;
		}

	// Method which removes a life from the Avatar
	public void loseLife() {
		life --;
		}

	// Methods for moving the Avatar in 4 directions
	public void moveLeft(){
		if (getX() > min_x){
			setX(getX() - amtToMove);
			}
		}

	public void moveRight(){
		if (getX() < max_x){
			setX(getX() + amtToMove);
			}
		}

	public void moveUp(){
		if (getY() > min_y){
			setY(getY() - amtToMove);
			}
		}

	public void moveDown(){
		if (getY() < 740){
			setY(getY() + 10);
			}
		}

	/* Method which takes a KeyCode as a parameter, and uses it
	   to call movement methods. It also returns whether or not
	   the Avatar should shoot, based on input */
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

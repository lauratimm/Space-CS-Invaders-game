import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Avatar extends Character{

	//Instance Variable

	private int life = 5;
	private int e_killed = 0;

	public Avatar(int x, int y, int w, int h, String t, Image image) {
		super(x, y, w, h, t, image);
	}

	//Avatar Movements
	public void moveLeft(){
		if (getX() > 0){
			setX(getX() - 10);
		}
	}

	public void moveRight(){
		if (getX() < 540){
			setX(getX() + 10);
		}
    }

	public void moveUp(){
		if (getY() > 0){
			setY(getY() - 10);
		}
	}

	public void moveDown(){
		if (getY() < 740){
			setY(getY() + 10);
		}
	}

	public int getLife() {
		return life;
	}
	public void loseLife() {
		life -= 1;
	}
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

	public int getE_killed() {
		return e_killed;
	}

	public void setE_killed(int e_killed) {
		this.e_killed = e_killed;
	}
}

import javafx.scene.image.Image;

public class Avatar extends Character{

	//Instance Variable

	private int life = 5;

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
		life -= .5;
	}
}

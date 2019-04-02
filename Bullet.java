import javafx.scene.input.KeyCode;

public class Bullet {
	private int life = 5;
	private int x_coordinate = 0;
	private int y_coordinate = 0;
	private int movement = 1;
	
	public Bullet (int x, int y) {
		setX_coordinate(x);
		setY_coordinate(y);
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getX_coordinate() {
		return x_coordinate;
	}
	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}
	public int getY_coordinate() {
		return y_coordinate;
	}
	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}
	public int getMovement() {
		return movement;
	}
	public void setMovement(int movement) {
		this.movement = movement;
	}
	public void moveLeft() {
		if (getX_coordinate()> 0) {
			setX_coordinate(getX_coordinate() - getMovement());
		}
	}
	public void moveRight() {
		if (getX_coordinate()< 540) {
			setX_coordinate(getX_coordinate() + getMovement());
		}
	}
	public void moveUp() {
			setY_coordinate(getY_coordinate() - getMovement());
		
	}
	public void moveDown() {
		if (getY_coordinate() < 800) {
			setY_coordinate(getY_coordinate() + getMovement());
		}
	}
	public void movement(KeyCode code) {
		switch (code) {
		case A:
			moveLeft();
			break;
		case D:
			moveRight();
			break;
		case W:
			moveUp();
			break;
		case S:
			moveDown();
			break;
		case SPACE:
			break;
		}
	}
	public void delete() {
		setX_coordinate(-300);
		setY_coordinate(-300);
	}
}

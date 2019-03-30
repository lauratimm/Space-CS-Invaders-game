import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Avatar_GUI extends Avatar {
	private Image image;
	ImageView iv = new ImageView();
	private int width;
	private int height;
	
	public Avatar_GUI(Image image, int w, int h, int x, int y) {
		super (x,y);
		setImage(image);
		iv.setImage(getImage());
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
		setWidth(w);
		setHeight(h);
	}

	public ImageView getIV() {
		return iv;
	}
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		iv.setFitWidth(width);
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		iv.setFitHeight(height);
		this.height = height;
	}
	
	public void movement(KeyCode code) {
		super.movement(code);
		iv.setX(getX_coordinate());
		iv.setY(getY_coordinate());
	}
	
}

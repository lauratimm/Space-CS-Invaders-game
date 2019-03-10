import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Bullet extends Rectangle{
	
	private String type;
	
	// Bullet
	public Bullet(int x, int y, int w, int h, String t, Color color){
		super(w, h, color);
		this.type = t;
		setTranslateX(x);
		setTranslateY(y);
	}

	public void moveUp(){
		setTranslateY(getTranslateY() - 5);
	}

	public void moveDown(){
		setTranslateY(getTranslateY() + 3);
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
}

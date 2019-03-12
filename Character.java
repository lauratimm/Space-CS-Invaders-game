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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Math.*;

public class Character extends ImageView {
	
	boolean dead;
	String type;
	
//	double x = 0;
//	double y = 0;
	 
//	double velX = 0;
//	double velY = 0;

	public Character(int x, int y, int w, int h, String t, Image image){
		super(image);
		setFitWidth(w);
		setFitHeight(h);
		setX(x);
		setY(y);
		type = t;
		dead = false;
	}
	
/*	
	public void tickX(double d) {
		d += velX;	
	}
	
	public void tickY(double y) {
		y += velY;
	}
	
	public void setVelX(Double velX) {
		this.velX = velX;
	}
	public void setVelY(Double velY) {
		this.velY = velY;
	}
	
*/	
}

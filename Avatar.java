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

public class Avatar extends ImageView {
	boolean dead;
	String type;
	
	double x = 0;
	double y = 0;
	 
	double velX = 0;
	double velY = 0;

	public Avatar(int x, int y, int w, int h, String t, Image image){
		super(image);
		this.setFitWidth(w);
		this.setFitHeight(h);
		this.setX(x);
		this.setY(y);
		this.type = t;
		this.dead = false;
	}
	
	
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
	
	// Enemy Movements (random)
	public void moveRan(){
		
		double r = Math.random();
    
		if (r < 0.25 && getX() > 0){
			setX(getX() - 4);
		}
		else if (r < 0.5 && getX() < 600){
			setX(getX() + 4);
		}
		else if (r < 0.75 && getY() > 0){
			setY(getY() - 4);
		}
		else if (r < 0.99 && getY() < 500){
			setY(getY() + 4);
		}
	}
}

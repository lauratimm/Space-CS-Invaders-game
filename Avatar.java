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
  double velX = 0;
  double velY = 0;
  //int tries = 5;
  //Image image;
  //ImageView iv = new ImageView();



  Avatar(int x, int y, int w, int h, String t, Image image){
    super(image);
    setFitWidth(w);
    setFitHeight(h);
    setX(x);
    setY(y);
    this.type = t;
    this.dead = false;

  }

  void moveLeft(){
    if (getX() > 0){
      setX(getX() - 5);
    }
    else{
    }
  }

  void moveRight(){
    if (getX() < 540){
      setX(getX() + 5);
    }
    else{
    }
  }

  void moveUp(){
    if (getY() > 0){
      setY(getY() - 5);
    }
    else{
    }
  }

  void moveDown(){
    if (getY() < 740){
      setY(getY() + 5);
    }
    else{
    }
  }

  void moveRan(){
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

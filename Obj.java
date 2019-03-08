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

public class Obj extends Rectangle{
  boolean dead = false;
  String type;


  Obj(int x, int y, int w, int h, String t, Color color){
    super(w, h, color);

    this.type = t;
    setTranslateX(x);
    setTranslateY(y);
  }

  void moveLeft(){
    setTranslateX(getTranslateX() - 5);
  }

  void moveRight(){
    setTranslateX(getTranslateX() + 5);
  }

  void moveUp(){
    setTranslateY(getTranslateY() - 5);
  }

  void moveDown(){
    setTranslateY(getTranslateY() + 3);
  }


}

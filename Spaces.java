import javafx.application.Application;
import java.awt.*;
import java.awt.event.KeyEvent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.ArrayList;
//import java.animation.TranslateTransition;


public class Spaces extends Application{
	Stage window;
	Scene scene;
	double t = 0;
	Pane layout = new Pane();
	Image image = new Image("avatar.png");
	Image image2 = new Image("enemy.png");
	Image image3 = new Image("heart.png");

	Avatar avatar = new Avatar(300, 700, 60, 60, "avatar", image);
	Avatar ailen = new Avatar(300, 200, 40, 40, "enemy", image2);
	int life = 5;
	int numEnemies = 10;


	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Space Invaders");
		layout.getChildren().add(avatar);
		layout.getChildren().add(ailen);		
		
		AnimationTimer eTimer = new AnimationTimer(){		
	
		
	@Override
	public void handle(long now){
		ailen.moveRan();
		if (Math.random() < 0.01){
			if (!ailen.dead){
				shoot(ailen, Color.RED);
			}
        }
      }
    };
    
    	eTimer.start();
    
    	scene = new Scene(layout, 600, 800, Color.BLACK);
    	scene.setOnKeyPressed(e -> {
    		
    		switch (e.getCode()){
    		case A:
    			avatar.moveLeft();
    			break;
        
    		case D:
    			avatar.moveRight();
    			break;
    		
    		case W:
    			avatar.moveUp();
    			break;
    		case S:
    			avatar.moveDown();	
    			break;
    		
    		case L:
    			shoot(avatar,Color.YELLOW);
          break;
			default:
				break;
      
      }
    });

    numHeart();
    window.setScene(scene);
    window.show();
	}


	public void numHeart(){
		int f = 10;
		ArrayList<Avatar> numli = new ArrayList<Avatar>(5);
		for (int i = 0; i < life; i++){
			Avatar h = new Avatar(f, 10, 20, 20, "heart", image3);
			numli.add(h);
			f+=30;
		}
		for (Avatar a: numli){
			layout.getChildren().add(a);
		}
	}


	public void shoot(Avatar p, Color c){

		Bullet s = new Bullet((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);
		layout.getChildren().add(s);

		AnimationTimer bTimer = new AnimationTimer(){
			
		@Override
		public void handle(long now){
        
			if (s.getType().equals("avatarBullet")){
				if (!s.getBoundsInParent().intersects(ailen.getBoundsInParent()) && s.getTranslateY() > -20) {
					s.moveUp();
				}
				else if (s.getBoundsInParent().intersects(ailen.getBoundsInParent()) ){
					ailen.dead = true;
					layout.getChildren().remove(ailen);
					layout.getChildren().remove(s);
				}
        
			}
			else if (s.getType().equals("enemyBullet") ){
				if (!s.getBoundsInParent().intersects(avatar.getBoundsInParent()) && s.getTranslateY() < 800){
					s.moveDown();
				}
				else if (s.getBoundsInParent().intersects(avatar.getBoundsInParent())){
					layout.getChildren().remove(s);
				}
			}
		}
    }; 
    bTimer.start();
  }

}

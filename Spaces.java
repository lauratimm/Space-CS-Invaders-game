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
	Enemy alien = new Enemy(300, 200, 40, 40, "enemy", image2);
	Enemy alien2 = new Enemy(100, 300, 40, 40, "enemy", image2);
	Enemy alien3 = new Enemy(200, 200, 40, 40, "enemy", image2);
	Enemy alien4 = new Enemy(300, 300, 40, 40, "enemy", image2);
	Enemy alien5 = new Enemy(250, 350, 40, 40, "enemy", image2);

	ArrayList<Character> numli = new ArrayList<Character>(5);


	int numEnemies = 10;


	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Space Invaders");
		layout.getChildren().add(avatar);
		layout.getChildren().addAll(alien, alien2, alien3, alien4, alien5);

		AnimationTimer eTimer = new AnimationTimer(){


	@Override
	public void handle(long now){
		alien.moveRan();
		alien2.moveRan();
		alien3.moveRan();
		alien4.moveRan();
		alien5.moveRan();

		if (Math.random() < .01){
			if (!alien.dead){
				shoot(alien, Color.RED);
			}
		}
		if (Math.random() < .01){
			if (!alien2.dead){
				shoot(alien2, Color.RED);
			}
		}
		if (Math.random() < .01){
			if (!alien3.dead){
				shoot(alien3, Color.RED);
			}
		}
		if (Math.random() < .01){
			if (!alien4.dead){
				shoot(alien4, Color.RED);
			}
		}
		if (Math.random() < .01){
			if (!alien5.dead){
				shoot(alien5, Color.RED);
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

    		case SPACE:
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
		for (int i = 0; i < avatar.getLife(); i++){
			Character insertHeart = new Character(f, 10, 20, 20, "heart", image3);
			numli.add(insertHeart);
			f+=30;
		}
			layout.getChildren().addAll(numli);
	}
	public void removeHeart(){
			layout.getChildren().removeAll(numli);
			numli.removeAll(numli);
			numHeart();
	}


	public void shoot(Character p, Color c){

		Bullet shoot = new Bullet((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);
		layout.getChildren().add(shoot);

		AnimationTimer bulletTimer = new AnimationTimer(){

		@Override
		public void handle(long now){


			ArrayList<Enemy> numE = new ArrayList<Enemy>();
			numE.add(alien);
			numE.add(alien2);
			numE.add(alien3);
			numE.add(alien4);
			numE.add(alien5);

			for (Enemy enemy: numE) {
				if (shoot.getType().equals("avatarBullet")){
					if (!shoot.getBoundsInParent().intersects(enemy.getBoundsInParent()) && shoot.getTranslateY() > -20) {
						shoot.moveUp();
					}
					else if (shoot.getBoundsInParent().intersects(enemy.getBoundsInParent()) ){
						enemy.dead = true;
						layout.getChildren().remove(enemy);
						layout.getChildren().remove(shoot);
						enemy.delete();


						//alien = new Enemy(-1, -1, 1, 1, "enemy", image2);
						//alien.dead = true;

					}
				}
				else if (shoot.getType().equals("enemyBullet") ){
					int count = 0;
					if (!shoot.getBoundsInParent().intersects(avatar.getBoundsInParent()) && shoot.getTranslateY() < 800){
						shoot.moveDown();
					}
					else if (shoot.getBoundsInParent().intersects(avatar.getBoundsInParent())){
						layout.getChildren().remove(shoot);
						//layout.getChildren().remove(avatar);
						stop();
					}
				}

			}
			if (shoot.getBoundsInParent().intersects(avatar.getBoundsInParent())){
				if (avatar.getLife()>0){
					avatar.loseLife();
					removeHeart();
					System.out. println(avatar.getLife());
				}

		}
			/*

			if (shoot.getType().equals("avatarBullet")){
				if (!shoot.getBoundsInParent().intersects(alien.getBoundsInParent()) && shoot.getTranslateY() > -20) {
					shoot.moveUp();
				}
				else if (shoot.getBoundsInParent().intersects(alien.getBoundsInParent()) ){
					alien.dead = true;
					layout.getChildren().remove(alien);
					layout.getChildren().remove(shoot);

					//alien = new Enemy(-1, -1, 1, 1, "enemy", image2);
					//alien.dead = true;

				}
			}
			else if (shoot.getType().equals("enemyBullet") ){
				if (!shoot.getBoundsInParent().intersects(avatar.getBoundsInParent()) && shoot.getTranslateY() < 800){
					shoot.moveDown();
				}
				else if (shoot.getBoundsInParent().intersects(avatar.getBoundsInParent())){
					layout.getChildren().remove(shoot);
					layout.getChildren().remove(avatar);


				}
			}

			*/

		}
    };
    bulletTimer.start();
	}
}

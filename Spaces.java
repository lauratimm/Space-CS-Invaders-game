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
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	Pane layout = new Pane();

	//https://opengameart.org/content/spaceship-set-4-pixel-art-space-ships
	Image image = new Image("avatar.png");
	//https://commons.wikimedia.org/wiki/File:Space_invaders_alien.svg
	Image image2 = new Image("enemy.png");
	//https://ya-webdesign.com/explore/video-game-heart-png/
	Image image3 = new Image("heart.png");

	Avatar avatar = new Avatar(300, 700, 60, 60, "avatar", image);
	Enemy alien = new Enemy(300, 200, 40, 40, "enemy", image2);
	Enemy alien2 = new Enemy(100, 300, 40, 40, "enemy", image2);
	Enemy alien3 = new Enemy(200, 200, 40, 40, "enemy", image2);
	Enemy alien4 = new Enemy(300, 300, 40, 40, "enemy", image2);
	Enemy alien5 = new Enemy(250, 350, 40, 40, "enemy", image2);

	ArrayList<Character> numli = new ArrayList<Character>(5);
	Heart heart = new Heart();

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
		alien.setEnemyList(alien, alien2, alien3, alien4, alien5);
		enemyList = alien.getEnemyList();
		
		for (int i = 0; i < 5; i++) {
			enemyList.get(i).moveRan();
		}		

		
		for (int i = 0; i < 5; i++) {
			if (enemyList.get(i).enemyShoot() == true) {
			shoot(enemyList.get(i), Color.RED);
			}
		}
      }
    };

    	eTimer.start();

    	scene = new Scene(layout, 600, 800, Color.BLACK);
    	scene.setOnKeyPressed(e -> {

    		if (avatar.movement(e.getCode()) == true){
    			shoot(avatar,Color.YELLOW);
    		}
    });

    heart.numHeart(numli, avatar, image3);
    layout.getChildren().addAll(numli);
    window.setScene(scene);
    window.show();
	}

	public void shoot(Character p, Color c){

		Bullet bullet = new Bullet((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);
		layout.getChildren().add(bullet);

		AnimationTimer bulletTimer = new AnimationTimer(){

		@Override
		public void handle(long now){
			for (int i = 0; i < 5; i++) {
				if (bullet.getType().equals("avatarBullet")){
					if (!bullet.getBoundsInParent().intersects(enemyList.get(i).getBoundsInParent()) && bullet.getTranslateY() > -20) {
						bullet.moveUp();
					}
					else if (bullet.getBoundsInParent().intersects(enemyList.get(i).getBoundsInParent()) ){
						enemyList.get(i).dead = true;
						layout.getChildren().remove(enemyList.get(i));
						layout.getChildren().remove(bullet);
						enemyList.get(i).delete();


						//alien = new Enemy(-1, -1, 1, 1, "enemy", image2);
						//alien.dead = true;

					}
				}
				else if (bullet.getType().equals("enemyBullet") ){
					int count = 0;
					if (!bullet.getBoundsInParent().intersects(avatar.getBoundsInParent()) && bullet.getTranslateY() < 800){
						bullet.moveDown();
					}
					else if (bullet.getBoundsInParent().intersects(avatar.getBoundsInParent())){
						layout.getChildren().remove(bullet);
						//layout.getChildren().remove(avatar);
						stop();
					}
				}

			}
			if (bullet.getBoundsInParent().intersects(avatar.getBoundsInParent())){
				if (avatar.getLife()>0){
					avatar.loseLife();
					layout.getChildren().removeAll(numli);
					heart.removeHeart(numli, avatar, image3);
					layout.getChildren().addAll(numli);
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

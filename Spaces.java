import javafx.application.Application;
import java.awt.*;
import java.awt.Label;
import java.awt.event.KeyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.application.Platform;
import java.io.*;
//import javafx.scene.control.Label;
//import java.animation.TranslateTransition;


public class Spaces extends Application{
	Stage window;
	Scene scene;
	boolean avatar_dead = false;
	boolean e_dead = false;
	double t = 0;
  //boolean exit = false;
	//int quit = 0;
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	Pane layout = new Pane();
  //VBox layout2 = new VBox();

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
	/*
  Label lb = new Label("GAME OVER");
  Button btn = new Button("Ok");
	*/





	ArrayList<Character> numli = new ArrayList<Character>(5);
	Heart heart = new Heart();
	static boolean restart = false;

	public static void main(String[] args) throws IOException{
		launch(args);
		while(restart){
			//System.out.println("z");
			//DO NOT ERASE LINE BELOW. IT BLOWS YOUR PC!!!!!!!!!!!!!
			restart = false;
			Process P = Runtime.getRuntime().exec("java Spaces");
		}


		//Process P = Runtime.getRuntime().exec("java Spaces");
	}


	@Override
	public void start(Stage primaryStage) throws Exception{
    /*
    btn.setOnAction(e -> {
      if(menu("..", "exit?")){
        System.exit(0);
      }
    });
    */
		window = primaryStage;
		window.setTitle("Space Invaders");
    //https://stackoverflow.com/questions/22841000/how-to-change-the-color-of-pane-in-javafx
    layout.setStyle("-fx-background-color:black;");
		layout.getChildren().add(avatar);
    //btn.relocate(560,8);
    //layout.getChildren().add(btn);

		layout.getChildren().addAll(alien, alien2, alien3, alien4, alien5);
		/*
    layout2.setStyle("-fx-background-color:black;");
    layout2.getChildren().addAll(btn);
    btn.setOnAction(ev -> {
      menu("Game Over", "exit?");
    });
    //layout2.setAlignment(Pos.CENTER);
		*/

		AnimationTimer eTimer = new AnimationTimer(){


	@Override
	public void handle(long now){
		alien.setEnemyList(alien, alien2, alien3, alien4, alien5);
		enemyList = alien.getEnemyList();
		if (avatar_dead) {
			stop();
			//quit = 2;
			MenuBox.display("Menu", "You Lost!", "lose");
			//menu("Menu","You lost!");


		}
		if (e_dead) {
			stop();
			//quit = 1;
			MenuBox.display("Menu", "You Won!", "win");

		}

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

    	scene = new Scene(layout, 600, 800);
      //scene2 = new Scene(layout2, 300, 400);
    	scene.setOnKeyPressed(e -> {

				if (e.getCode() == KeyCode.Q) {
    		//quit = 0;
				MenuBox.display("Menu", "Game Menu", "Q");

    	}

    		else if (avatar.movement(e.getCode()) == true){
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
			int idk = bullet.shooter(avatar, enemyList, layout, heart, numli, image3);
			if(idk == 2) {
				stop();
			}
			if (avatar.getLife() == 0) {
				avatar.delete();
				stop();
				avatar_dead = true;

			}
			if (avatar.getE_killed() == 5) {
				e_dead = true;
			}


		}
    };

    bulletTimer.start();

	}
  

}

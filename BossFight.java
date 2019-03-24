import javafx.application.Application;
import java.awt.*;
import java.awt.Label;
import java.awt.event.KeyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
//import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
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

public class BossFight extends Spaces{

  Stage window;
	Scene scene;
	boolean avatar_dead = false;
  boolean boss_dead = false;
	double t = 0;
  Pane layout = new Pane();
  Image image = new Image("avatar.png");
  Image image3 = new Image("heart.png");
  Heart heart = new Heart();
  Avatar avatar = new Avatar(300, 500, 60, 60, "avatar", image);
  Image imageBoss = new Image("boss.png");
  ArrayList<Character> numli = new ArrayList<Character>(5);
  //ArrayList<String> bossHp = new ArrayList<String>(50);
  //String joined = String.join("",bossHp);
  Boss boss = new Boss(150,70, 300, 200, "boss", imageBoss);
  //Text t = new Text(200,400,joined);


  public static void main(String[] args){
    launch(args);
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
		window.setTitle("Boss fight");
    //https://stackoverflow.com/questions/22841000/how-to-change-the-color-of-pane-in-javafx
    layout.setStyle("-fx-background-color:black;");
		layout.getChildren().add(avatar);
    //btn.relocate(560,8);
    //layout.getChildren().add(btn);

		layout.getChildren().addAll(boss);

		/*
    layout2.setStyle("-fx-background-color:black;");
    layout2.getChildren().addAll(btn);
    btn.setOnAction(ev -> {
      menu("Game Over", "exit?");
    });
    //layout2.setAlignment(Pos.CENTER);
		*/

		AnimationTimer bossTimer = new AnimationTimer(){


	@Override
	public void handle(long now){

		//alien.setEnemyList(alien, alien2, alien3, alien4, alien5);
		//enemyList = alien.getEnemyList();
		if (avatar_dead) {
			stop();
			//quit = 2;
			//menu("Menu","You lost!");


		}
		if (boss_dead) {
			stop();
			//quit = 1;
		}


    //shoot(boss, Color.PINK);


      }
    };

    	bossTimer.start();

    	scene = new Scene(layout, 600, 800);
      //scene2 = new Scene(layout2, 300, 400);
    	scene.setOnKeyPressed(e -> {

				if (e.getCode() == KeyCode.Q) {
    		//quit = 0;
    	}

    		else if (avatar.movement(e.getCode()) == true){
    			shoot(avatar,Color.YELLOW);
    		}

    });


    heart.numHeart(numli, avatar, image3);
    //Label barcode = new Label("dfsf");
    //barcode.relocate(100,760);
    layout.getChildren().addAll(numli);
    boss.numHp();
    //System.out.println(boss.shp(bossHp));
    System.out.println(boss.shp());
    //boss.thp();

    boss.setHp();
    layout.getChildren().add(boss.t);

    window.setScene(scene);
    window.show();
	}

  public void shoot(Character p, Color c){
    Bullet bullet = new Bullet((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);
    layout.getChildren().add(bullet);

    AnimationTimer bulletTimer = new AnimationTimer(){

		@Override
		public void handle(long now){
			boolean avatar_hit = bullet.bossShooter(avatar, boss, layout, heart, numli, image3);

			if(avatar_hit) {
				stop();
			}

			if (avatar.getLife() == 0) {
				avatar.delete();
				stop();
				avatar_dead = true;

			}
			if (boss.getBLife() == 0) {
				boss_dead = true;
			}


		}
    };
    bulletTimer.start();


  }

}

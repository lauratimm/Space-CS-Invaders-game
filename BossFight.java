import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BossFight extends Application{
	Stage window;
	Scene scene;
	boolean avatar_dead = false;
	boolean boss_dead = false;
	double t = 0; 
	int quit = 0;

	Pane layout = new Pane();
	Image image = new Image("avatar.png");
	Image image2 = new Image("heart.png");
	Heart heart = new Heart();
	Avatar avatar = new Avatar(300, 500, 60, 60, "avatar", image);
	MenuBox menuBox = new MenuBox();
	Image image3 = new Image("boss.png");
	ArrayList<Character> num_h = new ArrayList<Character>(5);
	Boss boss = new Boss(150, 70, 300, 200, "boss", image3);
	
	public static void main(String[] args){
		launch(args);
		}
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Space Invaders Boss Fight");
		layout.setStyle("-fx-background-color:black;");
		layout.getChildren().add(avatar);
		layout.getChildren().add(boss);
		AnimationTimer bossTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (avatar_dead) {
					stop();
					quit = 2;
					endGame();
				}
				if (boss_dead) {
					stop();
					quit = 1;
					endGame();
				}
				boss.moveRan();
				if (boss.bossShoot() == true) {
					shoot(boss, Color.RED);
				}
			}
		};
		bossTimer.start();
		scene = new Scene(layout, 600, 800, Color.BLACK);
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.Q) {
				quit = 0;
				endGame();
			}
			else if (avatar.movement(e.getCode()) == true){
				shoot(avatar,Color.YELLOW);
				}
			});
		heart.numHeart(num_h, avatar, image2);
		layout.getChildren().addAll(num_h);
		window.setScene(scene);
		window.show();
		}
	
	public void endGame() {
		// if all enemies are dead; quit conditon '1'
		if (quit == 1) {
			menuBox.WinBoss(window);
		}
		
		
		// if avatar is dead; quit condition '2'
		else if (quit == 2) {
			menuBox.Lose(window);
		}
		
		// if 'Q' is pressed; quit condition '0'
		else {
			menuBox.Quit(window);
		}
		}
	public void shoot(Character p, Color c){
		Bullet bullet;
		if (p == avatar) {
		bullet = new Bullet((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);
		}
		else {
			bullet = new Bullet((int) p.getX() + 110, (int) p.getY() + 170, 5, 20, p.type+"Bullet", c);			
		}
		layout.getChildren().add(bullet);

		// Creates a new timer in which the bullets are shot
		AnimationTimer bulletTimer = new AnimationTimer(){
			@Override
			public void handle(long now){
				// runs the shooter class for the specific bullet, and removes enemies/avatar if hit
				// uses the boolean shooter returns to determine if avatar was hit 
				boolean avatar_hit = bullet.bossShooter(avatar, boss, layout, heart, num_h, image2);
				
				// if avatar is hit, stop the timer, which will run another timer again
				if(avatar_hit) {
					stop();
					}
				
				// if avatar life is zero, then remove the avatar, and set avatar_dead to true
				if (avatar.getLife() == 0) {
					avatar.delete();
					avatar_dead = true;
					}
				
				// if all enemies are killed, set e_dead to true
				if (boss.getBLife() == 0) {
					boss_dead = true;
					}
				}
			};
			bulletTimer.start();
			}

		
		
	
}
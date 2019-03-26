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
	static final int intQuit = 0;
	static final int intWin = 1;
	static final int intLose = 2;

	Stage window;
	Scene scene;
	boolean avatar_dead = false;
	boolean boss_dead = false;
	double t = 0;
	int quit = 0;

	Pane layout = new Pane();
	Image avatarImage = new Image("avatar.png");
	Image heartImage = new Image("heart.png");
	Heart heart = new Heart();
	Avatar avatar = new Avatar(300, 500, 60, 60, "avatar", avatarImage);
	MenuBox menuBox = new MenuBox();
	Image bossImage = new Image("boss.png");
	ArrayList<Character> heartList = new ArrayList<Character>(5);
	Boss boss = new Boss(150, 70, 300, 200, "boss", bossImage);

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
					quit = intLose;
					endGame();
				}
				if (boss_dead) {
					stop();
					quit = intWin;
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
				quit = intQuit;
				endGame();
			}
			else if (avatar.movement(e.getCode()) == true){
				shoot(avatar,Color.YELLOW);
				}
			});
		heart.numHeart(heartList, avatar, heartImage);
		layout.getChildren().addAll(heartList);
		window.setScene(scene);
		window.show();
		}

	public void endGame() {
		// if all enemies are dead; quit conditon '1'
		if (quit == intWin) {
			menuBox.WinBoss(window);
		}


		// if avatar is dead; quit condition '2'
		else if (quit == intLose) {
			menuBox.Lose(window);
		}

		// if 'Q' is pressed; quit condition '0'
		else {
			menuBox.Quit(window);
		}
		}
	public void shoot(Character piece, Color color){
		Bullet bullet;
		if (piece == avatar) {
		bullet = new Bullet((int) piece.getX() + 20, (int) piece.getY(), 5, 20, piece.getType() + "Bullet", color);
		}
		else {
			bullet = new Bullet((int) piece.getX() + 110, (int) piece.getY() + 170, 5, 20, piece.getType() + "Bullet", color);
		}
		layout.getChildren().add(bullet);

		// Creates a new timer in which the bullets are shot
		AnimationTimer bulletTimer = new AnimationTimer(){
			@Override
			public void handle(long now){
				// runs the shooter class for the specific bullet, and removes enemies/avatar if hit
				// uses the boolean shooter returns to determine if avatar was hit
				boolean avatar_hit = bullet.bossShooter(avatar, boss, layout, heart, heartList, heartImage);

				// if avatar is hit, stop the timer, which will run another timer again
				if(avatar_hit) {
					stop();
					}

				// if avatar life is zero, then remove the avatar, and set avatar_dead to true
				if (avatar.getLife() == 0) {
					avatar.delete();
					avatar_dead = true;
					}

				// if the boss is killed, set boss_dead to true
				if (boss.getBossLife() == 0) {
					boss_dead = true;
					}
				}
			};
			bulletTimer.start();
			}




}

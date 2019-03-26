import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;

public class Spaces extends Application {

	// Instance Variables
	static final int intQuit = 0;
	static final int intWin = 1;
	static final int intLose = 2;
	Stage window;
	Scene scene;
	boolean avatar_dead = false; // boolean for when avatar is dead
	boolean enemies_dead = false; // boolean for when all enemies are dead
	int quit = 0; // int for different quit implementations
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>(); // ArrayList of enemies
	Pane layout = new Pane();

	// Importing images
	//https://opengameart.org/content/spaceship-set-4-pixel-art-space-ships
	Image avatarImage = new Image("avatar.png");
	//https://commons.wikimedia.org/wiki/File:Space_invaders_alien.svg
	Image enemyImage = new Image("enemy.png");
	//https://ya-webdesign.com/explore/video-game-heart-png/
	Image heartImage = new Image("heart.png");

	MenuBox menuBox = new MenuBox();
	// Creating five enemies and one avatar
	Avatar avatar = new Avatar(300, 700, 60, 60, "avatar", avatarImage);
	Enemy enemy = new Enemy(40, 40, "enemy", enemyImage);
	Enemy enemy2 = new Enemy(40, 40, "enemy", enemyImage);
	Enemy enemy3 = new Enemy(40, 40, "enemy", enemyImage);
	Enemy enemy4 = new Enemy(40, 40, "enemy", enemyImage);
	Enemy enemy5 = new Enemy(40, 40, "enemy", enemyImage);

	ArrayList<Character> heartList = new ArrayList<Character>(5); // ArrayList to store heart Characters in
	Heart heart = new Heart(); // Creating new heart

	// Main
	public static void main(String[] args){
		launch(args);
		}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Setting primarystage to window and adding the avatar and enemies to the stage
		window = primaryStage;
		window.setTitle("Space Invaders");
		layout.setStyle("-fx-background-color:black;");
		layout.getChildren().add(avatar);
		layout.getChildren().addAll(enemy, enemy2, enemy3, enemy4, enemy5);

		// New animation timer for random movement and shoot of enemy
		// If all enemy or avatar are dead, then timer stops and endGame() is called
		// https://docs.oracle.com/javafx/2/api/javafx/animation/AnimationTimer.html
		AnimationTimer eTimer = new AnimationTimer(){
			@Override
			public void handle(long now){
				// add all enemies to the list
				enemy.setEnemyList(enemy, enemy2, enemy3, enemy4, enemy5);
				enemyList = enemy.getEnemyList();

				// if avatar is dead, then stop the game with quit statement '2'
				if (avatar_dead) {
					stop();
					quit = intLose;
					endGame();
					}

				// if all enemies are dead, then stop the game with quit statement '1'
				if (enemies_dead) {
					stop();
					quit = intWin;
					endGame();
					}

				// for every enemy, move randomly
				for (int i = 0; i < 5; i++) {
					enemyList.get(i).moveRan();
					}

				// for every enemy, if alive, shoot randomly
				for (int i = 0; i < 5; i++) {
					if (enemyList.get(i).enemyShoot() == true) {
						shoot(enemyList.get(i), Color.RED);
						}
					}
				}
			};
			eTimer.start();

			// create a new scene with layout pane
			scene = new Scene(layout, 600, 800, Color.BLACK);
			// when a key is pressed
			scene.setOnKeyPressed(e -> {

				// if the key pressed is 'Q', quit game with quit statement '0'
				if (e.getCode() == KeyCode.Q) {
					quit = intQuit;
					endGame();
					}
				// call avatar.movement to move avatar based on key input
				// if movement returns true then shoot
				else if (avatar.movement(e.getCode()) == true){
					shoot(avatar,Color.YELLOW);
					}
				});

			// add the hearts to the layout, then show the scene
			heart.numHeart(heartList, avatar, heartImage);
			layout.getChildren().addAll(heartList);
			window.setScene(scene);
			window.show();
			}

	// method for ending game. Creates a new window in which a VBox
	// has a button and text. Once the button is pressed the game exits
	public void endGame() {
		// if all enemies are dead; quit conditon '1'
		if (quit == intWin) {
			menuBox.Win(window);
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
	// This method is used to shoot, by calling shooter in bullet
	public void shoot(Character piece, Color color){

		Bullet bullet = new Bullet((int) piece.getX() + 20, (int) piece.getY(), 5, 20, piece.type + "Bullet", color);
		layout.getChildren().add(bullet);

		// Creates a new timer in which the bullets are shot
		AnimationTimer bulletTimer = new AnimationTimer(){
			@Override
			public void handle(long now){
				// runs the shooter class for the specific bullet, and removes enemies/avatar if hit
				// uses the boolean shooter returns to determine if avatar was hit
				boolean avatar_hit = bullet.shooter(avatar, enemyList, layout, heart, heartList, heartImage);

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
				if (avatar.getEnemiesKilled() == 5) {
					enemies_dead = true;
					}
				}
			};
			bulletTimer.start();
			}
}

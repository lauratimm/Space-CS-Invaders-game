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

public class Spaces extends Application{
	// Instance Variables
	Stage window;
	Scene scene;
	boolean avatar_dead = false; // boolean for when avatar is dead
	boolean e_dead = false; // boolean for when all enemies are dead
	int quit = 0; // int for different quit implementations
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>(); // ArrayList of enemies
	Pane layout = new Pane();

	// Importing images
	//https://opengameart.org/content/spaceship-set-4-pixel-art-space-ships
	Image image = new Image("avatar.png");
	//https://commons.wikimedia.org/wiki/File:Space_invaders_alien.svg
	Image image2 = new Image("enemy.png");
	//https://ya-webdesign.com/explore/video-game-heart-png/
	Image image3 = new Image("heart.png");
	
	// Creating five enemies and one avatar
	Avatar avatar = new Avatar(300, 700, 60, 60, "avatar", image);
	Enemy alien = new Enemy(300, 200, 40, 40, "enemy", image2);
	Enemy alien2 = new Enemy(100, 300, 40, 40, "enemy", image2);
	Enemy alien3 = new Enemy(200, 200, 40, 40, "enemy", image2);
	Enemy alien4 = new Enemy(300, 300, 40, 40, "enemy", image2);
	Enemy alien5 = new Enemy(250, 350, 40, 40, "enemy", image2);

	ArrayList<Character> num_h = new ArrayList<Character>(5); // ArrayList to store heart Characters in
	Heart heart = new Heart(); // Creating new heart

	// Main
	public static void main(String[] args){
		launch(args);
		}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		// Setting primarystage to window and adding the avatar and enemies to the stage
		window = primaryStage;
		window.setTitle("Space Invaders");
		layout.getChildren().add(avatar);
		layout.getChildren().addAll(alien, alien2, alien3, alien4, alien5);
		
		// New animation timer for random movement and shoot of enemy
		// If all enemy or avatar are dead, then timer stops and endGame() is called
		// https://docs.oracle.com/javafx/2/api/javafx/animation/AnimationTimer.html
		AnimationTimer eTimer = new AnimationTimer(){
			@Override
			public void handle(long now){
				// add all enemies to the list
				alien.setEnemyList(alien, alien2, alien3, alien4, alien5);
				enemyList = alien.getEnemyList();
				
				// if avatar is dead, then stop the game with quit statement '2'
				if (avatar_dead) {
					stop();
					quit = 2;
					endGame();
					}
				
				// if all enemies are dead, then stop the game with quit statement '1'
				if (e_dead) {
					stop();
					quit = 1;
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
					quit = 0;
					endGame();
					}
				// call avatar.movement to move avatar based on key input
				// if movement returns true then shoot
				else if (avatar.movement(e.getCode()) == true){
					shoot(avatar,Color.YELLOW);
					}
				});
			
			// add the hearts to the layout, then show the scene
			heart.numHeart(num_h, avatar, image3);
			layout.getChildren().addAll(num_h);
			window.setScene(scene);
			window.show();
			}
	
	// method for ending game. Creates a new window in which a VBox
	// has a button and text. Once the button is pressed the game exits
	public void endGame() {
		Button b1 = new Button ("Quit Game");
		Text won = new Text (10, 10, "You Won!");
		Text lost = new Text ("You Lost!");
		VBox vbox = new VBox();
		
		// if all enemies are dead; quit conditon '1'
		if (quit == 1) {
			vbox.getChildren().add(won);
			vbox.getChildren().add(b1);
			vbox.setAlignment(Pos.CENTER);
			Stage newstage = new Stage();
			Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
			newstage.setScene(newscene);
			newscene.setFill(Color.BLACK);
			newstage.show();
			
			b1.setOnAction(e -> {
				window.close();
				newstage.close();
				});
			}
		
		// if avatar is dead; quit condition '2'
		else if (quit == 2) {
			vbox.getChildren().add(lost);
			vbox.getChildren().add(b1);
			vbox.setAlignment(Pos.CENTER);
			Stage newstage = new Stage();
			Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
			newstage.setScene(newscene);
			newscene.setFill(Color.BLACK);
			newstage.show();
			
			b1.setOnAction(e -> {
				window.close();
				newstage.close();
				});
			}
		
		// if 'Q' is pressed; quit condition '0'
		else {
			vbox.getChildren().add(b1);
			vbox.setAlignment(Pos.CENTER);
			Stage newstage = new Stage();
			Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
			newstage.setScene(newscene);
			newscene.setFill(Color.BLACK);
			newstage.show();
			
			b1.setOnAction(e -> {
				window.close();
				newstage.close();
				});
			}
		}
	// This method is used to shoot, by calling shooter in bullet
	public void shoot(Character p, Color c){

		Bullet bullet = new Bullet((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);
		layout.getChildren().add(bullet);

		// Creates a new timer in which the bullets are shot
		AnimationTimer bulletTimer = new AnimationTimer(){
			@Override
			public void handle(long now){
				// runs the shooter class for the specific bullet, and removes enemies/avatar if hit
				// uses the boolean shooter returns to determine if avatar was hit 
				boolean avatar_hit = bullet.shooter(avatar, enemyList, layout, heart, num_h, image3);
				
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
				if (avatar.getE_killed() == 5) {
					e_dead = true;
					}
				}
			};
			bulletTimer.start();
			}
}
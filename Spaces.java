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
	Stage window;
	Scene scene;
	boolean avatar_dead = false;
	boolean e_dead = false;
	int quit = 0;
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
				if (avatar_dead) {
					stop();
					quit = 2;
					endGame();
					}
				if (e_dead) {
					stop();
					quit = 1;
					endGame();
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
			heart.numHeart(numli, avatar, image3);
			layout.getChildren().addAll(numli);
			window.setScene(scene);
			window.show();
			}
	public void endGame() {
		Button b1 = new Button ("Quit Game");
		Text won = new Text (10, 10, "You Won!");
		Text lost = new Text ("You Lost!");
		VBox vbox = new VBox();
		
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
	public void shoot(Character p, Color c){

		Bullet bullet = new Bullet((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);
		layout.getChildren().add(bullet);

		AnimationTimer bulletTimer = new AnimationTimer(){
			@Override
			public void handle(long now){
				boolean avatar_hit = bullet.shooter(avatar, enemyList, layout, heart, numli, image3);
				if(avatar_hit) {
					stop();
					}
				if (avatar.getLife() == 0) {
					avatar.delete();
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
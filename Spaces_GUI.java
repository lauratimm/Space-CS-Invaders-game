import java.util.ArrayList;
import javafx.scene.input.KeyCode;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Spaces_GUI extends Application {
	Stage stage;
	static Scene scene;
	static Image avatar_image = new Image("avatar.png");
	static Pane pane = new Pane();
	Avatar_GUI avatar = new Avatar_GUI(avatar_image, 60, 60, 265, 700);
	static Image enemy_image = new Image("enemy.png");
	static Image heart_image = new Image("heart.png");
	static Image bullet_image = new Image("mario1.gif");
	static Image bullete_image = new Image("luigi1.gif");
	
	
	Enemy_GUI enemy1 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy2 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy3 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy4 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	Enemy_GUI enemy5 = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	ArrayList<Enemy_GUI> enemy_list = new ArrayList<Enemy_GUI>(5);
	Heart_GUI heart = new Heart_GUI(heart_image, 20, 20, 10, 10);
	Heart_GUI heart2 = new Heart_GUI(heart_image, 20, 20, 40, 10);
	Heart_GUI heart3 = new Heart_GUI(heart_image, 20, 20, 70, 10);
	Heart_GUI heart4 = new Heart_GUI(heart_image, 20, 20, 100, 10);
	Heart_GUI heart5 = new Heart_GUI(heart_image, 20, 20, 130, 10);
	ArrayList<Heart_GUI> heart_list = new ArrayList<Heart_GUI>(5);

	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start (Stage stage) {
		this.stage = stage;
		stage.setTitle("Space Invaders");
		pane.setStyle("-fx-background-color:black;");
		pane.getChildren().add(avatar.getIV());
		pane.getChildren().addAll(enemy1.getIV(), enemy2.getIV(), enemy3.getIV(), enemy4.getIV(), enemy5.getIV());
		AnimationTimer eTimer = new AnimationTimer() {
			@Override 
			public void handle(long now) {
				enemy_list.add(enemy1);
				enemy_list.add(enemy2);
				enemy_list.add(enemy3);
				enemy_list.add(enemy4);
				enemy_list.add(enemy5);
				for (int i = 0; i < 5; i++) {
					enemy_list.get(i).moveRan();
				}
			for (int i = 0; i <5; i++) {
				if(enemy_list.get(i).enemyShoot()) {
					shoot(enemy_list.get(i), "enemy" + i);
				}
			}
			}
		};
		
		eTimer.start();
		heart_list.add(heart);
		heart_list.add(heart2);
		heart_list.add(heart3);
		heart_list.add(heart4);
		heart_list.add(heart5);
		pane.getChildren().addAll(heart.getIV(), heart2.getIV(), heart3.getIV(), heart4.getIV(), heart5.getIV());
		scene = new Scene(pane, 600, 800, Color.BLACK);
		scene.setOnKeyPressed(e -> {
			avatar.movement(e.getCode());
			if (avatar.getShoots()) {
				shoot(avatar, "avatar");
			}
		});
		stage.setScene(scene);
		stage.show();
		
	}
	public void shoot(Character character, String type) {
		Bullet_GUI bullet;
		if (type == "avatar") {
			bullet = new Bullet_GUI(bullet_image, 60, 35, character.getX_coordinate(), character.getY_coordinate(), type); 
		}
		else {
		bullet = new Bullet_GUI(bullete_image, 50, 35, character.getX_coordinate(), character.getY_coordinate() + 30, type); 
		}
		
		pane.getChildren().add(bullet.getIV());
		AnimationTimer bulletTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				bullet.shootAvatar(enemy_list, pane);
			}
		};
		bulletTimer.start();
		
	}
	
}

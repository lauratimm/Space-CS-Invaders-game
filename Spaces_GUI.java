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
	Enemy_GUI enemy = new Enemy_GUI(enemy_image, 60, 60, 400, 500);
	
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start (Stage stage) {
		this.stage = stage;
		stage.setTitle("Space Invaders");
		pane.setStyle("-fx-background-color:black;");
		pane.getChildren().add(avatar.getIV());
		pane.getChildren().add(enemy.getIV());
		scene = new Scene(pane, 600, 800, Color.BLACK);
		scene.setOnKeyPressed(e -> {
			avatar.movement(e.getCode());
		});
		stage.setScene(scene);
		stage.show();
		
	}
	
}

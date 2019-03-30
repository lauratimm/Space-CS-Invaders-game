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
    public Spaces(){}
    // Importing images
    //https://commons.wikimedia.org/wiki/File:Space_invaders_alien.svg
    Image enemyImage = new Image("enemy.png");


    Stage window;
    Scene scene;
    Pane layout = new Pane();
    CharacterGUI enemy1 = new EnemyGUI(40,40, "enemy", enemyImage);
    CharacterGUI enemy2 = new EnemyGUI(40,40, "enemy", enemyImage);
    CharacterGUI enemy3 = new EnemyGUI(40,40, "enemy", enemyImage);
    CharacterGUI enemy4 = new EnemyGUI(40,40, "enemy", enemyImage);
    CharacterGUI enemy5 = new EnemyGUI(40,40, "enemy", enemyImage);

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
        // create a new scene with layout pane
        scene = new Scene(layout, 600, 800, Color.BLACK);
        layout.getChildren().addAll(enemy1,enemy2,enemy3,enemy4,enemy5);//add enemies
        window.setScene(scene);
        window.show();
    }


}
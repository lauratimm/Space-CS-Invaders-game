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

    Stage window;
    Scene scene;
    Pane layout = new Pane();


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
        // when a key is pressed
        layout.getChildren().addAll();//add enemies
        window.setScene(scene);
        window.show();
    }


}
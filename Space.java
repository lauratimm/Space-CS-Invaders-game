import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.event.*;
import javafx.scene.input.*;

public class Space extends Application{



    public void start(Stage primaryStage) {
        StackPane stackpane = new StackPane();

        Image space = new Image("space.jpg");
        ImageView iv = new ImageView(space);
        Button sh = new Button();

        stackpane.getChildren().add(iv);

        Avatar ship = new Avatar();
        Rectangle r = ship.getShip();
        VBox grid = new VBox();
        //grid.getChildren().add(r);
        stackpane.getChildren().add(grid);
        grid.getChildren().add(sh);
        //sh.setOnKeyPress(new EventHandler <KeyEvent>());
        //.root.add(iv, 0,0);
        Scene scene = new Scene(stackpane, 442, 784); //you can replace these (different window, highscore, play game)
        primaryStage.setTitle("CS Invaders");
        primaryStage.setScene(scene);
        primaryStage.show();// show the window
        scene.setOnKeyPressed(this);
            @Override
            public void handle(KeyEvent event){
                System.out.println("click");
            }
        }
    }





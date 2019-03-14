import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.application.Platform;


public class MenuBox{


  public static void display(String title, String message, String m){

    Stage window1 = new Stage();
    String mode = "Q";

    //window1.initModality(Modality.APPLICATION_MODAL);
    window1.setTitle(title);
    window1.setMinWidth(250);

    Label label = new Label();
    label.setText(message);


    Button exitP = new Button("exit");
    Button restartP = new Button("restart");
    Button back = new Button("Go Back");



    VBox layout = new VBox(10);
    if (mode.equals(m)){
      layout.getChildren().addAll(label, exitP, restartP, back);
      layout.setAlignment(Pos.CENTER);
    }
    else{
      layout.getChildren().addAll(label, exitP, restartP);
      layout.setAlignment(Pos.CENTER);
    }


    Scene scene = new Scene(layout);
    window1.setScene(scene);

    exitP.setOnAction(e -> {
      Spaces.restart = false;
      Platform.exit();
    });
    restartP.setOnAction(e -> {


      Spaces.restart = true;
      Platform.exit();

    });
    back.setOnAction(e -> {
      window1.close();
    });


    window1.show();


  }

}

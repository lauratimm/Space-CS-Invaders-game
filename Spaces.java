import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.ArrayList;
//import java.animation.TranslateTransition;


public class Spaces extends Application{
  Stage window;
  Scene scene;
  double t = 0;
  Pane layout = new Pane();
  Image image = new Image("avatar.png");
  Image image2 = new Image("enemy.png");
  Image image3 = new Image("heart.png");
  //Image image4 = new Image("gheart.png");
  Avatar avatar = new Avatar(300, 700, 60, 60, "avatar", image);
  Avatar ailen = new Avatar(300, 200, 40, 40, "enemy", image2);
  //Avatar heart = new Avatar(10, 765, 20, 20, "heart", image3);
  int life = 5;
  //ArrayList<Avatar> numli = new ArrayList<Avatar>(5);


  public static void main(String[] args){
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception{
    window = primaryStage;
    window.setTitle("Space Invaders");
    //Image image = new Image("avatar.png");
    //Image image2 = new Image("enemy.png");

    //Obj avatar = new Obj(300, 750, 40, 40, "avatar", Color.BLUE);
    //Avatar avatar = new Avatar(300, 700, 60, 60, "avatar", image);
    //Avatar ailen = new Avatar(300, 200, 60, 60, "enemy", image2);
    //Enemy enemy = new Enemy(60,60,"enemy", image2);




    //Pane layout = new Pane();
    layout.getChildren().add(avatar);
    layout.getChildren().add(ailen);
    //layout.getChildren().add(heart);
    //layout.getChildren().add(enemy);



    AnimationTimer eTimer = new AnimationTimer(){
      @Override
      public void handle(long now){
        //update();
        ailen.moveRan();
        if (Math.random() < 0.01){
          if (!ailen.dead){
            shoot(ailen, Color.RED);
          }
          //shoot(ailen);
        }
      }
    };

    eTimer.start();








    scene = new Scene(layout, 600, 800, Color.BLACK);


    scene.setOnKeyPressed(e -> {
      switch (e.getCode()){
        case A:
          avatar.moveLeft();
          //System.out.println(avatar.getX());

          break;
        case D:
          avatar.moveRight();

          break;
        case W:
          avatar.moveUp();

          break;
        case S:
          avatar.moveDown();

          break;
        case SPACE:
          shoot(avatar,Color.YELLOW);


          break;
      }
    });




    numHeart();
    window.setScene(scene);
    window.show();
  }


  public void numHeart(){
    int f = 10;
    ArrayList<Avatar> numli = new ArrayList<Avatar>(5);
    for (int i = 0; i < life; i++){
      Avatar h = new Avatar(f, 765, 20, 20, "heart", image3);
      numli.add(h);
      f+=30;
    }
    for (Avatar a: numli){
      layout.getChildren().add(a);


    }

    /**
    int f = 10;
    for (int i = 0; i < life; i++){
      Avatar h = new Avatar(f, 765, 20, 20, "heart", image3);
      f += 30;
      layout.getChildren().add(h);

    }
    */

  }



/**
  public List<Avatar> avatarss() {
          return layout.getChildren().stream().map(n -> (Avatar)n).collect(Collectors.toList());
      }
*/



  public void update(){



  }



  public void shoot(Avatar p, Color c){

    Obj s = new Obj((int) p.getX() + 20, (int) p.getY(), 5, 20, p.type+"Bullet", c);



    layout.getChildren().add(s);
    //System.out.println(s.type);


    AnimationTimer bTimer = new AnimationTimer(){
      @Override
      public void handle(long now){
        //ailen.moveRan();
        //s.moveUp();
        if (s.type.equals("avatarBullet")){
          if (!s.getBoundsInParent().intersects(ailen.getBoundsInParent()) && s.getTranslateY() > -20) {
            //System.out.println("s");

            s.moveUp();

          }
          else if (s.getBoundsInParent().intersects(ailen.getBoundsInParent()) ){
            ailen.dead = true;
            layout.getChildren().remove(ailen);
            layout.getChildren().remove(s);
            //closeProgram();
            //t.stop();

            //System.out.println(ailen.dead);

          }

          //System.out.println("ss");
          //s.moveUp();
        }

        else if (s.type.equals("enemyBullet") ){
          if (!s.getBoundsInParent().intersects(avatar.getBoundsInParent()) && s.getTranslateY() < 800){
            //System.out.println("a");
            s.moveDown();
          }
          else if (s.getBoundsInParent().intersects(avatar.getBoundsInParent())){
            //avatar.dead = true;
            layout.getChildren().remove(s);



            //System.out.println(life);
          }
        }

      }
    };

    bTimer.start();




    //update();
  }

  public void loseLife(){
    life -= 1;
  }



/**
  public int getBX(){
    return shoot().getTranslateX();
  }

  public int getBY(){
    return shoot().getTranslateY();
  }
*/


}

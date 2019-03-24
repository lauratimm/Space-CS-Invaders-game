import java.util.ArrayList;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;

import javafx.scene.image.Image;

public class Boss extends Character{
  private int bLife = 123;

  ArrayList<String> bossHp = new ArrayList<String>();
  //Text t = new Text();
  //Text t = new Text(20,400,String.join("",bossHp));
  //String joined = String.join("",bossHp);
  //Text t;
  //Text t = new Text(20,400,);
  Text t;
  //Text t = new Text(20,400,"22"+shp());
  //Text t = new Text(20,400,"dfsdfdsfsfdfs");
  //Text ts = t;
  //Text t = new Text();



  //Text t;




  public Boss (int x, int y, int w, int h, String t, Image image){
    super(x, y, w, h, t, image);
  }



  public void numHp(){

    for (int i = 0; i<bLife; i++){
      bossHp.add("|");
    }
    //Text t = new Text(20,400,"22"+shp());

    //joined = String.join("",bossHp);
    //String sBossHp = String.join("",bossHp);
  }

  public void removeHp(){
    bossHp.removeAll(bossHp);

    for (int i = 0; i<bLife; i++){
      bossHp.add("|");
    }
    //Text t = new Text(20,400,"22"+shp());

    //joined = String.join("",bossHp);
    //String sBossHp = String.join("",bossHp);

  }
  public int getBLife() {
		return bLife;
	}
	public void loseBLife() {
		bLife -= 1;
	}
  public String shp(){
    //Text t = new Text(400,400,String.join("",bossHp));
    //Text t = new Text(200,400,"||||||||||||||||||||||||||||||");
    return String.join("",bossHp);
  }
/*
  public void rthp(){
    layout.getChildren().remove(t);
    //move to bossfight
    Text t = new Text(200,400,String.join("",bossHp));
    t.setStyle("-fx-font: 30 arial;");
    //t.setFont(20);
    t.setFill(Color.RED);
    layout.getChildren().add(t);

  }
  */
  public void setHp(){
    //layout.getChildren().remove(t);
    //move to bossfight
    //Text r = t;
    Text h = new Text(10,55,String.join("",bossHp));

    h.setStyle("-fx-font: 18 arial;");
    h.setFill(Color.GREY);

    //System.out.println("b");
    this.t = h;
  }
  public Text getHp(){

    return t;
  }



}

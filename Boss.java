import java.util.ArrayList;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;

import javafx.scene.image.Image;

public class Boss extends Enemy{
  private int bLife = 123;

  ArrayList<String> bossHp = new ArrayList<String>();
  Text t;
  public Boss (int x, int y, int w, int h, String t, Image image){
    super(x, y, w, h, t, image);
  }



  public void numHp(){

    for (int i = 0; i<bLife; i++){
      bossHp.add("|");
    }
  }

  public void removeHp(){
    bossHp.removeAll(bossHp);

    for (int i = 0; i<bLife; i++){
      bossHp.add("|");
    }

  }
  public int getBLife() {
		return bLife;
	}
	public void loseBLife() {
		bLife -= 1;
	}
  public String shp(){
    return String.join("",bossHp);
  }
  public void setHp(){
    Text h = new Text(10,55,String.join("",bossHp));

    h.setStyle("-fx-font: 18 arial;");
    h.setFill(Color.GREY);

    this.t = h;
  }
  public Text getHp(){

    return t;
  }



}

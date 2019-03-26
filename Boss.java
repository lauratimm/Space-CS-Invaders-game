import java.util.ArrayList;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;

import javafx.scene.image.Image;

public class Boss extends Enemy {
  private int bossLife = 123;

  ArrayList<String> bossHp = new ArrayList<String>();
  Text t;
  public Boss (int xCoord, int yCoord, int width, int height, String type, Image image){
    super(xCoord, yCoord, width, height, type, image);
  }

  public void numHp() {
    for (int i = 0; i < bossLife; i++) {
      bossHp.add("|");
    }
  }

  public void removeHp() {
    bossHp.removeAll(bossHp);

    for (int i = 0; i < bossLife; i++) {
      bossHp.add("|");
    }
  }

  public int getBossLife() {
		return bossLife;
	}

	public void loseBossLife() {
		bossLife --;
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

public boolean bossShoot() {
	return false;
}
}

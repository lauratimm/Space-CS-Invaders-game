import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.geometry.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Bullet extends Rectangle{
	
	private String type;
	
	// Bullet
	public Bullet(int x, int y, int w, int h, String t, Color color){
		super(w, h, color);
		this.type = t;
		setTranslateX(x);
		setTranslateY(y);
	}

	public void moveUp(){
		setTranslateY(getTranslateY() - 5);
	}

	public void moveDown(){
		setTranslateY(getTranslateY() + 3);
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public int shooter (Avatar avatar, ArrayList<Enemy> enemyList, Pane layout, Heart heart, ArrayList<Character>numli, Image image3) {
		int ret = 0;
		for (int i = 0; i < 5; i++) {
			if (this.getType().equals("avatarBullet")){
				if (!this.getBoundsInParent().intersects(enemyList.get(i).getBoundsInParent()) && this.getTranslateY() > -20) {
					this.moveUp();
				}
				else if (this.getBoundsInParent().intersects(enemyList.get(i).getBoundsInParent()) ){
					enemyList.get(i).dead = true;
					layout.getChildren().remove(enemyList.get(i));
					layout.getChildren().remove(this);
					enemyList.get(i).delete();
					avatar.setE_killed(avatar.getE_killed() + 1);
				}
			}
			else if (this.getType().equals("enemyBullet") ){
				int count = 0;
				if (!this.getBoundsInParent().intersects(avatar.getBoundsInParent()) && this.getTranslateY() < 800){
					this.moveDown();
				}
				else if (this.getBoundsInParent().intersects(avatar.getBoundsInParent())){
					layout.getChildren().remove(this);
					//layout.getChildren().remove(avatar);
					ret = 2;
				}
			}

		}
		if (this.getBoundsInParent().intersects(avatar.getBoundsInParent())){
			if (avatar.getLife()>0){
				avatar.loseLife();
				layout.getChildren().removeAll(numli);
				heart.removeHeart(numli, avatar, image3);
				layout.getChildren().addAll(numli);
				System.out. println(avatar.getLife());
			}

	}


		
		return ret;
	}

	
}

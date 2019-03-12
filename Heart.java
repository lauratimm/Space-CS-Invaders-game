import java.util.ArrayList;

import javafx.scene.image.Image;

public class Heart {

	public void numHeart(ArrayList<Character> list, Avatar avatar, Image image){
		int f = 10;
		for (int i = 0; i < avatar.getLife(); i++){
			Character insertHeart = new Character(f, 10, 20, 20, "heart", image);
			list.add(insertHeart);
			f+=30;
		}

}
	public void removeHeart(ArrayList<Character> list, Avatar avatar, Image image){
		list.removeAll(list);
		int f = 10;
		for (int i = 0; i < avatar.getLife(); i++){
			Character insertHeart = new Character(f, 10, 20, 20, "heart", image);
			list.add(insertHeart);
			f+=30;
		}
		
	}

}

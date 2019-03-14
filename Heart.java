import java.util.ArrayList;

import javafx.scene.image.Image;

// This class creates a Heart object which uses a list of Characters
// the Avatar, and the image of the heart, and adds Hearts of type Character
// to the list
public class Heart {

	// This method uses a list, Avatar, and image. It gets the number of lives the 
	// Avatar has and use it to add the respective number of hearts to the list
	public void numHeart(ArrayList<Character> list, Avatar avatar, Image image){
		int heart_x = 10; // x-coordiante of the heart
		for (int i = 0; i < avatar.getLife(); i++){
			Character insertHeart = new Character(heart_x, 10, 20, 20, "heart", image);
			list.add(insertHeart);
			heart_x+=30;
			}
		}
	// This method uses a list, Avatar, and image. Revmoes all the hearts from the list
	// Then It gets the number of lives the Avatar has and use it to add the respective 
	// number of hearts to the list
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
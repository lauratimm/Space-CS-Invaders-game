import java.util.ArrayList;

import javafx.scene.image.Image;

/* This class creates a Heart object which uses a list of Characters
   the Avatar, and the image of the heart, and adds Hearts of type Character
   to the list */
public class Heart {

	static final int start_x = 10;
	static final int x_gap = 30;
	static final int heart_y = 10;
	static final int heart_width = 20;
	static final int heart_length = 20;

	/* This method uses a list, Avatar, and image. It gets the number of lives the
	   Avatar has and use it to add the respective number of hearts to the list */
	public void numHeart(ArrayList<Character> list, Avatar avatar, Image image){
		int heart_x = start_x;
		for (int i = 0; i < avatar.getLife(); i++){
			Character insertHeart = new Character(heart_x, heart_y, heart_width,
			heart_length, "heart", image);
			list.add(insertHeart);
			heart_x += x_gap;
			}
		}
	/* This method uses a list, Avatar, and image. Revmoes all the hearts from the list
	   Then It gets the number of lives the Avatar has and use it to add the respective
	   number of hearts to the list */
	public void removeHeart(ArrayList<Character> list, Avatar avatar, Image image){
		list.removeAll(list);
		//int f = 10;
		numHeart(list, avatar, image);
		}
}

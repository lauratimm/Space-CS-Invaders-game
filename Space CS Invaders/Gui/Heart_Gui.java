package Gui;

import java.util.ArrayList;

import Logic.Heart_Logic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This is the GUI class for the hearts of the avatar and boss
 * It creates an ArrayList of ImageView heart objects and extends off the 
 * Heart_Logic logic class to use the parent class' instance variables to
 * set the position, and remove hearts
 * It also has a constant width and height for the ImageView hearts
 */
public class Heart_Gui extends Heart_Logic {
    final int HEART_WIDTH_AND_HEIGHT = 20;
    private Image heart_image;
    private ArrayList<ImageView> heart_iv_list = new ArrayList<ImageView>();

    /**
     * This constructor sets the Image of the hearts to the provided
     * Image object
     * 
     * @param heart_image The Image object to set heart_image to
     */
    public Heart_Gui(Image heart_image) {
        setHeart_image(heart_image);
    }

    /**
     * This getter method gets the Image instance of the heart_image
     * 
     * @return The image of the heart
     */
    public Image getHeart_image() {
        return heart_image;
    }

    /**
     * This setter method sets the Image instance of the heart_image
     * 
     * @param heart_image The Image instance to set the heart_image to
     */
    public void setHeart_image(Image heart_image) {
        this.heart_image = heart_image;
    }
    
    /**
     * This method adds hearts to the Pane provided based on the x_coordinate 
     * provided. It first removes the hearts from the Pane, resets the parent 
     * class' heartList. Then based on the size of the heartList, the method will 
     * add ImageView heart objects to the provided Pane
     * 
     * @param pane The provided Pane object to add the hearts
     * @param x_coordinate The x coordinate to start placing the hearts at
     */
    public void addHearts(Pane pane, int x_coordinate) {
        removeHearts(pane);
        super.removeHeartList();
        super.createHeartList(x_coordinate);
        for (int i = 0; i < super.getHeartList().size(); i++) {
        	/* set xCoord to the specific x value to set the heart_iv to 
             * based on the int and index i in heartList
             */
        	int xCoord = super.getHeartList().get(i); 
            ImageView heart_iv = new ImageView();
            heart_iv.setImage(getHeart_image());
            heart_iv.setX(xCoord);
            heart_iv.setY(super.getY());
            heart_iv.setFitHeight(HEART_WIDTH_AND_HEIGHT);
            heart_iv.setFitWidth(HEART_WIDTH_AND_HEIGHT);
            pane.getChildren().add(heart_iv);
            heart_iv_list.add(heart_iv); // adds the ImageView instance to the heart_iv_list
        }
    }
    
    /**
     * This method removes all of the ImageView hearts from the Pane object
     * provided, using the heart_iv_list to get the ImageView instances of 
     * the hearts to remove
     * 
     * @param pane The provided Pane object to remove the hearts from
     */
    public void removeHearts(Pane pane) {
        for (int i = 0; i < heart_iv_list.size(); i++) {
            pane.getChildren().remove(heart_iv_list.get(i));
        }
        heart_iv_list.clear(); // removes all objects from the heart_iv_list
    }
}


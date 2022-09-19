package Gui;

import Logic.Bullet_Logic;
import Logic.Avatar_Logic;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * This is the GUI class of our bullet for our game (boss level)
 * It creates an ImageView of an image provided and extends off the 
 * Bullet_Logic logic class to use the parent class' instance variables to 
 * set the position, more, and delete the ImageView object
 * It also sets the width and height of the ImageView object
 * and moves ImageView of bullet until it hits something
 */
public class Boss_Bullet_Gui extends Bullet_Logic {
    final int TOP_BOUND = -20;
    final int BOTTOM_BOUND= 800;
    private Image bullet_image;
    private ImageView bullet_iv = new ImageView();
    private int bullet_width;
    private int bullet_height;
    private String type;

    /**
     * This constructor creates an instance of Boss_Bullet_Gui
     * by creating an ImageView with the specific width, height,
     * and calls Bullet_Logic constructor to set the X and Y coordinate
     * 
     * @param image The image file that the bullet will use
     * @param width The width of the bullet
     * @param height The height of the bullet
     * @param x_coordinate The x-coordinate of the bullet
     * @param y_coordinate The y-coordinate of the bullet
     * @param type The type of bullet (avatar or boss)
     */
    public Boss_Bullet_Gui(Image image, int width, int height, int x_coordinate, int y_coordinate, String type) {
        super (x_coordinate,y_coordinate);
        setBullet_image(image);
        bullet_iv.setImage(getBullet_image());
        bullet_iv.setX(getX_coordinate());
        bullet_iv.setY(getY_coordinate());
        setBullet_width(width);
        setBullet_height(height);
        setType(type);
        super.setMovement(15); // sets the bullet to move 15 pixels every time
    }

    /**
     * This getter method returns the ImageView instance of the bullet
     * 
     * @return bullet_iv The ImageView of the bullet
     */
    public ImageView getBullet_iv() {
        return bullet_iv;
    }

    /**
     * This getter method returns the Image instance of the bullet
     * 
     * @return bullet_iamge The Image of the bullet
     */
    public Image getBullet_image() {
        return bullet_image;
    }
    
    /**
     * This is a getter method which returns the type of the bullet
     * 
     * @return type This bullet's type String
     */
    public String getType() {
        return type;
    }

    /**
     * This setter method sets the type of bullet based 
     * on String provided
     * 
     * @param type The String type of bullet
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * This sets the image of the bullet
     * 
     * @param image the image that the bullet will use
     */
    public void setBullet_image(Image image) {
        this.bullet_image = image;
    }

    /**
	 * This method sets the width of the bullet and the width
	 * of the ImageView of bullet based on the integer width 
	 * provided
	 * 
	 * @param bullet_width The integer width to set the bullet_width to
	 */
    public void setBullet_width(int width) {
        bullet_iv.setFitWidth(width);
        this.bullet_width = width;
    }

    /**
	 * This method sets the height of the bullet and the height
	 * of the ImageView of bullet based on the integer height 
	 * provided
	 * 
	 * @param bullet_height The integer width to set the bullet_height to
	 */
    public void setBullet_height(int height) {
        bullet_iv.setFitHeight(height);
        this.bullet_height = height;
    }

    /**
	 * This method is used to remove the ImageView object of bullet
	 * from the boundaries of the Pane that the ImageView is in
	 * It calls the parent delete method to change x and y values
	 */
    public void delete() {
        super.delete();
        bullet_iv.setX(getX_coordinate());
        bullet_iv.setY(getY_coordinate());
    }

    /**
     * This method checks which type of bullet is shot and then calls the respective method
     * and run shootAvatar or shootEnemy accordingly
     * 
     * @param boss The object of the Boss_Gui in Boss_Fight_Gui
     * @param pane The layout pane for the Boss_Fight_Gui
     * @param avatar The object Avatar_Gui that is being used
     * @param heart The Heart_Gui of the avatar
     * @param boss_heart The Heart_Gui of the boss
     * @param bulletTimer The AnimationTimer of the bullets
     */
    public void shoot(Boss_Gui boss, Pane pane, Avatar_Gui avatar, Heart_Gui heart, Heart_Gui boss_heart, AnimationTimer bulletTimer) {
        if (getType().equals("avatar")) {
            this.shootAvatar(boss, pane, boss_heart, avatar, bulletTimer);
        }
        else {
            this.shootEnemy(avatar, pane, heart, bulletTimer);
        }
    }

    /**
     * This method moves the avatar bullet up until it intersects with ImageView of boss
     * and then decreases the boss' hearts by 1 
     * 
     * @param boss The object of the Boss_Gui in Boss_Fight_Gui
     * @param pane The layout Pane for the Boss_Fight_Gui
     * @param boss_heart The Heart_Gui of the boss
     * @param avatar The object Avatar_Gui that is being used
     * @param bulletTimer The AnimationTimer of the bullets
     */
    public void shootAvatar(Boss_Gui boss, Pane pane, Heart_Gui boss_heart, Avatar_Logic avatar, AnimationTimer bulletTimer) {
        // if the avatar bullet is within the bound and hasn't hit the boss yet, the bullet will move up
        if (!bullet_iv.getBoundsInParent().intersects(boss.getBoss_iv().getBoundsInParent())
                && bullet_iv.getTranslateY() > TOP_BOUND) {
            this.moveUp();
            bullet_iv.setX(getX_coordinate());
            bullet_iv.setY(getY_coordinate());
        }
        // if the avatar bullet hits the boss, then remove bullet and remove the boss's life
        else if (bullet_iv.getBoundsInParent().intersects(boss.getBoss_iv().getBoundsInParent()) ){
            pane.getChildren().remove(bullet_iv);
            boss_heart.loseLife();
            bulletTimer.stop();
            //400 is the x-coordinates where the hearts are being placed
            boss_heart.addHearts(pane, 400);
        }
    }

    /**
     * This method moves the boss bullet down until it intersects with ImageView of avatar
     * and then decreases the avatar's hearts by 1 
     * 
     * @param avatar The object Avatar_Gui that is being used
     * @param pane The layout Pane for the Boss_Fight_Gui
     * @param heart The Heart_Gui of the avatar
     * @param bulletTimer The AnimationTimer of the bullets
     */
    public void shootEnemy(Avatar_Gui avatar, Pane pane, Heart_Gui heart, AnimationTimer bulletTimer) {
        // if boss's bullet is within the bound and hasn't hit avatar, then the bullet will move in pattern
        if (!bullet_iv.getBoundsInParent().intersects(avatar.getAvatar_iv().getBoundsInParent())
                && bullet_iv.getTranslateY() < BOTTOM_BOUND){
            this.bossPattern();
            bullet_iv.setX(getX_coordinate());
            bullet_iv.setY(getY_coordinate());
        }
        // if the bullet does intersect with the Avatar_Logic, remove the bullet, and avatar will lose life
        else if (bullet_iv.getBoundsInParent().intersects(avatar.getAvatar_iv().getBoundsInParent())){
            pane.getChildren().remove(bullet_iv);
            heart.loseLife();
            bulletTimer.stop();
            heart.addHearts(pane, 10);
        }
    }
}

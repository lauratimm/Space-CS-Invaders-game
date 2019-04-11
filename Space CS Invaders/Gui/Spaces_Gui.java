package Gui;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * This is the main class for the enemy level of the game
 * It initializes instance variables for the Scene, Stage, Pane and Images
 * and for the various objects used in the method. It has a method to 
 * create instances of the Images, to end the game by calling Menu_Box_Gui class.
 * It also has a method, shoot, which creates Bullet_Logic objects to shoot.
 * This class extends off of Application, and overrides the Application
 * start method with a new start method
 */
public class Spaces_Gui extends Application {
    final int NUM_ENEMIES = 5;
    private Scene scene;
    private Stage stage;
    private Pane pane;
    /*
     * set Text score to be the previous score, by reading a text file 
     * with Read_Score_Gui class
     */
    private Text score = new Text (10, 50, "HighScore: " + Read_Score_Gui.read());
    private Image avatar_image;
    private Image background;
    private Image enemy_image;
    private Image heart_image;
    private Image bullet_image;
    private Image bullet_Enemy_Image;
    private ImageView background_Iv;
    private Menu_Box_Gui menuBox;
    private Avatar_Gui avatar;
    private Heart_Gui heart;
    private Enemy_Gui enemy1;
    private Enemy_Gui enemy2;
    private Enemy_Gui enemy3;
    private Enemy_Gui enemy4;
    private Enemy_Gui enemy5;
    private ArrayList<Enemy_Gui> enemy_list; // ArrayList to store all enemies in
    private String quit = "Quit"; // String used to initiate different menuBox instances by using endGame method
    private boolean avatar_dead = false; // boolean for if avatar has lost all lives
    private boolean enemy_dead = false; // boolean for if all enemies are killed
    
    /**
     * This method creates instances for all the images used in the class
     * by calling their directory in the Gui folder
     */
    public void createImages() {
    	//https://opengameart.org/content/spaceship-set-4-pixel-art-space-ships
        avatar_image = new Image("Gui/avatar.png");  
        //https://wallimpex.com/super-mario-galaxy-backgrounds/5510708.html
        background = new Image("Gui/background.jpg");
        //https://commons.wikimedia.org/wiki/File:Space_invaders_alien.svg
        enemy_image = new Image("Gui/enemy.png");
        //https://ya-webdesign.com/explore/video-game-heart-png/
        heart_image = new Image("Gui/heart.png");
        //https://gfycat.com/stickers/search/mario+64
        bullet_image = new Image("Gui/mario1.gif");
        //https://aminoapps.com/c/undertale/page/blog/happy-days-with-music-pt-2/rk0S_euvgwrY2GPZWpXxjjVgk8EZlD
        bullet_Enemy_Image = new Image("Gui/luigi1.gif");
        background_Iv = new ImageView(background);    
        }
    
    /**
     * This method different methods of menuBox based on the String quit
     * condition, to end the game
     */
    public void endGame() {
        if (quit.equals("Won")) {
            menuBox.Win(stage, heart);
        } 
        else if (quit.equals("Won Boss_Logic")) {
            menuBox.winBoss(stage, heart);
        }
        else if (quit.equals("Lost")) {
            menuBox.lose(stage);
        }
        else {
            menuBox.quit(stage);
        }
    }

    /**
     * This method is used to create an instance of Bullet_Logic object based on the type 
     * of avatar/enemy which shoots the bullet. Then, inside an AnimationTimer
     * it calls the shoot method in Bullet_Logic to move the Bullet_Logic in the Pane.
     * 
     * @param type The String type of the enemy/avatar
     * @param avatar The Avatar_Gui instance
     * @param enemy The Enemy_Gui instance
     */
    public void create_bullet(String type, Avatar_Gui avatar, Enemy_Gui enemy) {
        Bullet_Gui bullet;
        if (type.equals( "avatar")) { // if the object shooting is avatar, create a Bullet_Logic with x and y coordinates of Avatar_Logic
        	// 60 is the avatar bullet width and 35 is the height
            bullet = new Bullet_Gui(bullet_image, 60, 35, avatar.getX_coordinate(), avatar.getY_coordinate(), type); 
        } 
        else { // if the object shooting is enemy, create a Bullet_Logic with x and y coordinates of Enemy_Logic
        	// 50 is the avatar bullet width and 35 is the height
        	bullet = new Bullet_Gui(bullet_Enemy_Image, 50, 35, enemy.getX_coordinate(), enemy.getY_coordinate() + 30, type);
        }
        pane.getChildren().add(bullet.getBullet_iv());
        AnimationTimer bulletTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                bullet.shoot(enemy_list, pane, avatar, heart, this); // 'this' is the bulletTimer
                // if the avatar hearts are 0, set avatar dead to true
                if (heart.getLife() == 0) {
                    avatar.delete();
                    avatar_dead = true;
                }
                // if the avatar has killed 5 enemies, set enemy dead to true
                if (avatar.getEnemies_killed() == NUM_ENEMIES) {
                    enemy_dead = true;
                    stop();
                }
            }
        };
        bulletTimer.start();
    }
    
    /**
     * This method overrides the Application start method
     * and runs the actual Javafx part of the program. It will
     * call createImages to create new Images, then creates instances 
     * of instance variable objects and adds them to the Stage
     * Than it makes enemies randomly shoot and moves/shoots the avatar
     * based on input
     * 
     * @param stage This is the Stage instance where the Javafx application is set
     * 
     * @exception Exception If any error occurs
     */
    @Override
    public void start(Stage stage) {
    	boolean images_exist = true; // set images_exist to true
    	/*
    	 * try to call the createImages method, if it throws an exception
    	 * set images_exist to false 
    	 */
    	try {
    		createImages();
    	} 
    	catch (Exception e) {
    		images_exist = false;
    	}
    	/*
    	 * if the images are created run the rest of the code
    	 * else exit the Platform and print the problem
    	 */
	    if (images_exist) {
	        pane = new Pane();
	        menuBox = new Menu_Box_Gui();
	        /*
	         * create instances of avatar and enemies
	         * with 60 as height and width for all, and 265, 700
	         * as x and y coordinates for the avatar and 400, 500 for
	         * x and y of enemies
	         */
	        avatar = new Avatar_Gui(avatar_image, 60, 60, 265, 700);
	        enemy1 = new Enemy_Gui(enemy_image, 60, 60, 400, 500);
	        enemy2 = new Enemy_Gui(enemy_image, 60, 60, 400, 500);
	        enemy3 = new Enemy_Gui(enemy_image, 60, 60, 400, 500);
	        enemy4 = new Enemy_Gui(enemy_image, 60, 60, 400, 500);
	        enemy5 = new Enemy_Gui(enemy_image, 60, 60, 400, 500);
	        enemy_list = new ArrayList<Enemy_Gui>(5);
	        heart = new Heart_Gui(heart_image);
	        this.stage = stage; // set the instance variable stage to the one provided
	        /*
	         * Set the style, font and fill of the Text score
	         */
	        score.setStyle("-fx-font-weight: bold");
	        score.setFont(Font.font ("Verdana", 20));
	        score.setFill(Color.YELLOW);
	        stage.setTitle("Space Invaders");
	        /*
	         * add everything to the pane
	         */
	        pane.getChildren().addAll(background_Iv);
	        pane.getChildren().add(avatar.getAvatar_iv());
	        pane.getChildren().addAll(enemy1.getEnemy_iv(), enemy2.getEnemy_iv(), enemy3.getEnemy_iv(), enemy4.getEnemy_iv(), enemy5.getEnemy_iv());
	        pane.getChildren().add(score);
	        /*
	         * create an AnimationTimer which randomly moves the enemy
	         * and constantly checks if avatar_dead or enemy_dead are true
	         * it also shoots enemy bullets randomly
	         */
	        AnimationTimer enemyTimer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	                enemy_list.add(enemy1);
	                enemy_list.add(enemy2);
	                enemy_list.add(enemy3);
	                enemy_list.add(enemy4);
	                enemy_list.add(enemy5);
	                for (int i = 0; i < NUM_ENEMIES ; i++) {
	                    enemy_list.get(i).moveRan();
	                }
	                if (avatar_dead) { // if avatar is dead stop timer and quit game by calling endGame
	                    stop();
	                    quit = "Lost";
	                    endGame();
	                }
	                if (enemy_dead) { // if enemies are dead stop the timer and quit game
	                    stop();
	                    quit = "Won";
	                    endGame();
	                }
	                for (int i = 0; i < NUM_ENEMIES; i++) { // for every enemy, if enemyShoot returns true create enemy bullet
	                    if (enemy_list.get(i).enemyShoot()) {
	                        create_bullet("enemy" + i, avatar, enemy_list.get(i));
	                    }
	                }
	            }
	        };
	        enemyTimer.start();
	        heart.addHearts(pane, 10); // add hearts to the pane
	        scene = new Scene(pane, 600, 800, Color.BLACK); // set the scene as the pane with 600 width and 800 height
	        /*
	         * when input is given, call movement in Avatar_Gui
	         * if input is Q, quit the game
	         * if input makes avatar shoot, create an avatar bullet
	         */
	        scene.setOnKeyPressed(e -> {
	            avatar.movement(e.getCode());
	            if (e.getCode() == KeyCode.Q) {
	                quit = "Quit";
	                endGame();
	            }
	            if (avatar.getShoots()) {
	                create_bullet("avatar", avatar, null);
	                avatar.setShoots(false);
	            }
	        });
	        stage.setScene(scene);
	        stage.show();
        }
    	else {
    		System.out.println("Images did not load properly");
    		Platform.exit();
    	}
    }
    
    /**
     * This is the main method, which calls upon the launch
     * method from Application to run the program
     * 
     * @param args The string provided to run the program
     */
    public static void main(String[] args) {
        launch(args);
    }
}
package Gui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This is the main class for the boss level of the game
 * It initializes instance variables for the Scene, Stage, Pane and Images
 * and for the various objects used in the method. It has a method to 
 * create instances of the Images, to end the game by calling Menu_Box_Gui class.
 * It also has a method, shoot, which creates Bullet_Logic objects to shoot.
 * This class extends off of Application, and overrides the Application
 * start method with a new start method
 */
public class Boss_Fight_Gui extends Application {
	private Stage stage;
	private Scene scene;
	private Pane pane = new Pane();
    /*
     * set Text score to be the previous score, by reading a text file 
     * with Read_Score_Gui class
     */
	private Text score = new Text (10, 50, "HighScore: " + Read_Score_Gui.read());
	private Image heart_image;
    private Image avatar_image;
	private Image background;
	private Image bullet_image;
    private Image bullet_Enemy_Image;
	private Image boss_image;
    private ImageView background_Iv;
	private Menu_Box_Gui menuBox;
    private Avatar_Gui avatar;
    private Heart_Gui heart;
    private Heart_Gui boss_heart;
	private Boss_Gui boss;
	private String quit = "Quit"; // String used to initiate different menuBox instances by using endGame method
	// this is from the number of hearts that avatar has in the enemy level
	private static String hearts_Transferred; 
	boolean avatar_dead = false; // boolean for if avatar has lost all lives
	boolean boss_dead = false; // boolean for if all boss has lost all lives
	
	/**
	 * This is a setter method which sets the value of hearts_Transferred
	 * 
	 * @param num_hearts The number of hearts to set hearts_Transferred to
	 */
	public static void setHearts(String num_hearts) {
        hearts_Transferred = num_hearts;
    }
	
	/**
	 * This is a getter method which gets the hearts_Transferred
	 * 
	 * @return hearts_Transferred The number of hearts of avatar from previous level as String
	 */
    public String getHearts() {
        return hearts_Transferred;
    }
    
    /**
     * This method creates instances for all the images used in the class
     * by calling their directory in the Gui folder
     */
    public void createImages() {
        //https://commons.wikimedia.org/wiki/File:Space_invaders_alien.svg
    	boss_image = new Image("Gui/boss.png");
    	//https://opengameart.org/content/spaceship-set-4-pixel-art-space-ships
        avatar_image = new Image("Gui/avatar.png");  
        //https://wallimpex.com/super-mario-galaxy-backgrounds/5510708.html
        background = new Image("Gui/background.jpg");
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
		} else if (quit.equals("Won Boss_Logic")) {
			menuBox.winBoss(stage,heart);
		}

		// if avatar is dead; quit condition '2'
		else if (quit.equals("Lost")) {
			menuBox.lose(stage);
		}

		// if 'Q' is pressed; quit condition '0'
		else {
			menuBox.quit(stage);
		}
	}
	
    /**
     * This method is used to create an instance of Bullet_Logic object based on the type 
     * of avatar/boss which shoots the bullet. Then, inside an AnimationTimer
     * it calls the shoot method in Bullet_Logic to move the Bullet_Logic in the Pane.
     * 
     * @param type The String type of the boss/avatar
     * @param avatar The Avatar_Gui instance
     * @param boss The Boss_Gui instance
     */
	public void shoot(String type, Avatar_Gui avatar, Boss_Gui boss) {
		Boss_Bullet_Gui bullet;
		if (type.equals("avatar")) {// if the object shooting is avatar, create a Bullet_Logic with x and y coordinates of Avatar_Logic
        	// 60 is the avatar bullet width and 35 is the height
			bullet = new Boss_Bullet_Gui(bullet_image, 60, 35, avatar.getX_coordinate(), avatar.getY_coordinate(), type);
		} 
		else {// if the object shooting is boss, create a Bullet_Logic with x and y coordinates of Enemy_Logic
        	// 50 is the avatar bullet width and 35 is the height
			bullet = new Boss_Bullet_Gui(bullet_Enemy_Image, 50, 35, boss.getX_coordinate(), boss.getY_coordinate() + 30, type);
		}
		pane.getChildren().add(bullet.getBullet_iv());
		AnimationTimer bulletTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				bullet.shoot(boss, pane, avatar, heart, boss_heart, this);// 'this' is the bulletTimer
                // if the avatar hearts are 0, set avatar dead to true
				if (heart.getLife() == 0) {
					avatar.delete();
					avatar_dead = true;
				}
				 // if the boss hearts are 0, set boss dead to true
				if (boss_heart.getLife() == 0) {
					boss_dead = true;
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
     * Than it makes boss randomly shoot and moves/shoots the avatar
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
    		menuBox = new Menu_Box_Gui();
    		/*
	         * create instances of avatar and boss
	         * with 60 as height and width for avatar, and 265, 700
	         * as x and y coordinates for the avatar and 400, 500 for
	         * x and y of boss with 100 as width and height
	         */
    		boss = new Boss_Gui(boss_image, 100, 100, 400, 500);
			avatar = new Avatar_Gui(avatar_image, 60, 60, 265, 700);
    		boss_heart = new Heart_Gui(heart_image);
    		heart = new Heart_Gui(heart_image);
			this.stage = stage;// set the instance variable stage to the one provided
	        /*
	         * Set the style, font and fill of the Text score
	         */
	        score.setStyle("-fx-font-weight: bold");
	        score.setFont(Font.font ("Verdana", 20));
	        score.setFill(Color.YELLOW);
			stage.setTitle("Space Invaders Boss_Logic Fight");
			/*
	         * add everything to the pane
	         */
			pane.getChildren().addAll(background_Iv);
			pane.getChildren().add(avatar.getAvatar_iv());
			pane.getChildren().add(boss.getBoss_iv());
			pane.getChildren().add(score);
			/*
	         * create an AnimationTimer which randomly moves the boss
	         * and constantly checks if avatar_dead or boss_dead are true
	         * it also shoots boss bullets randomly
	         */
			AnimationTimer eTimer = new AnimationTimer() {
				@Override
				public void handle(long now) {
					boss.moveRan();
					if (avatar_dead) { // if avatar is dead stop timer and quit game by calling endGame
						stop();
						quit = "Lost";
						endGame();
					}
					if (boss_dead) { // if enemies are dead stop the timer and quit game
						stop();
						quit = "Won Boss_Logic";
						endGame();
					}
					if (boss.enemyShoot()) { 
						shoot("enemy" + 1, avatar, boss);
					}
	
				}
			};
			eTimer.start();
	        heart.setLife(Integer.parseInt(getHearts()));
	        // add hearts to the pane
			heart.addHearts(pane, 10);
			boss_heart.addHearts(pane, 400);
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
					shoot("avatar", avatar, boss);
				}
			});
			stage.setScene(scene);
			stage.show();
		}
    	else {
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
        setHearts(args[0]);
        launch(args);
	}
}

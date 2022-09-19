package Gui;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class is for the Menu Box that comes up when you press 'q',
 * win, or lose the game. Then you have the option to quit
 * or fight boss if you win the first level
 * When you win the boss level the score is then displayed in the last menu box
 */
public class Menu_Box_Gui {
    private Button quit_Button = new Button("Quit Game");
    private Button fightBoss_Button = new Button("Fight Boss");
    private int hearts_Transferred = 0;
    private Text won = new Text(10, 10, "You Won!");
    private Text lost = new Text(10, 10, "You Lost!");
    private VBox vbox = new VBox();

    /**
     * This method creates a default menu box which is used for all
     * the different menu boxes
     * there is a quit button which close the window when it is pressed
     * and the action for the boss button is stored here
     * when the bossfight button is pressed "java Gui.Boss_Fight_Gui" and hearts_Transferred
     * is used in the command prompt to open the boss level and transfers you life from
     * the previous level
     * 
     * @param window The Stage from either Spaces_Gui or Boss_Fight_Gui
     * @param heart The Heart_Gui of the avatar
     */
    public void defaultMenuBox(Stage window, Heart_Gui heart) {
        vbox.getChildren().add(quit_Button);
        vbox.setAlignment(Pos.CENTER);
        Stage newstage = new Stage();
        Scene newscene = new Scene(vbox, 100, 100, Color.BLACK);
        newstage.setScene(newscene);
        newscene.setFill(Color.BLACK);
        newstage.show();

        quit_Button.setOnAction(e -> {
            window.close();
            newstage.close();
        });
        fightBoss_Button.setOnAction(e -> {
            window.close();
            newstage.close();
            try {
                Process P = Runtime.getRuntime().exec("java Gui.Boss_Fight_Gui" + " " + hearts_Transferred);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    /**
     * This method creates a menu box when you win the first level
     * using the default menu box
     * you have the option to quit the game or fight the boss
     * and it displays a message saying "you won!"
     * 
     * @param window The Stage from either Spaces_Gui
     * @param heart The Heart_Gui of the avatar
     */
    public void Win(Stage window, Heart_Gui heart) {
        vbox.getChildren().add(won);
        vbox.getChildren().add(fightBoss_Button);
        defaultMenuBox(window, heart);
        hearts_Transferred = heart.getLife();
    }

    /**
     * This method creates a menu box when you beat the boss
     * using the default menu box
     * you have the option to quit the game and it displays
     * your score and a message saying "you won!"
     * 
     * @param window The Stage from either Spaces_Gui or Boss_Fight_Gui
     * @param heart The Heart_Gui of the avatar
     */
    public void winBoss(Stage window, Heart_Gui heart) {
        int newScore = (heart.getLife()) * 100;
        Text score_Text = new Text(10, 10, "Score: " + newScore);
        Read_Score_Gui.setScore(newScore);
        vbox.getChildren().add(won);
        vbox.getChildren().add(score_Text);
        defaultMenuBox(window, heart);
    }

    /**
     * This method creates a menu box when you press 'q'
     * using the default menu box
     * you have can quit the game
     * 
     * @param window The Stage from either Spaces_Gui or Boss_Fight_Gui
     */
    public void quit(Stage window) {
        defaultMenuBox(window, null);
    }

    /**
     * This method creates a menu box when you lose the game
     * using the default menu box
     * you have the option to quit the game and it displays
     * message saying "you lost!"
     * 
     * @param window The Stage from either Spaces_Gui or Boss_Fight_Gui
     */
    public void lose(Stage window) {
        vbox.getChildren().add(lost);
        defaultMenuBox(window, null);
    }
}
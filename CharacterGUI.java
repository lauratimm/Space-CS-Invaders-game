import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterGUI extends ImageView {
    private String type;
    private Image image;

    // Importing images
    //https://opengameart.org/content/spaceship-set-4-pixel-art-space-ships
    Image avatarImage = new Image("avatar.png");
    //https://commons.wikimedia.org/wiki/File:Space_invaders_alien.svg
    Image enemyImage = new Image("enemy.png");
    //https://ya-webdesign.com/explore/video-game-heart-png/
    Image heartImage = new Image("heart.png");


    public CharacterGUI(int width, int height, String type) {
        setFitWidth(width);
        setFitHeight(height);
        this.type = type;
        if (type.equals("enemy")){
            image = enemyImage;
        }
        else if(type.equals("avatar")){
            image = avatarImage;
        }
        else if(type.equals("heart")){
            image = heartImage;
        }
    }

    CharacterGUI(String atype){
        this.type = type;
    }
    public Image getTypeImage(){
        return image;
    }

}

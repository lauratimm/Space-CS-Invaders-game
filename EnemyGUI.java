import javafx.scene.image.Image;
import java.util.ArrayList;

public class EnemyGUI extends CharacterGUI{
    private ArrayList<Enemy> enemyGUIList = new ArrayList<Enemy>();
    Enemy enemyClass = new Enemy();
    static final int boundary_y = 400;
    static final int boundary_x = 500;

    public EnemyGUI(int width, int height, String type){
        super(width, height, type);
        setX(Math.random() * boundary_x);
        setY(Math.random() * boundary_y);

    }
    public void EnemyGUIList() {
        /*ArrayList<Enemy> enemyList = enemyClass.getEnemyList();
        for(Enemy items : enemyList){
            enemyGUIList.add(new EnemyGUI(40, 40, "enemy"));
        }*/
    }
    public void spawingEnemies(Enemy enemy1, Enemy enemy2, Enemy enemy3, Enemy enemy4, Enemy enemy5){
        enemyGUIList.add(enemy1);
        enemyGUIList.add(enemy2);
        enemyGUIList.add(enemy3);
        enemyGUIList.add(enemy4);
        enemyGUIList.add(enemy5);
    }
}

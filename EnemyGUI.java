import java.awt.*;
import java.util.ArrayList;

public class EnemyGUI extends CharacterGUI{
    private ArrayList<EnemyGUI> enemyGUIList = new ArrayList<EnemyGUI>();
    Enemy enemyClass = new Enemy();
    static final int boundary_y = 400;
    static final int boundary_x = 500;

    public EnemyGUI(int width, int height, String type){
        super(type);
        setFitWidth(width);
        setFitHeight(height);

    }
    public void EnemyGUIList() {
        ArrayList<Enemy> enemyList = enemyClass.getEnemyList();
        for(Enemy items : enemyList){
            enemyGUIList.add(new EnemyGUI(40, 40, "enemy"));
        }
    }
    public void spawingEnemies(){

    }
}

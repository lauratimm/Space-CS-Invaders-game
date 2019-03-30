import java.util.ArrayList;

public class Enemy {
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private String type = "enemy";

    public void setEnemyList(Enemy enemy1, Enemy enemy2, Enemy enemy3, Enemy enemy4, Enemy enemy5){
        enemyList.add(enemy1);
        enemyList.add(enemy2);
        enemyList.add(enemy3);
        enemyList.add(enemy4);
        enemyList.add(enemy5);
    }
    // Getter method for the enemy list
    public ArrayList getEnemyList(){
        return enemyList;
    }
    // when intersect happens in GUI return type and remove an enemy from the list.
    // in the logic based one you dont have to put the enemies on the grid
}

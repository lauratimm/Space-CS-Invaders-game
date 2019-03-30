import java.util.ArrayList;

public class Enemy {
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    private String type = "enemy";

    // Getter method for the enemy list
    public ArrayList<Enemy> getEnemyList(){
        return enemyList;
    }

    public void setEnemyList(Enemy e1, Enemy e2, Enemy e3, Enemy e4, Enemy e5){
        enemyList.add(e1);
        enemyList.add(e2);
        enemyList.add(e3);
        enemyList.add(e4);
        enemyList.add(e5);
    }
    // when intersect happens in GUI return type and remove an enemy from the list.
    // in the logic based one you dont have to put the enemies on the grid
}

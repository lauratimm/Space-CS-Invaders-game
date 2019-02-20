public class Enemies extends Space_Board {
  char alien = 'Z'

//use randam to choose where the enemies will be placed on the board
public void generateEnemies(char alien, int row, int column){
  grid[row][column] = alien;

}
// use the bullet location to remove the enemy that is hit there
public void removeEnemies(){

}
// after each turn move the enemy based on a boolean
public void moveEnemies(){

}


}

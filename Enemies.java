public class Enemies extends Space_Board {
  char alien = 'Z'
  boolean changeDirection = false;
  int MAXENEMIES = 9;

//use randam to generate row and column where the enemies will be placed on the board
public void generateEnemies(char alien, int row, int column){
  int enemies = 0;
  while (enemies<MAXENEMIES){
    grid[row][column] = alien;
    enemies++
  }
}
public int getRowPosition() {
      return row;
   }

public int getColumnPosition() {
      return column;
    }
// use the bullet location to remove the enemy that is hit there
public void removeEnemies(){
//if hit getXPosition and getYPosition then remove.
}
// after each turn move the enemy based on a boolean
public void moveEnemies(){
  //make sure there is room in list to move
  if (changeDirection == true){
    //move on grid one way
  }
  else if (changeDirection == false){
    //move opposite way
  }
}

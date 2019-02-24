import java.util.Random;

public class Enemies extends Space_Board {
  char alien = 'Z'
  boolean changeDirection = false;
  int MAXENEMIES = 9;
  int ROW = 10;
  int COLUMN =11;

//use randam to generate row and column where the enemies will be placed on the board
public void generateEnemies(char alien, int row, int column){
  int enemies = 0

  while (enemies<MAXENEMIES){
    // Obtain a number between 0 to x then use for row and column.
    //check if [row][column] already in list
    int row = rand.nextInt(10);
    int column = rand.nextInt(11);
    if (grid[row][column] == ''){
      grid[row][column] = alien;
      enemies++
    }
  }
}
public int getRowPosition() {
      return row;
   }

public int getColumnPosition() {
      return column;
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


}

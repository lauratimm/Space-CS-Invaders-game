import java.util.Random;

public class Enemies extends Space_Board {
  char alien = 'Z';
  boolean changeDirection = false;
  int MAXENEMIES = 15;
  int ROW = 9;
  int COLUMN =10;

//use randam to generate row and column where the enemies will be placed on the board
public void generateEnemies(){
  Random rand = new Random();
  int enemies = 0;
  Space_Board grid = new Space_Board();

while (enemies<MAXENEMIES){
    // Obtain a number between 0 to x then use for row and column.
    //check if [row][column] already in list
    int row = rand.nextInt(6);
    int column = rand.nextInt(10);
    if (grid.getObject(row,column)== ' '){
      grid.placeObject(alien, row, column);
    enemies++;
 }
}
  grid.print();
}
public int getPosition() {
  for (int column = 0; column <= COLUMN; column++){
    for (int row = 0; row <= ROW; row++){
      if (grid[row][column] == 'Z'){
        return grid[row][column];
        }
      }
    } return -1;
  }

// after each turn move the enemy based on a boolean
public void moveEnemies() {
  for (int column = 0; column <= COLUMN; column++){
    for (int row = 0; row <= ROW; row++){
      if (grid[row][column] == 'Z'){
        //grid[row][column];
        //get temp location tempAlien = [row][column]
      }
    }
  }
  //make sure there is room in list to move
  if (changeDirection == true){
    //move on grid one way
  }
  else if (changeDirection == false){
    //move opposite way
  }
}
public static void main(String [] args){
  Enemies one = new Enemies();
  one.generateEnemies();

}

}


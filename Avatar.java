public class Avatar extends Space_Board {

  private char ship = 'S';

  // Initial coordinates of the ship, as list indices.
  private int row = 9;
  private int column = 5;

  // Getter methods are needed to provide bullet with the location of the ship.
  public int getRow(){
    return this.row;
  }

  public int getColumn(){
    return this.column;
  }

  // Based on user input move in a specific direction
  // Will also remove ship from previous space and place it in new space.
  public void moveShip(char input) {
    //first, get rid of old ship by calling the inherited method
    this.removeObject(row, column);
    // determine what direction to move
    if (input = 'w') {
      row += 1;
    }
    else if (input = 's') {
      row -= 1;
    }
    else if (input = 'd') {
      column += 1;
    }
    else if (input = 'a') {
      column -= 1;
    }
    //place new ship with new coord also using method from Space_Board.
    this.placeObject(ship, row, column);
  }

}

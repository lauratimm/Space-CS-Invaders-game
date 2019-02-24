import java.util.*;
public class Avatar{

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
  public int moveShipUD(char input, int row, int column) {
    //first, get rid of old ship by calling the inherited method
    // determine what direction to move
    if (input == 'w') {
      row -= 5;
    }
    else if (input == 's') {
      row += 1;
    }
    return row;
    //place new ship with new coord also using method from Space_Board.
    //this.placeObject(ship, row, column);
  }
  public int moveShipLR(char input, int row, int column) {
    //first, get rid of old ship by calling the inherited method
    // determine what direction to move
    if (input == 'd') {
      column += 1;
    }
    else if (input == 'a') {
      column -= 1;
    }
    return column;
    //place new ship with new coord also using method from Space_Board.
    //this.placeObject(ship, row, column);
  }




}

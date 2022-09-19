package Logic;

import java.util.ArrayList;

/**
 * This class contains a number of lives and a list with the location of the
 * hearts that are used for the Avatar_Gui and Boss_Gui in the GUI version of
 * the game.
 */
public class Heart_Logic {
  final int HEART_INCREASE_X_COORD = 30;
  private int Y_COORDINATE = 10;
  private int life = 5;
  private ArrayList<Integer> heartList = new ArrayList<Integer>();

  /**
   * This gets the lives remaining 
   * 
   * @return life The number of lives remaining.
   */
  public int getLife() {
    return life;
  }
  
  /**
   * This gets the y coordinate for where the hearts to be placed
   * 
   * @return Y_COORDINATE The y coordinate for where the hearts should be placed on
   * the screen
   */
  public int getY() {
    return Y_COORDINATE;
  }
  
  /**
   * This gets the list of hearts
   * 
   * @return heartList Which contains an x coordinate for each heart.
   */
  public ArrayList<Integer> getHeartList() {
    return heartList;
  }

  /**
   * This sets the number of lives
   * 
   * @param life The number of lives.
   */
  public void setLife(int life) {
    this.life = life;
  }

  /**
   * This removes all hearts from the heartlist
   * 
   * Removes all values that are currentmy in heartList.
   */
  public void removeHeartList() {
    heartList.clear();
  }

  /**
   * Adds x coordinates to heartList by multiplying the first x coordinate
   * by a constant and the number of hearts that are already in the list.
   * heartList should be empty before calling this method.
   * @param x_coordinate the x coordinate of the first heart.
   */
  public void createHeartList(int x_coordinate) {
    for (int i = 0; i < getLife(); i++) {
      heartList.add(x_coordinate + i * HEART_INCREASE_X_COORD);
    }
  }

  /**
   * Removes one life from the instance variable life. This is used to update
   * the lives of either the Avatar_Gui or Boss_Gui.
   */
  public void loseLife() {
    setLife(getLife() - 1);
  }
}

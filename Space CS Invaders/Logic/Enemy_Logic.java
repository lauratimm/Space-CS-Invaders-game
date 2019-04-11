package Logic;

/**
 * This class is the logic base for the enemies in both the text based
 * and GUI versions. It contains methods for movement as well as methods
 * to determine what actions the enemies should take.
 */
public class Enemy_Logic {
  final int RIGHT_BOUNDS = 600;
  final int BOTTOM_BOUNDS = 500;
  final int DELETE_COORD = -1000;
  final double ENEMY_BULLET_SPEED = 0.005;
  private int x_coordinate = 0;
  private int y_coordinate = 0;
  private int movement = 7;
  private boolean shoot = false;
  private boolean dead = false;

  /**
   * This constructor creates an enemy with random x and y 
   * coordinates by multiplying a max
   * x and y by a random number between 0 and 1.
   * @param max_x the bound for the x coordinate.
   * @param max_y the bound for the y coordinate.
   */
  public Enemy_Logic(int max_x, int max_y) {
    setX_coordinate((int) (Math.random() * max_x));
    setY_coordinate((int) (Math.random() * max_y));
  }

  /**
   * This getter method gets the x coordinate of the enemy
   * 
   * @return x_coordinate Which is used to place the Enemy_Logic
   */
  public int getX_coordinate() {
    return x_coordinate;
  }
  
  /**
   * This getter method gets the y coordinate of the enemy 
   * 
   * @return y_coordinate Which is used to place the Enemy_Logic.
   */
  public int getY_coordinate() {
    return y_coordinate;
  }
  
  /**
   * This getter method gets the int amount the enemy should move
   * each time
   * 
   * @return movement Which is the amount the Enemy_Logic moves each time.
   */
   public int getMovement() {
     return movement;
   }
   
   /**
    * This method gets if the enemy is dead or not
    * 
    * @return dead Is true if the Enemy_Logic has been shot, true otherwise.
    */
   public boolean getDead() {
     return dead;
   }
   
   /**
    * This method gets if the enemy shoots 
    * 
    * @return shoot Is true if the Enemy_Logic should shoot, false otherwise.
    */
   public boolean getShoot() {
     return shoot;
   }

  /**
   * This sets the x coordinate for the enemy logic
   * 
   * @param x_coordinate The x coord for Enemy_Logic.
   */
  public void setX_coordinate(int x_coordinate) {
    this.x_coordinate = x_coordinate;
  }

  /**
   * This sets the y coordinate for the enemy logic
   * 
   *@param y_coordinate The y coord for Enemy_Logic.
   */
  public void setY_coordinate(int y_coordinate) {
    this.y_coordinate = y_coordinate;
    }

  /**
   * This setter method sets the amount the enemy will move each time
   * 
   * @param movement Sets a value for how much the Enemy_Logic moves.
   */
  public void setMovement(int movement) {
    this.movement = movement;
  }

  /**
   * This setter method sets if the enemy is dead or not
   * 
   * @param dead Sets whether or not the Enemy_Logic has been shot.
   */
  public void setDead(boolean dead) {
    this.dead = dead;
  }

  /**
   * This setter method sets if the enemy shoots or not
   * 
   * @param shoot Sets whether or not the Enemy_Logic should shoot.
   */
  public void setShoot(boolean shoot) {
    this.shoot = shoot;
  }

  /**
   * Sets the x and y coordinates to a location off screen.
   */
  public void delete() {
    setX_coordinate(DELETE_COORD);
    setY_coordinate(DELETE_COORD);
  }

  /**
   * This method uses Math.random() to move the enemy. The magic numbers
   * are percentages, so for the first 10% the enemy is moved left, for the next
   * 10% it moves right, then up and down respectively. If the number generated
   * is greater than 0.40 the enemy will not move.
   */
  public void moveRan() {
    double r = Math.random();
    if (r < 0.10 && getX_coordinate() > 0) {
      setX_coordinate(getX_coordinate() - getMovement());
    } else if (r < 0.20 && getX_coordinate() < RIGHT_BOUNDS) {
        setX_coordinate(getX_coordinate() + getMovement());
    } else if (r < 0.30 && getY_coordinate() > 0) {
        setY_coordinate(getY_coordinate() - getMovement());
    } else if (r < 0.40 && getY_coordinate() < BOTTOM_BOUNDS) {
        setY_coordinate(getY_coordinate() + getMovement());
    }
  }

  /**
   * Sets shoot to true if a randomly generated number is less than the constant
   * bullet speed and the Enemy_Logic is not dead.
   * This causes the Enemy_Logic to shoot at random times but ensures that it is
   * not shooting too often.
   */
  public boolean enemyShoot() {
    if (Math.random() < ENEMY_BULLET_SPEED && !this.getDead()) {
      setShoot(true);
    } else {
        setShoot(false);
      }
    return getShoot();
  }
}

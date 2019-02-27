# group18_project

This is our Space CS Invaders game, in order to run you must have a working version of java.
You must download all 3 files: Avatar.java, Enemies.java, and Space_Board.java. 
and compile the Space_Board.java file, then you run the Space_Board file to play our game.

This our first version of the game we have a texted based game that is similar to Space Invaders, that is an input-based game. Our Input is WASD and “l” where WASD is for the movement of the ship and “l” is pressed to shoot a bullet. The ship is represented with the letter “S” and the enemies are “Z”.  Currently the enemies spawn randomly per row, the number of enemies can be changed in future implementation, as levels are created. As of right now the enemies cannot shoot bullets, therefore there is no way to lose the game. Each enemy is killed and removed if the bullet collides with the enemy. If the bullet and the enemy are in the same position in the Array list, the enemy is removed from the board (or Array list). Once all the enemies are shot the game ends and a print statement says “You Won!”. 

Controls for the ship:
  'w' to go up
  's' to go down
  'a' to go left 
  'd' to go right 
  'l' to shoot bullets 
  'p' to exit the game 

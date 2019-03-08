# group18_project

This is our Space CS Invaders game, in order to run you must have a working version of java.
You must download all 3 files: Avatar.java, Enemies.java, and Space_Board.java. 
and compile the Space_Board.java file, then you run the Space_Board file to play our game. 
For demo 1, the final versions are in the master branch.

This our first version of the game we have a texted based game that is similar to Space Invaders, that is an input-based game. Our Input is WASD and “l” where WASD is for the movement of the ship and “l” is pressed to shoot a bullet. The ship is represented with the letter “S” and the enemies are “Z”.  Currently the enemies spawn randomly per row, the number of enemies can be changed in future implementation, as levels are created. As of right now the enemies cannot shoot bullets, therefore there is no way to lose the game. Each enemy is killed and removed if the bullet collides with the enemy. If the bullet and the enemy are in the same position in the Array list, the enemy is removed from the board (or Array list). Once all the enemies are shot the game ends and a print statement says “You Won!”. 

The project proposal, team contract, and class diagrams are in a zip file in d2l dropbox.

Controls for the ship:
  'w' to go up
  's' to go down
  'a' to go left 
  'd' to go right 
  'l' to shoot bullets 
  'p' to exit the game 

References:
Our game currently is based on Space Invaders developed by Taito, but will be similar to a Bullet Hell game when we are finished 

JavaFX:
https://www.youtube.com/watch?v=l2XhUHW8Oa4

ArrayList:
https://youtu.be/k6rTH77tML0?t=76

Inheritance Ideas: 
https://www.youtube.com/watch?v=GDG-wzEZW8E&list=PLEH2kL-crMGFSXqNd98feVwJ_aem1JiEi&index=2

Using the random function:
https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

Other:
Verwaal, N. (2019.). Computer Science 219. Lecture and Class Examples presented at University of Calgary, Calgary.
Savitch, W. J. (2018). Java: An introduction to problem solving and programming. Upper Saddle River: Pearson.

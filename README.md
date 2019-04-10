# group18_project
This is the final version of our Space CS Invaders game. It is similar to Space Invaders, and the text based version is turn based while the GUI is an animation game. 

Both Versions:

'W' moves the ship up, 'S' moves it down, 'A' moves it left and 'D' moves it right.
There are 5 randomly generated enemies.
Once the avatar or an enemy dies it is removed along with the bullet that collided with it.
If the ship is hit five times, you lose the game, if you hit all the enemies before dying you win the game.
The ship cannot move and shoot at the same time.

Text Based Version:

'L' is the command to shoot a bullet and enter must be pressed after every command.
If you win the game "You won!" prints at the command line.

GUI Version:

The ship moves and shoots without needing to press enter and 'SPACE' is the command to shoot.
If all the enemies are killed in the GUI version you have the option to fight the boss, which is accessed through a pop up window.
If you lose or press 'Q', a pop-up window will show asking you to quit the game.

Compiling and Running:

In order to run you must have a working version of java. The files to download are in the Final branch. There are three packages: Logic, GUI and Text which must all be downloaded. There are a number of images in the GUI package and the application will not run without them. The GUI version also uses a text file to save high scores which is saved in the GUI folder. To run the application, all three packages need to be downloaded and compiled. For example, if all packages are in the same folder, it should be compiled at the command line as follows:


Text Based:

javac Logic/*.java

javac Text/*.java

java Text.Spaces_Text


GUI:

javac Logic/*.java

javac GUI/*.java

java GUI.Spaces_GUI

Note that the application will not run BossFight.java if you are working in Eclipse because ??????????????????????????????


The project proposal, team contract, and class diagrams are in a zip file in d2l dropbox.

References: Our game is based on Space Invaders developed by Taito. 

JavaFX: https://www.youtube.com/watch?v=l2XhUHW8Oa4

ArrayList: https://youtu.be/k6rTH77tML0?t=76

Inheritance Ideas: https://www.youtube.com/watch?v=GDG-wzEZW8E&list=PLEH2kL-crMGFSXqNd98feVwJ_aem1JiEi&index=2

Using the random function: https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

Using the intersect function: https://www.youtube.com/watch?v=FVo1fm52hz0&feature=youtu.be

Using Animation Timers: https://docs.oracle.com/javafx/2/api/javafx/animation/AnimationTimer.html

Other: Verwaal, N. (2019.). Computer Science 219. Lecture and Class Examples presented at University of Calgary, Calgary. Savitch, W. J. (2018). Java: An introduction to problem solving and programming. Upper Saddle River: Pearson.

# group18_project
This is the final version of our Space CS Invaders game. It is similar to Space Invaders, and the text based version is turn based while the Gui is an animation game. 

For both versions; 'w' moves the ship up, 's' moves it down, 'a' moves it left, 'd' moves it right and 'q' is to quit. The ship cannot move and shoot at the same time. In the text based game 'l' is the command to shoot a bullet and enter must be pressed after every command. For the Gui, the ship moves and shoots without needing to press enter and 'SPACE' is the command to shoot. If all the enemies are killed in the Gui version you have the option to fight the boss, which is accessed through a pop up window. If you lose or press 'q', a pop-up window will show asking you to quit the game.

Compiling and Running:

In order to run you must have a working version of java. The files to download are in the Final branch. There are three packages: Logic, Gui and Text which must all be downloaded. There are a number of images in the Gui package and the application will not run without them. The Gui version also uses a text file to save high scores which is saved in the Gui folder. 

To run the application, all three packages need to be downloaded and. For example, if all packages are in the same folder, it should be compiled at the command line as follows:

Step 1: In the main folder which contains the 3 packages type cmd in the file directroy (this will open the command prompt)

Step 2: 
Type the following to compile each package seprately:

Text Based:

javac Logic/*.java

javac Text/*.java

java Text.Spaces_Text (this is the command to run the program)


Gui:

javac Logic/*.java

javac Gui/*.java

java Gui.Spaces_Gui (this is the command to run the program)

Note: the fight boss level will not run in eclipse due to ROHAN EXPLAIN THIS BETTER.. 

Step 3:
Play and enjoy!! 

!!!!! ALJUNE EXPLAINE THE J UNTS 
The project proposal, team contract, and class diagrams are in a zip file in d2l dropbox.

References: Our game is based on Space Invaders developed by Taito. 

JavaFX: https://www.youtube.com/watch?v=l2XhUHW8Oa4

ArrayList: https://youtu.be/k6rTH77tML0?t=76

Inheritance Ideas: https://www.youtube.com/watch?v=GDG-wzEZW8E&list=PLEH2kL-crMGFSXqNd98feVwJ_aem1JiEi&index=2

Using the random function: https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

Using the intersect function: https://www.youtube.com/watch?v=FVo1fm52hz0&feature=youtu.be

Using Animation Timers: https://docs.oracle.com/javafx/2/api/javafx/animation/AnimationTimer.html

Javadoc: https://l.facebook.com/l.php?u=http%3A%2F%2Fwww.javapractices.com%2Ftopic%2FTopicAction.do%3FId%3D44%26fbclid%3DIwAR2OqzOA2dImPMCBOaNUdr76QgchYDSbELCrHGXrvUw9axDynBo86fYXjCo&h=AT1-jCcb-XiqxHg5agAkmzwQrneYXxr3ixFlCTb2HrUXwASkS49JGUS7GAi2_KpZ1jzOrt_8IPsZQE9QtwOVK6N8KFisdaCMeFYXHLZBgSUTUAceRw__5SM0VSQ33Psqzlg

Other: Verwaal, N. (2019.). Computer Science 219. Lecture and Class Examples presented at University of Calgary, Calgary. Savitch, W. J. (2018). Java: An introduction to problem solving and programming. Upper Saddle River: Pearson.

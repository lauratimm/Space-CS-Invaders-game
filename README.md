# group18_project
This is the final version of our Space CS Invaders game. It is similar to Space Invaders, and the text based version is turn based while the Gui is an animation game. 

For both versions; 'w' moves the ship up, 's' moves it down, 'a' moves it left, 'd' moves it right and 'q' is to quit. The ship cannot move and shoot at the same time. In the text based game 'l' is the command to shoot a bullet and enter must be pressed after every command. In the text based version if you press 'q' the game will quit. For the Gui, the ship moves and shoots without needing to press enter and 'SPACE' is the command to shoot. If all the enemies are killed in the Gui version you have the option to fight the boss, which is accessed through a pop up window. If you lose or press 'q', a pop-up window will show asking you to quit the game. 

Compiling and Running:

There are three packages: 'Logic', 'Gui' and 'Text' which must all be downloaded. There are a number of images in the 'Gui' package and the application will not run without them. The 'Gui' version also uses a text file to save high scores. 

In order to run you must have a working version of java. The files to download are in the 'master' branch. Once in the branch, click the 'Clone or download' green button and then 'Download ZIP'. Once the ZIP file has been downloaded, open it and go into the 'group18_project-master' folder (this is inside the ZIP file). From here extract the folder 'Space CS Invaders' into another directory. Inside of the 'Space CS Invaders' folder there should be three different folders/packages; 'Logic', 'Gui', 'Text'. To run the application, all three packages must be in the 'Space CS Invaders' folder.

From here follow the steps bellow to run the program:

Step 1: Open the 'Space CS Invaders' folder in command prompt or terminal. To do this for Windows open the 'Space CS Invaders' folder in File Directory and then in the address bar type 'cmd' (this will open the command prompt)

Step 2: In terminal or command prompt, type the following to compile and run each version of the game (not including the quotations:

For the Text Based version:

'javac Logic/*.java' (this is the command to compile the Logic package)

'javac Text/*.java' (this is the command to compile the Text package)

'java Text.Spaces_Text' (this is the command to run the program)


For the Gui version:

'javac Logic/*.java' (this is the command to compile the Logic package)

'javac Gui/*.java' (this is the command to compile the Gui package)

'java Gui.Spaces_Gui' (this is the command to run the program)

Note: The boss level of the Gui version will only open when running the game with command prompt or terminal but not by running it with an IDE like Eclipse, this is because in order to run the boss level, "Runtime.getRuntime().exec()" was used which executes a command in a seperate process (using cmd or terminal) but IDEs like Eclipse have their own way of running files which do not run the same commands.

Step 3:
Play and enjoy!! 

In order to run the JUnit tests, follow the steps above to download and extract the 'Space CS Invaders' folder. Then from the downloaded ZIP file, open the 'group18_project-master' folder and then open the 'Test' folder. Inside this folder are all of the JUnit tests. Extract all of these java files into the 'Logic' folder of the 'Space CS Invaders' folder (which was extracted earlier). Now in the 'Space CS Invaders' folder you should have three different folders; the original 'Gui' and 'Text' folders as well as the updated 'Logic' folder with the Junit tests and the original Logic classes. 

Now follow the steps bellow to run the tests:

Step 1: Download 'hamcrest-core-1.3.jar' and 'junit-4.12.jar' into the 'Space CS Invaders' folder

Step 2: Open the 'Space CS Invaders' folder in command prompt or terminal

Step 3: Run the following command (not including quotations):

For Windows:
'javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar Logic/.java'

Fow Mac/Linux: 
'javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar Logic/*.java'

Step 4: Run the following commands to test for the different logic classes (note, for Mac/Linux replace ';' with ':' when running the following commands):

To test Avatar_Logic: 
'java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Logic.Avatar_LogicTest'

To test Bullet_Logic:
'java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Logic.Bullet_LogicTest'

To test Boss_Logic:
'java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Logic.Boss_LogicTest'

To test Enemy_Logic:
'java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Logic.Enemy_LogicTest'

To test Heart_Logic:
'java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore Logic.Enemy_LogicTest'

For a more detailed explanation on running the tests, look at the test document in dropbox

The project proposal, team contract, test document, and class diagrams are in a zip file in d2l dropbox.

References: Our game is based on Space Invaders developed by Taito. 

JavaFX: https://www.youtube.com/watch?v=l2XhUHW8Oa4

ArrayList: https://youtu.be/k6rTH77tML0?t=76

Inheritance Ideas: https://www.youtube.com/watch?v=GDG-wzEZW8E&list=PLEH2kL-crMGFSXqNd98feVwJ_aem1JiEi&index=2

Using the random function: https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java

Using the intersect function: https://www.youtube.com/watch?v=FVo1fm52hz0&feature=youtu.be

Using Animation Timers: https://docs.oracle.com/javafx/2/api/javafx/animation/AnimationTimer.html

Javadoc: https://l.facebook.com/l.php?u=http%3A%2F%2Fwww.javapractices.com%2Ftopic%2FTopicAction.do%3FId%3D44%26fbclid%3DIwAR2OqzOA2dImPMCBOaNUdr76QgchYDSbELCrHGXrvUw9axDynBo86fYXjCo&h=AT1-jCcb-XiqxHg5agAkmzwQrneYXxr3ixFlCTb2HrUXwASkS49JGUS7GAi2_KpZ1jzOrt_8IPsZQE9QtwOVK6N8KFisdaCMeFYXHLZBgSUTUAceRw__5SM0VSQ33Psqzlg

Other: Verwaal, N. (2019.). Computer Science 219. Lecture and Class Examples presented at University of Calgary, Calgary. Savitch, W. J. (2018). Java: An introduction to problem solving and programming. Upper Saddle River: Pearson.

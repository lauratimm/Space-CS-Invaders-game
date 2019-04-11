package Text;

import java.util.Scanner;

/**
 * This class is the main class that runs the game
 * by calling upon the text classes.
 * it continually asks for input until 'q' is pressed or
 * all the enemies are killed
 * */
public class Spaces_Text {

	/**
	 * This is the main method which runs the text game
	 * it calls on the text classes in order to run the game
	 * it continually receives input from the user until all the enemies are killed
	 * or 'q' is pressed (which ends the game)
	 * 
	 * @param args A string array containing the command line arguments
	 */
	public static void main (String [] args) {
		Avatar_Text avatar = new Avatar_Text(4, 7);
		Grid_Text grid = new Grid_Text();
		Scanner reader = new Scanner(System.in);
		grid.placeObject(avatar.getAvatar_Char(), avatar.getY_coordinate(), avatar.getX_coordinate());
		Enemy_Text enemy = new Enemy_Text(7, 6);
		enemy.placeEnemies(grid);
		boolean quit = false;
		while (!quit) {
			if (avatar.getEnemies_killed() == 5) {
				quit = true;
				System.out.println("You Won!");
			}
			else {
			char c = reader.next().charAt(0);
			if (c == 'l') {
				Bullet_Text bullet = new Bullet_Text(avatar.getX_coordinate(), avatar.getY_coordinate() - 1);
				bullet.shoot(grid, avatar);
			}
			else if (c == 'q') {
				quit = true;
			}
			else{
			avatar.movement(c, grid);}
			}
		}
	}
}

package Text;

/**
 * This class is the game board for our game
 * It contains a list as an instance that is used to place the
 * Characters on the board.
 * The methods in this class are used to place and remove objects
 * on the board
 */
public class Grid_Text {
	public static char[][] grid = { {'#','#','#','#','#','#','#','#'}, //0
									{'#','.','.','.','.','.','.','#'},  //1
									{'#','.','.','.','.','.','.','#'},  //2
									{'#','.','.','.','.','.','.','#'},	//3
									{'#','.','.','.','.','.','.','#'},  //4
									{'#','.','.','.','.','.','.','#'},  //5
									{'#','.','.','.','.','.','.','#'},  //6
									{'#','.','.','.','.','.','.','#'},  //7
									{'#','.','.','.','.','.','.','#'},  //8
									{'#','#','#','#','#','#','#','#'}}; //9

    /**
     * This method print the game board when it is called
     */
    public void print() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 8; column++) {
                System.out.print(grid[row][column]);
            }
            System.out.println();
        }
    }
    /**
     * Sets the location of the object based on char, row and column input, each time it is used
     * 
     * @param object Used to decide what char to place on the board (avatar, enemy, or bullet)
     * @param row Is used to place the char on the game board at this row
     * @param column Is used to place the char on the game board at this column
     */
    public void placeObject(char object, int row, int column) {
        grid[row][column] = object;
    }
    /**
     * Removes an object that is at the row and column input, each time it is used
     * 
     * @param row Is used to remove the char on the game board at this row
     * @param column Is used to remove the char on the game board at this column
     */
    public void removeObject(int row, int column) {
        grid[row][column] = '.';
    }
    /**
     * Returns the character at the desired location
     * 
     * @param row Is used to get the char on the game board at this row
     * @param column Is used to get the char on the game board at this column
     * @return char Which is at the location provided by the parameters
     */
    public char getObject(int row, int column) {
        return grid[row][column];
    }
}

package Text;

import Logic.Avatar;

/*
 * This class is the avatar (or spaceship) for our game
 * It is represented by the char 'S' in our text version of the game
 * The methods in this class control the movement of the avatar
 * and placement of the avatar on our grid
 * */
public class Avatar_Text extends Avatar {
    private char avatar_Char = 'S';

    /**
     * Creates an avatar with the instance avatar_Char.
     *
     * @param x_coordinate The x coordinate from the logic Avatar class.
     * @param y_coordinate The y coordinate from the logic Avatar class.
     *                     sets the movement so that the avatar moves 1 index at a time.
     */
    public Avatar_Text(int x_coordinate, int y_coordinate) {
        super(x_coordinate, y_coordinate);
        super.setMovement(1);
    }

    /**
     * Gets the character which is used for the Avatar
     *
     * @return avatar_Char which is used as the ship in the text game
     */
    public char getAvatar_Char() {
        return avatar_Char;
    }

    /**
     * Sets the location of the avatar based on char input, each time it is used
     * it removes the object at the previous location and replaces it with the
     * new x and y coordinate
     *
     * @param aChar is the character the the user inputs which directs
     *              the movement
     * @param grid  is used in order to place the char on the game board
     */
    public void movement(char aChar, Grid_Text grid) {
        int x_coordinate = super.getX_coordinate();
        int y_coordinate = super.getY_coordinate();
        grid.removeObject(getY_coordinate(), getX_coordinate());
        if (aChar == 'w') {
            moveUp();
        }
        else if (aChar == 's') {
            moveDown();
        }
        else if (aChar == 'a') {
            moveLeft();
        }
        else if (aChar == 'd') {
            moveRight();
        }
        if (grid.getObject(super.getY_coordinate(), super.getX_coordinate()) == 'E') {
            System.out.println("You can not go over enemies!");
            super.setX_coordinate(x_coordinate);
            super.setY_coordinate(y_coordinate);
            grid.placeObject(getAvatar_Char(), getY_coordinate(), getX_coordinate());
        }
        else if (grid.getObject(super.getY_coordinate(), super.getX_coordinate()) == '#') {
            System.out.println("You can not go out of bounds!");
            super.setX_coordinate(x_coordinate);
            super.setY_coordinate(y_coordinate);
            grid.placeObject(getAvatar_Char(), getY_coordinate(), getX_coordinate());
        }
        else {
            grid.placeObject(getAvatar_Char(), getY_coordinate(), getX_coordinate());
        }

        grid.print();
    }
}


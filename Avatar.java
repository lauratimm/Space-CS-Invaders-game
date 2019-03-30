public class Avatar {
    private int life = 5; // the number of hearts the Avatar has left

    // Getter method for the life
    public int getLife() {
        return life;
    }

    // Method which removes a life from the Avatar
    public void loseLife() {
        life -= 1;
    }
// Avatar will be placed in the grid movement will be based on return from gui

}


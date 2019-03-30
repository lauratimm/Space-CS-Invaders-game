public class Grid {
    public char[][] grid = {
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R1
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R2
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},	//R3
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R4
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R5
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R6
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R7
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R8
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},  //R9
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}}; //R10
            //C 1   2   3   4   5   6   7   8   9   10  11

    // default constructor
    public Grid(){
    }

    // copy constructor
    public Grid(Grid board){
        Grid newBoard = new Grid();
        this.grid = board.grid;
    }

    // this method places a specified object on the specified row and column
    public void placeObject(char object, int row, int column) {
        grid[row][column] = object;
    }

    // this method removes a object from the specified row and column
    public void removeObject(int row, int column) {
        grid[row][column] = ' ';
    }

    // this method gets the letter of the object on the specified row and column
    public char getObject(int row, int column){
        return grid[row][column];
    }

}

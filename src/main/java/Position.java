/**
 * The Position class consists of two integers that represent the row and the column for the location of the Position.
 */
public class Position {

    private int row;
    private int col;

    /**
     * Position Constructor
     * @param row int representing the row
     * @param col int representing the column
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row int for the Position
     * @return int row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Sets the row int for the Position with the given int
     * @param i new row int value
     */
    public void setRow(int i) {
        this.row = i;
    }

    /**
     * Returns the column int for the Position
     * @return int column
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Sets the column int for the Position with the given int
     * @param i new column int value
     */
    public void setCol(int i) {
        this.col = i;
    }

}

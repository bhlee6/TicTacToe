import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Board class contains information regarding the Board, the scores, and methods to print the board, for
 * making moves, and updating board information to see if the game is still in progress,
 * if there is a winner, or if there is a draw.
 *
 */

class Board {

    private int size;
    private char[][] board;
    private int[] rowScore, columnScore, diagonalScore;
    private int maxNumberOfDiagonals = 2;

    //Array list of the Positions that do not have a Player piece
    private ArrayList<Position> availableTiles = new ArrayList<>();

    //Default char value for Blank squares
    private char unusedTileValue = Piece.Blank.pieceChar();
    private Player p1, p2;
    private Player currentPlayer;
    private boolean gameOver = false;

    //Random number generator
    private SecureRandom rand = new SecureRandom();

    /**
     * Board Constructor
     * @param size int size of the board
     * @param p1 Player 1
     * @param p2 Player 2
     * @param currentPlayer the current Player
     */
    Board(int size, Player p1, Player p2, Player currentPlayer) {
        this.size = size;
        this.p1 = p1;
        this.p2 = p2;
        this.currentPlayer = currentPlayer;
        this.board = new char[size][size];
        this.rowScore = new int[size];
        this.columnScore = new int[size];
        this.diagonalScore = new int[maxNumberOfDiagonals];
    }

    /**
     * Generates a Position object for each of the tile squares for the board and adds this to the
     * ArrayList of availableTiles.  The board is also initialized with the default Blank Piece char value.
     */
    void generateTileDataAndBoard() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                availableTiles.add(new Position(i, j));
                board[i][j] = unusedTileValue;
            }
        }
    }

    /**
     * Generates a random move on the board.  A random position will be selected from the availableTiles list, and the
     * current Player's Piece char value is put into the board.  The position will be removed from the availableTiles
     * list, the scores will be updated, and the player will change.
     */
    void randomMove() {
        int index = UtilityMethod.getRandomIndex(rand, availableTiles.size());
        Position randomPosition = availableTiles.get(index);
        int row = randomPosition.getRow();
        int col = randomPosition.getCol();
        board[row][col] = currentPlayer.getPiece().pieceChar();
        availableTiles.remove(index);
        updateScoreAndCheckGameOver(row, col);
        changeCurrentPlayer();
    }

    /**
     * Swaps the currentPlayer to the other player.
     */
    private void changeCurrentPlayer() {
        if (currentPlayer.equals(p1)) {
            currentPlayer = p2;
        } else currentPlayer = p1;
    }

    /**
     * Keeps track of the scores for the board.  For each row, column, and diagonal, a point will be added
     * for a piece placed by the first player, and a point will be subtracted if placed by the second player.
     * The method then sets gameOver conditions to true if a gameOver condition has been satisfied
     *
     * @param row int row of the Piece placed
     * @param col int column of the Piece placed
     */
    private void updateScoreAndCheckGameOver(int row, int col) {
        if (currentPlayer.equals(p1)) {
            rowScore[row] = rowScore[row] + 1;
            columnScore[col] = columnScore[col] + 1;
            if (row == col) {
                diagonalScore[0] = diagonalScore[0] + 1;
            }
            if (this.size - 1 - col == row) {
                diagonalScore[1] = diagonalScore[1] + 1;
            }
        }  else {
            rowScore[row] = rowScore[row] - 1;
            columnScore[col] = columnScore[col] - 1;
            if (row == col) {
                diagonalScore[0] = diagonalScore[0] - 1;
            }
            if (this.size - 1 - col == row) {
                diagonalScore[1] = diagonalScore[1] - 1;
            }
        }
        int rowValue = Math.abs(rowScore[row]);
        int colValue = Math.abs(columnScore[col]);
        int diagValue = Math.abs(diagonalScore[0]);
        int antidiagValue = Math.abs(diagonalScore[1]);
        if (checkGameOver(rowValue, colValue, diagValue, antidiagValue)) {
            gameOver = true;
        }
    }

    /**
     * Checks whether the game is over or not.  If the score matches the given board size, then the winner is the
     * current player, and it will print the board, print that the current player has won, and return true.
     *
     * If there are no more available tiles, there are no more moves to be made.  The board is printed,
     * it will print a draw message, and return true.
     *
     * Else the game is not over yet, and return false.
     *
     * @param rowValue score for the row after the move
     * @param colValue score for the column after the move
     * @param diagValue score for the diagonal after the move
     * @param antidiagValue score for the antidiagonal after the move
     * @return boolean True if a Player has won or if it is a draw, false otherwise
     */
    private boolean checkGameOver(int rowValue, int colValue, int diagValue, int antidiagValue) {
        if (rowValue == this.size || colValue == this.size || diagValue == this.size || antidiagValue == this.size) {
            printBoard();
            System.out.println(currentPlayer.getName() + " won!");
            return true;
        }
        if (availableTiles.isEmpty()) {
            printBoard();
            System.out.println("It was a draw.");
            return true;
        } else return false;
    }

    /**
     * Prints the current board state of the game.  Each row will be on a separate line.
     */
    private void printBoard() {
        for (int i = 0; i < this.size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < this.size; j++) {
                sb.append(board[i][j]);
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * Returns the ArrayList of availableTiles
     *
     * @return ArrayList of Positions in availableTiles
     */
    ArrayList<Position> getAvailableTiles() {
        return this.availableTiles;
    }

    /**
     * Returns the status of whether the game is over or not.
     *
     * @return boolean gameOver
     */
    boolean getGameStatus() {
        return this.gameOver;
    }
}

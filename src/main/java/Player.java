/**
 * The Player class represents a Player in TicTacToe with a name and a Piece value that represents
 * the piece value associated with the player
 */
public class Player {
    private String name;
    private Piece piece;

    /**
     * Player constructor
     * @param name The name of the player
     * @param piece Piece that represents the player's piece on a TicTacToe board
     */
    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    /**
     * Returns the name of the Player
     * @return String name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the Player to the given String
     * @param newName given String to represent new Player's name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Returns the Piece that represents the player's piece
     * @return Piece that represents the player's piece on a TicTacToe board
     */
    public Piece getPiece() {
        return this.piece;
    }

    /**
     * Sets the Player's piece to the given char value
     * @param newPiece given Piece to represent the Player's piece
     */
    public void setPiece(Piece newPiece) {
        this.piece = newPiece;
    }


}

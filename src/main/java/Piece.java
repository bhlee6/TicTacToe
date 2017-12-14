/**
 * Pieces for TicTacToe
 * The standard convention of Xs and Os are used for Pieces, and a Blank(unused square) Piece is represented as a '#'
 */
public enum Piece {
    X('X'), O('O'), Blank('#');

    /**
     * Returns the char value of the Piece
     * @return char value of the Piece
     */
    public char pieceChar() {
        return pieceChar;
    }

    //char of pieceChar
    private final char pieceChar;


    /**
     * Sets pieceChar to char value
     * @param asChar char of Piece
     */
    Piece(char asChar) {
        this.pieceChar = asChar;
    }
}

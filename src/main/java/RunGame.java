import java.util.ArrayList;

/**
 * Interface to run a TicTacToe Game
 */
public interface RunGame {

    /**
     * Generates the two players for the game
     * @return ArrayList of 2 Players
     */
    ArrayList<Player> generatePlayers();

    /**
     * Generates the board information
     * @param boardSize the size of the TicTacToe board
     * @param players the Players for the game
     * @param firstToPlay index of the player in Players who is first to make a move
     * @return Board with the
     */
    Board generateBoard(int boardSize, ArrayList<Player> players, int firstToPlay);

    /**
     * This method automatically plays until there is a winner or a draw for the game
     * @param board the given Board
     */
    void autoPlay(Board board);
}

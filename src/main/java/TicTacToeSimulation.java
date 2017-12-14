import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Simulates the automatic run of a TicTacToe game implementing the RunGame interface.
 */
public class TicTacToeSimulation implements RunGame{

    //Default values for both players in the simulation
    private String p1Name = "X";
    private String p2Name = "O";
    private Piece p1Piece = Piece.X;
    private Piece p2Piece = Piece.O;
    private int boardSize;
    private SecureRandom rand = new SecureRandom();

    /**
     * TicTacToe Constructor
     * @param boardSize the int length/width dimension of the TicTacToe board
     */
    public TicTacToeSimulation(int boardSize) {
        this.boardSize = boardSize;
    }

    /**
     * Generate the players for the game, pick a random player to make the first move, generate a
     * Board for the game, and autoPlay on the generated Board
     *
     */
    public void runSimulation() {
        ArrayList<Player> players = generatePlayers();
        //Pick a random player to move first
        int currentPlayerIndex = pickRandomFirstPlayer(players);
        Board board = generateBoard(this.boardSize, players, currentPlayerIndex);
        this.autoPlay(board);
    }

    /**
     * Create an ArrayList of Players for the game
     *
     * @return ArrayList of Players to play in the simulation
     */
    public ArrayList<Player> generatePlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(p1Name, p1Piece));
        players.add(new Player(p2Name, p2Piece));
        return players;
    }

    /**
     * Generates the tile data and board for the given Board, and automatically makes moves on the Board
     * while there are available moves and the game is not yet over.
     *
     * @param board the given Board
     */
    public void autoPlay(Board board) {
        board.generateTileDataAndBoard();
        while (board.getAvailableTiles().size() > 0 && !board.getGameStatus()) {
            board.randomMove();
        }
    }

    /**
     * Picks a random index from the players list, prints that the randomly chosen Player goes first,
     * and returns the index of the chosen Player.
     * @param players ArrayList of players
     * @return index int representing a random player
     */
    private int pickRandomFirstPlayer(ArrayList<Player> players) {
        int index = UtilityMethod.getRandomIndex(rand, players.size());
        System.out.println(players.get(index).getName() + " goes first");
        return index;
    }

    /**
     * Create a new Board for the TicTacToe game with the given players, and the randomly chosen player index to make
     * the first move
     * @param boardSize   the size of the TicTacToe board
     * @param players     the Players for the game
     * @param firstToPlay index of the player in Players who is first to make a move
     * @return
     */
    public Board generateBoard(int boardSize, ArrayList<Player> players, int firstToPlay) {
        return new Board(boardSize, players.get(0), players.get(1), players.get(firstToPlay));
    }
}

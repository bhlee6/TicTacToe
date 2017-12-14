/**
 * TicTacToe is a command line program that accepts a single integer argument N (where N is between 2 and 10 inclusive)
 * to indicate an NxN sized board and simulates two Players playing a game of tic-tac-toe.
 *
 * The traditional 'X' and 'O' characters are used to represent each player's pieces, and a blank, unused square
 * is represented by a '#' character.
 *
 * This program automatically chooses a random Player to start with, and
 * the players then automatically alternate turns in placing their piece randomly on an unused tile on the board.
 *
 * The game ends when:
 * 1. A Player first fills all the tiles in at least one row, column, or diagonal with their pieces, and that player is
 * declared the winner
 * or
 * 2. All tiles on the board have Player pieces, but there is no winner, and there is a draw.
 *
 * The output of the program is a print out to stdout with:
 * 1. The Player who goes first
 * 2. The board state after the game has ended.
 * 3. The declaration of the winner, or declaration of a draw if the game ends in a draw.
 *
 * Example:
 *
 * O goes first
 * XOO
 * XXX
 * #OO
 * X won!
 *
 */

public class TicTacToe {

    //Given input size of the board
    private static int size;

    //String Error messages for invalid command line arguments
    private static String invalidNumberOfArgumentsMessage =
            "Program argument must be an integer value between 2 and 10 inclusive";
    private static String argNotIntegerMessage = "Input must be an integer between 2 and 10 inclusive";
    private static String invalidBoardSize = "Board size must be an integer between 2 and 10 inclusive";


    /**
     * Validates the given command line arguments to match program requirements.
     * The argument must be a single integer value that lies between 2 and 10 inclusive
     *
     * @param args The given command line arguments
     * @return boolean true if the argument is an integer value between 2 and 10 inclusive, and false otherwise
     */
    private static boolean validateArguments(String[] args) {
        //If more than one argument provided, print error message and return false
        if (args.length != 1) {
            System.err.println(invalidNumberOfArgumentsMessage);
            return false;
        } else {
            //If there is one arg, ensure that it is a number and an integer, else return false
            try {
                int integerInput = Integer.parseInt(args[0]);
                //Ensure the number is between 2 and 10 inclusive
                if (integerInput > 10 || integerInput < 2) {
                    System.err.println(invalidBoardSize);
                    return false;
                } else {
                    size = integerInput;
                    return true;
                }
            } catch (NumberFormatException e) {
                System.err.println(argNotIntegerMessage);
                return false;
            }
        }
    }


    /**
     * Main function to start the simulation.  If the argument provided is a valid integer between 2 and 10 inclusive,
     * run the simulation of the game.  Else return.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        if (validateArguments(args)) {
            TicTacToeSimulation game = new TicTacToeSimulation(size);
            game.runSimulation();
        } else return;
    }
}

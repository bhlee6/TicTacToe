import java.security.SecureRandom;

/**
 * Utility method for generating a random number
 */
public class UtilityMethod {

    /**
     * Given an integer and a SecureRandom, return a random integer between 0 and the given (length - 1) (inclusive)
     * @param rand the given SecureRandom object
     * @param length the given length
     * @return a random integer between 0 and the given (length - 1) (inclusive)
     */
    public static int getRandomIndex(SecureRandom rand, int length) {
        return rand.nextInt(length);
    }

}

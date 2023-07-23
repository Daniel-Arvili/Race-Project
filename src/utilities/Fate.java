package utilities;
import java.util.Random;
/**
 * @Author Daniel Arvili
 * @Author Aviv Hagag
 */
public class Fate {
	/**
	 The Fate class represents a source of randomness for generating mishaps.
	 */
	private static Random rand = new Random();
	/**
	 Returns a random boolean value.
	 */
	public static boolean breakDown() {
		return rand.nextBoolean();
	}
	/**
	 Generates and returns a random boolean value that indicates if the generated mishap is fixable.
	 @return a random boolean value that indicates if the generated mishap is fixable
	 */
	public static boolean generateFixable() {
		return rand.nextInt(10) > 7;
	}
	/**
	 Generates and returns a new Mishap object with randomly generated values.
	 @return a new Mishap object with randomly generated values
	 */
	public static Mishap generateMishap() {
		return new Mishap(generateFixable(), generateTurns(), generateReduction());
	}
	/**
	 Generates and returns a random float
	 */
	private static float generateReduction() {
		return rand.nextFloat();
	}
	/**
	 Generates and returns a random integer value between 1 and 5 (inclusive).
	 */
	private static int generateTurns() {
		return rand.nextInt(5) + 1;
	}
	/**
	 Sets the seed of the random number generator to the specified value.
	 */
	public static void setSeed(int seed) {
		rand.setSeed(seed);
	}

}

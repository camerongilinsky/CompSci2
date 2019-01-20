// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5

import java.util.Random;
import java.util.Scanner;

/**
 * Runs the RandGuessGame. Creates an instance of RandGuessGame and calls upon its methods to conduct the game.
 * <br><strong>RandGuessGame methods called in order:</strong><br>
 * populateArray<br>
 * outputArray (passing true to hide values)<br>
 * playerGuess<br>
 * getResult<br>
 * outputArray (passing false to show all values)<br>
 * @author CSCI1620 instructors
 */
public class GameDriver
{
	/**
	 * Main method which creates instance of RandGuessGame and executes its methods.
	 * @param args Command line arguments (Unused)
	 */
	public static void main(String[] args)
	{
		//Generate instance of game
		RandGuessGame game = new RandGuessGame(new Random());
		Scanner input = new Scanner(System.in);
		char guess;

		//Conduct game behaviors
		game.populateArray();
		System.out.println(game);

		do
		{
			System.out.print("Is the sum of the numbers greater than 250?\n(Y or N): ");
			guess = input.next().charAt(0);
		} while (!game.validatePlayerGuess(guess));

		System.out.println(game.getResult());

		game.toggleHidden();
		System.out.println(game);
		
		input.close();
	}
}

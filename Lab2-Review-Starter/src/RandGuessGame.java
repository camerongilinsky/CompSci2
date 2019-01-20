// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky
// RESOURCES: Piazza discussion board posts by the students and instructors for this class,
//            found at https://piazza.com/class/jqiqv19pp2w4sw?cid=5

import java.util.Random;

/**
 * Class for a simple, randomized guessing game. Five integer values between 1 and MAX_VALUE (inclusive) will be
 * generated. Only the first and last will be shown to the player. The player must then guess if the sum
 * of all of the numbers is greater than the possible average or not.
 * @author Cameron Gilinsky
 */
public class RandGuessGame
{
	
	/**
	 * Number of randomly generated numbers.
	 */
	private static final int ARRAY_SIZE = 5;
	
	/**
	 * Maximum value of randomly generated values.
	 */
	private static final int MAX_VALUE = 100;
	
	/**
	 * Stores sum of random values.
	 */
	private int arraySum;
	
	/**
	 * Stores player's guess.
	 */
	private char guess;
	
	/**
	 * Number the player must guess against, calculated with MAX_VALUE and ARR_SIZE.
	 */
	private int guessTarget;
	
	/**
	 * Determines if the String returned by toString hides the middle values.
	 */
	private boolean hideMiddleVals = true;
	
	/**
	 * Stores randomly generated numbers for game.
	 */
	private int[] numbers;
	
	/**
	 * Random number generator to use for the game.
	 */
	private Random rand;
	
	/**
	 * Constructor for the RandGuessGame.
	 * @param inner is the random number generator passed from GameDriver.
	 */
	public RandGuessGame(Random inner) 
	{
		arraySum = 0;
		guessTarget = (MAX_VALUE * ARRAY_SIZE) / 2;
		rand = inner;
		numbers = new int[ARRAY_SIZE];
	}
	
	/**
	 * Retrieves the numbers array. Used for testing, do not change.
	 * @return The numbers array.
	 */
	public int[] getNumbers()
	{
		return numbers;
	}
	
	/**
	 * Retrieves the sum of the numbers in the array. Used for testing, do not change.
	 * @return The value of arraySum.
	 */
	public int getArraySum()
	{
		return arraySum;
	}
	
	/**
	 * Populates the "numbers" array with random numbers between 1 and "MAX_VALUE".
	 */
	public void populateArray()
	{
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(MAX_VALUE) + 1;
			arraySum += numbers[i];
		}
	}
	
	/**
	 * Accepts a user's guess for the game.
	 * @param yesOrNo is the user's input.
	 * @return either the char 'Y' or the char 'N' to accept the input as valid.
	 */
	public boolean validatePlayerGuess(char yesOrNo)
	{
		guess = yesOrNo;
		return yesOrNo == 'Y' || yesOrNo == 'N';
	}
	
	/**
	 * Checks to see if player's guess was correct, and constructs and returns
	 * a String that reports if they are correct or incorrect, and appends the 
	 * correct sum of the array.
	 * @return a string corresponding to whether or not the user's guess was correct or incorrect.
	 */
	public String getResult()
	{	
		String result = "";
		
		if ((guess == 'Y' && arraySum > guessTarget) || (guess == 'N' && arraySum <= guessTarget))
		{
			result = new String("You guessed correctly! The sum was " + arraySum + "!");
		}
		else
		{
			result = new String("You guessed wrong! The sum was " + arraySum + "!");
		}
	
		return result;
	}
	
	/**
	 * Toggles the value of hideMiddleVals.
	 */
	public void toggleHidden()
	{
		hideMiddleVals = hideMiddleVals ^ true;
	}
	
	/**
	 * Returns a String containing the values in the "numbers" array on a single line,
	 * separated by spaces with the middle values hidden or all visible based on value
	 * of "hideMiddleValue" data member.
	 * @return the "numbers" array with or without middle values obscured 
	 */
	public String toString()
	{
		
		if (hideMiddleVals)
		{
			return String.format("%d X X X %d ", numbers[0], numbers[4]); 
			
		}
		else
		{
			return String.format("%d %d %d %d %d ", 
					numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]); 
		}
	}
	
}
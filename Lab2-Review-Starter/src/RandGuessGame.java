// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky
// RESOURCES:

import java.util.Random;

/**
 * Class for a simple, randomized guessing game. Five integer values between 1 and MAX_VALUE (inclusive) will be
 * generated. Only the first and last will be shown to the player. The player must then guess if the sum
 * of all of the numbers is greater than the possible average or not.
 * @author Cameron Gilinsky
 */
public class RandGuessGame
{

	//Declare data members
	private static int ARRAY_SIZE = 5;
	private int arraySum;
	private char guess;
	private int guessTarget;
	private boolean hideMiddleVals = true;
	private static int MAX_VALUE = 100;
	private int[] numbers;
	private Random rand;
	
	//Create Constructor
	public RandGuessGame(Random inner) 
	{
		arraySum = 0;
		guessTarget = ((MAX_VALUE * ARRAY_SIZE) / 2);
		rand = inner;
		numbers = new int[ARRAY_SIZE];
		/*for (int k = 0; k < ARRAY_SIZE; k++)
		{
			numbers[k] = rand.nextInt(MAX_VALUE);
		}*/
		
	}
	
	//Write member methods
	
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
	
	public void populateArray()
	{
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(MAX_VALUE) + 1;
			arraySum += numbers[i];
		}
		//return 0;
	}
	
	/*public String outputArray(boolean gle)
	{
		if (gle)
		{
			
			return String.format("%d X X X %d ", numbers[0], numbers[4]);
			
		}
		else
		{
			return String.format("%d %d %d %d %d ", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]);
		}
	}*/
	
	/*public void playerGuess()
	{
		
	}*/
	
	public boolean validatePlayerGuess(char yesOrNo)
	{


		guess = yesOrNo;
		return yesOrNo == 'Y' || yesOrNo == 'N';
	}
	
	public String getResult()
	{	
		String result = new String("");
		
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
	
	public void toggleHidden()
	{
		hideMiddleVals = hideMiddleVals ^ true;
	}
	
	public String toString()
	{
		//return outputArray(hideMiddleVals);
		if (hideMiddleVals)
		{
			return String.format("%d X X X %d ", numbers[0], numbers[4]); 
			
		}
		else
		{
			return String.format("%d %d %d %d %d ", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]); 
		}
	}
}

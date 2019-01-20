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
	private final int MAX_VALUE = 100;
	private final int ARRAY_LENGTH = 5;
	private final int SUM_MAX = 250;
	public int[] arr = new int[5];
	public char answer;
	public int sum;
	public boolean tog = false;
	
	Random rand = new Random();
	
	//Create Constructor
	public RandGuessGame(Random inner) 
	{
		rand = inner;
		
		for (int k = 0; k < ARRAY_LENGTH; k++)
		{
			arr[k] = rand.nextInt(MAX_VALUE);
		}
		
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
		int arraySum = 0;
		for (int j = 0; j < 5; j++)
		{
			arraySum += arr[j];
		}
		sum = arraySum;
		return arraySum;
	}
	
	public int populateArray()
	{
		for (int i = 0; i < 5; i++)
		{
			arr[i] = rand.nextInt(MAX_VALUE);
		}
		return 0;
	}
	
	public boolean validatePlayerGuess(char yesOrNo)
	{
		answer = yesOrNo;
		return yesOrNo == 'Y' || yesOrNo == 'N';
	}
	
	public String getResult()
	{
		sum = getArraySum();
		
		String result = new String("");
		
		if (answer == 'Y' && sum > SUM_MAX)
		{
			result = new String("You guessed correctly! The sum was " + sum + "!");
		}
		else if (answer == 'N' && sum <= SUM_MAX)
		{
			result = new String("You guessed correctly! The sum was " + sum + "!");
		}
		else
		{
			result = new String("You guessed wrong! The sum was " + sum + "!");
		}
	
		return result;
	}
	
	public void toggleHidden()
	{
		tog = true;
	}
	
	public String toString()
	{
		if (tog)
		{
			return String.format("%d %d %d %d %d", arr[0], arr[1], arr[2], arr[3], arr[4]);
		}
		else
		{
			return String.format("%d X X X %d", arr[0], arr[4]);
		}
	}
}

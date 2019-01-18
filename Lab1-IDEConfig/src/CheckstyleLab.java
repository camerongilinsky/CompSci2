// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky
// RESOURCES: Piazza discussion board posts by an anonymous student and one of the the instructors for this class.

/**
 * Calculate and display the square of each number in the range of the ARR_SIZE and the sum of the squares.
 * @author ckgilinsky
 *
 */
public class CheckstyleLab
{
	/**
	 * Sets the number range (and array size) to be used.
	 */
	private static final int ARR_SIZE = 10;
	
	/**
	 * Main method which calculates the sum of the squares of the integers 1 to 10 inclusive.
	 * @param args Command line arguments (Unused)
	 */
	public static void main(String[] args)
	{
		
		int[] squares = new int[ARR_SIZE];
		
		for (int i = 0; i < 10; i++)
		{
			squares[i] = (int) Math.pow(i + 1, 2);
			System.out.printf("Square of %d is %d\n", i + 1, squares[i]);
		}
		
		System.out.printf("The sum of the squares is %d!\n", sumArray(squares));

	}
	
	/**
	 * This method returns the sum of the values in the arr parameter or zero when arr is null.
	 * @param arr is the input array from the main method
	 * @return is the sum of the array indices
	 */
	public static int sumArray(int[] arr)
	{
		int sum = 0;
		if (arr != null)
		{
			for (int i = 0; i < arr.length; i++)
			{
				sum += arr[i];
			}
		}
		return sum;
	}

}

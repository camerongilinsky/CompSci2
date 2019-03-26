// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

import java.io.FileNotFoundException;

/**
 * A class to read and write RetailFoodEntry values to a file.
 * @author ckgilinsky and ckennell
 */
public class FileIO
{
	/**
	 * Constructor takes the file name of a file to read or write to.
	 * @param fileIn file Input file name.
	 */
	public FileIO(String fileIn)
	{
		
	}
	
	/**
	 * Method to read all entries in the file. Files contain the comma
	 * separated values. Following the a header row, each line corresponds
	 * to one RetailFoodEntry. For example:
	 * 
	 * Name,Address,RATING,CURRENT,RISK
	 * 1000 Degrees Neapolitan Pizzeria,17676 WELCH PLZ STE 9,EXCELLENT,10/25/2018,MEDIUM
	 * 
	 * Name and Address are the name and location of the establishment. RATING
	 * corresponds to the most recent health inspection rating conducted on CURRENT.
	 * RISK indicates how at-risk a restaurant could be based on the type of food
	 * they serve. For more details:
	 * https://www.douglascountyhealth.com/food-safety/retail-food-establishment-rating-list 
	 * While reading the file, any rows with invalid RATING, CURRENT, or RISK
	 * values will be skipped.
	 * A maximum of 10,000 entries can be assumed.
	 * @return Array of all valid RetailFoodEntry objects in the read file.
	 * @throws FileNotFoundException if the file specified in the constructordoes not exist.
	 */
	public RetailFoodEntry[] readFile() throws FileNotFoundException
	{
		RetailFoodEntry[] temp = null;
		return temp;
	}
	
	/**
	 * Method to write the entries to the file.
	 * @param entries The entries to be written to this file.
	 * @throws FileNotFoundException if the file specified in the constructor
	 * cannot be accessed for writing.
	 */
	public void writeFile(RetailFoodEntry[] entries) throws FileNotFoundException
	{
		
	}
}

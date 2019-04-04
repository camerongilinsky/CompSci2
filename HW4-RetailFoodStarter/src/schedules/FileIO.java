// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A class to read and write RetailFoodEntry values to a file.
 * @author ckgilinsky and ckennell
 */
public class FileIO
{
	/**
	 * The largest list size to expect.
	 */
	private static final int MAX_LIST_SIZE = 10000;
	
	/**
	 * The file name to be read or be written.
	 */
	private String file;
	
	/**
	 * Constructor takes the file name of a file to read or write to.
	 * @param fileIn file Input file name.
	 */
	public FileIO(String fileIn)
	{
		file = fileIn;
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
	 * @throws FileNotFoundException if the file specified in the constructor does not exist.
	 */
	public RetailFoodEntry[] readFile() throws FileNotFoundException
	{
		RetailFoodEntry[] items = new RetailFoodEntry[MAX_LIST_SIZE];
		
			
		Scanner in = new Scanner(new File(file));
		int i = 0;
		in.nextLine();
		
				
		while (in.hasNextLine())
		{
			try				
			{
				
				String record = in.nextLine();
					
				Scanner lineParser = new Scanner(record);
				lineParser.useDelimiter(",");
					
				String name = lineParser.next();
				String address = lineParser.next();
				String rating = lineParser.next();
				String date = lineParser.next();
				String risk = lineParser.next();
				
				
				
				items[i] = new RetailFoodEntry(name, address, rating, date, risk);
					
				lineParser.close();
				i++;
			}
			catch (IllegalArgumentException iae)
			{
				System.out.println("Invalid Rating or Risk");
			}
			catch (InvalidDateException ide)
			{
				System.out.println("Invalid date");
			}
		}

		in.close();
		return items;
	}
	
	/**
	 * Method to write the entries to the file.
	 * @param entries The entries to be written to this file.
	 * @throws FileNotFoundException if the file specified in the constructor
	 * cannot be accessed for writing.
	 */
	public void writeFile(RetailFoodEntry[] entries) throws FileNotFoundException
	{
		try
		{
			if (file == null || file.equals(""))
			{
				throw new FileNotFoundException();
			}
			
			FileOutputStream fileOut = new FileOutputStream(file, false);
			PrintWriter writer = new PrintWriter(fileOut);
			
			writer.println("Name,Address,RATING,CURRENT,RISK");
			
			for (int i = 0; i < entries.length; i++)
			{
				if (entries[i] != null)
				{
					writer.println(entries[i].toString());
				}
			}
			
			writer.close();
		}
		catch (FileNotFoundException fnfe)
		{
			throw new FileNotFoundException();
		}

	}
}
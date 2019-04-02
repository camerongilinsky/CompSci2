// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

import java.io.FileNotFoundException;

import sorting.EntryDateComparator;
import sorting.EntryNameComparator;
import sorting.EntryRatingComparator;
import sorting.EntryRiskComparator;
import sorting.SortData;

/**
 * Class to process and report on a schedule for the upcoming Month.
 * Starting with the current date, the schedule will be the consist of the
 * maximum number of possible inspections.
 * Ranking for order should be Date, then rating, then risk.
 * @author ckgilinsky and ckennell
 */
public class MonthlySchedule
{
	/**
	 * Maximum number of entries.
	 */
	public static final int MAX_ENTRIES = 10000;
	
	/**
	 * Instance array for output.
	 */
	private RetailFoodEntry[] masterList = new RetailFoodEntry[MAX_ENTRIES];
	
	/**
	 * Method takes in all of the RetailFoodEntry objects and a given date.
	 * All inspections for the month will be stored.
	 * @param data Array of all RetailFoodEntry objects
	 */
	public void processData(RetailFoodEntry[] data, Date dateIn)
	{
		int count = 0;
		
		for (int i = 0; i < data.length; i++)
		{
			if (dateIn.compareTo(data[i].getDate()) != 1) //this line is currently wrong, needs to be fixed
			{
				masterList[count] = data[i];
				count++;
			}
		}
	}
	
	/**
	 * Method to write the schedule to a CSV file.
	 * @param fileName Name of the file to write to.
	 * @return if the writing was successful.
	 */
	public boolean writeSchedule(String fileName)
	{
		FileIO writer = new FileIO(fileName);
		try
		{
			writer.writeFile(masterList);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Method to sort the current schedule by various fields.
	 * Fields will be "Name", "Date", "Rating" and "Risk".
	 * @param value the field parameter to sort the data by.
	 */
	public void sortBy(String value)
	{
		if (value.equals("Name"))
		{
			SortData.sort(masterList, new EntryNameComparator());
		}
		else if (value.equals("Date"))
		{
			SortData.sort(masterList, new EntryDateComparator());
		}
		else if (value.equals("Rating"))
		{
			SortData.sort(masterList, new EntryRatingComparator());
		}
		else if (value.equals("Risk"))
		{
			SortData.sort(masterList, new EntryRiskComparator());
		}
	}
}
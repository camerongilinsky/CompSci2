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
 * Class to create a daily schedule starting at a given date.
 * Priority will be given to the date, rating, and risk in that order.
 * @author ckgilinsky and ckennell
 */
public class DailySchedule implements Schedule
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
	 * Method to take all RetailFoodEntries in loaded list and pull out
	 * the entries that match the given date. Schedule will continue in sequential dates
	 * until max value of inspections are scheduled.
	 * The schedule should include dates from this date on.
	 * @param data All RetailFoodEntry objects in loaded file.
	 * @param dateIn The Date object to begin search.
	 */
	public void processData(RetailFoodEntry[] data, Date dateIn)
	{
		int count = 0;
		
		SortData.sort(data, (new EntryDateComparator())
				.thenComparing(new EntryRatingComparator()).thenComparing(new EntryRiskComparator()));
		
		for (int i = 0; count < MAX_DAILY_INSPECTIONS; i++)
		{
			if (dateIn.compareTo(data[i].getDate()) < 1) //this line is currently wrong, needs to be fixed
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
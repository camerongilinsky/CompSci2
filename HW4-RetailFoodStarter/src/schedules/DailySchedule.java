// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

/**
 * Class to create a daily schedule starting at a given date.
 * Priority will be given to the date, rating, and risk in that order.
 * @author ckgilinsky and ckennell
 */
public class DailySchedule implements Schedule
{
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
		
	}
	
	/**
	 * Method to write the schedule to a CSV file.
	 * @param fileName Name of the file to write to.
	 * @return if the writing was successful.
	 */
	public boolean writeSchedule(String fileName)
	{
		return true;
	}
	
	/**
	 * Method to sort the current schedule by various fields.
	 * Fields will be "Name", "Date", "Rating" and "Risk".
	 * @param value the field parameter to sort the data by.
	 */
	public void sortBy(String value)
	{
		
	}
	
}

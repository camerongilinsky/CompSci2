// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

/**
 * The Schedule interface defines common behaviors expected from 
 * all scheduling classes. 
 * 
 * @author bdorn
 *
 */
public interface Schedule 
{
	final String FILE_HEADER = "Name,Address,RATING,CURRENT,RISK";
	final int MAX_DAILY_INSPECTIONS = 10;
	final int MAX_MONTHLY_INSPECTIONS = 200;
	
	/**
	 * A method to process all the data from the given RetailFoodEntry array.
	 * @param data All the RetailFoodEntry objects to sort through.
	 * @param day The day around which a Schedule will be generated.
	 */
	void processData(RetailFoodEntry[] data, Date day);
	
	/**
	 * Writes the schedule to a CSV in the given file name.
	 * @param fileName Name of file to store output schedule
	 * @return if the write was successful.
	 */
	boolean writeSchedule(String fileName);
	
	/**
	 * Sorts the data by the parameter listed.
	 * @param value ("Name", "Date", "Risk", "Rating") to sort by.
	 */
	void sortBy(String value);
	
	
}

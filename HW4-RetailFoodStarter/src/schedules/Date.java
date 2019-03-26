// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

/**
 * Date object holds the month, day, and year of a given date.
 * Class is Comparable so it can evaluate one Date against another.
 * @author ckgilinsky and ckennell
 */
public class Date implements Comparable<Date>
{
	/**
	 * Constructor.
	 * @param dateIn a mm/dd/yyyy formed String representing a date
	 * @throws InvalidDateException when the date provided is null, empty,
	 * or improperly formatted.
	 */
	public Date(String dateIn)
	{
		
	}
	
	/**
	 * Takes a String in mm/dd/yyyy format and stores as a date object.
	 * @param dateIn String representation of the date.
	 * @throws InvalidDateException when the date provided is null, empty,
	 * or improperly formatted.
	 */
	public void setDate(String dateIn) throws InvalidDateException
	{
		
	}
	
	/**
	 * Accessor for the current month.
	 * @return the month
	 */
	public int getMonth()
	{
		return 0;
	}
	
	/**
	 * Accessor for current day.
	 * @return the day
	 */
	public int getDay()
	{
		return 0;
	}
	
	/**
	 * Accessor for the current year.
	 * @return the year
	 */
	public int getYear()
	{
		return 0;
	}
	
	/**
	 * Returns the date as a String in mm/dd/yyyy format.
	 * @return String representation of the object.
	 */
	public String toString()
	{
		return "";
	}
	
	/**
	 * Returns the comparison of this date to the other date object.
	 * @param other another date object to compare.
	 * @return a negative value if this date is before the other date, a positive value if after, 0 if same date.
	 */
	public int compareTo(Date other)
	{
		return 0;
	}
}

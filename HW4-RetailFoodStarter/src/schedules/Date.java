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
	 * Month for the local Date object.
	 */
	private int month;
	
	/**
	 * Day for the local Date object.
	 */
	private int day;
	
	/**
	 * Year for the local Date object.
	 */
	private int year;
	
	/**
	 * String representation of the Date.
	 */
	private String dateString;
	
	/**
	 * Constructor.
	 * @param dateIn a mm/dd/yyyy formed String representing a date
	 * @throws InvalidDateException when the date provided is null, empty,
	 * or improperly formatted.
	 */
	public Date(String dateIn)
	{
		setDate(dateIn);
	}
	
	/**
	 * Takes a String in mm/dd/yyyy format and stores as a date object.
	 * @param dateIn String representation of the date.
	 * @throws InvalidDateException when the date provided is null, empty,
	 * or improperly formatted.
	 */
	public void setDate(String dateIn) throws InvalidDateException
	{
		if (dateIn != null && !dateIn.equals(""))
		{
			dateString = dateIn;
			String[] monthDayYear = dateIn.split("/", 3);
			//System.out.printf(monthDayYear[0],monthDayYear[1], monthDayYear[2]);
			
			month = Integer.parseInt(monthDayYear[0]);
			day = Integer.parseInt(monthDayYear[1]);
			if (monthDayYear[2].matches("[0-9]+"))
			{
				year = Integer.parseInt(monthDayYear[2]);
			}
			else
			{
				year = 0;  //year = 2018;
			}
		}
		else
		{
			dateString = "";
		}
	}
	
	/**
	 * Accessor for the current month.
	 * @return the month
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * Accessor for current day.
	 * @return the day
	 */
	public int getDay()
	{
		return day;
	}
	
	/**
	 * Accessor for the current year.
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Returns the date as a String in mm/dd/yyyy format.
	 * @return String representation of the object.
	 */
	public String toString()
	{
		return String.format(dateString);
	}
	
	/**
	 * Returns the comparison of this date to the other date object.
	 * @param other another date object to compare.
	 * @return a negative value if this date is before the other date, a positive value if after, 0 if same date.
	 */
	public int compareTo(Date other)
	{
		int ret = 0;
		
		if (year == other.getYear())
		{
			if (month == other.getMonth())
			{
				if (day == other.getDay())
				{
					ret = 0;
				}
				else if (day > other.getDay())
				{
					ret = 1;
				}
				else
				{
					return -1;
				}
			}
			else if (month > other.getMonth())
			{
				ret = 1;
			}
			else
			{
				ret = -1;
			}
		}
		else if (year > other.getYear())
		{
			ret = 1;
		}
		else
		{
			ret = -1;
		}
			
		return ret;
	}
}
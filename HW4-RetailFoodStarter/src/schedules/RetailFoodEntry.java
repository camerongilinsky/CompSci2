// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

/**
 * Class to hold an entry of a retail food rating.
 * @author ckgilinsky and ckenell
 */
public class RetailFoodEntry
{
	private String name;
	private String address;
	private String rating;
	private String date;
	private String risk;
	
	
	
	/**
	 * Constructor that takes all elements of the RetailFoodEntry.
	 * @param nameIn Name of the food establishment
	 * @param addressIn Address of the entry
	 * @param ratingIn Rating of the entry
	 * @param dateIn Date of last inspection
	 * @param riskIn Risk level of the entry
	 * @throws IllegalArgumentException if the provided ratingIn or riskIn values do not
	 * correspond to one of the acceptable values.
	 */
	public RetailFoodEntry(String nameIn,
			String addressIn,
			String ratingIn,
			String dateIn,
			String riskIn)
	{
		name = nameIn;
		address = addressIn;
		rating = ratingIn;
		date = dateIn;
		risk = riskIn;
	}
	
	/**
	 * Accessor method for name.
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Accessor method for the address.
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Accessor method for the Date.
	 * @return the Date object
	 */
	public Date getDate()
	{
		Date temp = null;
		return temp;
	}
	
	/**
	 * Accessor for the rating.
	 * @return the rating
	 */
	public Rating getRating()
	{
		Rating temp = null;
		return temp;
	}
	
	/**
	 * Accessor for the Risk.
	 * @return the risk
	 */
	public Risk getRisk()
	{
		Risk temp = null;
		return temp;
	}
	
	/**
	 * Compares two RetailFoodEntry objects based on their names.
	 * @param other The other RetailFoodEntry object
	 * @return -1 if this is ahead of the other in the alphabet, 1 if after, 0 if equal.
	 */
	public int compareTo(RetailFoodEntry other)
	{
		return 0;
	}
	
	/**
	 * Returns the String version of a retail food entry with comma separation of fields.
	 * @return String version of name,address,rating,date,risk for storage in a CSV or display.
	 */
	public String toString()
	{
		return "";
	}
	
}

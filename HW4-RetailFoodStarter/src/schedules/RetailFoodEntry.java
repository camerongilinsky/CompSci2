// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;

/**
 * Class to hold an entry of a retail food rating.
 * @author ckgilinsky and ckennell
 */
public class RetailFoodEntry
{
	/**
	 * Name of the local RetailFoodEntry object.
	 */
	private String name;
	
	/**
	 * Address of the local RetailFoodEntry object.
	 */
	private String address;
	
	/**
	 * Rating of the local RetailFoodEntry object.
	 */
	private Rating rating;
	
	/**
	 * Date of the local RetailFoodEntry object.
	 */
	private Date date;
	
	/**
	 * Risk of the local RetailFoodEntry object.
	 */
	private Risk risk;
	
	/**
	 * Constructor that takes all elements of the RetailFoodEntry.
	 * @param nameIn Name of the food establishment
	 * @param addressIn Address of the entry
	 * @param ratingIn Rating of the entry
	 * @param dateIn Date of last inspection
	 * @param riskIn Risk level of the entry
	 * @throws IllegalArgumentException if the provided ratingIn or riskIn values do not
	 * correspond to one of the acceptable values.
	 * @throws InvalidDateException if the provided date is not acceptable.
	 */
	public RetailFoodEntry(String nameIn,
			String addressIn,
			String ratingIn,
			String dateIn,
			String riskIn) throws IllegalArgumentException, InvalidDateException
	{
			
		if (nameIn != null)
		{
			name = nameIn;
		}
		
		if (addressIn != null)
		{
			address = addressIn;
		}

	
		try
		{
			
			date = new Date(dateIn);
			
				
			if (ratingIn != null && !ratingIn.equals(""))
			{
				rating = Rating.valueOf(ratingIn.toUpperCase());
			}
			if (riskIn != null && !riskIn.equals(""))
			{
				risk = Risk.valueOf(riskIn.toUpperCase());				
			}
		}
		catch (InvalidDateException ice)
		{
			throw new InvalidDateException("Invalid Date");
		}
		catch (IllegalArgumentException ice)
		{
			throw new IllegalArgumentException("Invalid Rating");
		}
		//throw new IllegalArgumentException("Invalid Rating");
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
		return date;
	}
	
	/**
	 * Accessor for the rating.
	 * @return the rating
	 */
	public Rating getRating()
	{
		return rating;
	}
	
	/**
	 * Accessor for the Risk.
	 * @return the risk
	 */
	public Risk getRisk()
	{
		return risk;
	}
	
	/**
	 * Compares two RetailFoodEntry objects based on their names.
	 * @param other The other RetailFoodEntry object
	 * @return -1 if this is ahead of the other in the alphabet, 1 if after, 0 if equal.
	 */
	public int compareTo(RetailFoodEntry other)
	{
		return name.compareTo(other.getName());
	}
	
	/**
	 * Returns the String version of a retail food entry with comma separation of fields.
	 * @return String version of name,address,rating,date,risk for storage in a CSV or display.
	 */
	public String toString()
	{
		return String.format("%s,%s,%s,%s,%s", name, address,
				rating, //needs to be replaced with a working rating.toString
				date, //needs to be replaced with a working date.toString
				risk); //needs to be replaced with a working risk.toString
	}
}
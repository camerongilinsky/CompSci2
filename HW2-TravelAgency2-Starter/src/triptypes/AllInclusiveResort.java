// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class.

package triptypes;

/**
 * This class encapsulates details related to an all-inclusive resort
 * vacation package. Flight information to/from the resort location
 * can be added an additional price. Once at the resort, all-inclusive
 * packages are billed using a flat fee, regardless of the number of
 * included amenities.
 * @author ckgilinsky and ckennell
 */
public class AllInclusiveResort extends FlightOptionalPackage
{
	private String resortOut;
	private int guestsPerRoomOut;
	private double pricePerNightOut;
	private String[] amenitiesListOut;
	
	/**
	 * Creates a new AllInclusiveResort package.
	 * @param name The promotional name for this package.
	 * @param numDays The number of days included in this vacation package.
	 * @param resort The name of the resort.
	 * @param guestsPerRoom The number of guests allowed per room at the included price.
	 * @param pricePerNight The price of the stay per night.
	 * @param amenitiesList A list of amenities available for free at the resort.
	 */
	public AllInclusiveResort(String name,
			int numDays,
			String resort,
			int guestsPerRoom,
			double pricePerNight,
			String[] amenitiesList)
	{
		super(name, numDays);
		resortOut = resort;
		guestsPerRoomOut = guestsPerRoom;
		pricePerNightOut = pricePerNight;
		amenitiesListOut = amenitiesList;
	}
	
	/**
	 * Retrieves a single String containing all of the available amenities at the
	 * resort. Individual amenities should be separated by a single comma and space
	 * character, with no such separator at the end of the string.
	 * @return The amenities list.
	 */
	public String getAmenities()
	{
		String s1 = "";
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < amenitiesListOut.length; i++)
		{
			s.append(amenitiesListOut[i] + ", ");
		}
		
		s1 = s.toString();
		return s1;
	}
	
	/**
	 * Retrieves the number of guests allowed per room at the specified rate.
	 * @return The number of guests per room.
	 */
	public int getGuestsPerRoom()
	{
		return guestsPerRoomOut;
	}
	
	/**
	 * The full price for this all-inclusive package, including any optional flight pricing.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return getFlightCosts() + (numDays * pricePerNightOut);
	}
	
	/**
	 * The required deposit amount to be made at the time of booking. All
	 * upfront flight-related costs and 50% of the total lodging costs for this
	 * trip must be paid as a deposit.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return 0.0;
	}
	
	/**
	 * Provides the subtotal for a trip related to lodging expenses (ie. not
	 * including flights, meals, and incidentals). Lodging rates are determined
	 * by specific package types.
	 * @return The lodging subtotal in US dollars.
	 */
	public double getLodgingCost()
	{
		return 0.0;
	}
	
	/**
	 * A formatted summary string with details about this all-inclusive resort
	 * package. The string will contain information as described by FlightOptionalPackage
	 * followed by details about the resort and the number of people included at the
	 * specified price. The second line should be prefixed with 11 blank
	 * spaces for alignment below the trip name. For example:
	 * $  450.35  Punta Cana Fiesta! (Flight Included)
	 * An all-inclusive stay at Flip Flops for 2 people!
	 * @return The formatted string summary.
	 */
	public String toString()
	{
		return "";
	}
}

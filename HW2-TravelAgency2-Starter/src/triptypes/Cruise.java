// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class.

package triptypes;

import java.util.Calendar;

/**
 * This class represents a cruise package within the travel agency.
 * It stores required information about the cruise ship, including
 * departure and arrival times. It allows for optional off-ship
 * excursion packages to be added to a trip for an additional price.
 * @author ckgilinsky and ckennell
 */
public class Cruise extends FlightOptionalPackage
{

	/**
	 * Maximum number of excursions.
	 */
	private static final int MAX_EXCURSIONS = 10;
	
	/**
	 * Amount to scale lodging cost for the deposit.
	 */
	private static final double DEPOSIT_SCALE = 0.5;
	
	/**
	 * Amount to scale OCEAN_VIEW cabin by.
	 */
	private static final double OCEAN_VIEW_SCALE = 1.5;
	
	/**
	 * Amount to scale BALCONY cabin by.
	 */
	private static final int BALCONY_SCALE = 3;
	
	/**
	 * Amount to scale SUITE cabin by.
	 */
	private static final int SUITE_SCALE = 5;
	
	/**
	 * Name of the vessel.
	 */
	private String vesselNameOut;
	
	/**
	 * Name of the port city.
	 */
	private String portCityOut;
	
	/**
	 * Date and time of departure.
	 */
	private Calendar departsOut;
	
	/**
	 * Date and time of arrival.
	 */
	private Calendar returnsOut;
	
	/**
	 * Base price of the Cruise.
	 */
	private double basePriceOut;
	
	/**
	 * Collection of added excursions for this Cruise.
	 */
	private String[] excursions = new String[MAX_EXCURSIONS];
	
	/**
	 * Name of the excursion.
	 */
	private String excursionName;
	
	/**
	 * Cost of the excursion.
	 */
	private double excursionCost;
	
	/**
	 * Cost of all excursions combined.
	 */
	private double totalExcursionCost = 0;
	
	/**
	 * Type of cabin for Cruise.
	 */
	private CabinType cabinType;
	
	/**
	 * Creates a new Cruise trip with specified values for all data
	 * except optional excursions.
	 * @param name The promotional name of the travel package.
	 * @param numDays The number of days for this travel package.
	 * @param vesselName The ship name for this Cruise.
	 * @param portCity The departure port for this Cruise.
	 * @param departs The time and date of departure from the port.
	 * @param returns The time and date of return to the port.
	 * @param basePrice The base price for the cheapest tier cabin (interior) on the ship.
	 * Cabin upgrades can be accommodated through a subsequent setter call.
	 */
	public Cruise(String name,
			int numDays,
			String vesselName,
			String portCity,
			Calendar departs,
			Calendar returns,
			double basePrice)
	{
		super(name, numDays);
		vesselNameOut = vesselName;
		portCityOut = portCity;
		departsOut = departs;
		returnsOut = returns;
		basePriceOut = basePrice;
	}
	
	/**
	 * Adds a named excursion to this Cruise. Excursions may or may not
	 * have an additional charge associated.
	 * @param excursion The name of the excursion to add to this package.
	 * Empty excursion values are invalid and should not result in a change
	 * to the Cruise package configuration.
	 * @param price The price of the excursion. Prices must be >= 0, with
	 * any negative values being treated as equivalent to 0.
	 */
	public void addExcursion(String excursion, double price)
	{
		if (!excursion.equals(""))
		{
			excursionName = excursion;
		}
		
		if (price > 0)
		{
			excursionCost = price;
		}
		else
		{
			excursionCost = 0.0;
		}
		
		totalExcursionCost += excursionCost;
		
		for (int i = 0; i < MAX_EXCURSIONS; i++)
		{
			if (excursions[i] == null)
			{
				excursions[i] = excursionName;
				break;
			}
		}

	}
	
	/**
	 * Retrieves an array containing all of the excursions which have been
	 * added to this Cruise, in the order in which they were added.
	 * @return The list of excursions.
	 */
	public String[] getExcursions()
	{
		return excursions;
	}
	
	/**
	 * Updates the cabin configuration for this Cruise. This method can be
	 * used to upgrade a cruise from the base price corresponding to the
	 * cheapest cabin (an interior cabin without any ocean view).
	 * @param cabin A valid alternate cabin level for this package.
	 */
	public void setCabinType(CabinType cabin)
	{
		cabinType = cabin;
	}
	
	/**
	 * Retrieves the cabin level currently associated with this Cruise package.
	 * @return The current cabin level.
	 */
	public CabinType getCabinType()
	{
		return cabinType;
	}
	
	/**
	 * Retrieves the home port of the cruise ship for this package.
	 * @return The city from which this Cruise departs.
	 */
	public String getHomePort()
	{
		return portCityOut;
	}
	
	/**
	 * Retrieves the date and time of departure for this Cruise.
	 * @return The departure time at the port.
	 */
	public java.util.Calendar getDepartureDate()
	{
		return departsOut;
	}
	
	/**
	 * Retrieves the date and time of arrival for this Cruise.
	 * @return The arrival time at the port.
	 */
	public java.util.Calendar getReturnDate()
	{
		return returnsOut;
	}
	
	/**
	 * Retrieves the name of ship sailing for this Cruise.
	 * @return The ship name.
	 */
	public String getVesselName()
	{
		return vesselNameOut;
	}
	
	/**
	 * Retrieves the total cost for all added excursions on this Cruise.
	 * @return The excursions total in US Dollars.
	 */
	public double getExcursionCosts()
	{
		return totalExcursionCost;
	}
	
	/**
	 * Retrieves the number of excursions which have been added to this Cruise package.
	 * @return The number of excursions.
	 */
	public int getNumExcursions()
	{
		int count = 0;
		
		for (int i = 0; i < excursions.length; i++)
		{
			if (excursions[i] != null)
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Retrieves the full price of this Cruise package, including pre-cruise
	 * flight arrangements (as applicable), full lodging costs, and any
	 * additional excursion costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		return getExcursionCosts() + getLodgingCost() + getFlightCosts();
	}
	
	/**
	 * Retrieves the deposit amount required upfront for this Cruise.
	 * Cruise packages require that all applicable flight costs and 50%
	 * of expected lodging costs are paid at the time of booking.
	 * Optional excursion costs are not included in the deposit amount,
	 * but must be paid prior to departure.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		return (DEPOSIT_SCALE * getLodgingCost()) + getFlightCosts();
	}
	
	/**
	 * Retrieves the lodging charge for this Cruise package, calculated
	 * from the base price scaled based on the cabin level according to
	 * the following fee schedule:
	 * Interior Room:     100% of base price
	 * Ocean View Room:   150% of base price
	 * Balcony Room:      300% of base price
	 * Luxury Suite:      500% of base price
	 * .
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		double lodgingCost = basePriceOut;
		
		if (cabinType == CabinType.OCEAN_VIEW)
		{
			lodgingCost *= OCEAN_VIEW_SCALE;
		}
		else if (cabinType == CabinType.BALCONY)
		{
			lodgingCost *= BALCONY_SCALE;
		}
		else if (cabinType == CabinType.SUITE)
		{
			lodgingCost *= SUITE_SCALE;
		}
		
		return lodgingCost;
	}
	
	/**
	 * Retrieves a formatted string summarizing this Cruise package. The required format
	 * for this string includes information as described by FlightOptionalPackage followed
	 * by cruise details on the next line. The second line should be prefixed with 11 blank
	 * spaces for alignment below the trip name. An example of this format is shown here:
	 * 
	 * $2499.99 Bermuda Triangle...and Maybe Back (Flight Not Included)
	 * Cruising from Miami on the Caribbean Princess
	 * 
	 * If optional excursions have been added, a parenthetical suffix will be added indicating
	 * how many excursions are included:
	 * 
	 * $2499.99  Bermuda Triangle...and Maybe Back (Flight Not Included)
	 * Cruising from Miami on Caribbean Princess (includes 4 excursions)
	 * @return The formatted string summary.
	 */
	public String toString()
	{
		return String.format("%s\n"
				+ "           Cruising from %s on the %s (includes %d excursions)",
				super.toString(), portCityOut, vesselNameOut, getNumExcursions());
	}
}

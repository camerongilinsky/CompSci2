// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class.

package triptypes;

/**
 * This class represents a RoadTrip vacation that includes a rental care,
 * overnight lodging, and fuel cost estimation.
 * @author ckgilinsky and ckennell
 *
 */
public class RoadTrip extends VacationPackage
{
	/**
	 * Amount due after deposit is paid. Always 0.
	 */
	private static final double AMOUNT_DUE = 0.0;
	
	/**
	 * The base rate of a hotel room.
	 */
	private static final double HOTEL_BASE = 35.20;
	
	/**
	 * Default cost for fuel per gallon.
	 */
	private static final double FUEL_DEFAULT = 2.50;
	
	/**
	 * Car cost for 1-2 passengers.
	 */
	private static final double TWO_OR_LESS = 36.75;
	
	/**
	 * Car cost for 3-4 passengers.
	 */
	private static final double FOUR_OR_LESS = 50.13;
	
	/**
	 * Car cost for 5-6 passengers.
	 */
	private static final double SIX_OR_LESS = 60.25;
	
	/**
	 * Car cost for 7-8 passengers.
	 */
	private static final double EIGHT_OR_LESS = 70.50;
	
	/**
	 * Car cost for 9+ passengers.
	 */
	private static final double MORE_THAN_NINE = 150.00;
	
	/**
	 * MPG for 1-2 passengers.
	 */
	private static final int MPG_TWO_OR_LESS = 45;
	
	/**
	 * MPG for 3-4 passengers.
	 */
	private static final int MPG_FOUR_OR_LESS = 32;
	
	/**
	 * MPG for 5-6 passengers.
	 */
	private static final int MPG_SIX_OR_LESS = 28;
	
	/**
	 * MPG for 7-8 passengers.
	 */
	private static final int MPG_EIGHT_OR_LESS = 22;
	
	/**
	 * MPG for 9+ passengers.
	 */
	private static final int MPG_MORE_THAN_NINE = 15;
	
	/**
	 * The cost of the rental car.
	 */
	private double fuelPPG;
	/**
	 * The rating of the hotel from a scale 1..5.
	 */
	private int stars;

	/**
	 * The number of people going on the road trip.
	 */
	private int numPersonsOut;
	/**
	 * An array of strings listing the stops along the road trip.
	 */
	private String[] stopsArr;
	/**
	 * The distance of the trip in miles.
	 */
	private int distance;
	
	/**
	 * Creates a newly initialized RoadTrip object using the
	 * parameter data.
	 * @param name The promotional name to use for this RoadTrip in
	 * the travel agency system.
	 * @param numDays The number of days required for this RoadTrip.
	 * @param stops A list of destinations that will be visited along
	 * the way on this RoadTrip.
	 * @param fuelCost The estimated cost of fuel in US dollars per gallon
	 * based on current rates.
	 * @param miles The total number of miles for this RoadTrip, assuming
	 * people follow the intended route.
	 * @param maxPersons The number of people for whom this trip package
	 * will be budgeted.
	 * @param hotelStars The quality level of the hotels used during the 
	 * RoadTrip, ranging 1..5 stars, inclusive. Star values outside this range
	 * will be adjusted to the closest valid value.
	 */
	public RoadTrip(String name, int numDays, String[] stops,
					double fuelCost, int miles, int maxPersons, int hotelStars)
	{
		super(name, numDays);
		fuelPPG = fuelCost;
		numPersonsOut = maxPersons;
		distance = miles;
		stars = hotelStars;
		stopsArr = stops;		
	}
	
	/**
	 * Retrieves the current fuel price used for cost projections.
	 * @return The fuel price in US dollars per gallon.
	 */
	public double getFuelPrice()
	{
		return fuelPPG;
	}
	
	/**
	 * Retrieves the hotel quality level attached to this RoadTrip package.
	 * @return The number of stars for hotel stays.
	 */
	public int getHotelStars()
	{
		return stars;
	}
	
	/**
	 * Provides the full price of this RoadTrip object. RoadTrip prices
	 * are computed based on the total rental car, lodging, and fuel
	 * estimated costs.
	 * @return The price of a vacation package in US dollars.
	 */
	public double getPrice()
	{
		return getCarCost() + getLodgingCost() + getEstimatedFuelCost();
	}
	
	/**
	 * Provides the required deposit amount for this RoadTrip object.
	 * The required deposit for a Road trip includes the full lodging
	 * cost plus the full rental car cost.
	 * @return The deposit amount required in US dollars.
	 */
	public double getDepositAmount()
	{
		return getCarCost() + getLodgingCost();
	}
	
	/**
	 * All RoadTrips must be fully paid in advance, with the exception
	 * of fuel costs. Fuel costs are paid to the gas station, and not the
	 * travel agent. Thus, the balance due on RoadTrips is always 0.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		return AMOUNT_DUE;
	}
	
	/**
	 * Provides the total lodging cost for a RoadTrip object. Lodging
	 * is computed based on the length of the vacation, the quality of the
	 * hotel (in stars), the number of rooms needed for the party and a base
	 * charge of $35.20 per room per night. Lodging costs assume a 
	 * maximum 2 person occupancy per room.
	 * For example, a 5 day road trip for 4 people in 2 star hotels is costed as:
	 * $35.20 base x 2 star hotels x 4 nights x 2 rooms per night --> $563.20
	 * @return The lodging subtotal in US dollars.
	 */
	public double getLodgingCost()
	{
		int numberOfRooms;
		double lodgingCost;
		if (getNumPersons() % 2 == 0)
		{
			numberOfRooms = getNumPersons() / 2;
		}
		else
		{
			numberOfRooms = (getNumPersons() / 2) + 1;
		}
		
		lodgingCost = HOTEL_BASE * getHotelStars() * (getNumDays() - 1) * numberOfRooms;
		return lodgingCost;
	}
	
	/**
	 * Provides the total cost for the rental car based on the trip duration
	 * and the size of car needed. Rental cars are billed based
	 * on full days, with no partial day rentals allowed. Further, the travel
	 * agency uses a standard daily rental car charge based on the 
	 * number of occupants riding along.
	 * $ 36.75   1-2 passengers
	 * $ 50.13   3-4 passengers
	 * $ 60.25   5-6 passengers
	 * $ 70.50   7-8 passengers
	 * $150.00    9+ passengers (since you'll need a bus)
	 * @return The total rental car cost for this trip.
	 */
	public double getCarCost()
	{
		double carCost = 0.0;
		

		
		if (numPersonsOut <= 2)
		{
			carCost = TWO_OR_LESS;
		}
		else if (numPersonsOut <= 4)
		{
			carCost = FOUR_OR_LESS;
		}
		else if (numPersonsOut <= 6)
		{
			carCost = SIX_OR_LESS;
		}
		else if (numPersonsOut <= 8)
		{
			carCost = EIGHT_OR_LESS;
		}
		else
		{
			carCost = MORE_THAN_NINE;
		}
		
		return carCost * getNumDays();
	}
	
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		int count = 0;
		
		for (int i = 0; i < stopsArr.length; i++)
		{
			if (stopsArr[i] != null)
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Updates the number of people to be used for budgeting this 
	 * RoadTrip within the travel agency.
	 * @param maxPeople The new number of people to use in calculations.
	 */
	public void setPersons(int maxPeople)
	{
		numPersonsOut = maxPeople;
	}
	
	/**
	 * Retrieves the number of people included for budget calculations
	 * by this RoadTrip.
	 * @return The number of persons.
	 */
	public int getNumPersons()
	{
		return numPersonsOut;
	}
	
	/**
	 * Updates the cost of fuel in US dollars per gallon. This value
	 * is used for projecting out costs for this RoadTrip. Prices must
	 * be positive values, and a default assumption of $2.50 per gallon will 
	 * be used if an invalid price is specified.
	 * @param pricePerGallon The new price to use for cost projections.
	 */
	public void setFuelPrice(double pricePerGallon)
	{
		if (pricePerGallon > 0)
		{
			fuelPPG = pricePerGallon;
		}
		else
		{
			fuelPPG = FUEL_DEFAULT;
		}
	}
	
	/**
	 * Provides a projection of the total fuel cost for this trip based
	 * on the total number of miles to be traveled, the fuel efficiency
	 * of the rental car, and the cost of fuel. Standard rental cars
	 * used have decreasing fuel efficiency as the size gets bigger
	 * Thus, efficiency is a function of passenger count.
	 * 45mpg   1-2 passengers
	 * 32mpg   3-4 passengers
	 * 28mpg   5-6 passengers
	 * 22mpg   7-8 passengers
	 * 15mpg    9+ passengers (buses aren't very efficient)
	 * @return The projected fuel cost in US dollars.
	 */
	public double getEstimatedFuelCost()
	{
		double mpg;
		if (numPersonsOut <= 2)
		{
			mpg = MPG_TWO_OR_LESS;
		}
		else if (numPersonsOut <= 4)
		{
			mpg = MPG_FOUR_OR_LESS;
		}
		else if (numPersonsOut <= 6)
		{
			mpg = MPG_SIX_OR_LESS;
		}
		else if (numPersonsOut <= 8)
		{
			mpg = MPG_EIGHT_OR_LESS;
		}
		else
		{
			mpg = MPG_MORE_THAN_NINE;
		}
		
		return (distance / mpg) * fuelPPG;
	}
	
	/**
	 * Retrieves the list of stops on this RoadTrip as a single string
	 * with values separated by a comma and a single space. The last
	 * stop has no punctuation after it. 
	 * @return The list of stops.
	 */
	public String getStops()
	{
		String result = "";
		for (int i = 0; i < stopsArr.length; i++)
		{
			if (i < stopsArr.length - 1)
			{
				result += stopsArr[i];
				result += ", ";
			}
			else
			{
				result += stopsArr[i];
			}
		}
		return result;
	}
	
	/**
	 * Provides a string summary of this RoadTrip. Promotional details
	 * and trip duration are provided as with all VacationPackages,
	 * followed by a summary message about the stops to be made on the 
	 * following line with each stop separated by a comma. The second
	 * line should be prefixed with 11 blank spaces for alignment below 
	 * the trip name. 
	 * @return The formatted string summary.
	 */
	public String toString()
	{
		String result = "";
		result += String.format("$%8.2f  %s\n", getPrice(), getName());
		result += String.format("           ");
		result += getStops();
		
		return result;
	}
}
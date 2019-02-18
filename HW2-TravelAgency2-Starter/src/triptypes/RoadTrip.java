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
	private static final double HOTEL_BASE = 32.50;
	/**
	 * The cost of the rental car.
	 */
	private double rentalCost;
	/**
	 * The total deposit paid. Includes lodging and cost of car.
	 */
	private double depositAmount;
	/**
	 * The expected cost of fuel for the trip.
	 */
	private double fuelCost;
	/**
	 * The price of fuel per gallon USD.
	 */
	private double fuelPPG;
	/**
	 * The rating of the hotel from a scale 1..5.
	 */
	private int stars;
	/**
	 * The cost of lodging.
	 */
	private double lodgingCost;
	/**
	 * The number of people going on the road trip.
	 */
	private int numPersons;
	/**
	 * The number of stops on the trip.
	 */
	private int numStops;
	/**
	 * The total Price of the road trip.
	 */
	private double totalPrice;
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
	 * @param fuelcost The estimated cost of fuel in US dollars per gallon
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
					double fuelcost, int miles, int maxPersons, int hotelStars)
	{
		super(name, numDays);
		setFuelPrice(fuelcost);
		setPersons(maxPersons);
		distance = miles;
		stars = hotelStars;
		stopsArr = stops;		
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
		totalPrice = getCarCost() + getLodgingCost() + getEstimatedFuelCost();
		return totalPrice;
	}
	
	/**
	 * Provides the required deposit amount for this RoadTrip object.
	 * The required deposit for a Road trip includes the full lodging
	 * cost plus the full rental car cost.
	 * @return The deposit amount required in US dollars.
	 */
	public double getDepositAmount()
	{
		depositAmount = getCarCost() + getLodgingCost();
		return depositAmount;
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
	 * @return The lodging subtotal in US dollars.
	 */
	public double getLodgingCost()
	{
		lodgingCost = HOTEL_BASE * stars * super.getNumDays() * (numPersons / 2);
		return lodgingCost;
	}
	
	/**
	 * Provides the total cost for the rental car based on the trip duration
	 * and the size of car needed. Rental cars are billed based
	 * on full days, with no partial day rentals allowed. Further, the travel
	 * agency uses a standard daily rental car charge based on the 
	 * number of occupants riding along.
	 * @return The total rental car cost for this trip.
	 */
	public double getCarCost()
	{
		//double rentalCost;
		if (numPersons < 9)
		{
			if (numPersons >= 7)
			{
				rentalCost = 70.50;
			}
			else if (numPersons >= 5)
			{
				rentalCost = 60.25;
			}
			else if (numPersons >= 3)
			{
				rentalCost = 50.13;
			}
			else
			{
				rentalCost = 36.25;
			}
		}
		else
		{
			rentalCost = 150.00;
		}
		return rentalCost;
	}
	
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		return stopsArr.length;
	}
	
	/**
	 * Updates the number of people to be used for budgeting this 
	 * RoadTrip within the travel agency.
	 * @param maxPeople The new number of people to use in calculations.
	 */
	public void setPersons(int maxPeople)
	{
		numPersons = maxPeople;
	}
	
	/**
	 * Retrieves the number of people included for budget calculations
	 * by this RoadTrip.
	 * @return The number of persons.
	 */
	public int getNumPersons()
	{
		return numPersons;
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
		if (!(pricePerGallon < 0))
		{
			fuelPPG = pricePerGallon;
		}
		else
		{
			fuelPPG = 2.50;
		}
	}
	
	/**
	 * Provides a projection of the total fuel cost for this trip based
	 * on the total number of miles to be traveled, the fuel efficiency
	 * of the rental car, and the cost of fuel. Standard rental cars
	 * used have decreasing fuel efficiency as the size gets bigger
	 * Thus, efficiency is a function of passenger count.
	 * @return The projected fuel cost in US dollars.
	 */
	public double getEstimatedFuelCost()
	{
		int mpg;
		if (numPersons < 9)
		{
			if (numPersons >= 7)
			{
				mpg = 22;
			}
			else if (numPersons >= 5)
			{
				mpg = 28;
			}
			else if (numPersons >= 3)
			{
				mpg = 32;
			}
			else
			{
				mpg = 45;
			}
		}
		else
		{
			mpg = 15;
		}
		
		fuelCost = (distance / mpg) * fuelPPG;
		return fuelCost;
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
		result += String.format("$%9.2f %s\n", getPrice(), getName());
		result += String.format("           ");
		result += getStops();
		
		return result;
	}
}
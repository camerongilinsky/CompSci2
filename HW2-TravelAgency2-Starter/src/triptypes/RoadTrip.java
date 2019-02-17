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
 */
public class RoadTrip extends VacationPackage
{
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
	}
	
	/**
	 * Retrieves the hotel quality level attached to this RoadTrip package.
	 * @return The number of stars for hotel stays.
	 */
	public int getHotelStars()
	{
		return 0;
	}
	
	/**
	 * Provides the full price of this RoadTrip object. RoadTrip prices
	 * are computed based on the total rental car, lodging, and fuel
	 * estimated costs.
	 * @return The price of a vacation package in US dollars.
	 */
	public double getPrice()
	{
		return 0.0;
	}
	
	/**
	 * Provides the required deposit amount for this RoadTrip object.
	 * The required deposit for a Road trip includes the full lodging
	 * cost plus the full rental car cost.
	 * @return The deposit amount required in US dollars.
	 */
	public double getDepositAmount()
	{
		return 0.0;
	}
	
	/**
	 * All RoadTrips must be fully paid in advance, with the exception
	 * of fuel costs. Fuel costs are paid to the gas station, and no the
	 * travel agent. Thus, the balance due on RoadTrips is always 0.
	 * @return The remaining balance to pay the travel angency.
	 */
	public double getAmountDue()
	{
		return 0.0;
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
		return 0.0;
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
		return 0.0;
	}
	
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		return 0;
	}
	
	/**
	 * Updates the number of people to be used for budgeting this 
	 * RoadTrip within the travel agency.
	 * @param maxPeople The new number of people to use in calculations.
	 */
	public void setPersons(int maxPeople)
	{
		
	}
	
	/**
	 * Retrieves the number of people included for budget claculations
	 * by this RoadTrip.
	 * @return The number of persons.
	 */
	public int getNumPersons()
	{
		return 0;
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
		return 0.0;
	}
	
	/**
	 * Retrieves the list of stops on this RoadTrip as a single string
	 * with values separated by a comma and a single space. The last
	 * stop has no punctuation after it. 
	 * @return The list of stops.
	 */
	public String getStops()
	{
		return "";
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
		return "";
	}
}
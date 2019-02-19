// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class.

package triptypes;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * This class represents a single flight within the travel agency system.
 * @author ckgilinsky and ckennell
 */
public class Flight 
{
	/**
	 * Code of airline.
	 */
	private String airlineOut;
	
	/**
	 * Flight number for Flight.
	 */
	private int flightNumOut;
	
	/**
	 * Airport code of departure city.
	 */
	private String fromOut;
	
	/**
	 * Airport code of the arrival city.
	 */
	private String toOut;
	
	/**
	 * Day and time of departure.
	 */
	private Calendar leavesAtOut;
	
	/**
	 * Day and time of arrival.
	 */
	private Calendar arrivesOut;
	
	/**
	 * Price of the Flight.
	 */
	private double priceOut;
	
	/**
	 * Creates a new flight leg in the system.
	 * @param airline The Two letter airline code.
	 * @param flightNum The unique flight number on a given day.
	 * @param from The three letter airport code for the departure airport.
	 * @param to The three letter airport code for the arrival airport.
	 * @param leavesAt The departure time.
	 * @param arrives The arrival time.
	 * @param price The price for this flight in US dollars.
	 */
	public Flight(String airline, int flightNum, String from, String to,
				Calendar leavesAt, Calendar arrives, double price)
	{
		airlineOut = airline;
		flightNumOut = flightNum;
		fromOut = from;
		toOut = to;
		leavesAtOut = leavesAt;
		arrivesOut = arrives;
		priceOut = price;
	}
	
	/**
	 * Getter method for arrival day and time.
	 * @return Arrival day and time.
	 */
	public Calendar getArrives()
	{
		return arrivesOut;
	}
	
	/**
	 * Getter method for departure day and time.
	 * @return Departure day and time.
	 */
	public Calendar getLeavesAt()
	{
		return leavesAtOut;
	}
	
	/**
	 * Getter method for arrival airport code.
	 * @return Arrival airport code.
	 */
	public String getTo()
	{
		return toOut;
	}
	
	/**
	 * Getter method for departure airport code.
	 * @return Departure airport code.
	 */
	public String getFrom()
	{
		return fromOut;
	}
	
	/**
	 * Getter method for flight number.
	 * @return Flight number.
	 */
	public int getFlightNum()
	{
		return flightNumOut;
	}
	
	/**
	 * Getter method for airline code.
	 * @return Airline code.
	 */
	public String getAirline()
	{
		return airlineOut;
	}
	
	/**
	 * Retrieves the price of this flight.
	 * @return The price in US dollars.
	 */
	public double getPrice()
	{
		return priceOut;
	}
	
	/**
	 * Retrieves a formatted string summarizing this Flight. Strings will
	 * be formatted as: XX#### Departs: AIR at HH:mm MM-dd-YYYY; Arrives POR at HH:mm MM-dd-YYYY
	 * Where XX is the two letter airline abbreviation and #### is the flight number, which may be
	 * 1-4 digits in length and is right aligned in a 4 character wide field. AIR and POR are the
	 * departure and arrival airport codes, respectively.The HH:mm MM-dd-YYYY values correspond to the
	 * departure and arrival time formats using a 24-hour
	 * clock. (see, e.g., java.util.SimpleDateFormat). For example:
	 * 
	 * DL 123 Departs: OMA at 15:25 03-15-2019; Arrives ATL at 18:01 03-15-2019
	 * 
	 * @return The formatted string summary for the flight.
	 */
	public String toString()
	{
		leavesAtOut.add(Calendar.MONTH, 1);
		arrivesOut.add(Calendar.MONTH, 1);
		
		SimpleDateFormat departing = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		SimpleDateFormat arriving = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		return String.format("%s%4d Departs: %s at %s; Arrives %s at %s", airlineOut, flightNumOut, fromOut,
				departing.format(leavesAtOut.getTime()), arriving.format(arrivesOut.getTime()),
				toOut);
	}
}
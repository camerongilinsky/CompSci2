package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import triptypes.RoadTrip;

public class RoadTripTests
{
	private static final double DOUBLE_TOLERANCE = 0.001;

	/**
	 * This test verifies the behavior of the default constructor within
	 * the RoadTrip class. Getters are used to check the values set by the 
	 * constructor.
	 */
	@Test
	public void testRoadTripConstructor()
	{
		//Set up the prior state (don't need for constructor)
		//Call the method being tested
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 5, 5);
		
		//Verify the post-state of the object
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(5, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Verify the return (don't need for constructor)
		
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 1 person.
	 */
	@Test
	public void testRoadTripGetPrice1Person()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(1, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 2 people.
	 */
	@Test
	public void testRoadTripGetPrice2People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 2, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(2, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 3 people.
	 */
	@Test
	public void testRoadTripGetPrice3People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 3, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(3, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 4 people.
	 */
	@Test
	public void testRoadTripGetPrice4People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 4, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(4, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 5 people.
	 */
	@Test
	public void testRoadTripGetPrice5People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 5, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(5, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 6 people.
	 */
	@Test
	public void testRoadTripGetPrice6People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 6, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(6, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 7 people.
	 */
	@Test
	public void testRoadTripGetPrice7People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 7, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(7, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 8 people.
	 */
	@Test
	public void testRoadTripGetPrice8People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 8, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(8, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method test the getPrice() method for the RoadTrip class.
	 * The method should return the total price for the RoadTrip, ie. 
	 * getCarCost() + getLodgingCost() + getEstimatedFuelCost(). This
	 * value is based upon values set up by the constructor. Checked for 
	 * 9 people.
	 */
	@Test
	public void testRoadTripGetPrice9People()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 9, 5);
		
		//Call the method to test
		double total = a.getPrice();
		
		//Check the post-state
		assertEquals("Road Trip", a.getName());
		assertEquals("Atlanta, Omaha", a.getStops());
		assertEquals(5, a.getNumDays());
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(9, a.getNumPersons());
		assertEquals(5, a.getHotelStars());
		
		//Check the return
		assertEquals(a.getPrice(), total, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method will test the Amount Due for a RaodTrip object.
	 * It should always return 0.0.
	 */
	@Test
	public void testRoadTripGetAmountDue()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
		
		//Call the method to test
		double amount = a.getAmountDue();
		
		//Check the return
		assertEquals(0.0, amount, DOUBLE_TOLERANCE);
	}
	
	/**
	 * This method will test the getNumStops() method to see if it returns
	 * the appropriate integer value of the number of stops for a RoadTrip.
	 * If the stop is not null in the array of stops it will count as a stop.
	 */
	@Test
	public void testGetNumStopsValid()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
		
		//Call the method to test
		int count = a.getNumStops();
		
		//Check the return
		assertEquals(2, count);
	}
	
	/**
	 * This method will look to test the getNumStops() method when there are 
	 * no entries into the stops array and it is null at all indices.
	 */
	@Test
	public void testGetNumStopsInvalid()
	{
		//Set up the prior state
		String[] stops = new String[2];
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
		
		//Call the method to test
		int count = a.getNumStops();
		
		//Check the return
		assertEquals(0, count);
	}
	
	/**
	 * This method will test the setPersons() method. The parameter taken
	 * is an integer value with no limitations.
	 */
	@Test
	public void testSetPersons()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
		
		//Call the method to test
		a.setPersons(15);
		
		//Check the post state
		assertEquals(15, a.getNumPersons());
	}
	
	/**
	 * This Test will check the method setFuelPrice to see if the price per
	 * gallon for fuel is changed when using a positive value. If it is not
	 * a value greater than 0, the default of 2.50 should be used.
	 */
	@Test
	public void testSetFuelPriceValid()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
		
		//Call the method to test
		a.setFuelPrice(1.99);
		
		//Check the post state
		assertEquals(1.99, a.getFuelPrice(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This Test will check to see if the fuel price per gallon default of 
	 * 2.50 is used when an invalid value (0 or less) is used to set the value.
	 */
	@Test
	public void testSetFuelPriceInvalid()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
				
		//Call the method to test
		a.setFuelPrice(0);
				
		//Check the post state
		assertEquals(2.50, a.getFuelPrice(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testgetDepositAmount()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
				
		//Call the method to test
				
		//Check the post state
		assertEquals(887.75, a.getDepositAmount(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test will look for the appropriate return of the toString()
	 * method for the RoadTrip class. The 
	 */
	@Test
	public void testRoadTripToString()
	{
		//Set up the prior state
		String[] stops = new String[2];
		stops[0] = "Atlanta";
		stops[1] = "Omaha";
		RoadTrip a = new RoadTrip("Road Trip", 5, stops, 2.50, 10, 1, 5);
				
		//Call the method to test
				
		//Check the post state
		assertEquals("$  888.31  Road Trip\n"
				+ "           Atlanta, Omaha", a.toString());
	}
}

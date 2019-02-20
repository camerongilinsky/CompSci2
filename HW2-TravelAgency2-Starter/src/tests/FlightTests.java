package tests;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import triptypes.Flight;

public class FlightTests
{
	
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * This test verifies the behavior of the default constructor when 
	 * provided valid parameter values.  Getters are also exercised to
	 * verify that the object has been set up correctly.
	 */
	@Test
	public void testFlightConstructor()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
			
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		SimpleDateFormat clean = new SimpleDateFormat("HH:mm MM-dd-YYYY");

		Flight a = new Flight("Delta", 777, "OMA", "PDX", departs, arrives, 750.99);
			
		//Verify the post-state of the object
		assertEquals("Delta", a.getAirline());
		assertEquals(777, a.getFlightNum());
		assertEquals("OMA", a.getFrom());
		assertEquals("PDX", a.getTo());
		assertEquals(departs, a.getLeavesAt());
		assertEquals(arrives, a.getArrives());
		assertEquals(750.99, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testFlightToStringThree()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
			
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);

		Flight a = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 750.99);
		System.out.println(a);	
		//Verify the post-state of the object
		assertEquals("DL 777 Departs: OMA at 15:30 04-19-2019; Arrives PDX at 18:30 04-19-2019", a.toString());
	}
	
	@Test
	public void testFlightToStringFour()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 1, 19, 15, 30);
			
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 1, 19, 18, 30);

		Flight a = new Flight("DL", 7777, "OMA", "PDX", departs, arrives, 750.99);
		System.out.println(a);
		//Verify the post-state of the object
		assertEquals("DL7777 Departs: OMA at 15:30 02-19-2019; Arrives PDX at 18:30 02-19-2019", a.toString());
		
	}
}

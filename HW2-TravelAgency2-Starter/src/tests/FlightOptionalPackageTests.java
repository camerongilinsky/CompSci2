package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Calendar;

import org.junit.Test;

import triptypes.AllInclusiveResort;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;

public class FlightOptionalPackageTests
{
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	@Test
	public void testFlightOptionalPackageConstructor()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 250, amenities);
		
		//Verify the post-state of the object
		assertEquals("Getaway Vacation", a.getName());
		assertEquals(7, a.getNumDays());
		assertEquals("Sandals", ((AllInclusiveResort) a).getResort());
		assertEquals(2, ((AllInclusiveResort) a).getGuestsPerRoom());
		assertEquals(250, ((AllInclusiveResort) a).getPricePerNight(), DOUBLE_TOLERANCE);
		assertEquals("Ocean View, Hot Tub", ((AllInclusiveResort) a).getAmenities());
	}
	
	@Test
	public void testAddFlighttoAllInclusiveResort()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 250, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		Flight b = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 750.99);
		Flight c = new Flight("AA", 88, "OMA", "ABQ", departs, arrives, 450.89);
		a.addFlightLeg(b);
		a.addFlightLeg(c);
		
		assertTrue(a.hasFlights());
	}
	
	@Test
	public void testFullAddFlighttoAllInclusiveResort()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 250, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		Flight b = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 750.99);
		Flight c = new Flight("AA", 88, "OMA", "ABQ", departs, arrives, 450.89);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		a.addFlightLeg(b);
		
		Flight[] temp = new Flight[12];
		temp = a.getFlightItinerary();
		
		assertEquals(b, temp[0]);
	}
	
	@Test
	public void testHasFlights()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 250, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);

		
		Flight[] temp = new Flight[12];
		temp = a.getFlightItinerary();
		
		assertFalse(a.hasFlights());
	}
	
	@Test
	public void testGetFlightCosts()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 250, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);

		Flight b = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 500);
		Flight c = new Flight("AA", 88, "OMA", "ABQ", departs, arrives, 450);
		
		a.addFlightLeg(b);
		a.addFlightLeg(c);
		
		assertEquals(950, a.getFlightCosts(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testFlightOptionalPackageToString()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);

		Flight b = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 200);
		Flight c = new Flight("AA", 88, "OMA", "ABQ", departs, arrives, 300);
		
		//a.addFlightLeg(b);
		//a.addFlightLeg(c);
		
		assertEquals("$  600.00  Getaway Vacation (Flight Not Included)\n"
				+ "           An all-inclusive stay at Sandals for 2 people!", a.toString());
	}
	/*
	@Test
	public void testFlightOptionalPackageFlightItinerary()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 250, amenities);
		
		//Verify the post-state of the object
			Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		Flight[] temp = new Flight[25];
		Flight b = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 1000);
		Flight c = new Flight("DL", 888, "OMA", "ABQ", departs, arrives, 750);
		temp[0] = b;
		temp[1] = c;
		
		a.addFlightLeg(b);
		a.addFlightLeg(c);
		
		assertEquals(temp, a.getFlightItinerary());
	}
	*/
	
}

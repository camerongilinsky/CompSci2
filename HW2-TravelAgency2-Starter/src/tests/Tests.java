package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import triptypes.*;
import travelgui.VacationPackageCollection;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Tests
{
	
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * This test verifies the behavior of the default constructor when 
	 * provided valid parameter values.  Getters are also exercised to
	 * verify that the object has been set up correctly.
	 */
	@Test
	public void testAllInclusiveResortConstructor()
	{
		//STEP 1: Setup prior state of the object
		//Since we're testing a constructor here, this step is not applicable.
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		//STEP 2: Call the method being tested
		AllInclusiveResort a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 250, amenities);
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Getaway Vacation", a.getName());
		assertEquals(7, a.getNumDays());
		assertEquals("Sandals", a.getResort());
		assertEquals(2, a.getGuestsPerRoom());
		assertEquals(250, a.getPricePerNight(), DOUBLE_TOLERANCE);
		assertEquals("Ocean View, Hot Tub", a.getAmenities());
		
		// When comparing double or float values, assertEquals takes a 
		// third parameter that specifies how close the two values need to
		// be to be considered equal.
		
		//STEP 4: Verify the return value of the method called
		//For constructors, verifying the "post-state" in step 3 and the return 
		//value are synonymous.  There's nothing more to do here.
	}
	
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
	public void testFlightToString()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);

		Flight a = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 750.99);
		
		//Verify the post-state of the object
		assertEquals("DL 777 Departs: OMA at 15:30 04-19-2019; Arrives 18:30 04-19-2019 at PDX", a.toString());
		System.out.println(a.toString());
	}
	
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
		assertEquals("Ocean View, Hot Tub, ", ((AllInclusiveResort) a).getAmenities());
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
	public void testCheckPriceAllInclusiveResort()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		Flight b = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 1000);
		a.addFlightLeg(b);
		
		assertEquals(1000, a.getFlightCosts(), DOUBLE_TOLERANCE);
		assertEquals(1700, a.getPrice(), DOUBLE_TOLERANCE);
		assertEquals(1350, a.getDepositAmount(), DOUBLE_TOLERANCE);
		assertEquals(700, a.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testAllInclusiveResortToString()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		FlightOptionalPackage a = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		Flight b = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 1000);
		a.addFlightLeg(b);
		
		assertEquals("$ 1700.00  Getaway Vacation! (Flight Included)\n"
				+ "           An all-inclusive stay at Sandals for 2 people!", a.toString());
	}
	
	
	
	@Test
	public void testVacationPackageCollectionConstructor()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		
		//assertEmpty(a.getAllVacations(), null);
		assertEquals(0, a.getNumTrips());
	}
	
	@Test
	public void testVacationPackageCollectionAdd()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		VacationPackageCollection a = new VacationPackageCollection();
		
		VacationPackage b = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		
		a.addVacation(b);
		
		assertEquals(1, a.getNumTrips());
	}
	
	@Test
	public void testVacationPackageCollectionDisplay()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		VacationPackageCollection a = new VacationPackageCollection();
		
		VacationPackage b = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		
		VacationPackage[] c = new VacationPackage[25];
		a.addVacation(b);
		c[0] = b;
		
		assertEquals(c[0], a.getItemAt(0));
	}
	
	
	@Test
	public void testVacationPackageCollectionPrint()
	{
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		VacationPackageCollection a = new VacationPackageCollection();
		
		VacationPackage b = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		Flight d = new Flight("DL", 777, "OMA", "PDX", departs, arrives, 1000);
		((FlightOptionalPackage) b).addFlightLeg(d);
		
		VacationPackage[] c = new VacationPackage[25];
		a.addVacation(b);
		
		assertEquals("DL 777 Departs: OMA at 15:30 04-19-2019; Arrives 18:30 04-19-2019 at PDX", a.getFlightDetails(0));


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
	/*
	@Test
	public void testvacationPackageFilter()
	{
		
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		String[] stops = new String[2];
		stops[0] = "Omaha";
		stops[1] = "Lincoln";
		
		VacationPackageCollection a = new VacationPackageCollection();
		
		VacationPackage b = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		VacationPackage c = new RoadTrip("Hotel California", 7, stops, 60.50, 55, 5, 3);
		a.addVacation(b);
		a.addVacation(c);
		
		VacationPackage[] d = new VacationPackage[25];
		
		d = a.filterVacationsFor(1);
		
		//assertEquals(b, a.getItemAt(0));
		//assertEquals(null, d.getItemAt(1));
	}
	*/
	@Test
	public void testVacationPackageSort()
	{
		
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		String[] stops = new String[2];
		stops[0] = "Omaha";
		stops[1] = "Lincoln";
		
		VacationPackageCollection a = new VacationPackageCollection();
		VacationPackage b = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 10000, amenities);
		VacationPackage c = new RoadTrip("Hotel California", 7, stops, 60, 55, 5, 3);
		a.addVacation(b);
		a.addVacation(c);
		
		//a.sortCollection(true);
		
		//assertEquals(70000, b.getPrice(), DOUBLE_TOLERANCE);
		//assertEquals(420, c.getPrice(), DOUBLE_TOLERANCE);
		
		//assertEquals(c, a.getItemAt(0));
		//assertEquals(b, a.getItemAt(1));
		
	}
	
}

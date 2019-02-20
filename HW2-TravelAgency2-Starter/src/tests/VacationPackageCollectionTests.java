package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import travelgui.VacationPackageCollection;
import triptypes.AllInclusiveResort;
import triptypes.Cruise;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;
import triptypes.RoadTrip;
import triptypes.VacationPackage;

public class VacationPackageCollectionTests
{
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
		
		assertEquals("DL 777 Departs: OMA at 15:30 05-19-2019; Arrives PDX at 18:30 05-19-2019", 
					a.getFlightDetails(0));

	}
	
	@Test
	public void testAddVacation()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		
		String[] amenities = new String[2];
		amenities[0] = "Ocean View";
		amenities[1] = "Hot Tub";
		
		VacationPackage b = new AllInclusiveResort("Getaway Vacation", 7, "Sandals", 2, 100, amenities);
		
		assertEquals(0, a.getNumTrips());
		
		
	}
	
	@Test
	public void testGetFlightDetailsNoFlights()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		String[] stops = new String[1];
		VacationPackage b = new RoadTrip("Road Trip", 1, stops, 1.00, 10, 1, 5);
		
		a.addVacation(b);
		String flightdeets = a.getFlightDetails(0);
		
		assertTrue(flightdeets.equals("ERROR: No flights are allowed for this type of trip!"));
		
	}
	
	@Test
	public void testGetFlightDetailsIndexOutOfRange()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		String[] stops = new String[1];
		VacationPackage b = new RoadTrip("Road Trip", 1, stops, 1.00, 10, 1, 5);
		
		a.addVacation(b);
		String flightdeets = a.getFlightDetails(13);
		
		assertTrue(flightdeets.equals("ERROR: Index is out of range!"));
		
		
		
	}
	
	@Test
	public void testGetFlightDetailsIndexOutOfRangeLow()
	{
		VacationPackageCollection a = new VacationPackageCollection();
		String[] stops = new String[1];
		VacationPackage b = new RoadTrip("Road Trip", 1, stops, 1.00, 10, 1, 5);
		
		a.addVacation(b);
		String flightdeets = a.getFlightDetails(-1);
		
		assertTrue(flightdeets.equals("ERROR: Index is out of range!"));
		
}
}

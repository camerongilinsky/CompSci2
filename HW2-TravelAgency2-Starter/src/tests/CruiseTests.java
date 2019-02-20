package tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import travelgui.VacationPackageCollection;
import triptypes.AllInclusiveResort;
import triptypes.CabinType;
import triptypes.Cruise;
import triptypes.VacationPackage;

public class CruiseTests
{
	
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	@Test
	public void testCruiseConstructor()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		assertEquals("Tom Cruise", a.getName());
		assertEquals(5, a.getNumDays());
		assertEquals("Big Boat", ((Cruise) a).getVesselName());
		assertEquals("Omaha", ((Cruise) a).getHomePort());
		assertEquals(departs, ((Cruise) a).getDepartureDate());
		assertEquals(arrives, ((Cruise) a).getReturnDate());
		assertEquals(500, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);

	}
	
	@Test
	public void testCruiseAddExcursion()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).addExcursion("Fun Stuff", 100);
		
		String[] temp = new String[1];
		temp = ((Cruise) a).getExcursions();
		
		assertEquals(temp[0], "Fun Stuff");

	}
	
	@Test
	public void testCruiseAddBlankExcursion()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).addExcursion("", 100);
		
		String[] temp = new String[1];
		temp = ((Cruise) a).getExcursions();
		
		assertEquals(temp[0], null);

	}
	
	@Test
	public void testCruiseAddNegativePrice()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).addExcursion("Fun Stuff", -1);
		
		assertEquals(((Cruise) a).getExcursionCosts(), 0, DOUBLE_TOLERANCE);

	}
	
	@Test
	public void testCruiseNullExcursions()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).addExcursion("Fun Stuff", 10);
		((Cruise) a).addExcursion("More Stuff", 25);
		String[] temp = new String[2];
		temp = ((Cruise) a).getExcursions();
		
		assertEquals(temp[1], "More Stuff");

	}
	
	@Test
	public void testCruiseMaxExcursions()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).addExcursion("Fun Stuff", 10);
		((Cruise) a).addExcursion("More Stuff", 25);
		((Cruise) a).addExcursion("Fun Stuff", 10);
		((Cruise) a).addExcursion("More Stuff", 25);
		((Cruise) a).addExcursion("Fun Stuff", 10);
		((Cruise) a).addExcursion("More Stuff", 25);
		((Cruise) a).addExcursion("Fun Stuff", 10);
		((Cruise) a).addExcursion("More Stuff", 25);
		((Cruise) a).addExcursion("Fun Stuff", 10);
		((Cruise) a).addExcursion("More Stuff", 25);
		((Cruise) a).addExcursion("Fun Stuff", 10);
		((Cruise) a).addExcursion("More Stuff", 25);
		String[] temp = new String[10];
		temp = ((Cruise) a).getExcursions();
		
		assertEquals(temp[1], "More Stuff");

	}
	
	@Test
	public void testCruiseSetCabinType()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).setCabinType(CabinType.SUITE);
		
		assertEquals(CabinType.SUITE, ((Cruise) a).getCabinType());

	}
	
	@Test
	public void testCruisGetNumberExcursion()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).addExcursion("Fun Stuff", 100);
		((Cruise) a).addExcursion("Fun Stuff", 100);
		
		String[] temp = new String[2];
		temp = ((Cruise) a).getExcursions();
		
		assertEquals(2, ((Cruise) a).getNumExcursions());

	}
	
	@Test
	public void testCruisGetPrice()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 500);
		
		((Cruise) a).addExcursion("Fun Stuff", 100);
		((Cruise) a).addExcursion("Fun Stuff", 100);
		
		assertEquals(700, ((Cruise) a).getPrice(), DOUBLE_TOLERANCE);
		assertEquals(250, ((Cruise) a).getDepositAmount(), DOUBLE_TOLERANCE);

	}
	
	@Test
	public void testCruiseCabinTypeOceanView()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 100);
		
		((Cruise) a).setCabinType(CabinType.OCEAN_VIEW);
		
		assertEquals(150, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);

	}
	
	@Test
	public void testCruiseCabinTypeBalcony()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 100);
		
		((Cruise) a).setCabinType(CabinType.BALCONY);
		
		assertEquals(300, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);

	}
	
	@Test
	public void testCruiseCabinTypeSuite()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 100);
		
		((Cruise) a).setCabinType(CabinType.SUITE);
		
		assertEquals(500, ((Cruise) a).getLodgingCost(), DOUBLE_TOLERANCE);

	}
	
	@Test
	public void testCruiseToString()
	{
		Calendar departs = Calendar.getInstance();
		departs.set(2019, 3, 19, 15, 30);
		
		Calendar arrives = Calendar.getInstance();
		arrives.set(2019, 3, 19, 18, 30);
		
		VacationPackage a = new Cruise("Tom Cruise", 5, "Big Boat", "Omaha", departs, arrives, 100);
		
		((Cruise) a).setCabinType(CabinType.SUITE);
		
		assertEquals("$  500.00  Tom Cruise (Flight Not Included)\n"
				+ "           Cruising from Omaha on the Big Boat (includes 0 excursions)", ((Cruise) a).toString());

	}
	

}

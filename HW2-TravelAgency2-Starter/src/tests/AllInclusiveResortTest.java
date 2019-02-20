package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import triptypes.*;
import travelgui.VacationPackageCollection;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class AllInclusiveResortTest
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
		assertEquals(1600, a.getPrice(), DOUBLE_TOLERANCE);
		assertEquals(1300, a.getDepositAmount(), DOUBLE_TOLERANCE);
		assertEquals(600, a.getLodgingCost(), DOUBLE_TOLERANCE);
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
		
		assertEquals("$ 1600.00  Getaway Vacation (Flight Included)\n"
				+ "           An all-inclusive stay at Sandals for 2 people!", a.toString());
	}
}
package tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import travelgui.VacationPackageCollection;
import triptypes.AllInclusiveResort;
import triptypes.Flight;
import triptypes.FlightOptionalPackage;
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
		
		assertEquals("DL 777 Departs: OMA at 15:30 05-19-2019; Arrives 18:30 05-19-2019 at PDX", a.getFlightDetails(0));

	}
}

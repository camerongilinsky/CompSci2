package tests;

import org.junit.Test;

import travelgui.VacationPackageCollection;
import triptypes.AllInclusiveResort;
import triptypes.RoadTrip;
import triptypes.VacationPackage;

public class VacationPackageTests
{
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
}

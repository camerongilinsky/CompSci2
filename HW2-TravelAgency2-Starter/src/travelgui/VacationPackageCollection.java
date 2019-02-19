// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the students and instructors for this class.

package travelgui;

import triptypes.Flight;
import triptypes.FlightOptionalPackage;
import triptypes.RoadTrip;
import triptypes.VacationPackage;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**
 * This class serves as a collection to store, filter, and explore VacationPackages
 * within the trip search user interface. Up to 25 VacationPackages can be 
 * stored in a single collection.
 * @author ckgilinsky and ckennell
 */
public class VacationPackageCollection 
{
	/**
	 * The maximum number of VacationPackage that can be stored in a single collection.
	 */
	private static final int MAX_PACKAGES = 25;

	private int numTrips;
	
	private VacationPackage[] vpc; //

	//private List<VacationPackage> vacationPackageCollection;
	
	
	
	/**
	 * Creates a new empty VacationPackageCollection.
	 */
	public VacationPackageCollection()
	{
		vpc = new VacationPackage[MAX_PACKAGES];
		numTrips = 0;
		//vacationPackageCollection = new ArrayList<>();
	}
	
	/**
	 * Retrieves the number of trip packages that have been
	 * added to this collection for purchase.
	 * @return The total number of available packages.
	 */
	public int getNumTrips()
	{
		return numTrips;
		//return vacationPackageCollection.size();
	}
	
	/**
	 * Retrieves an array of all available packages from the
	 * collection. Valid packages are guaranteed to be stored
	 * contiguously in the left most array cells. Any empty cells
	 * will appear to the right of the last valid VacationPackage. 
	 * Unless a sort has occurred, packages will appear in the
	 * order in which they were added.
	 * @return The list of available packages.
	 */
	public triptypes.VacationPackage[] getAllVacations()
	{
		return vpc;
		//VacationPackage[] toArray = new VacationPackage[vacationPackageCollection.size()];
		//toArray = vacationPackageCollection.toArray(toArray);
		//return toArray;
	}
	
	/**
	 * Adds a single trip package to the collection at the next
	 * available position. If adding this trip would result in more
	 * than 25 total packages, it will not be added to the collection.
	 * @param trip The trip to add to the collection.
	 */
	public void addVacation(triptypes.VacationPackage trip)
	{
		for (int i = 0; i < vpc.length; i++)
		{
			if (vpc[i] == null)
			{
				vpc[i] = trip;
				numTrips++;
				break;
			}
		}
		
		
	//	if (vacationPackageCollection.size() < MAX_PACKAGES)
	//	{
	//		vacationPackageCollection.add(trip);
	//	}
	}
	
	/**
	 * Retrieves a filtered subcollection of trips corresponding to a specific
	 * subtype. Should no trips of a specified type be present in this VacationPackageCollection
	 * an empty collection containing zero packages will be returned.
	 * @param selection An integer signaling what type of packages to extract. 1 represents RoadTrips,
	 * 2 represents Cruises, and 3 represents All-Inclusive Resort packages.
	 * @return An integer signaling what type of packages to extract. 1 represents RoadTrips,
	 * 2 represents Cruises, and 3 represents All-Inclusive Resort packages.
	 */
	public VacationPackageCollection filterVacationsFor(int selection)
	{
		VacationPackageCollection temp = new VacationPackageCollection();
		
		int count = 0;

		if (selection == 1)
		{
			for (int i = 0; i < vpc.length; i++)
			{
				if ( vpc[i] instanceof triptypes.RoadTrip)
				{
					temp.addVacation(vpc[i]);
				}
			}
		}
		else if (selection == 2)
		{
			for (int i = 0; i < vpc.length; i++)
			{
				if (vpc[i] instanceof triptypes.Cruise)
				{
					temp.addVacation(vpc[i]);
				}
			}
		}
		else if (selection == 3)
		{
			for (int i = 0; i < vpc.length; i++)
			{
				if (vpc[i] instanceof triptypes.AllInclusiveResort)
				{
					temp.addVacation(vpc[i]);
				}
			}
		}
		
		return temp;
		
		/*
		List<VacationPackage> temp = new ArrayList<>();
		
		for (int i = 0; i < vacationPackageCollection.size(); i++)
		{
			if (vacationPackageCollection.get(i) instanceof triptypes.RoadTrip)
			{
				temp.add(vacationPackageCollection.get(i));
			}
		}
		
		return (VacationPackageCollection) temp;
		*/
	}
	
	/**
	 * Produces a summary of flight information inside a VacationPackage
	 * for detail display elsewhere. In addition to properly extracting flight
	 * details when the given index corresponds to a FlightOptionalPackage with one or
	 * more flight legs, this method will also detect various error conditions. In
	 * erroneous situations, one of the following strings will be produced: 
	 * 
	 * ERROR: Index is out of range!
	 * ERROR: No flights are allowed for this type of trip!
	 * ERROR: The selected trip has no flight information.
	 * 
	 * Each of these errors corresponds to invalid range input, packages for which flights
	 * cannot be added in the first place, and packages which potentially could (but do not yet)have flight data.
	 * @param index The index position in the collection from which to extract flight information.
	 * @return The formatted flight details, with one Flight per line and each Flight displayed as
	 * detailed in Flight.toString.
	 */
	public String getFlightDetails(int index)
	{
		if (index < 0 || index > 12)
		{
			return String.format("ERROR: Index is out of range!");
		}
		else if (vpc[index] instanceof RoadTrip)
		{
			return String.format("ERROR: No flights are allowed for this type of trip!");
		}
		else if (((FlightOptionalPackage) vpc[index]).hasFlights())
		{
			Flight[] temp = new Flight[12];
			temp = ((FlightOptionalPackage) vpc[index]).getFlightItinerary();
			String[] allFlights = new String[12];
			String output = "";
			
			for (int i = 0; i < 12; i++)
			{
				if (temp[i] != null)
				{
					allFlights[i] = temp[i].toString();
				}
			}
			
			for (int j = 0; j < 12; j++)
			{
				if (allFlights[j] != null && allFlights[j + 1] != null)
				{
					output += String.format(allFlights[j] + "\n");
				}
				else if (allFlights[j] != null && allFlights[j + 1] == null)
				{
					output += String.format(allFlights[j]);
				}
			}
			
			return output;
		}
		else
		{
			return String.format("ERROR: The selected trip has no flight information.");
		}
	}
	
	/**
	 * Provides 0-based indexed access to the VacationPackageCollection.
	 * @param index The index position whose VacationPackage should be returned.
	 * @return The selected VacationPackage when index is valid. The method will return null otherwise.
	 */
	public triptypes.VacationPackage getItemAt(int index)
	{
		return vpc[index];
	}
	
	/**
	 * Produces a stable sort of the contents of this VacationPackageCollection,
	 * with the sort order determined by an externally specified criteria. When
	 * byPrice is true, the method will sort all available packages in ascending
	 * order by total package price. When false, the method sorts packages in
	 * standard lexicographically ascending order by package name(see,
	 * https://en.wikipedia.org/wiki/Lexicographical_order).
	 * @param byPrice A flag which sets the sort criteria as described above.
	 */
	public void sortCollection(boolean byPrice)
	{
	/*	VacationPackage insert;
		 
		if (byPrice)
		{
			for (int next = 1; next < vpc.length; next++)
			{
				insert = vpc[next];
				int moveItem = next;
				
				while (moveItem > 0 && vpc[moveItem - 1].getPrice() > insert.getPrice())
				{
					if (vpc[moveItem] != null && vpc[moveItem - 1] != null)
					{
						vpc[moveItem] = vpc[moveItem - 1];
						moveItem--;
					}
				}
				vpc[moveItem] = insert;
			}
		}*/
		/*
		if (byPrice)
		{
			int hold;
			for (int i = 0; i < vpc.length - 1; i++)
			{
				hold = i;
				
				for (int index = i + 1; index < vpc.length - 1; index++)
				{
					String temp1 = vpc[index].getName();
					String temp2 = vpc[hold].getName();
					
					if (temp1.compareTo(temp2) < 0)
					{
						hold = index;
					}
				}
				
				VacationPackage temp = vpc[i];
				vpc[i] = vpc[i + 1];
				vpc[i + 1] = temp;
			}
		}*/

		
		if (byPrice)
		{
			
			for (int pass = 0; pass < MAX_PACKAGES; pass++)
			{
				for (int comp = 0; comp < MAX_PACKAGES; comp++)
				{	

					 
					if (vpc[comp] != null
						&& vpc[comp + 1] != null
						&& vpc[comp].getPrice() > vpc[comp + 1].getPrice())
					{
						
						VacationPackage temp = (VacationPackage) vpc[comp];
						vpc[comp] = vpc[comp + 1];
						vpc[comp + 1] = temp;
					}
				}
			}

			
		}
		else
		{

			for (int pass = 0; pass < MAX_PACKAGES - 1; pass++)
			{
				for (int comp = 0; comp < MAX_PACKAGES - 1; comp++)
				{
					if (vpc[comp] != null
							&& vpc[comp + 1] != null
							&& (vpc[comp].getName()).compareTo(vpc[comp + 1].getName()) > 0)
					{
						VacationPackage temp = vpc[comp];
						vpc[comp] = vpc[comp + 1];
						vpc[comp + 1] = temp;
					}
				}
			}
			
		}
		/*if (byPrice)
		{
			
			
			System.out.println(vpc[0].getPrice());
			System.out.println(vpc[1].getPrice());
		}*/
	}
}
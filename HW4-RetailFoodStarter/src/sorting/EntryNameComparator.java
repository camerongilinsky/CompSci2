package sorting;
import java.util.Comparator;

import schedules.RetailFoodEntry;
import schedules.Risk;

/**
 * A Comparator for the Name element of a RetailFoodEntry.
 * @author Derek Babb
 *
 */
public class EntryNameComparator implements Comparator<RetailFoodEntry>
{
	/**
	 * Comparison method will take in two RetailFoodEntry objects and compare the
	 * Name of each of them.  Names are ordered based on their standard
	 * lexicographic ordering.
	 * 
	 * @param a The first RetailFoodEntry
	 * @param b The second RetailFoodEntry
	 * @return a negative integer, zero, or a positive integer as the first argument is less
	 *  than, equal to, or greater than the second.
	 */
	public int compare(RetailFoodEntry a, RetailFoodEntry b)
	{
		return a.getName().compareTo(b.getName());
	}
}
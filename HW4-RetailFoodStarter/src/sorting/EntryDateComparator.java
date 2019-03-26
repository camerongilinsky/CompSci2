package sorting;

import java.util.Comparator;

import schedules.RetailFoodEntry;

public class EntryDateComparator implements Comparator<RetailFoodEntry>
{
	/**
	 * Comparison method will take in two RetailFoodEntry objects and compare the
	 * Date of each of them.  Dates are ordered using a standard tiered ordering of 
	 * dates (year, month, day).
	 * 
	 * @param a The first RetailFoodEntry
	 * @param b The second RetailFoodEntry
	 * @return a negative integer, zero, or a positive integer as the first argument is less
	 *  than, equal to, or greater than the second.
	 */
	public int compare(RetailFoodEntry a, RetailFoodEntry b)
	{
		return a.getDate().compareTo(b.getDate());
	}
}

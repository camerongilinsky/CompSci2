// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package sorting;

import java.util.Comparator;

import schedules.RetailFoodEntry;

/**
 * Compares two RetailFoodEntry dates.
 * @author ckgilinsky and ckennell
 */
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
		{
			if (a != null && b != null)
			{
				return a.getDate().compareTo(b.getDate());
			}
			else
			{
				return 0; //uhhhhhhhhh not sure
			}
		}
	}
}

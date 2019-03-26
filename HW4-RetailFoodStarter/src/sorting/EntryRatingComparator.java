// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package sorting;

import schedules.RetailFoodEntry;

/**
 * Comparator class for RetailFoodEntry ratings.
 * @author ckgilinsky and ckennell
 */
public class EntryRatingComparator
{
	/**
	 * Comparison method will take in two RetailFoodEntry objects and compare the
	 * Rating of each of them. Dates are ordered as follows:
	 * SUPERIOR > EXCELLENT > STANDARD > POOR
	 * @param a The first RetailFoodEntry
	 * @param b The second RetailFoodEntry
	 * @return a negative integer, zero, or a positive integer as the first argument is less
	 * than, equal to, or greater than the second.
	 */
	public int compare(RetailFoodEntry a, RetailFoodEntry b)
	{
		return a.getRating().compareTo(b.getRating());
	}
}

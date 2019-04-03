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
 * Comparator class for RetailFoodEntry ratings.
 * @author ckgilinsky and ckennell
 */
public class EntryRatingComparator implements Comparator<RetailFoodEntry>
{
	/**
	 * Comparison method will take in two RetailFoodEntry objects and compare the
	 * Rating of each of them. Dates are ordered as follows:
	 * SUPERIOR > EXCELLENT > STANDARD > FAIR
	 * @param a The first RetailFoodEntry
	 * @param b The second RetailFoodEntry
	 * @return a negative integer, zero, or a positive integer as the first argument is less
	 * than, equal to, or greater than the second.
	 */
	public int compare(RetailFoodEntry a, RetailFoodEntry b)
	{
		int ret = 0;
		//System.out.println(a);
		//System.out.println(b);
		if (a != null && b != null)
		{
			if (a.getRating().toString().equals(b.getRating().toString()))
			{
				ret = 0;
			}
			else if (a.getRating().toString().equals("SUPERIOR"))
			{
				ret = -1;
			}
			else if (a.getRating().toString().equals("EXCELLENT")
					&& (b.getRating().toString().equals("STANDARD")
					|| b.getRating().toString().equals("FAIR")))
			{
				ret = -1;
			}
			else if (a.getRating().toString().equals("STANDARD")
					&& b.getRating().toString().equals("FAIR"))
			{
				ret = -1;
			}
			else
			{
				ret = 1;
			}
		}
		else
		{
			ret = -1;
		}
		
		return ret;
	}
}
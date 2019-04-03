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
 * Class to compare RetailFoodEntry objects based on risk.
 * @author ckgilinsky and ckennell
 */
public class EntryRiskComparator implements Comparator<RetailFoodEntry>
{
	/**
	 * Comparison method will take in two RetailFoodEntry objects and compare the
	 * Risk of each of them. Risk values are ordered as follows:
	 * HIGH > MEDIUM > LOW
	 * @param a The first RetailFoodEntry
	 * @param b The second RetailFoodEntry
	 * @return a negative integer, zero, or a positive integer as the first argument is less
	 * than, equal to, or greater than the second.
	 */
	public int compare(RetailFoodEntry a, RetailFoodEntry b)
	{
		int ret = 0;
		if (a != null && b != null)
		{
			if (a.getRisk().toString().equals(b.getRisk().toString()))
			{
				ret = 0;
			}
			else if (a.getRisk().toString().equals("HIGH"))
			{
				ret = -1;
			}
			else if (a.getRisk().toString().equals("MEDIUM")
					&& b.getRisk().toString().equals("LOW"))
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
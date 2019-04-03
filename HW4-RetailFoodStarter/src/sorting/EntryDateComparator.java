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
		int ret = 0;
		
		//System.out.println(a);
		//System.out.println(b);
		
		if (a != null && b != null)
		{
		
			if (a.getDate().getYear() == b.getDate().getYear())
			{
				if (a.getDate().getMonth() == b.getDate().getMonth())
				{
					if (a.getDate().getDay() == b.getDate().getDay())
					{
						ret = 0;
					}
					else if (a.getDate().getDay() > b.getDate().getDay())
					{
						ret = 1;
					}
					else
					{
						return -1;
					}
				}
				else if (a.getDate().getMonth() > b.getDate().getMonth())
				{
					ret = 1;
				}
				else
				{
					ret = -1;
				}
			}
			else if (a.getDate().getYear() > b.getDate().getYear())
			{
				ret = 1;
			}
			else
			{
				ret = -1;
			}
			
		}
		else
		{
			return -1;
		}
		return ret;
	}
}

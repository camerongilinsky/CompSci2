// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import schedules.RetailFoodEntry;

/**
 * This utility class provides a basic sorting method that enables
 * a broad range of comparisons.
 * @author ckgilinsky and ckennell
 */
public class SortData
{
	/**Generic method to sort a list of objects based on a comparator.
	 * The ordering for the sorted list will be determined by comparator.
	 * @param list the type of a single item in the list
	 * @param comparator the type of the comparator to use for sorting items of type E
	 * @param <E> the generic type
	 * @param <T> the generic type
	 */
	public static <E, T extends Comparator<E>> void sort(E[] list, T comparator)
	{
		 //insertion sort algorithm below; this needs to somehow sort based on the T input
		 //The comparator does the comparison between the two objects and returns 
		 //a value related to order.
		
		RetailFoodEntry temp;
		RetailFoodEntry insert; // temporary variable to hold element to insert
		
		// loop over data.length - 1 elements
		for (int next = 1; next < list.length; next++) 
		{ 
			insert = (RetailFoodEntry) list[ next ]; // store value in current element
			int moveItem = next; // initialize location to place element
		   
			// shift items in the sorted part of the array to make room for next element
			// making sure we don't step off the front of the array
			while (moveItem > 0 && comparator.compare(list[moveItem - 1], (E)insert) < 0)
				//((RetailFoodEntry) list[ moveItem - 1 ]).compareTo(insert) < 0) 
			{           
				//SWAP pasted here to avoid method invocation overhead in timing data
				//swap(data, moveItem, moveItem - 1); // shift element right one slot
				temp = (RetailFoodEntry) list[moveItem];
				list[moveItem] = list[moveItem - 1];
				list[moveItem - 1] = (E)temp;		
				
				moveItem--;
			} 
		   
			list[ moveItem ] = (E)insert; // place inserted element
		}
		
		
		
		/*public void insertionSortRange(RetailFoodEntry[] data)
		{
			RetailFoodEntry insert; // temporary variable to hold element to insert
			
			// loop over data.length - 1 elements
			for (int next = 0; next <= data.length - 1; next++)
			{ 
				insert = data[ next ]; // store value in current element
				int moveItem = next; // initialize location to place element
			   
				// shift items in the sorted part of the array to make room for next element
				// making sure we don't step off the front of the array
				while (moveItem > 0 && insert.compare(insert.getName(), data[ moveItem - 1 ]) > 0)
				{           
					data[ moveItem ] = data[ moveItem - 1 ]; // shift element right one slot
					moveItem--;
				} 
			   
				data[ moveItem ] = insert; // place inserted element
			}*/
		}

	
}
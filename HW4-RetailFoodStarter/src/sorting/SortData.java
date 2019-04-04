// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.
//             Insertion sort algorithm referenced from Lab 8 code by Dr. Dorn.

package sorting;

import java.util.Comparator;

/**
 * This utility class provides a basic sorting method that enables
 * a broad range of comparisons.
 * @author ckgilinsky and ckennell
 */
public class SortData
{
	/**
	 * Blank constructor.
	 */
	public SortData()
	{
		//Blank constructor for testing purposes.
	}
	
	/**Generic method to sort a list of objects based on a comparator.
	 * The ordering for the sorted list will be determined by comparator.
	 * @param list the type of a single item in the list
	 * @param comparator the type of the comparator to use for sorting items of type E
	 * @param <E> the generic type
	 * @param <T> the generic type
	 */
	public static <E, T extends Comparator<E>> void sort(E[] list, T comparator)
	{	
		E temp;
		E insert;
		
		for (int next = 1; next < list.length; next++) 
		{ 
			insert = list[ next ];
			int moveItem = next;
		   
			while (moveItem > 0 && comparator.compare(list[moveItem - 1], insert) > 0)

			{           
				temp = list[moveItem];
				list[moveItem] = list[moveItem - 1];
				list[moveItem - 1] = temp;		
				
				moveItem--;
			} 
		   
			list[ moveItem ] = insert;
		}	
	}
}
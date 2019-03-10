
package datautils;

/**
 * This class provides generic implementations of multiple sorting
 * algorithms.
 * 
 * @author 
 */
public class Sorting //implements Comparable<Sorting>
{
	///////////////////////////////////////////////
	//  STEP 1 -- Make sorting methods generic
	///////////////////////////////////////////////
	
	/**
	 * Re-orders the contents given array using the insertion sort algorithm.
	 * 
	 * @param data The array to be sorted.
	 */
	//TODO: Make me generic to work on any kind of Comparable data!
	public static <E extends Comparable<E>> void insertionSort(E[] data)
	{
		E insert; // temporary variable to hold element to insert
		
		// loop over data.length - 1 elements
		for (int next = 0; next < data.length; next++)
		{ 
			insert = data[ next ]; // store value in current element
			int moveItem = next; // initialize location to place element
		   
			// shift items in the sorted part of the array to make room for next element
			// making sure we don't step off the front of the array
			while (moveItem > 0 && data[ moveItem - 1 ].compareTo(insert) > 0)
			{           
				data[ moveItem ] = data[ moveItem - 1 ]; // shift element right one slot
				moveItem--;
			} 
		   
			data[ moveItem ] = insert; // place inserted element
		}
	}
	
	/**
	 * Sorts passed data using Merge Sort by modifying the input array. 
	 * 
	 * @param data The data to be sorted.
	 */
	//TODO: Make me generic to work on any kind of Comparable data!
	public static void mergeSort(int[] data)
	{
		mergeSortHelper(data, 0, data.length - 1);
	}
	
	/**
	 * Recursive helper method for mergeSort.
	 * @param data The data in which the sub-array is located
	 * @param left Lower index of the sub-array.
	 * @param right Upper index of the sub-array.
	 */
	//TODO: Make me generic to work on any kind of Comparable data!
	private static void mergeSortHelper(int[] data, int left, int right)
	{
		//General Case: The sublist has at least one item in it.
		if ((right - left) >= 1)	
		{
			int middle1 = (left + right) / 2;
			int middle2 = middle1 + 1;
			
			mergeSortHelper(data, left, middle1);
			mergeSortHelper(data, middle2, right);

			merge(data, left, middle1, middle2, right);
		}
	}
	
	/**
	 * Helper method for merge sort. Merges two sub-arrays into sorted order.
	 * 
	 * @param data The data in which the sub-arrays are located
	 * @param left Lower index of first sub-array.
	 * @param middle1 Upper index of first sub-array.
	 * @param middle2 Lower index of second sub-array.
	 * @param right Upper index of second sub-array.
	 */
	//TODO: Make me generic to work on any kind of Comparable data!
	private static void merge(int[] data, int left, int middle1, int middle2, int right)
	{
		int leftIndex = left;					// Local variables for tracking left and right
		int rightIndex = middle2;				// while merging.
		
		int[] combined = new int[data.length];	// A temporary place where we can store our merged results 
		
		int combinedIndex = left;		        //The position we are at filling up combined
		                                
		// As long as both subarray pieces have data still in them, 
		// we need to keep picking the next smallest from the start
		// of each and putting it into combined
		while (leftIndex <= middle1 && rightIndex <= right)
		{
			// Is the first item of the left subarray smaller?
			if (data[leftIndex] <= data[rightIndex])
			{
				combined[combinedIndex++] = data[leftIndex++];
			}
			// Or is the first item in the right one smaller?
			else 
			{
				combined[combinedIndex++] = data[rightIndex++];
			}
		}

		// If the left sub-array has run out of values, we need
		// to go through emptying the remainder from the right
		if (leftIndex == middle2)
		{
			while (rightIndex <= right)
			{
				combined[combinedIndex++] = data[rightIndex++];
			}
		}
		// Otherwise, check whether the right one is empty and 
		// grab any remaining values from the left sub-array
		else
		{
			while (leftIndex <= middle1)
			{
				combined[combinedIndex++] = data[leftIndex++];
			}
		}
			
		// Lastly, copy the merged array values back into the 
		// original input array so it will be sorted after
		// returning from merge.
		for (int i = left; i <= right; i++)
		{
			data[i] = combined[i];
		}		
	}
	/*
	@Override
	public int compareTo(Sorting other) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
	///////////////////////////////////////////////////////
	// STEP 2  - Refactor Insertion Sort
	//
	//TODO: Write the helper method described below and then 
	// simplify insertionSort to eliminate duplicate code
	///////////////////////////////////////////////////////
	
	/**
	 * insertionSortRange is a generic method that allows for
	 * sorting a sub-range of Comparable array values using the 
	 * insertion sort algorithm.  
	 * 
	 * Ranges are specified with the parameters left and right, 
	 * which are inclusive.
	 * 
	 * @param data  The array of data to sort
	 * @param left  The index of the left-most position to sort
	 * @param right The index of the right most position to sort
	 */
	//TODO: Write the method header and body for insertionSortRange here

	
	//////////////////////////////////////////////////////
	// STEP 3 - Complete TimSort
	//////////////////////////////////////////////////////
	
	/**
	 * timSort is a generic sorting method that sorts an array of Comparable
	 * data using the TimSort algorithm.  Make sure this method is public so
	 * that we can test it.
	 * 
	 * @param data  The array of data to be sorted
	 */
	//TODO: Write the method header for timSort here.  Just uncomment the body, do not edit it.
	/*
	{
		timSortHelper(data, 0, data.length - 1);
	}
	*/
	
	
	/**
	 * timSortHelper is a generic sorting method that sorts a sub-array array of Comparable
	 * data using the TimSort algorithm.  This method should be public for testing purposes
	 * but would normally be private.
	 * 
	 * Ranges are specified with the parameters left and right, 
	 * which are inclusive.
	 * 
	 * @param data  The array of data to sort
	 * @param left  The index of the left-most position to sort
	 * @param right The index of the right most position to sort
	 */
	//TODO: Now write the header and body of the timSortHelper method as described
	//      for the algorithm.
	
	
	
}


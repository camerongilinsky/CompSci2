package datautils.test;

import java.util.Random;

import datautils.Sorting;

/**
 * This test driver is provided to help partially verify components of your
 * sorting algorithms and v
 * @author bdorn
 *
 */
public class SortingDriver
{
	public static void main(String[] args)
	{
		/*
		// STEP 1 Check Correctness of Generics
		 
		System.out.println("\nSTEP 1");
		Integer[] data = generateIntegerArray(20, 0);  // Random 20 numbers
		Sorting.insertionSort(data);
		System.out.print("  INSERTION SORTED: ");
		printArray(data);
		
		
		String[] words = generateStringArray();
		Sorting.insertionSort(words);
		System.out.print("  INSERTION SORTED: ");
		printArray(words);		
		
		data = generateIntegerArray(20, 0);  // Random 20 numbers
		Sorting.mergeSort(data);
		System.out.print("  MERGE SORTED: ");
		printArray(data);	
		words = generateStringArray();
		Sorting.mergeSort(words);
		System.out.print("  MERGE SORTED: ");
		printArray(words);	
		
		// END STEP 1 CHECKS
		*/
		
		
		/*
		// STEP 2 Use to help check insertionSortRange
		 
		System.out.println("\nSTEP 2");
		data = generateIntegerArray(20, 0);  // Random 20 numbers
		Sorting.insertionSortRange(data, 5, 15);
		System.out.print("  INDEXES SORTED 5-15: ");
		printArray(data);
		
		// END STEP 2 CHECKS
		*/
		
		/*
		// STEP 3 Use to help check TimSort
		 
		System.out.println("\nSTEP 3");
		data = generateIntegerArray(20, 0);  // Random 20 numbers
		Sorting.timSort(data);
		System.out.print("  TIM SORTED: ");
		printArray(data);
		
		words = generateStringArray();
		Sorting.timSort(words);
		System.out.print("  TIM SORTED: ");
		printArray(words);
		
		// END STEP 3 
		*/ 
		
		/*
		//STEP 4 Conduct Timing Experiments, use this code to compare and constrast their performance
		//       In what situations do they do relatively better/worse/same as each other?
		  
		//IMPORTANT: DON'T FORGET TO UNCOMMENT THE RUNEXPERIMENT METHOD BODY TOO!!!
		 
		System.out.println("\nSTEP 4");
		runExperiment("Tiny Array (n=20), Random Values", generateIntegerArray(20, 0));
		runExperiment("Small Array (n=1000), Random Values", generateIntegerArray(1000, 0));
		runExperiment("Large Array (n=100K), Random Values", generateIntegerArray(100000, 0));
		
		runExperiment("Tiny Array (n=20), Ascending Values", generateIntegerArray(20, 1));
		runExperiment("Small Array (n=1000), Ascending Values", generateIntegerArray(1000, 1));
		runExperiment("Large Array (n=100K), Ascending Values", generateIntegerArray(100000, 1));
		
		runExperiment("Tiny Array (n=20), Reversed Values", generateIntegerArray(20, 2));
		runExperiment("Small Array (n=1000), Reversed Values", generateIntegerArray(1000, 2));
		runExperiment("Large Array (n=100K), Reversed Values", generateIntegerArray(100000, 2));
		*/
	}
	
	
	/**
	 * A helper method that conducts a timing run of each sorting algorithm on a copy of the 
	 * input data.
	 * @param msg A descriptive name for this experiment to be printed to the screen along 
	 * 			  with timing results.
	 * @param array The values to use for this experiment.
	 */
	/*
	private static <E extends Comparable<E>> void runExperiment(String msg, Integer[] array)
	{
		System.out.println("  EXPERIMENT: " + msg);
		
		//Create 3 separate copies of this array so that the algorithms don't interfere with each
		//other
		Integer[] copy1 = copyArray(array);
		Integer[] copy2 = copyArray(array);
		Integer[] copy3 = copyArray(array);
		
		// Run Insertion Sort
		long start = System.nanoTime();
		Sorting.insertionSort(copy1);		
		long end = System.nanoTime();
		System.out.println("    INSERTION SORT: " + (end - start) + " nanoseconds");
		
		// Run Merge Sort
		start = System.nanoTime();
		Sorting.mergeSort(copy2);
		end = System.nanoTime();
		System.out.println("        MERGE SORT: " + (end - start) + " nanoseconds");
		
		// Run Tim Sort
		start = System.nanoTime();
		Sorting.timSort(copy3);
		end = System.nanoTime();
		System.out.println("          TIM SORT: " + (end - start) + " nanoseconds\n");
	}
	*/
	
	/**
	 * Generates an array of values for testing purposes.
	 * 
	 * @param size the number of elements in the returned array
	 * @param shape an integer value to signify what kind of data
	 *              to generate.  0 = random, 1 = ascending, 2 = descending
	 *              
	 * @return the array that was created per the parameters
	 */
	private static Integer[] generateIntegerArray(int size, int shape)
	{
		Integer[] result = new Integer[size];
		Random nums = new Random();
		for (int i = 0; i < size; i++)
		{
			switch (shape)
			{
				case 0:
					result[i] = nums.nextInt(1000);
					break;
				case 1:
					result[i] = i;
					break;
				case 2: 
					result[i] = size - i;
					break;
				default:
					throw new RuntimeException("Invalid shape parameter value!");
			}
		}
		return result;
	}
	
	/**
	 * Utility method to print an array to the console.
	 * 
	 * @param data The data to be displayed
	 */
	private static <E> void printArray(E[] data)
	{
		System.out.print("{");
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i]);
			if (i < data.length - 1)
			{
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	
	/**
	 * Utility method to get a list of mixed up strings each time.
	 * Gauranteed to be a different array object each call.
	 * 
	 * @return A static list of strings.
	 */
	private static String[] generateStringArray()
	{
		String[] words = {"a", "an", "the", "this", "UNO", "COFFEE!", "pizza", 
			"ice cream", "CHOCOLATE"};		
		return words;
	}
	
	/**
	 * Utility method to copy an array.
	 * @param data The array to be copied
	 * @return A shallow copy of the items in the array specified.
	 */
	private static Integer[] copyArray(Integer[] data)
	{
		Integer[] result = new Integer[data.length];	
		for (int i = 0; i < data.length; i++)
		{
			result[i] = data[i];
		}
		return result;
	}
}

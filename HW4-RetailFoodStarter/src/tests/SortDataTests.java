// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.



package tests;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import schedules.RetailFoodEntry;
import sorting.EntryDateComparator;
import sorting.EntryNameComparator;
import sorting.EntryRatingComparator;
import sorting.EntryRiskComparator;
import sorting.SortData;

public class SortDataTests 
{

private RetailFoodEntry a = new RetailFoodEntry("1912","6201 MAPLE ST","EXCELLENT","07/20/2018","HIGH");
private RetailFoodEntry b = new RetailFoodEntry("1000 Degrees Neapolitan Pizzeria","17676 WELCH PLZ STE 9","EXCELLENT","10/25/2018","MEDIUM");
private RetailFoodEntry c = new RetailFoodEntry("13TH STREET BRICKHOUSE","2202 S 13TH ST","FAIR","1/3/2018","LOW");
	

	@Test
	public void blankConstructor()
	{
		SortData temp = new SortData();
	}

	@Test
	public void SortTestByName() 
	{
		//Set up the prior state
		RetailFoodEntry[] temp = new RetailFoodEntry[3]; //Unsorted array
		temp[0] = c;
		temp[1] = b;
		temp[2] = a;
		/*RetailFoodEntry[] temp2 = new RetailFoodEntry[3]; //Sorted array
		temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		*/
		
		//Call the method
		SortData.sort(temp, new EntryNameComparator());
		
		//Check the return
		//Come back to this 
	}
	
	@Test
	public void SortTestByDate() 
	{
		//Set up the prior state
		RetailFoodEntry[] temp = new RetailFoodEntry[3]; //Unsorted array
		temp[0] = c;
		temp[1] = b;
		temp[2] = a;
		/*RetailFoodEntry[] temp2 = new RetailFoodEntry[3]; //Sorted array
		temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		*/
		
		//Call the method
		SortData.sort(temp, new EntryDateComparator());
		
		//Check the return
		//Come back to this 
	}
	
	@Test
	public void SortTestByRating() 
	{
		//Set up the prior state
		RetailFoodEntry[] temp = new RetailFoodEntry[3]; //Unsorted array
		temp[0] = c;
		temp[1] = b;
		temp[2] = a;
		/*RetailFoodEntry[] temp2 = new RetailFoodEntry[3]; //Sorted array
		temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		*/
		
		//Call the method
		SortData.sort(temp, new EntryRatingComparator());
		
		//Check the return
		//Come back to this 
	}
	
	@Test
	public void SortTestByRisk() 
	{
		//Set up the prior state
		RetailFoodEntry[] temp = new RetailFoodEntry[3]; //Unsorted array
		temp[0] = c;
		temp[1] = b;
		temp[2] = a;
		/*RetailFoodEntry[] temp2 = new RetailFoodEntry[3]; //Sorted array
		temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		*/
		
		//Call the method
		SortData.sort(temp, new EntryRiskComparator());
		
		//Check the return
		//Come back to this 
	}

}
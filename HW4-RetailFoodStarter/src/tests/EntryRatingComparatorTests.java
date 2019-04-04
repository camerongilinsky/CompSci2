package tests;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import schedules.RetailFoodEntry;
import sorting.EntryRatingComparator;

public class EntryRatingComparatorTests 
{

	
	private RetailFoodEntry a = new RetailFoodEntry("1912","6201 MAPLE ST","EXCELLENT","07/20/2018","HIGH");
	private RetailFoodEntry b = null;
	private RetailFoodEntry c = new RetailFoodEntry("13TH STREET BRICKHOUSE","2202 S 13TH ST","FAIR","1/3/2018","LOW");
	private RetailFoodEntry d = new RetailFoodEntry("1912","6201 MAPLE ST","EXCELLENT","07/20/2018","HIGH");
	private RetailFoodEntry e = null;
	private RetailFoodEntry superior = new RetailFoodEntry("5 GUYS BURGER & FRIES","7345 DODGE ST","SUPERIOR","2/26/2018","MEDIUM");
	private RetailFoodEntry standard = new RetailFoodEntry("5 GUYS BURGER & FRIES","7345 DODGE ST","STANDARD","2/26/2018","MEDIUM");
	private RetailFoodEntry fair = new RetailFoodEntry("5 GUYS BURGER & FRIES","7345 DODGE ST","FAIR","2/26/2018","MEDIUM");

	
	@Test
	public void RatingComparatorTestLess() 
	{
		//Set up the prior state
		EntryRatingComparator temp = new EntryRatingComparator();
		
		//Call the method
		int x = temp.compare(a, c);
		
		//Check the return
		assertEquals(x, -1);
	}
	
	@Test
	public void RatingComparatorTestEqual() 
	{
		//Set up the prior state
		EntryRatingComparator temp = new EntryRatingComparator();
		
		//Call the method
		int x = temp.compare(a, d);
		
		//Check the return
		assertEquals(x, 0);
	}
	
	@Test
	public void RatingComparatorTestGreater() 
	{
		//Set up the prior state
		EntryRatingComparator temp = new EntryRatingComparator();
		
		//Call the method
		int x = temp.compare(c, a);
		
		//Check the return
		assertEquals(x, 1);
	}
	
	@Test
	public void RatingComparatorTestNull() 
	{
		//Set up the prior state
		EntryRatingComparator temp = new EntryRatingComparator();
		
		//Call the method
		int x = temp.compare(e, b);
		
		//Check the return
		assertEquals(x, -1);
	}
	
	@Test
	public void RatingComparatorTestSuperior() 
	{
		//Set up the prior state
		EntryRatingComparator temp = new EntryRatingComparator();
		
		//Call the method
		int x = temp.compare(superior, a);
		
		//Check the return
		assertEquals(x, -1);
	}
	
	@Test
	public void RatingComparatorTestStandard() 
	{
		//Set up the prior state
		EntryRatingComparator temp = new EntryRatingComparator();
		
		//Call the method
		int x = temp.compare(d, standard);
		
		//Check the return
		assertEquals(x, -1);
	}

	
	@Test
	public void RatingComparatorTestFair() 
	{
		//Set up the prior state
		EntryRatingComparator temp = new EntryRatingComparator();
		
		//Call the method
		int x = temp.compare(standard, fair);
		
		//Check the return
		assertEquals(x, -1);
	}
}
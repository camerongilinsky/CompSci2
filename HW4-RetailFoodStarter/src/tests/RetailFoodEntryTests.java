// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.


package tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import schedules.InvalidDateException;
import schedules.Rating;
import schedules.RetailFoodEntry;

public class RetailFoodEntryTests {

	@Test
	public void RetailFoodEntryConstructorTest() 
	{
		//Set up the prior State/Call the constructor to make an object
		RetailFoodEntry a = new RetailFoodEntry("1912", "6201 MAPLE ST", "EXCELLENT", "7/20/2018", "HIGH");
		//Rating x;
		assertEquals("1912", a.getName());
		assertEquals("6201 MAPLE ST", a.getAddress());
		assertEquals("EXCELLENT", a.getRating().toString());
		assertEquals("7/20/2018", a.getDate().toString());
		assertEquals("HIGH", a.getRisk().toString());
	}
	
	@Test 
	public void RetailFoodEntryCompareToTest()
	{
		//Set up the prior state
		RetailFoodEntry a = new RetailFoodEntry("1912", "6201 MAPLE ST", "EXCELLENT", "7/20/2018", "HIGH");
		RetailFoodEntry b = new RetailFoodEntry("1912", "6201 MAPLE ST", "EXCELLENT", "7/20/2018", "HIGH");
		
		//Call the method in question
		int x = a.compareTo(b);
		
		//Verify the return value
		assertEquals(0, x);
	}
	
	@Test
	public void RetailFoodEntryToStringTest()
	{
		//Set up the prior state
		RetailFoodEntry a = new RetailFoodEntry("1912", "6201 MAPLE ST", "EXCELLENT", "7/20/2018", "HIGH");
		
		//Call the method
		String x = a.toString();
		
		//Check the return
		assertEquals("1912,6201 MAPLE ST,EXCELLENT,7/20/2018,HIGH", x);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void RetailFoodEntryConstructorExceptionTest() throws IllegalArgumentException, InvalidDateException
	{
		thrown.expect(IllegalArgumentException.class);
		tossed.expect(InvalidDateException.class);
		
		//Throws the exception
		RetailFoodEntry a = new RetailFoodEntry("1912", "6201 MAPLE ST", "Bad", "7/20/2018", "HIGH");
	}
	
	@Rule
	public ExpectedException tossed = ExpectedException.none();
	
	@Test
	public void RetailFoodEntryConstructorExceptionTest2() throws InvalidDateException
	{
		tossed.expect(InvalidDateException.class);
		
		//Throws the exceptions
		RetailFoodEntry a = new RetailFoodEntry("1912", "6201 MAPLE ST", "EXCELLENT", null, "HIGH");
	}

}
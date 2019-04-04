// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.


package tests;

import static org.junit.Assert.*;

import org.junit.Rule;

//import java.util.Date;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import schedules.Date;
import schedules.InvalidDateException;
import schedules.RetailFoodEntry;

public class DateTests {

	@Test
	public void setDateTest() 
	{
		//Prior State
		Date a = new Date("1/03/1992");
		
		//Date c = new Date("");
		
		//Call method
		//a.setDate("11/21/1992");
		
		//Check the post state
		assertEquals(1, a.getMonth());
		assertEquals(3, a.getDay());
		assertEquals(1992, a.getYear());
		//assertEquals("", b.toString());
		//assertEquals("", c.toString());
		assertEquals("01/03/1992", a.toString());
		
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	@Test
	public void RetailFoodEntryConstructorExceptionTest() throws InvalidDateException
	{
		thrown.expect(InvalidDateException.class);
		//tossed.expect(InvalidDateException.class);
		
		//Throws the exception
		Date b = new Date(null);
	}
	
	@Rule
	public ExpectedException thrown1 = ExpectedException.none();

	
	@Test
	public void RetailFoodEntryConstructorExceptionTest2() throws InvalidDateException
	{
		thrown.expect(InvalidDateException.class);
		//tossed.expect(InvalidDateException.class);
		
		//Throws the exception
		Date c = new Date("");
	}
	
	@Test
	public void dateToStringTest()
	{
		//Prior State
		Date a = new Date("11/20/1992");
		
		//Call method
		String x = a.toString();
		
		//Check return
		assertEquals("11/20/1992", x);
	}
	
	@Test
	public void dateCompareToTest()
	{
		//Prior State
		Date a = new Date("11/20/1992");
		Date b = new Date("4/19/1993");
		Date c = new Date("4/20/1992");
		Date d = new Date("11/19/1992");
		
		//Call the method
		int x = a.compareTo(b);
		int y = b.compareTo(a);
		int z = a.compareTo(a);
		int month1 = a.compareTo(c);
		int month2 = c.compareTo(a);
		int day1 = a.compareTo(d);
		int day2 = d.compareTo(a);
		
		//Check the return
		assertEquals(-1, x);
		assertEquals(1, y);
		assertEquals(0, z);
		assertEquals(1, month1);
		assertEquals(-1, month2);
		assertEquals(1, day1);
		assertEquals(-1, day2);
	}
	
	
}
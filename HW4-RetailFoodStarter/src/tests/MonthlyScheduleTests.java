package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import schedules.MonthlySchedule;
import schedules.Date;
import schedules.MonthlySchedule;
import schedules.RetailFoodEntry;

public class MonthlyScheduleTests 
{

	private RetailFoodEntry a = new RetailFoodEntry("1912","6201 MAPLE ST","EXCELLENT","07/20/2018","HIGH");
	private RetailFoodEntry b = new RetailFoodEntry("1000 Degrees Neapolitan Pizzeria","17676 WELCH PLZ STE 9","EXCELLENT","10/25/2018","MEDIUM");
	private RetailFoodEntry c = new RetailFoodEntry("13TH STREET BRICKHOUSE","2202 S 13TH ST","FAIR","1/3/2018","LOW");

	@Test
	public void test() 
	{
		//Set up prior state
		RetailFoodEntry[] temp = {a, b, c}; //Unsorted array
		/*temp[0] = a;
		temp[1] = b;
		temp[2] = c;
		temp[3] = a;
		temp[4] = b;
		temp[5] = c;
		temp[6] = a;
		temp[7] = b;
		temp[8] = c;
		temp[9] = a;
		temp[10] = b;*/
		
		/*for (int i = 0; i < 200; i++ )
		{
			temp[i] = a;
		}*/
		
		
		Date date = new Date("1/3/2018");
		MonthlySchedule x = new MonthlySchedule();
		
		//Call the method
		x.processData(temp, date);
	}
	
	/*@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void writeScheduleTestException1() throws FileNotFoundException
	{
		thrown.expect(FileNotFoundException.class);
		String fileIn = "In";
		MonthlySchedule x = new MonthlySchedule();
		
		x.processData();
	}*/
	
	
	@Test
	public void writeScheduleTest()
	{
		//Set up prior state
		String fileIn = "In";
		MonthlySchedule x = new MonthlySchedule();
		
		//call the method
		x.writeSchedule(fileIn);
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void writeScheduleTestException() throws FileNotFoundException
	{
		thrown.expect(FileNotFoundException.class);
		String fileIn = "In";
		MonthlySchedule x = new MonthlySchedule();
		
		x.writeSchedule("");
	}
	
	@Test
	public void sortByTest()
	{
		//Prior State
		MonthlySchedule x = new MonthlySchedule();
		
		//call method
		x.sortBy("Name");
		x.sortBy("Date");
		x.sortBy("Rating");
		x.sortBy("Risk");

	}


}
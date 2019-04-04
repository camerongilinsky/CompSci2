package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import schedules.FileIO;
import schedules.RetailFoodEntry;

public class FileIOTests {

	@Test
	public void constructorTest()
	{
		FileIO a = new FileIO("testdoc.csv");
	}
	
	@Test
	public void readFileTest()
	{
		FileIO a = new FileIO("testdoc.csv");
		RetailFoodEntry[] b = new RetailFoodEntry[10000];
		try {
			a.readFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeFileTest()
	{
		FileIO a = new FileIO("testdoc.csv");
		RetailFoodEntry[] b = new RetailFoodEntry[10000];
		try {
			a.readFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileIO c = new FileIO("testoutput.csv");
		try {
			c.writeFile(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import scraper.base.ImageEntry;

public class ImageEntryTests 
{

	@Test
	public void imageEntryConstructorTest() 
	{
		//Set up prior state
		ImageEntry a = new ImageEntry("HTML", "Website");
		
		//Check the prior state
		assertEquals("HTML", a.getPageLocation());
		assertEquals("Website", a.getImgLocation());
	}
	
	
	@Test
	public void imageEntryEqualsValidTest()
	{
		ImageEntry a = new ImageEntry("HTML", "Website");
		ImageEntry b = new ImageEntry("HTML", "Website");
		
		assertTrue(a.equals(b));
	}
	
	@Test
	public void imageEntryEqualsInvalidTest()
	{
		ImageEntry a = new ImageEntry("HTML", "Website");
		ImageEntry b = new ImageEntry("HTML", "Web");
		String c = "dog";
		
		assertFalse(a.equals(b));
		assertFalse(a.equals(c));
	}
	
	@Test
	public void imageEntryToStringTest()
	{
		ImageEntry a = new ImageEntry("HTML", "Website");
		
	
		
		assertEquals("Website", a.toString());
	}

}

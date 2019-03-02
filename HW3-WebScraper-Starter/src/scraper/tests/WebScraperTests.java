package scraper.tests;

import scraper.utils.*;

import static org.junit.Assert.*;

import org.junit.Test;

import scraper.base.ImageEntry;
import scraper.base.WebScraper;

public class WebScraperTests {

	@Test
	public void WebScraperSpecificConstructorTest() 
	{
		WebScraper a = new WebScraper("Website", 2);
		
		assertEquals("Website", a.getURL());
		assertEquals(2, a.getDepth());
		
	}
	
	@Test
	public void WebScraperGeneralConstructorTest() 
	{
		WebScraper a = new WebScraper("Website");
		
		assertEquals("Website", a.getURL());
		
	}
	
	@Test
	public void WebScraperSpecificConstructorInvalidTest() 
	{
		WebScraper a = new WebScraper("", -1);
		assertEquals(null, a.getURL());
		assertEquals(0, a.getDepth());
		
	}
	
	@Test
	public void WebScraperSpecificConstructorInvalidNullTest() 
	{
		WebScraper a = new WebScraper(null, -1);
		assertEquals(null, a.getURL());
		assertEquals(0, a.getDepth());
		
	}
	
	@Test
	public void WebScraperGetImagesHelperTest()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page0.html", 0);
		//ImageEntry IE = new ImageEntry("Dog", "Cat");
		ResultSet r = new ResultSet();
		//Document page = new Document();
		ResultSet s = a.getImages();
		
		assertEquals(r.getNumEntries(), s.getNumEntries());
	}
	
	@Test
	public void WebScraperCrawlPageHelperTest()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", 0);
		//ImageEntry IE = new ImageEntry("Dog", "Cat");
		ImageEntry test1 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy1.jpg");
		ImageEntry test2 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy5.jpg");
		ImageEntry test3 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy2.jpg");
		ImageEntry test4 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy3.jpg");
		ImageEntry test5 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy4.jpg");
		ImageEntry test6 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy6.jpg");
		
		ResultSet r = new ResultSet();
		r.addResult(test1);
		r.addResult(test2);
		r.addResult(test3);
		r.addResult(test4);
		r.addResult(test5);
		r.addResult(test6);
		
		ResultSet s = a.crawlPage();

		
		//Document page = new Document();
		
		assertEquals(r.getNumEntries(), s.getNumEntries());
	}
	
	
	@Test
	public void WebScraperGetPageHistoryTest()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page0.html", 0);
		//ImageEntry IE = new ImageEntry("Dog", "Cat");
		//ResultSet r = new ResultSet();
		//Document page = new Document();
		ResultSet s = a.crawlPage();
		//PageHistory tester = new PageHistory();
		
		
		assertFalse(a.getPageHistory().wereDuplicatesVisited());
		assertTrue(a.getPageHistory().visited("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page0.html"));
		assertFalse(a.getPageHistory().visited("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html"));
	}

	@Test
	public void WebScraperCrawlPageHelperTest2()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", 1);
		//ImageEntry IE = new ImageEntry("Dog", "Cat");
		
		ImageEntry testn5 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/Palm_Tree_Emoji_42x42.png");
		ImageEntry testn4 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/Slice_Of_Pizza_Emoji_42x42.png");
		ImageEntry testn3 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/Tears_of_Joy_Emoji_Icon_42x42.png");
		ImageEntry testn2 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/Top_Magic_Hat_Emoji_42x42.png");
		ImageEntry testn1 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/Turtle_Emoji_42x42.png");
		ImageEntry test0 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page2.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/Waning_crescent_moon_emoji_icon_png_42x42.png");
		ImageEntry test1 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy1.jpg");
		ImageEntry test2 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy5.jpg");
		ImageEntry test3 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy2.jpg");
		ImageEntry test4 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy3.jpg");
		ImageEntry test5 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy4.jpg");
		ImageEntry test6 = new ImageEntry("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page3.html", "http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/imgs/puppy6.jpg");
		
		ResultSet r = new ResultSet();
		r.addResult(testn5);
		r.addResult(testn4);
		r.addResult(testn3);
		r.addResult(testn2);
		r.addResult(testn1);
		r.addResult(test0);
		r.addResult(test1);
		r.addResult(test2);
		r.addResult(test3);
		r.addResult(test4);
		r.addResult(test5);
		r.addResult(test6);
		
		ResultSet s = a.crawlPage();

		
		//Document page = new Document();
		
		assertEquals(15, s.getNumEntries());
	}
	
	@Test
	public void WebScraperGetPageHistoryTest3()
	{
		WebScraper a = new WebScraper("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html", 1);
		//ImageEntry IE = new ImageEntry("Dog", "Cat");
		//ResultSet r = new ResultSet();
		//Document page = new Document();
		ResultSet s = a.crawlPage();
		//PageHistory tester = new PageHistory();
		
		
		assertFalse(a.getPageHistory().wereDuplicatesVisited());
		assertTrue(a.getPageHistory().visited("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page1.html"));
		assertFalse(a.getPageHistory().visited("http://loki.ist.unomaha.edu/~bdorn/csci1620/hw3testpage/page7.html"));
	}
}

// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Devin from the CSLC and Piazza discussion board posts by the
//				students and instructors for this class.

package scraper.base;

import scraper.utils.Document;
import scraper.utils.Elements;
import scraper.utils.PageHistory;
import scraper.utils.ResultSet;

/**
 * This class provides a simple mechanism to crawl a series of web pages 
 * recursively and extract all of the images that are found on 
 * the pages visited.
 * @author ckennell and ckgilinsky
 *
 */
public class WebScraper 
{
	/**
	 * The default recursive depth to explore.
	 */
	private static final int DEPTH_DEFAULT = 0;
	
	/**
	 * The set recursive depth to explore. Should be >= 0.
	 */
	private int depth;
	
	/**
	 * The base URL used to explore for images.
	 */
	private String baseURL;
	
	/**
	 * Page history for the current scrape.
	 */
	private PageHistory history = new PageHistory();
	
	/**
	 * Builds a new WebScraper that should start at the provided 
	 * URL and will by default explore that page at a depth of 0. 
	 * This allows extracting just the details from this page and 
	 * nothing else.
	 * @param urlIn The URL to explore for images.
	 */
	public WebScraper(String urlIn)
	{
		depth = DEPTH_DEFAULT;
		setURL(urlIn);
	}
	
	/**
	 * Builds a new WebScraper that should start at the provided 
	 * URL and will explore recursively to a specified depth.
	 * @param urlIn The URL to begin exploring for images.
	 * @param depthIn The recursive depth to explore, 
	 * must be >= 0. Negative values will be treated as equivalent to 0.
	 */
	public WebScraper(String urlIn, int depthIn)
	{
		setDepth(depthIn);
		setURL(urlIn);
	}
	
	/**
	 * Updates this WebScraper to explore to a new depth.
	 * @param depthIn The recursive depth to explore, 
	 * must be >= 0. Negative values will be treated as equivalent to 0.
	 */
	public void setDepth(int depthIn)
	{
		if (depthIn >= DEPTH_DEFAULT)
		{
			depth = depthIn;
		}
		else
		{
			depth = DEPTH_DEFAULT;
		}
	}
	
	/**
	 * Retrieves the exploration depth of this WebScraper.
	 * @return The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * @param url The new URL to explore. The WebScraper url 
	 * is only changed if the url value is valid (not null or empty).
	 */
	public void setURL(String url)
	{
		if (url != null && !url.equals(""))
		{
			baseURL = url;
		}
	}
	
	/**
	 * Retrieves the base url for exploration by this WebScraper.
	 * @return The base url.
	 */
	public String getURL()
	{
		return baseURL;
	}
	
	/**
	 * Retrieves the set of images found directly at the initial base 
	 * URL for this WebScraper. This method will not explore any links 
	 * found at the base page. Image information should be stored in the 
	 * order in which their corresponding <img> tags appear in the source 
	 * HTML code. If an image appears more than once in a page, only one 
	 * entry should appear in the ResultSet.
	 * @return A collection of ImageEntry objects for the images found at 
	 * the base url location.
	 */
	public ResultSet getImages()
	{
		/*
		 * A ResultSet is basically just an array of ImageEntry objects from what I can tell.
		 * Probably have to load in an Documents object, search it for it Element strings (i.e.
		 *    the img keyword) and then store those results into an Elements object. Note that 
		 *    and Elements object is basically just an array of Element objects. And and Element
		 *    is a string?
		 * Use addResult() to append an image to the array.
		 * Use merge() to combine image sets from each depth.
		 * One recursive aspect will be updating the URL once there are no more imgs to retrieve.
		 *    (i.e. the new "baseURL" will be the next page. Or something.
		 * 
		 */
		ResultSet a = new ResultSet();
		
		a = getImagesHelper(baseURL);
		
		return a;
	}
	
	/**
	 * Helper method for getImages().
	 * @param urlIn The URL to be scraped.
	 * @return A ResultSet of ImageEntry objects for the given URL.
	 */
	private ResultSet getImagesHelper(String urlIn)
	{
		ResultSet a = new ResultSet(); //create a new ResultSet (ImageEntry array)
		
		Document page = new Document(); //create a new Document to store the HTML elements

		page.loadPageFromURL(urlIn);
		
		Elements c = page.getElementsByTag("img"); //do we need the < > here?
		
		for (int i = 0; i < c.size(); i++)
		{
			ImageEntry temp = new ImageEntry(urlIn, c.getNextElement().getAttributeValue("src"));
			
			if (!a.contains(temp.getImgLocation()))
			{
				a.addResult(temp);
			}
		}
		
		return a;
	}
	
	/**
	 *  This method will recursively explore pages starting at the base url 
	 *  defined for this WebScraper to the depth for which the scraper is configured.
	 * 
	 *  The ResultSet will contain all images discovered along the way, with images 
	 *  from a page being explored stored in the ResultSet prior to any images found 
	 *  on linked pages. ImageEntries will always appear in the ResultSet in the order 
	 *  in which the corresponding <img> tags are given in the HTML files. Only the 
	 *  first occurrence of a particular image (by absoluteURL) is stored in the 
	 *  ResultSet.
	 *  
	 *  Links on a page will be explored in the sequential order in which their 
	 *  corresponding &lt;a&gt; tags appear in the HTML file. The same URL should never 
	 *  be crawled more than once, even if it is linked from itself or 
	 *  another later page.
	 * @return The set of ImageEntry objects resulting from this recursive crawl.
	 */
	public ResultSet crawlPage()
	{
		ResultSet a = crawlPageHelper(depth, baseURL);
		
		return a;
	}
	
	/**
	 * Helper method for crawlPage().
	 * @param index The current depth.
	 * @param urlIn The URL to be explored.
	 * @return Result set for the URL specified.
	 */
	private ResultSet crawlPageHelper(int index, String urlIn)
	{
		ResultSet a = new ResultSet();
		Document page = new Document();
		page.loadPageFromURL(urlIn);
		Elements c = page.getElementsByTag("a");
		
		if (!history.visited(urlIn))
		{
			history.markVisited(urlIn);
		}
		
		
		if (index == 0)
		{
			return getImagesHelper(urlIn);
		}
		else
		{
			a = getImagesHelper(urlIn);
			
			for (int i = 0; i < c.size(); i++)
			{
				String currentPage = c.getNextElement().getAttributeValue("href");
				
				if (!history.visited(currentPage) && page.loadPageFromURL(currentPage))
				{
					a = a.merge(crawlPageHelper(index - 1, currentPage));
					
				}
			}
			
			return a;
		}
	}
	
	/**
	 * Retrieves the historical trail of pages visited during the 
	 * last top-level call to crawlPage.
	 * @return The most recent collection of pages visited. 
	 * If the crawlPagemethod has not been previously called, the
	 * PageHistory object will be empty.
	 */
	public PageHistory getPageHistory()
	{
		return history;
	}
}
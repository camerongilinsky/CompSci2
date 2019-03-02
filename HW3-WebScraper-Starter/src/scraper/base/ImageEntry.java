// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Devin from the CSLC and Piazza discussion board posts by the
//				students and instructors for this class.

package scraper.base;

/**
 * This class stores information about each image found while 
 * crawling pages. Image URLs are saved along with the URL for
 * the page on which the image appears.
 * 
 * @author ckennell and ckgilinsky
 */
public class ImageEntry 
{
	/**
	 * The URL for the source page.
	 */
	private String sourceURL;
	
	/**
	 * The direct URL for the image.
	 */
	private String imageURL;

	/**
	 * Creates a new ImageEntry storing an image URL alongside 
	 * the source page URL.
	 * @param pageAddress the URL for the page where the image was found.
	 * @param imgAddress the full URL of the image itself
	 */
	public ImageEntry(String pageAddress, String imgAddress)
	{
		sourceURL = pageAddress;
		imageURL = imgAddress;
	}
	
	/**
	 * Retrieves the source page URL.
	 * @return The web page where the image of this ImageEntry 
	 * can be found.
	 */
	public String getPageLocation()
	{
		return sourceURL;
	}
	
	/**
	 * Retrieves the direct image URL.
	 * @return The full URL of image file itself.
	 */
	public String getImgLocation()
	{
		return imageURL;
	}
	
	/**
	 * Compares this ImageEntry to another object for equality 
	 * based on the URL of the image file. Two ImageEntries 
	 * with the same image URL but different page URLs will be 
	 * considered equivalent.
	 * @param other The object to be compared.
	 * @return True if this ImageEntry and other refer to the 
	 * same image as file on the Web; false otherwise.
	 */
	public boolean equals(Object other)
	{
		return other instanceof ImageEntry
				&& getImgLocation().equals(((ImageEntry) other).getImgLocation());
	}
	
	/**
	 * Retrieves a String version of this ImageEntry. 
	 * The returned string should only contain the URL for the image 
	 * file.
	 * @return The image file URL from this ImageEntry.
	 */
	public String toString()
	{
		return getImgLocation();
	}
}
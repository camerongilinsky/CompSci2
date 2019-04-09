// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Dr. Dorn
// RESOURCES: I created this file from memory, using no external resources.

/////////////////////////////////////////////////////
// YOU DO NOT NEED TO EDIT THIS CLASS
/////////////////////////////////////////////////////

package hospital.exceptions;

/**
 * This exception is used to signal that an invalid request has been made to a log
 * object.  It signifies that valid statistics could not be computed when the log
 * object is empty.  
 * 
 * @author bdorn
 *
 */
public class EmptyLogException extends RuntimeException
{
	/**
	 * Class versioning information for serialization.
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructs a EmptyLogException containing a default message
	 * that "No data is in the log!".
	 */
	public EmptyLogException()
	{
		super("No data is in the log!");
	}
}

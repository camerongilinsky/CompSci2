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
 * This exception is used to signal that an invalid triage priority has been provided
 * to a method in the hospital management system.  
 * 
 * @author bdorn
 */
public class InvalidPriorityException extends RuntimeException
{
	/**
	 * Class versioning information for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an InvalidPriorityException object with a default message.
	 */
	public InvalidPriorityException()
	{
		super("The specified triage priority is outside the allowable range.");
	}
}

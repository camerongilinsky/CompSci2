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
 * This exception signals that an unsupported emergency condition has been provided
 * to the hospital management system.  
 * 
 * @author bdorn
 *
 */
public class InvalidConditionException extends RuntimeException
{
	/**
	 * Class versioning information for serialization.
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructs an InvalidConditionException with a message indicating which condition
	 * led to the exception being generated.
	 * 
	 * @param condition The offending condition.
	 */
	public InvalidConditionException(String condition)
	{
		super(condition + " is an unrecognized emergency condition.");
	}
}

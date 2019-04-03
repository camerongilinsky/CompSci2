// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package schedules;
/**
 * An Exception to be thrown if an entry does not have a valid date.
 * @author ckgilinsky and ckennell
 */
@SuppressWarnings("serial")
public class InvalidDateException extends RuntimeException 
{
	/**
	 * Sets the message of the Exception to "Invalid Date".
	 * @param input The invalid date value causing the exception.
	 */
	public InvalidDateException(String input)
	{
		super("Invalid Date: " + input);
	}
}

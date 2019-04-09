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
 * This exception arises when a waiting room cannot support a requested action
 * because there are no patients currently waiting.
 * 
 * @author bdorn
 *
 */
public class EmptyWaitingRoomException extends RuntimeException
{
	/**
	 * Class versioning information for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Produces a new EmptyWaitingRoomException with a default message of
	 * indicating that the waiting room is empty.
	 */
	public EmptyWaitingRoomException()
	{
		super("The waiting room is currently empty.");
	}
}

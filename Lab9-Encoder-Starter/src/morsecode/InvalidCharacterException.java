// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Dr. Dorn
// RESOURCES: I did not refer to any outside materials while producing 
//            this code file.

package morsecode;

/**
 * This class is an unchecked exception to signal that an invalid
 * character was read while encoding or decoding a morse code file.
 * 
 * @author bdorn
 *
 */
public class InvalidCharacterException extends RuntimeException
{
	
	/**
	 * The character that caused this exception in the first place.
	 */
	private String offendingChar;
	
	/**
	 * Creates a new exception that encapsulates a user-provided
	 * message and the character (as a String) that caused this
	 * exception to occur.  This constructor is intended for use
	 * when a series of dots and dashes does not match a valid
	 * Morse Code character.
	 * 
	 * @param msg The message to associate with the exception.
	 * @param c The offending character String.
	 */
	public InvalidCharacterException(String msg, String c)
	{
		super(msg);
		offendingChar = c;
	}
	
	/**
	 * Creates a new exception that encapsulates a user-provided
	 * message and the character that caused this
	 * exception to occur.
	 * 
	 * @param msg The message to associate with the exception.
	 * @param c The offending character.
	 */
	public InvalidCharacterException(String msg, char c)
	{
		this(msg, "" + c);
	}
	
	/**
	 * Retrieves the character that caused this exception to occur.
	 * 
	 * @return The offending character.
	 */
	public String getCharacter()
	{
		return offendingChar;
	}
}

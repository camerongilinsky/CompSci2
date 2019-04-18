package molecule.exceptions;

/**
 * Exception used when an unknown atom is encountered.
 */
public class InvalidAtomException extends RuntimeException
{
	/**
	 * Generates an InvalidAtomException with the message: "Invalid Atom Value: ",
	 * followed by the offending atom character.
	 * @param atom Character value for atom the cause the Exception
	 */
	public InvalidAtomException(char atom)
	{
		super("Invalid Atom Value: " + atom);
	}
}

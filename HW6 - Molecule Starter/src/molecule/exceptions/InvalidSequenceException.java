package molecule.exceptions;

/**
 * Exception used when it is determined that a Molecule sequence is improperly formatted.
 */
public class InvalidSequenceException extends RuntimeException
{
	/**
	 * Generates and InvalidSequenceException with the message: "Invalid Molecule Sequence".
	 */
	public InvalidSequenceException()
	{
		super("Invalid Molecule Sequence");
	}
}

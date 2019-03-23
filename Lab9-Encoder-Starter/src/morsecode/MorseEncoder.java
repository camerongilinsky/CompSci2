package morsecode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/////////////////////////////////////////////////////////////
// TODO: Complete the method stubs for MorseEncoder to 
//       implement the functionality of each as designed.
//       Don't forget to add necessary instance data!
/////////////////////////////////////////////////////////////

/**
 * This class provides the ability to encode character data and files
 * into their equivalent representation in Morse Code. The International
 * Morse Code alphabet is used, and only the letters A-Z are supported. 
 *  
 * For more: https://en.wikipedia.org/wiki/Morse_code
 * 
 * @author ckgilinsky
 *
 */
public class MorseEncoder
{
	private char[] letters;
	private String[] encodedLetters;
	
	/**
	 * Initializes a MorseEncoder object based on a character map file.
	 * The character map file is a CSV where each row represents the mapping
	 * between a single English alphabet character and the Morse Code equivalent.
	 * 
	 * For example, rows in the should look like this:
	 * A,.-
	 * B,-...
	 * C,-.-.
	 * 
	 * Further, MorseEncoder class assumes that rows in this file are in order
	 * from A-Z and that no additional data is present in the file.
	 * 
	 * All exceptions arising during attempts to read character map file will be
	 * passed back to the client code.
	 * 
	 * @param characterMapFile The name of the file containing Morse code character mappings.
	 * @throws FileNotFoundException when the characterMapFile path is invalid 
	 */
	public MorseEncoder(String characterMapFile) throws FileNotFoundException
	{
		try
		{
			Scanner in = new Scanner(new File(characterMapFile));
			int i = 0;
			
			while (in.hasNextLine())
			{
				String record = in.nextLine();
				
				Scanner lineParser = new Scanner(record);
				lineParser.useDelimiter(",");
				
				char letter = lineParser.next().charAt(0);
				String encodedLetter = lineParser.next();
				
				letters[i] = letter;
				encodedLetters[i] = encodedLetter;
				
				lineParser.close();
				i++;
			}
		
			in.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File could not be found!");
		}

	}
	
	/**
	 * Encodes a single English alphabet character into Morse code based on
	 * the character map file specified at the time this MorseCode object was
	 * created.  Lowercase and uppercase characters are treated equivalent
	 * in the conversion to Morse code.
	 * 
	 * @param plainChar The alphabetic character to convert into Morse code.
	 * @return A string containing the corresponding Morse code character.
	 * @throws InvalidCharacterException when a character other than A-Z or a-z is passed as plainChar.
	 */
	public String encodeChar(char plainChar)
	{
		String encodedChar = "";
		
		for (int i = 0; i < letters.length; i++)
		{
			if (plainChar == letters[i])
			{
				encodedChar = encodedLetters[i];
			}
		}
		return encodedChar;
	}
	
	/**
	 * Encodes a whole English word into Morse code based on the character map
	 * file specified at the time this MorseCode object was created.  Lowercase and 
	 * uppercase characters are treated equivalent in the conversion to Morse code.
	 * 
	 * Consecutive characters in the Morse code equivalent string will be separated
	 * by a single space character.  For example: "DOG" ==> "-.. --- --."
	 * 
	 * @param plainWord The word to convert into Morse code.
	 * @return A string containing the corresponding Morse code characters.
	 * @throws InvalidCharacterException when plainWord contains one or more non-alphabetic characters.
	 */
	public String encodeWord(String plainWord)
	{
		plainWord.toUpperCase();
		char[] temp = plainWord.toCharArray();
		String result = "";
		
		for (int i = 0; i < temp.length; i++)
		{
			result += encodeChar(temp[i]);
		}
		
		return result;
	}
	
	/**
	 * Processes a text input file and outputs its Morse code equivalent
	 * in a separate file.  Line breaks are preserved between the input
	 * and output files in identical locations.  Consecutive words on a 
	 * single line will be rendered in the output file with the sequence 
	 * " | " so that they can be easily distinguished in Morse code.  
	 * 
	 * Thus, if the input file contains the phrase:
	 *  GO SPOT GO
	 *  
	 * The output file will contain:
	 *  --. --- | ... .--. --- - | --. ---
	 * 
	 * Any exceptions that occur during file read/write will be passed back
	 * to the calling code.
	 * 
	 * @param inputFile The filename of the English based file to be processed.
	 * @param outputFile The filename where the output will be written.  Output files are
	 * 					 always written in "write" mode and any existing contents will be
	 *                   deleted.
	 * @throws FileNotFoundException when the inputFile does not exist.
	 * @throws InvalidCharacterException when one or more invalid characters are detected 
	 *                   while processing the input file.
	 */
	public void encodeFile(String inputFile, String outputFile) throws FileNotFoundException
	{
		try
		{
			Scanner in = new Scanner(new File(inputFile));
			
			while (in.hasNextLine())
			{
				String record = in.nextLine();
				
				Scanner lineParser = new Scanner(record);
				lineParser.useDelimiter("");
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File could not be found!");
		}
	}
	
	/**
	 * A helper method that quickly converts between a character letter and an integer ordinal position
	 * suitable for use as an array index.
	 * 
	 * @param c	The uppercase character to convert.
	 * @return	An ordinal value 0-25 corresponding to the letter c's alphabetic position (A is 0, B is 1, and so on).
	 *          The behavior for non-uppercase characters is unspecified.
	 */
	private int charToInt(char c)
	{
		return c - 'A';
	}
	
}

// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky
// RESOURCES: Piazza discussion board posts by the students and instructors for this class.

package morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
	/**
	 * Number of letters in alphabet to use.
	 */
	private static final int ALPHABET_QUANTITY = 26;
	
	/**
	 * Array to store the alphabetic letters.
	 */
	private char[] letters = new char[ALPHABET_QUANTITY];
	
	/**
	 * Array to store the Morse equivalents of letters.
	 */
	private String[] encodedLetters = new String[ALPHABET_QUANTITY];
	
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
		catch (FileNotFoundException fnfe)
		{
			throw new FileNotFoundException();
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
		try
		{
			String encodedChar = "";
			char temp = Character.toUpperCase(plainChar);
			
			for (int i = 0; i < letters.length; i++)
			{
				if (temp == letters[i])
				{
					encodedChar = encodedLetters[i];
					break;
				}
				else if (temp == ' ')
				{
					encodedChar = "|";
				}
				else if (charToInt(temp) < 0 || charToInt(temp) > ALPHABET_QUANTITY - 1)
				{	  	
					throw new InvalidCharacterException("Error on the char", plainChar);
				}
			}
			
			return encodedChar;
		}
		catch (InvalidCharacterException ice)
		{
			throw new InvalidCharacterException("Error on the char", plainChar);
		}
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
		try
		{
			char[] temp = plainWord.toCharArray();
			String result = "";
			
			for (int i = 0; i < temp.length; i++)
			{
				result += String.format(encodeChar(temp[i]) + " ");
			}
			
			if (!result.equals(""))
			{
				result = result.substring(0, result.length() - 1);
			}
			
			return result;
		}
		catch (InvalidCharacterException ice)
		{
			throw new InvalidCharacterException("Error on the char", plainWord);
		}
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
			if (inputFile == null || inputFile.equals(""))
			{
				throw new FileNotFoundException();
			}
			Scanner in = new Scanner(new File(inputFile));
			FileOutputStream fileOut = new FileOutputStream(outputFile, false);
			PrintWriter writer = new PrintWriter(fileOut);
			
			while (in.hasNextLine())
			{
				String record = in.nextLine();
				
				writer.println(encodeWord(record));
			}
			
			writer.print("\b");
			
			in.close();
			writer.close();
		}
		catch (FileNotFoundException fnfe)
		{
			throw new FileNotFoundException();
		}
		catch (InvalidCharacterException ice)
		{
			throw new InvalidCharacterException("Error on the char", inputFile);
		}
	}
	
	/**
	 * A helper method that quickly converts between a character letter and an integer ordinal position
	 * suitable for use as an array index.
	 * 
	 * @param c	The uppercase character to convert.
	 * @return	An ordinal value 0-25 corresponding to the letter c's alphabetic position
	 * (A is 0, B is 1, and so on).
	 *          The behavior for non-uppercase characters is unspecified.
	 */
	private int charToInt(char c)
	{
		return c - 'A';
	}
	
}

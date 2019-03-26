// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Dr. Dorn
// RESOURCES: I did not refer to any outside materials while producing 
//            this code file.
package app;

import java.io.FileNotFoundException;
import java.util.Scanner;
import morsecode.MorseEncoder;
import morsecode.InvalidCharacterException;

/**
 * Handles top-level user I/O for interaction with MorseEncoder. 
 * 
 * @author bdorn
 *
 */
public class MorseDriver
{
	/**
	 * Entry point for the program.  Basic user input to encode
	 * a file using the MorseEncoder functionality.
	 * 
	 * @param args Command line arguments, not used.
	 */
	public static void main(String[] args) 
	{
		Scanner console = new Scanner(System.in);  
			
		boolean flag = true;
		while (flag)
		{
			try
			{
				System.out.print("What is the Morse code mapping file named? ");
				String mapFile = console.nextLine();
				System.out.print("Which file to encode? ");
				String toEncode = console.nextLine();
				System.out.print("Where to write the output? ");
				String output = console.nextLine();
				
				MorseEncoder m = new MorseEncoder(mapFile);
				m.encodeFile(toEncode, output);
				
				System.out.println("<<SUCCESS>> Refresh the Eclipse project folder and view the file!");
				
				flag = false;
			}
			catch (FileNotFoundException fnfe)
			{
				System.out.println("<<ERROR>> That file doesn't exist. Let's try again.\n");
			}
			catch (InvalidCharacterException ice)
			{
				System.out.println("<<ERROR>> The input file contains a character"
						+ "that could not be encoded.");
				System.out.println("<<BAD CHAR = " + ice.getCharacter() + ">>");
				flag = false;
			}
		}
		console.close();
	}

}

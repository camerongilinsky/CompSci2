// COURSE: CSCI1620
// TERM: Spring 2019
//
// NAME: Cameron Gilinsky and Carter Kennell
// RESOURCES: Piazza discussion board posts by the
//				students and instructors for this class.

package hospital.model;

import java.io.FileNotFoundException;

/**
 * This class stores and provides information about various emergency conditions
 * recognized by the hospital's ER. Conditions and their triage ratings are loaded
 * from a configuration file at the time the EmergencyConditions object is created.
 * @author ckgilinsky and ckennell
 */
public class EmergencyConditions
{
	/**
	 * Creates a new EmergencyConditions object based on comma separated data
	 * provided in a specified configuration file. This method assumes that the
	 * file, if present, is valid and contains a series of records formatted as:
	 * 
	 * Condition Name,#
	 * 
	 * Where "Condition Name" is a string of potentially several words (including spaces and
	 * special characters like hyphens) and # is a single integer value in the range 1-5 (inclusive)
	 * corresponding to the associated triage level.
	 * 
	 * @param fileName The name of the configuration file to be read.
	 * @throws FileNotFoundException occurs when the specified file does not exist or cannot
	 * 		   be opened for reading.
	 */
	public EmergencyConditions(String fileName) throws FileNotFoundException
	{
		
	}
	/**
	 * This method retrieves triage compliance thresholds (in minutes) per fixed
	 * hospital policy. The rules are:
	 * Priority 1: Immediate attention required and should be seen immediately with a 0 minute wait.
	 * Priority 2: Very urgent attention needed and should be seen within 10 minutes of arriving.
	 * Priority 3: Urgent attention needed and should be seen within 60 minutes of arriving.
	 * Priority 4: Standard attention. Should be seen within 2 hours.
	 * Priority 5: Not an emergency. Should be seen within 4 hours of arriving.
	 * 
	 * @param priority The priority level of interest.
	 * @return The wait threshold corresponding to the specified priority.
	 * @throws InvalidPriorityException when the priority specified lies outside of the range 1-5, inclusive.
	 */
	public static int timeThreshold(int priority)
	{
		return 0;
	}
	
	/**
	 * This method looks up the priority level for a specified condition per the
	 * hospital's current configuration file. String matches are considered in a
	 * case-sensitive manner, including spacing and punctuation.
	 * @param conditionName  string containing the condition of interest.
	 * @return A priority value 1-5 corresponding to the provided condition.
	 * @throws InvalidConditionException if a condition is specified that does not exist
	 * 		   in the hospital's configuration file.
	 */
	public int lookup(String conditionName)
	{
		return 0;
	}	
}
